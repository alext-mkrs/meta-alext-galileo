DESCRIPTION = "Small and simple webcam software for *nix"
HOMEPAGE = "http://www.sanslogic.co.uk/fswebcam/"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=393a5ca445f6965873eca0259a17f833"
PR = "r0"

DEPENDS = "gd"
RDEPENDS_${PN} = "gd"

#FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://www.sanslogic.co.uk/fswebcam/files/fswebcam-${PV}.tar.gz \
"

SRC_URI[md5sum] = "88e654edcf63504fa39f962c75d31361"
SRC_URI[sha256sum] = "3ee389f72a7737700d22e0c954720b1e3bbadc8a0daad6426c25489ba9dc3199"

inherit autotools gettext

do_install_append() {
  install -D -m 0644 ${S}/example.conf ${D}${sysconfdir}/fswebcam.conf
}
