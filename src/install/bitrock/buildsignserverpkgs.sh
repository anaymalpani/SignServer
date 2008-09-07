#!/bin/bash
# This script requires that ant and builder is in the path
# The jboss prepared dist should be in JBOSS-DIST and 
# signserver_build.properties should be preconfigured.

cd ../../..
ant clean 
ant
ant pkgdist

cd src/install/bitrock
builder build signservernode-unix.xml linux
builder build signservermgmt-unix.xml linux
builder build signservernode-windows.xml windows
builder build signservermgmt-windows.xml windows
