<?php
 $db = mysqli_connect("localhost", "root", "", "smartshare");
 $en_no = mysqli_real_escape_string($db, $_POST["en_no"]);
 $user_name = mysqli_real_escape_string($db, $_POST["user_name"]);
 $user_email = mysqli_real_escape_string($db, $_POST["user_email"]);
 $user_pno = mysqli_real_escape_string($db, $_POST["user_pno"]);
 $user_pass = mysqli_real_escape_string($db, $_POST["user_pass"]);
 $sql_query = "INSERT INTO students (en_no, name, email, phone_no, password) VALUES ('$en_no', '$user_name', '$user_email', '$user_pno', '$user_pass')";
 mysqli_query($db, $sql_query);
?>