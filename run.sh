#!/bin/bash

set -e

cd server/
java -Xmx1024M -Xms1024M -jar spigot-1.15.2.jar nogui
