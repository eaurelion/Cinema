<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Movie session editing</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<main>
    <form method="post" action="/admin/sessions/${cinemaSession.id}/update" style="margin-top: 10%">
        <label style="background-color: darkgray" for="date">Session date</label>
        <input id="date" type="datetime-local" name="cinemaSessionDateTime" value="${cinemaSession.getDateToEdit()}" required>
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
        <input type="text" id="ticketCost" name="ticketCost" value="${cinemaSession.ticketCost}">
        <div>
        <button type="submit" style="width: 30%; height: 7%; font-size: xx-large">Update</button>
        </div>
    </form>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
