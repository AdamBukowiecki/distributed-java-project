<?php
    session_start();
    if(isset($_SESSION['accountId'])){
        header("location:dashboard.php");
    }

    $title = "logowanie";
    $file = "login";

    include("template/header.html");

    echo '<div class="container">
<form class="form-signin" name="form1" method="post" action="checklogin.php">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input name="accountId" id="accountId" type="text" class="form-control" placeholder="Accout Number" autofocus>
        <input name="password" id="password" type="password" class="form-control" placeholder="Password">
        <button name="Submit" id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
        <div id="message"></div>
    </form>
    <a href="index.php" class="btn btn-lg btn-primary">Back</a>
</div>



    <script src="template/js/login.js"></script>
    ';

    include("template/footer.html");
?>