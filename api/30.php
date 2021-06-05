<?php 

// Deleting old files:
unlink ('subst_001.htm');
unlink ('subst_002.htm');
unlink ('subst_003.htm');
unlink ('subst_004.htm');
unlink ('subst_005.htm');

// Downloading new files:
echo "Successfully updated - You will be redirected immediately";
include('1.php');
include('2.php');
include('3.php');
include('4.php');
include('5.php');

?>