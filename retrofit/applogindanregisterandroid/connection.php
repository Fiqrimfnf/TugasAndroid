<?php

$connection = null;

try{
    //config
    $host = "localhost";
    $username = "root";
    $password = "";
    $dbname = "app-login-register-android";
    
    //Connect
    $database = "mysql:dbname=$dbname;host=$host";
    $connection = new PDO($database, $username, $password);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // if($connection){
    //     echo"Koneksi Berhasil";
    // }else{
    //     echo"Gagal";
    // }

    }catch (PDOException $e){
        echo"Error !". $e->getMessage();
        die;
    }

?>