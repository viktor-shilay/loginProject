<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <link rel="stylesheet" type="text/css" href="css/jquery-ui.css">
    <script src="js/jquery-1.12.4.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script>
        $(function() {
            $('#datepicker').datepicker({
                changeMonth: true,
                changeYear: true,
                yearRange: "1920:2020",
                showOtherMonths: true
            });
        });
    </script>
</head>
<body>
<div class="container">
    <header>
        <h1><strong>Registration</strong></h1>
    </header>
    <section class="main">
        <form method="post" action="/registration" class="form-1">
            <p class="field">
                <input type="text" name="login" placeholder="Login or email">
                <i class="icon-user icon-large"></i>
            </p>
            <p class="field">
                <input type="password" name="password" placeholder="Password">
                <i class="icon-lock icon-large"></i>
            </p>
            <p class="field">
                <input type="text" name="birthdate" id="datepicker" placeholder="Birthdate">
                <i class="icon-heart icon-large"></i>
            </p>
            <p class="submit">
                <button type="submit" name="submit"><i class="icon-arrow-right icon-large"></i></button>
            </p>
        </form>
    </section>
</div>
</body>
</html>
