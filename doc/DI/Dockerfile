FROM centos:7.6.1810

LABEL maintainer="jenkins runtime environment <522264152@qq.com>"

USER root

RUN mkdir -p /opt/tools/ \
    && yum install -y git

COPY jdk1.8.0_181/ /opt/tools/jdk-1.8/
COPY apache-maven-3.5.4/ /opt/tools/maven-3.5.4/
COPY apache-tomcat-8.5.42/ /opt/tools/tomcat-8.5/
COPY apache-jmeter-5.1.1/ /opt/tools/jmeter-5.1.1/

ENV  JAVA_HOME=/opt/tools/jdk-1.8/ \
     MAVEN_HOME=/opt/tools/maven-3.5.4/ \
	 CLASSPATH=$CLASSPATH:$JAVA_HOME/lib:$JAVA_HOME/jre/lib \
	 JAVA_TOOL_OPTIONS='-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8'

ENV PATH $PATH:$JAVA_HOME/bin:$JAVA_HOME/jre/bin:$MAVEN_HOME/bin

EXPOSE 9090

CMD ["/opt/tools/tomcat-8.5/bin/catalina.sh","run"]