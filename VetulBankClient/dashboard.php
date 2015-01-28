<?php
    session_start();
    if(!isset($_SESSION['accountId'])){
        header("location:index.php");
    }

    $title = "konto";
    $file = "dashboard";

    $page = $_GET['p'];

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
            <li'.(($page=="") ? ' class="active"' : '').'><a href="dashboard.php">Dashboard</a></li>
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
            <li'.(($page=="") ? ' class="active"' : '').'><a href="dashboard.php">Overview <span class="sr-only">(current)</span></a></li>
            <li'.(($page=="transfer") ? ' class="active"' : '').'><a href="dashboard.php?p=transfer">Make a transfer</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">';


          if($page == "") {
              echo '<h1 class="page-header">Dashboard</h1><div class="row">
              <div class="col-sm-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">Account number</h3>
                    </div>
                    <div class="panel-body">
                      123
                    </div>
                </div>
              </div>
              <div class="col-sm-3">
                <div class="panel panel-default">
                    <div class="panel-heading">
                      <h3 class="panel-title">Account balance</h3>
                    </div>
                    <div class="panel-body">
                      123 $
                    </div>
                </div>
              </div>
          </div>
          <h2 class="sub-header">Transaction History</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                  <th>Header</th>
                </tr>
              </thead>
              <tbody>';

              $json_string = file_get_contents('http://api.wunderground.com/api/f429b85619ed45e8/geolookup/conditions/forecast/q/Australia/Sydney.json');
              $transactions = json_decode($json_string);

              foreach($transactions as $row) {
                  echo '<tr>
                  <td>$row->{\'id\'}</td>
                  <td>$row->{\'from\'}</td>
                  <td>$row->{\'to\'}</td>
                  <td>$row->{\'amount\'}</td>
                </tr>';
              }

              echo '</tbody>
            </table>
          </div>';
          } elseif($page == "transfer"){
              echo '<h1 class="page-header">Transfer</h1>';
          } elseif($page == "profile"){
              echo '<h1 class="page-header">Profile</h1>
                <div id="accountId" class="hide">'.$_SESSION['accountId'].'</div>
                <a id="delete" href="#" class="btn btn-lg btn-danger">Delete account</a>
                <script src="template/js/profile.js"></script>';
          }
        echo '</div>
      </div>
    </div>';

include("template/footer.html");

?>