#!/bin/bash

set -e

cd beerpong
mvn install -f "pom.xml"

#cp target/*.jar ../server/plugins/
