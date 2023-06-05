package edu.school21.cinema.config;

import edu.school21.cinema.filters.CinemaEncodingFilter;
import edu.school21.cinema.filters.LoginPageFilter;
import edu.school21.cinema.services.CinemaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class CinemaSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CinemaUserService cinemaUserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .cors()
                .disable()
                .authorizeRequests()
                //Доступ только для пользователей с ролью Администратор
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/auth/profile", "/auth/profile/**").authenticated()
                //Доступ разрешен всем пользователей
                .antMatchers("/", "/img/**", "/js/**", "/css/**", "/sessions/**", "/films", "/films/**/image").permitAll()
                .antMatchers("/auth/register", "/auth/login").permitAll()
                //Все остальные страницы требуют аутентификации
                .anyRequest().authenticated()
                .and()
                //Настройка для входа в систему
                .formLogin()
                .loginPage("/auth/login")
                //Перенаправление на главную страницу после успешного входа
                .defaultSuccessUrl("/auth/profile")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/auth/logout")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
                .permitAll()
                .logoutSuccessUrl("/");
        http.addFilterBefore(new CinemaEncodingFilter(), ChannelProcessingFilter.class);
        http.addFilterBefore(new LoginPageFilter(), UsernamePasswordAuthenticationFilter.class);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(cinemaUserService).passwordEncoder(bCryptPasswordEncoder());
    }
}
