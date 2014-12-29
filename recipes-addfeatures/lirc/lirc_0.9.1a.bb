DESCRIPTION = "Linux Infrared Remote Control"
HOMEPAGE = "http://www.lirc.org"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

PR = "r0"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "http://downloads.sourceforge.net/project/${PN}/LIRC/${PV}/${PN}-${PV}.tar.gz \
           file://replaced-libsystemd-daemon-with-libsystemd.patch \
           file://corrected-surplus-systemd-dir-check.patch \
"


SRC_URI[md5sum] = "3d304a430014c96284797913d6ace6cd"
SRC_URI[sha256sum] = "b8bf3706f35ff55c48320c45d56917f3e76e421290cec5cb6a1bfb347213eb48"

inherit autotools

EXTRA_OECONF = "--with-syslog --with-driver=userspace"

do_install_append() {
    # systemd piece
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/systemd/lircd.service ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/systemd/lircd.socket ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/systemd/lircmd.service ${D}${systemd_unitdir}/system/

    # example configs
    install -d ${D}${datadir}/${PN}/remotes/
    cp -r ${S}/remotes/* ${D}${datadir}/${PN}/remotes/
    chmod -R 0644 ${D}${datadir}/${PN}/remotes
}

FILES_${PN} += "/run"

inherit systemd

SYSTEMD_AUTO_ENABLE = "disable"
SYSTEMD_SERVICE_${PN} = "lircd.service lircd.socket lircmd.service"

