# CowsayKagga

how to run :

1. run  >> mvn clean package
2. run >> java -jar target\<jar file name>

How to change idea settings : 
go to settings -> tools -> terminal -> shell path

How to run the project:
java -jar target\CowsayKagga-1.0-SNAPSHOT.jar <json file path>

How to run simple command on terminal start up
cmd.exe /k echo hello


cmd.exe /k java -jar target\CowsayKagga-1.0-SNAPSHOT.jar <json file path>

This works but on a new window. Just paste the below in the shell path of idea setting after installing 'windows terminal':
wt new-tab -p "Command Prompt"  -d "." cmd /k java -jar <jar file path> <json file path>