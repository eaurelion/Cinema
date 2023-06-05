<#import "/spring.ftl" as spring/>
<html>
<head>
    <title>Foto</title>
</head>
<body>
<img style="height: 200px; width: 300px;" src="/auth/profile/photo/${filename}" onerror="this.onerror=null;this.src='/img/image.png';">
</body>
</html>
