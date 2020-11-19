<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="container">
    <header>
        <h1><strong>Login</strong></h1>
    </header>
    <section class="main">
        <form method="post" action="/login" class="form-1">
            <p class="field">
                <input type="text" name="login" placeholder="Login or email">
                <i class="icon-user icon-large"></i>
            </p>
            <p class="field">
                <input type="password" name="password" placeholder="Password">
                <i class="icon-lock icon-large"></i>
            </p>
            <p class="submit">
                <button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
            </p>
        </form>
    </section>
</div>

</body>
</html>
