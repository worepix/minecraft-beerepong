#!/bin/bash

set -e

cd beerpong
mvn install -f "/home/radim/Documents/Own/mc-beerpong/beerpong/pom.xml"

if [ "$1" == ""]; then
    exit 0
fi

cp target/*.jar ../server/plugins/
