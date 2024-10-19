#!/bin/bash

# --------------- FUNCTIONS --------------- #

display_help(){
	echo
	echo "Usage $(basename "$0") [options] DEST_DIR [SOURCE_DIR]"
	echo
	echo "Options: "
	echo "	-h/ --help	Shows this message"
	echo "	-rmd		Removes the directories after copying the files"
	echo
	echo "DEST_DIR is required!"
	echo "It can exist, but doesn't have to."
	echo
	echo "SOURCE_DIR is an option."
	echo "You can give as multiple and the program will copy their content to the DEST_DIR"
	echo
	exit 0
}

# --------------- PRE- PROCESS -------------- #

if [ "$#" -lt 1 ]; then
	echo "Must give the directorys name you want to copy to."
	echo "Type '-h/ --help' for help."
	exit 1
fi

while [[ "$1" == -* ]]; do
	case "$1" in 
		-h | --help)
			display_help
			;;
		-rmd)
			rmd=1
			;;
		*)
			echo "Invalid argument $1"
			exit 1
			;;
	esac
	shift
done

mkdir -p "$1"
DEST_DIR="$1"
rmd=0
shift

file_count=0

# -------------- PROGRAM -------------- #

while [[ $# -gt 0 ]]; do
	if [ -d "$1" ]; then
		file_count=$(find "$1" -maxdepth 1 -type f | wc -l)
		if [ "$file_count" -eq 0 ]; then
			echo "Directory $1 already empty"
		else
			mv "$1"/* "$1"/.[!.]* "$DEST_DIR"/
			file_count=$(find "$1" -maxdepth 1 -type f | wc -l)
			if [ "$file_count" -ne 0 ]; then
				echo "Error in file transfer, $file_count files couldn't be transferrred"
			elif [ "$rmd" -eq 1 ]; then
				rm -rf "$1"
			fi
		fi
	else
  		echo "Source directory $1 does not exist."
  		exit 1
	fi
	shift
    file_count=0
done
