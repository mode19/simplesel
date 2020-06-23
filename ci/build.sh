#!/bin/bash

VERSION=0.2


echo "b - build"
echo "p - push"
read -n1 CHAR
echo "chose=$CHAR"
case "$CHAR" in
        b) echo "build"
           sudo docker build -f ./Dockerfile -t imranhomedocker/myjenkins-inbound:$VERSION -t imranhomedocker/myjenkins-inbound:latest .
	    ;;
        p) 
           sudo docker push imranhomedocker/myjenkins-inbound:$VERSION
	    ;;
        *) echo "invalid key "
           ;;
esac
