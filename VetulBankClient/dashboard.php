<?php
    session_start();
    if(!isset($_SESSION['accountId'])){
        header("location:index.php");
    }

    $title = "konto";
    $file = "dashboard";

    $page = $_GET['p'];
    if(!isset($page))
        $page = "index";

    include("template/header.html");

    echo '<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.php">VetulBank</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li'.(($page=="index") ? ' class="active"' : '').'><a href="dashboard.php">Dashboard</a></li>
            <li'.(($page=="profile") ? ' class="active"' : '').'><a href="dashboard.php?p=profile">Profile</a></li>
            <li class="divider-vertical"></li>
            <li><a href="logout.php">Logout</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li'.(($page=="index") ? ' class="active"' : '').'><a href="dashboard.php">Overview <span class="sr-only">(current)</span></a></li>
            <li'.(($page=="transfer") ? ' class="active"' : '').'><a href="dashboard.php?p=transfer">Make a transfer</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">';

          include("template/dashboard/".$page.".php");

        echo '</div>
      </div>
    </div>';

include("template/footer.html");

?>