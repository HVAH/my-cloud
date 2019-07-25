#!/usr/bin/env bash

MODULES=`echo $MODULES | sed -r 's/"//g'`
MODULES=`echo $MODULES | sed -r 's/,/ /g'`
EVAS=`echo $EVAS | sed -r 's/"//g'`
EVAS=`echo $EVAS | sed -r 's/,/ /g'`
echo "开始构建所选模块：${MODULES}"
VERSION_ARRAY=()
INDEX1=0


for modoule in $MODULES
do
	if [ "parent" = ${modoule} ]
    then
    	mvn clean install -DskipTests -Ddockerfile.skip
        break
    fi
	echo "开始构建: ${modoule}模块"
    cd ${modoule}
    VERSION=$(mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout)
    VERSION_ARRAY[$INDEX1]=$VERSION
    INDEX1=$INDEX1+1
    echo ${VERSION}
    mvn clean install -DskipTests -Ddockerfile.skip
    echo "成功构建: ${modoule}模块"
    cd ..
done

echo "成功构建所选模块：${MODULES} 即将进行远程部署"

for eva in $EVAS
do
    echo "开始部署: ${eva}环境"
    INDEX2=0
    for modoule in $MODULES
    do
        if [ "parent" = ${modoule} ]
        then
            break
        fi
        if [ "base" = ${modoule} ]
        then
            INDEX2=$INDEX2+1
            continue
        fi
        echo "开始部署: ${modoule}模块"
		FN=${modoule}"-"${VERSION_ARRAY[${INDEX2}]}".jar"
        echo $FN
        scp $modoule/target/$FN ycvr@192.168.0.${eva}:~/modou/Modou-Backend/${modoule}/app
        ssh ycvr@192.168.0.${eva} "cd ~/modou/Modou-Backend/${modoule}/app; docker-compose rm -sf $modoule; mv $FN $modoule".jar"; docker-compose up -d $modoule"
        INDEX2=$INDEX2+1
        echo "成功部署: ${modoule}模块"
    done
    echo "完成部署: ${eva}环境"
done



echo "成功部署所选模块：${MODULES} ，本次构建任务完成"