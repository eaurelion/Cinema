<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
<header><h1 class="header"><a class="header" href="/">To main</a></h1></header>
<main>
<a href="/">To main</a>
<div>
    <h1 class="main">Registration</h1>
    <form action="/auth/register" method="post">
    <div>
        <label path="username">Login</label>
        <input style="margin-left: 10px" name="username" type="text">
    </div>
    <div>
        <label path="password">Password</label>
        <input type="password" name="password">
    </div>
    <div>
        <button type="submit">Registration</button>
    </div>
    </form>
</div>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
