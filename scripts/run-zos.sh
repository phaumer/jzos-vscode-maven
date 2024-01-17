#!/bin/sh
################################################################
# LICENSED MATERIALS - PROPERTY OF IBM
# "RESTRICTED MATERIALS OF IBM"
# (C) COPYRIGHT IBM CORPORATION 2024. ALL RIGHTS RESERVED
# US GOVERNMENT USERS RESTRICTED RIGHTS - USE, DUPLICATION,
# OR DISCLOSURE RESTRICTED BY GSA ADP SCHEDULE
# CONTRACT WITH IBM CORPORATION
################################################################

FILES_CMD=zos-files                 # for z/OSMF use "zos-files", for RSE API use "rse"
COMMAND_CMD="zos-ssh issue command" # for z/OSMF use "zos-ssh issue command", for RSE API use "rse issue command"
JOBS_CMD=zos-jobs                   # for z/OSMF use "zos-jobs", for RSE API use "rse"
PROFILE=""                          # to use a non-default profile use "--rse-profile profileName"

USER=ibmuser
LOCAL_PROGRAM=$1
INPUT1=$2
REMOTE_PROGRAM=/u/$USER/projects/java/$(basename $LOCAL_PROGRAM)
if [ -z "$3" ]; then
  DEBUG_OPTIONS=""
else
  DEBUG_OPTIONS="-agentlib:jdwp=transport=dt_socket,server=y,suspend=y,address=*:8000"
fi

set -ex
echo "Uploading jar file.."
zowe $FILES_CMD upload file-to-uss $LOCAL_PROGRAM \"$REMOTE_PROGRAM\" --binary $PROFILE
echo "Starting Java application.."
zowe $COMMAND_CMD "java $DEBUG_OPTIONS -jar \"$REMOTE_PROGRAM\" $INPUT1" $PROFILE
