DESCRIPTION = "Motion detection software"
HOMEPAGE = "http://motion.sourceforge.net/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=8ca43cbc842c2336e835926c2166c28b"
PR = "r0"

DEPENDS = "libav"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://downloads.sourceforge.net/project/motion/motion%20-%203.2/${PV}/motion-${PV}.tar.gz \
           file://fix_v4l_includes.patch \
"
SRC_URI[md5sum] = "1ba0065ed50509aaffb171594c689f46"
SRC_URI[sha256sum] = "a597f8d7ec0bf3c5fb62722c4eead59717fe01c2ae0d256c642027cea74b2f0a"

inherit autotools gettext
