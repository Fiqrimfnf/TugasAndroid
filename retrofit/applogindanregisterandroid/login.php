<?php

include 'connection.php';

if($_POST){

    //data
    $username = $_POST['username'] ??'';
    $password = $_POST['password'] ??'';

    $response = []; //Data Response

    //Cek username didalam database
    $userQuery = $connection->prepare("SELECT* FROM user where username = ?");
    $userQuery->execute(array($username));
    $query = $userQuery->fetch();

    if($userQuery->rowCount()== 0){
        $response['status'] = false;
        $response['message'] = "Username Tidak Terdaftar";
    }else{
        //Ambil password di database

        $passwordDB = $query['password'];

        if(strcmp(md5($password),$passwordDB) === 0){
            $response['status'] = true;
            $response['message'] = "Login Berhasil";
            $response['data'] = [
                'user_id' => $query['id'],
                'username' => $query['username'],
                'name' => $query['name']
            ];
        }else{
        $response['status'] = false;
        $response['message'] = "Password anda salah";   
        }
    }
    //Jadikan data json
    $json = json_encode($response,JSON_PRETTY_PRINT);

    //Print
    echo $json;
}