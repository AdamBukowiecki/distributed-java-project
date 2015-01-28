<?php
    if(isset($_POST['myusername'])){
        ob_start();
        session_start();
        $myusername = $_POST['myusername'];
        $mypassword = $_POST['mypassword'];

        $myusername = stripslashes($myusername);
        $mypassword = stripslashes($mypassword);

        $count = 1;

        if($count==1){
            echo "true";
            $_SESSION['username'] = 'myusername';
            $_SESSION['password'] = 'mypassword';
        }
        else {
            echo "<div class=\"alert alert-danger alert-dismissable\"><button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-hidden=\"true\">&times;</button>Wrong Username or Password</div>";
        }
        ob_end_flush();
    } else {
        $data = array(
            'username' => $myusername,
            'password' => $mypassword
        );

        $postString = http_build_query($data, '', '&');

        $url = 'http://rest-service.guides.spring.io/greeting';

        $opts = array('http' =>
            array(
                'method'  => 'POST',
                'header'  => 'Content-type: application/x-www-form-urlencoded',
                'content' => $postString
            )
        );

        $context = stream_context_create($opts);

        $result = file_get_contents($url, false, $context);

        $array = json_decode($result);
        print_r($array);
    }
?>