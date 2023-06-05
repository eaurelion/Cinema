<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Authorization</title>
    <link rel="stylesheet" type="text/css" href="/css/login.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>

<main>
<div>
    <h1 class="main">Authorization</h1>
    <form action="/auth/login" method="post">
        <div>
        <label for="username">Login</label>
        <input style="margin-left: 10px" name="username" id="username">
        </div>
        <div>
        <label for="password">Password</label>
        <input name="password" type="password" id="password">
        </div>
        <div>
        <button type="submit">Sign in</button>
        </div>
    </form>
</div>

</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
