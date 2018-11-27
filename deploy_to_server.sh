#!/bin/sh
export PUTFILE=./build/libs/ElectricIOTServer.war
ftp -p -v -n 172.81.239.174<<EOF
user ubuntu Root12365$
cd /opt/apache-tomcat-9.0.13/webapps
lcd /root
put $PUTFILE
prompt
bye
EOF
echo "deploy to server successfully"
