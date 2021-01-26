<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/upload" enctype="multipart/form-data">
        <input type="file" name="filename"><br>
        <input type="submit" value="提交">
    </form>

    <form>
        <a href="./download">下载</a>
    </form>
</body>
</html>
