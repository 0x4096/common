#!/usr/bin/bash

mvn clean install org.apache.maven.plugins:maven-deploy-plugin:2.8:deploy -DskipTests
