FROM jenkinsci/blueocean
USER root
RUN apt-get update \
        && apt-get install -y sudo
USER jenkins

MAINTAINER vah/522264152@qq.com

RUN mkdir -p /opt/tools/jdk/
RUN mkdir -p /opt/tools/maven/
RUN mkdir -p /opt/tools/git/


COPY /usr/lib/jdk/jdk1.8.0_181/ /opt/tools/jdk/jdk_1.8/
COPY /usr/lib/maven/maven-3.5.4/ /opt/tools/maven/maven_3.5.4/
COPY /usr/lib/git /opt/tools/git/

# 添加环境变量
ENV JAVA_HOME /opt/tools/jdk/jdk_1.8
ENV MAVEN_HOME /opt/tools/maven/maven_3.5.4/
ENV GIT_HOME /opt/tools/git/
ENV PATH $PATH:$JAVA_HOME/bin:$MAVEN_HOME/bin:$GIT_HOME/bin:/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/root/bin
