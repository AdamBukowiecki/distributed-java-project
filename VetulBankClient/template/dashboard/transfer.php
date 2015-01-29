<?php

    echo '<h1 class="page-header">Transfer</h1>
    <form class="form-signin" id="transfer" name="transfer" method="POST" action="http://localhost:8080/transactions">
        <h2 class="form-signin-heading">Wypełnij formularz</h2>
        <input name="from" id="from" type="text" class="form-control" placeholder="From Id">
        <input name="target" id="target" type="text" class="form-control" placeholder="Target Id">
        <input name="value" id="value" type="text" class="form-control" placeholder="Value">
        <input name="desciprion" id="desciprion" type="text" class="form-control" placeholder="Description">
        <button name="Submit" id="submit" class="btn btn-lg btn-primary btn-block" type="submit">Transfer</button>
    </form><script src="template/js/transfer.js"></script>';

?>