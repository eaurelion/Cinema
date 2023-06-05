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
    <h1 class="main">List of movies</h1>
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
            <th>
                Edit
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
                    ${iterMovie.title}
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
                <td>
                    <a href="/admin/films/${iterMovie.id}">Edit</a>
                    <form method="post" action="/admin/films/${iterMovie.id}/delete">
                        <button type="submit">Remove</button>
                    </form>
                </td>
            </tr>
        </#list>
    </table>

    <div class="addMovies">
        <form method="post" action="/admin/films" enctype="multipart/form-data">
            <label for="title" style="background-color: darkgray">Title</label>
            <input type="text" name="title" id="title" required>
            <label for="releaseDate" style="background-color: darkgray">Year of release</label>
            <input type="date" pattern="yyyy-MM-dd" name="releaseDate" id="releaseDate" required>
            <label for="restrictions" style="background-color: darkgray">Age restrictions</label>
            <input type="number" name="restrictions" id="restrictions" required>
            <label for="description" style="background-color: darkgray">Description </label>
            <input type="text" name="description" id="description" required>
            <label for="files">Upload a poster</label>
            <input type="file" name="file" accept="image/*" style="background-color: darkgrey" id="files" hidden>
            <button type="submit">Add</button>
        </form>
    </div>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
