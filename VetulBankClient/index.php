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
          </div><div class="inner cover">';

          if(isset($page)){
              include("template/".$page.".html");
          } else {
              include("template/index.html");
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