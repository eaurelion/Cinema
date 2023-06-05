<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Movie discussion</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css">
</head>
<body>
<header>
    <h1 class="header"><a class="header" href="/">To main</a></h1>
</header>
<main>
    <h1 class="main">Movie discussion</h1>
    <script>
        let movieId = ${movie.id};
        let cinemausername = '${cinemausername}';
    </script>
    <div>
        <table border="3" style="text-align: center; background-color: darkgrey">
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
                </td>
                <td>
                    ${movie.title}
                </td>
                <td>
                    ${movie.formatDate()}
                </td>
                <td>
                    ${movie.restrictions}
                </td>
                <td>
                    ${movie.description}
                </td>
            </tr>
        </table>
    </div>
    <div id="chat-page" class="chat" style="background-color: #9E9C9C">
            <div id="messageArea"></div>
    </div>
    <form id="messageForm" name="messageForm">
        <div class="form-group">
            <div class="input-group clearfix">
                <input type="text" id="message" placeholder="Type a message..." autocomplete="off" class="form-control"/>
                <button type="submit" class="primary">Send</button>
            </div>
        </div>
    </form>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.4/sockjs.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.min.js"></script>
    <script src="/js/main.js"></script>
</main>
<footer>
    <h2 class="footer">Moscow 2023</h2>
</footer>
</body>
</html>
