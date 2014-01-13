#!/bin/sh
# Alex T <alext.mkrs@gmail.com>
# http://github.com/alext-mkrs/meta-alext-galileo
### BEGIN INIT INFO
# Provides:          set_sketch_dir
# Required-Start:    $all
# Required-Stop:
# Default-Start:     5
# Default-Stop:
# Short-Description: Redirects the sketch dir to USB thumbdrive if connected
### END INIT INFO

THUMBDRIVE_SKETCH_DIR="/media/sda1/sketch"
LOCAL_SKETCH_DIR="/sketch"

# If this succeeds, we've booted off an SD card
# Not the nicest detection, but I haven't yet found any better
mount |grep realroot |grep -q mmcblk
if [ $? -eq 0 ]
then
    echo "We've booted off an SD card, won't touch anything" >> /var/log/set_sketch_dir.log
    exit 0
fi

if [ -d ${THUMBDRIVE_SKETCH_DIR} -a -w ${THUMBDRIVE_SKETCH_DIR} ]
then
    rm -rf ${LOCAL_SKETCH_DIR}
    # Note that we don't create this dir on the thumbdrive on purpose,
    # to avoid messing up with drives that got connected by mistake.
    # This logic can be changed if needed
    ln -sf ${THUMBDRIVE_SKETCH_DIR} ${LOCAL_SKETCH_DIR}
fi

: exit 0