<!doctype html>
<html lang="" xmlns:th="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    Hello, world!
    <div>
        <form method="post" action="/login" id="loginForm">
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" value="Войти">
            <input
                    type="hidden"
                    th:name="${_csrf.parameterName}"
                    th:value="${_csrf.token}" />
        </form>
    </div>
</body>
</html>