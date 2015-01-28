<?php

session_start();

$title = "start";

$page = $_GET['p'];

include("template/header.html");

echo '
<div class="site-wrapper">

      <div class="site-wrapper-inner">

        <div class="cover-container">

          <div class="masthead clearfix">
            <div class="inner">
              <h3 class="masthead-brand">VetulBank</h3>
              <nav>
                <ul class="nav masthead-nav">
                  <li'.(($page=="") ? ' class="active"' : '').'><a href="index.php">Start</a></li>
                  <li'.(($page=="signup") ? ' class="active"' : '').'><a href="index.php?p=signup">Załóż konto</a></li>
                  <li'.(($page=="about") ? ' class="active"' : '').'><a href="index.php?p=about">O nas</a></li>
                  <li><a href="'.((isset($_SESSION['accountId'])) ? 'dashboard.php">Moje konto' : 'login.php">Zaloguj').'</a></li>
                </ul>
              </nav>
            </div>
          </div>';

          if($page=="about"){
             echo 'Pustka';
          } elseif($page=="signup"){
              echo '<div class="inner cover">
            <form class="form-signin" id="signup" name="singup" method="post" action="#">
        <h2 class="form-signin-heading">Wypełnij formularz</h2>
        <input name="password" id="password" type="password" class="form-control" placeholder="Password">
        <input name="confirmPassword" id="confirmPassword" type="password" class="form-control" placeholder="Confirm Password">
        <button name="Submit" id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
    </form>
    <div id="message"></div>
    <script src="template/js/singup.js"></script>';
          } else {
              echo '<div class="inner cover">
            <h1 class="cover-heading">Bezpieczeństwo.</h1>
            <p class="lead">Przede wszystkim.</p>
            <p class="lead">
              <a href="login.php" class="btn btn-lg btn-primary">Log In!</a>
            </p>
          </div>';
          }

          echo '<div class="mastfoot">
            <div class="inner">
              <p>Cover template for <a href="http://getbootstrap.com">Bootstrap</a>, by <a href="https://twitter.com/mdo">@mdo</a>.</p>
            </div>
          </div>

        </div>

      </div>

    </div>';


include("template/footer.html");
?>