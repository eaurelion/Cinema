<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Movie editing</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<form method="post" action="/admin/films/${movie.id}/update" enctype="multipart/form-data" style="margin-top: 5%">
    <table border="3">
        <tr>
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
        <tr>
            <td>
                <div>
                    <#if movie.hasImage == true>
                        <img src='/films/${movie.id}/image' style="height: 100px; width: 150px;">
                    </#if>
                    <#if movie.hasImage == false>
                        <img src="/img/image.png" style="height: 100px; width: 150px;">
                    </#if>
                </div>
                <input type="file" name="file" accept="image/*">
            </td>
            <td>
                <input name="title" value="${movie.title}" required>
            </td>
            <td>
                <input id="releaseDate" type="date" pattern="yyyy-MM-dd" name="releaseDate" value="${movie.formatDate()}" required>
            </td>
            <td>
                <input name="restrictions" value="${movie.restrictions}" required>
            </td>
            <td>
                <input name="description" value="${movie.description}" required>
            </td>
        </tr>
    </table>
    <button type="submit" style="width: 30%; height: 7%; font-size: xx-large">Update</button>
</form>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>