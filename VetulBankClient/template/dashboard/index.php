<?php

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

?>