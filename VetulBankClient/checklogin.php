<?php
    if(isset($_POST['accountId'])){

        ob_start();
        session_start();
        $accountId = $_POST['accountId'];
        $password = $_POST['password'];

        $url = 'http://localhost:8080/accounts/'.$accountId.'/password/'.$password;

        $opts2 = array('http' =>
            array(
                'method'  => 'GET'
            )
        );

        $opts = array('http' =>
            array(
                'method'  => 'POST',
                'header'  => 'Content-type: application/x-www-form-urlencoded',
                'content' => $postString
            )
        );

        $context = stream_context_create($opts2);

        $result = file_get_contents($url, FILE_USE_INCLUDE_PATH, $context);

        if($result == "true"){
            echo 'true';
            $_SESSION['accountId'] = $accountId;
            $_SESSION['password'] = $password;
        } else {
            echo "<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>Wrong Account Id or Password</div>";
        }

        ob_end_flush();
    } else {
        header("location:index.php");
    }
?>