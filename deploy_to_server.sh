#!/bin/sh
export PUT_FILE=ElectricIOTServer.war
export CURRENT_DIR=$PWD/build/libs/
ftp -p -v -n 172.81.239.174<<EOF
user ubuntu Root12365$
cd /opt/tomcat/webapps
lcd $CURRENT_DIR
put $PUT_FILE
prompt
bye
EOF
echo "deploy to server successfully"

export $SERVER_USERNAME = "ubuntu"
export $SERVER_PASSWORD = "Root12365$"
export $SERVER_IP = "172.81.239.174"
export $SERVER_CMD1 = "sudo service tomcat restart"
export $SERVER_CMD2 = "exit"

(
    sleep 10;
    echo $SERVER_USERNAME;
    sleep 10;
    echo $SERVER_PASSWORD;
    sleep 10;
    echo $SERVER_CMD1;
    sleep 50;
    echo $SERVER_CMD2;
)|telnet $SERVER_IP