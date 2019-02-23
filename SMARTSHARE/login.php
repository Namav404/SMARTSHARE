<?php 
 $db = mysqli_connect("localhost", "root", "", "smartshare");
 $user_email = $_POST["user_email"];
 $user_pass =  $_POST["user_pass"];
 $sql_query = "SELECT * FROM students WHERE email = '$user_email' AND password = '$user_pass'";
 $result = mysqli_query($db,$sql_query);
 if(mysqli_num_rows($result) > 0 )  {
 $row = mysqli_fetch_assoc($result);
 echo "Login Successfull!";
 }
 else  {   
 echo "Login Failed.......Try Again?";
 }
?>