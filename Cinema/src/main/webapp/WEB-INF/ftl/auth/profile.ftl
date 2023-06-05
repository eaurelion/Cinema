<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <table style="background-color: #181258">
        <td width="85%">
            <h1 class="header"><a class="header" href="/" style="margin-left: 10%">To main</a></h1>
        </td>
        <td width="15%">
            <form action="/auth/logout" method="POST">
                <label for="logout" style="font-size: xx-large; color: white">Hi, ${user.username}!</label>
                <input id="logout" type="submit" style="background-color: #181258;
      border: none;
      color: white;
      text-align: center;
      text-decoration: none;
      display: inline-block;
      font-size: 20px;
      cursor: pointer;" value="Sign out">
            </form>
        </td>
    </table>


</header>
<main>
    <h1 class="main">User information</h1>
    <table border="3">
        <tr>
            <th>ID</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>Access rights</th>
            <td>
                <#list user.roles as iterRole>
                    ${iterRole.name}
                </#list>
            </td>
        </tr>
        <tr>
            <th>Login</th>
            <td>${user.username}</td>
        </tr>
        <tr>
            <th>Password</th>
            <td>${user.password}</td>
        </tr>
        <tr>
            <th>Foto</th>
            <td><img src="/auth/profile/avatar" style="height: 100px; width: 150px;" onerror="this.onerror=null;this.src='/img/image.png';">
                <form method="post" action="/auth/profile/avatar" enctype="multipart/form-data">
                    <input type="file" name="image" accept="image/*">
                    <div>
                    <button type="submit">Download</button>
                    </div>
                </form>
            </td>
        </tr>
    </table>
<h1 class="main">Login History</h1>
<div>
    <table border="3">
        <tr>
            <th>
                Date of operation
            </th>
            <th>
                Type
            </th>
            <th>
                Address
            </th>
        </tr>
        <#list user.authHistory as iterAuth>
            <tr>
                <td>
                        ${iterAuth.time}
                </td>
                <td>
                        ${iterAuth.type}
                </td>
                <td>
                        ${iterAuth.address}
                </td>
            </tr>
        </#list>
    </table>
</div>
<h1 class="main">Uploaded avatar photos</h1>
<div>
    <table border="3">
        <tr>
            <th>
                Link
            </th>
        </tr>
        <#list listFiles as filesIter>
            <tr>
                <td>
                    <a href="/auth/profile/photo/${filesIter}/show">${filesIter}</a>
                </td>
            </tr>
        </#list>
    </table>
</div>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
