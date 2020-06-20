<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <@spring.bind "registrationForm"/>
    <form method="post">
        <div>
            <input type="text" name="name" placeholder="Name">
        </div>
        <div>
            <input type="text" name="username" placeholder="Username">
        </div>
        <div>
<#--            <@spring.formInput "registrationForm.mail"/>-->
<#--            <@spring.showErrors/>-->
            <input type="text" name="mail" placeholder="Mail">
        </div>
        <div>
            <input type="password" name="password" placeholder="Password">
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div>
            <input type="submit">
        </div>
    </form>
</body>
</html>