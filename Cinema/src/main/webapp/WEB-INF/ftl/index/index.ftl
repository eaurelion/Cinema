<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="ru">
<html>
<head>
    <title>Cinema. School 21. Moscow.</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
          crossorigin="anonymous">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="https://projects.intra.42.fr/projects/cinema">Cinema.</a> School 21. Moscow.</h1>
</header>
<main>
    <a class="main" href="/admin/halls">[Admin] Edit movie halls</a>
    <br>
    <a class="main" href="/admin/films">[Admin] Edit movies</a>
    <br>
    <a class="main" href="/admin/sessions">[Admin] Edit sessions</a>
    <br>
    <a class="main" href="/sessions">Search by movie sessions</a>
    <br>
    <a class="main" href="/auth/login">Authorization</a>
    <br>
    <a class="main" href="/auth/register">Registration</a>
    <br>
    <a class="main" href="/films">All movies</a>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
