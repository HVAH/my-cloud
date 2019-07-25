#!/usr/bin/env bash
rm -rf /opt/tools/jmeter-5.1.1/log/*
rm -rf /opt/tools/jmeter-5.1.1/html/*
rm -rf ${WORKSPACE}/test.jtl
/opt/tools/jmeter-5.1.1/bin/jmeter.sh  -n -t /opt/tools/jmeter-5.1.1/script/test.jmx -l test.jtl -j  /opt/tools/jmeter-5.1.1/log/test.log
