<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Movie hall editing</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<main>
<form method="post" action="/admin/halls/${movieHall.id}/update" modelAttribute="movieHall" cssStyle="margin-top: 10%">
    <label cssStyle="background-color: darkgray" path="seatsCount">Number of seats</label>
    <input type="text" name="seatsCount">
    <button type="submit">Update</button>
</form>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
