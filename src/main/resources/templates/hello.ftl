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
    <#if name!="shicongcong">
        你的名字是:${name}<br>
    </#if>

    你的密码是:${pwd}<br>

    <#list list as l >
        当前是第${l.name},他的密码是${l.age}<br>
    </#list>
</body>
</html>