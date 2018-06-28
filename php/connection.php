<?php
echo "hi";
$servername = "bybtest.000webhost.com";
$username = "id5253336_root";
$password = "/bybtest/";
$database = "id5253336_bybtest";

// Create connection
$conn = new mysqli($servername, $username, $password, $database);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
echo "Connected successfully";
?>