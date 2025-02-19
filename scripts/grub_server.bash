#!/bin/env bash

#
# This script requires tight hand-shaking with the initial server
# script grub_server that invokes this script
#
# This script will run the 'build' program to perform the build of 'repo'
# in directory 'server_root'
#
server_root=$1
repo=$2
branch=$3

if ! [ -d "${server_root}/${repo}" ]; then
  echo "Directory ${server_root}/${repo} does not exist! No build performed." >&2
  exit 4
fi
cd "${server_root}/${repo}" && git checkout "${branch}" >/dev/null 2>&1 && mvn package
