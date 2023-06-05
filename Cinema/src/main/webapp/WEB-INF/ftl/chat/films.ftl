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
    <h1 class="main">List of all movies</h1>
    <table border="3">
        <tr>
            <th>
                ID
            </th>
            <th>
                Poster
            </th>
            <th>
                Title
            </th>
            <th>
                Year of release
            </th>
            <th>
                Age restrictions
            </th>
            <th>
                Description
            </th>
        </tr>
        <#list movies as iterMovie>
            <tr>
                <td>
                        ${iterMovie.id}
                </td>
                <td>
                    <#if iterMovie.hasImage == true>
                        <img src='/films/${iterMovie.id}/image' style="height: 100px; width: 150px;">
                    </#if>
                    <#if iterMovie.hasImage == false>
                        <img src="/img/image.png" style="height: 100px; width: 150px;">
                    </#if>
                </td>
                <td>
                    <p>${iterMovie.title}</p>
                    <a style="text-decoration: darkorange; color: darkred" href="/films/${iterMovie.id}/chat">Обсудить</a>
                </td>
                <td>
                        ${iterMovie.formatDate()}
                </td>
                <td>
                        ${iterMovie.restrictions}
                </td>
                <td>
                        ${iterMovie.description}
                </td>
            </tr>
        </#list>
    </table>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
