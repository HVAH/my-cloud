#!/usr/bin/env bash
EVAS=`echo $EVAS | sed -r 's/"//g'`
EVAS=`echo $EVAS | sed -r 's/,/ /g'`

echo "开始构建所选环境：${EVAS}"
#curl --silent --location https://rpm.nodesource.com/setup_10.x | bash -
#npm install -g cnpm --registry=https://registry.npm.taobao.org
#npm i
for eva in $EVAS
do
	echo "开始构建: ${eva}环境"
    #npm install
	npm run build:$eva
    echo "完成构建: ${eva}环境"
    echo "开始部署: ${eva}环境"
	scp -r dist/** ycvr@192.168.0.$eva:~/modou/Modou-Front/nginx/html
	ssh ycvr@192.168.0.$eva "cd ~/modou/Modou-Front/; docker-compose rm -sf ; docker rmi modou-front_modou-frontend:latest; docker-compose up -d"
    echo "完成部署: ${eva}环境"
done
