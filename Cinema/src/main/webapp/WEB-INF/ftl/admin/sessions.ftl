<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<main>
    <div class="cinemaSessions">
        <h1 class="main">List of movie sessions</h1>
        <table border="3">
            <tr>
                <th>
                    ID
                </th>
                <th>
                    Date/Time
                </th>
                <th>
                    Movie hall
                </th>
                <th>
                    Movie
                </th>
                <th>
                    Ticket cost
                </th>
                <th>
                    Edit
                </th>
            </tr>
            <#list cinemaSessions as iterCinemaSession>
                <tr>
                    <td>
                        ${iterCinemaSession.id}
                    </td>
                    <td>
                        ${iterCinemaSession.getDateHtml()}
                    </td>
                    <td>
                        Hall №${iterCinemaSession.movieHall.id}, ${iterCinemaSession.movieHall.seatsCount} seats
                    </td>
                    <td>
                        ${iterCinemaSession.movie.title}
                    </td>
                    <td>
                        ${iterCinemaSession.ticketCost}
                    </td>
                    <td>
                        <a href="/admin/sessions/${iterCinemaSession.id}">Edit</a>
                        <form method="post" action="/admin/sessions/${iterCinemaSession.id}/delete">
                            <button type="submit">Remove</button>
                        </form>
                    </td>
                </tr>
            </#list>
        </table>

    </div>
    <div class="addCinemaSessions">
        <form method="post" action="/admin/sessions">
            <label style="background-color: darkgray" for="date">Date</label>
            <input id="date" type="datetime-local" pattern="yyyy-MM-dd, HH:mm" name="sessionDateTime" required>
            <label style="background-color: darkgray" for="movieHall">Movie hall</label>
            <select id="movieHall" name="movieHallId">
                <#list movieHalls as iterMovieHall>
                    <option value="${iterMovieHall.id}"><@spring.messageText "cinemaHallforSession" "Movie hall"></@spring.messageText> №${iterMovieHall.id}, ${iterMovieHall.seatsCount} <@spring.messageText "seatsCount" "Count of seats"></@spring.messageText></option>
                </#list>
            </select>
            <label style="background-color: darkgray" for="movie">Movie</label>
            <select id="movie" name="movieId">
                <#list movies as iterMovie>
                    <option value="${iterMovie.id}">${iterMovie.title}</option>
                </#list>
            </select>
            <label style="background-color: darkgray" for="ticketCost">Ticket cost</label>
            <input type="text" id="ticketCost" name="ticketCost" required>
            <button type="submit">Add</button>
        </form>
    </div>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
