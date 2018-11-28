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
