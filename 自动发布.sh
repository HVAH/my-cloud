#!/usr/bin/env bash
MODULES=`echo $MODULES | sed -r 's/"//g'`
MODULES=`echo $MODULES | sed -r 's/,/ /g'`
echo "开始构建所选模块：${MODULES}"
VERSION_ARRAY=()
INDEX1=0

for loop in $MODULES
do
	echo "开始构建: ${loop}模块"
    cd ${loop}
    VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout)
    VERSION_ARRAY[$INDEX1]=$VERSION
    INDEX1=$INDEX1+1
    echo ${VERSION}
    mvn clean install -DskipTests -Ddockerfile.skip
    echo "成功构建: ${loop}模块"
    cd ..
done

echo "成功构建所选模块：${MODULES} 即将进行远程部署"


INDEX2=0
for loop in $MODULES
do
	if [ "base" = ${loop} ]
    then
    	INDEX2=$INDEX2+1
    	continue
    fi
    echo "开始部署: ${loop}模块"

    scp $loop/target/${loop}"-"${VERSION_ARRAY[${INDEX2}]}".jar" ycvr@192.168.0.140:~/modou/Modou-Backend/${loop}/app
	ssh ycvr@192.168.0.140 "cd ~/modou/Modou-Backend/; docker-compose rm -sf $loop; docker-compose up -d $loop"
    INDEX2=$INDEX2+1
    echo "成功部署: ${loop}模块"
done

echo "成功部署所选模块：${MODULES} ，本次构建任务完成"