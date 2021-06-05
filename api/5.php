<?php
// Initialize a file URL to the variable 
$url = 'http://www.kreisgymnasium-halle.de/wp-content/uploads/Service/vertretungsplan/subst_005.htm'; 
  
// Use basename() function to return the base name of file  
$file_name = basename($url); 
   
// Use file_get_contents() function to get the file 
// from url and use file_put_contents() function to 
// save the file by using base name 
if(file_put_contents( $file_name,file_get_contents($url))) { 
    echo ""; 
} 
else { 
    echo ""; 
} 
?>