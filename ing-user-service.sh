#!/bin/sh

nohup java -agentlib:jdwp=transport=dt_socket,address=8788,server=y,suspend=n -Dspring.profiles.active=prod -jar target/ing-assessment.jar --server.port=8730 --server.address=0.0.0.0 > messaging.log &
