<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Session information</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<main>
<div class="cinemaSessions">
    <h1 class="main">View session</h1>
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
        </tr>
            <tr>
                <td>
                        ${cinemaSession.id}
                </td>
                <td>
                        ${cinemaSession.date.toLocalDate()} ${cinemaSession.date.toLocalTime()}
                </td>
                <td>
                    Hall №${cinemaSession.movieHall.id}, ${cinemaSession.movieHall.seatsCount} seats
                </td>
                <td>
                    <div>
                        ${cinemaSession.movie.title}
                    </div>
                    <div>
                        <#if cinemaSession.movie.hasImage == true>
                            <img src='/films/${cinemaSession.movie.id}/image' style="height: 100px; width: 150px;">
                        </#if>
                        <#if cinemaSession.movie.hasImage == false>
                            <img src="${pageContext.request.contextPath}/img/image.png" style="height: 100px; width: 150px;">
                        </#if>
                    </div>
                    <div>
                        ${cinemaSession.movie.description}
                    </div>
                </td>
                <td>
                        ${cinemaSession.ticketCost}
                </td>
            </tr>
    </table>

</div>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
