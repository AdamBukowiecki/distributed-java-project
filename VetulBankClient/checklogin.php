<?php
    if(isset($_POST['accountId'])){

        ob_start();
        session_start();
        $accountId = $_POST['accountId'];
        $password = $_POST['password'];


        $data = array(
            'accountId' => $accountId,
            'password' => $password
        );

        $postString = http_build_query($data, '', '&');

        $url = 'http://localhost:8080/account/'.$accountId.'/password/'.$password;

        $opts2 = array('http' =>
            array(
                'method'  => 'GET',
                'header'  => 'Content-type: application/x-www-form-urlencoded'
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

        $result = file_get_contents($url, false, $context);

        $array = json_decode($result);
        print_r($array);

        if(true){
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