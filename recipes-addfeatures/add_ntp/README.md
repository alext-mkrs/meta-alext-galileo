This recipe adds NTP packages to the image-full (the one for SD card).
For BSp 0.9.0 you need to use the image-full-galileo one (because the image name has changed there).

It depends on the meta-oe/meta-networking layer, which is not enabled by default
by Galileo BSP's setup.sh. Just add it manually to your yocto_build/conf/bblayers.conf.
