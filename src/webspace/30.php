<?php 
// Der Skript ist eine Übertragung des Originalsskripts auf dem Rootserver in Frankfurt und wurde in PHP umgeschrieben, so das man ihn auch auf der Webspace benutzen kann.
// Die Datei kann deshalb immer nur dann ausgeführt werden, wenn jemand die Webseite besucht.

// Lösung der alten Dateien:
unlink ('subst_001.htm');
unlink ('subst_002.htm');
unlink ('subst_003.htm');
unlink ('subst_004.htm');
unlink ('subst_005.htm');

// Download der neuen / selben Dateien
include('1.php');
echo " - ";
include('2.php');
echo " - ";
include('3.php');
echo " - ";
include('4.php');
echo " - ";
include('5.php');

// Meldung das er die Aufgabe abgeschlossen hat.
include('webhook.php');
?>