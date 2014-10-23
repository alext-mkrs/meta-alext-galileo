SUMMARY = "C library for lightweight websocket clients and servers"
DESCRIPTION = "Libwebsockets is a lightweight pure C library built \
               to use minimal CPU and memory resources, and provide \
               fast throughput in both directions."
HOMEPAGE = "http://libwebsockets.org"

LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://${S}/LICENSE;md5=041a1dec49ec8a22e7f101350fd19550"

SRC_URI = "http://git.libwebsockets.org/cgi-bin/cgit/${PN}/snapshot/${PN}-${PV}-chrome37-firefox30.tar.gz"
SRC_URI[md5sum] = "63117f35174a5fe4ec062f6baa411638"
SRC_URI[sha256sum] = "022c91f821014c50b9db5fb93404df475dc081a7c23b57fca9529e3ddcc5d821"

S = "${WORKDIR}/${PN}-${PV}-chrome37-firefox30"

DEPENDS += "openssl"

inherit cmake

do_configure() {
  # This line allows to tell openssl where its config files are located
  export OPENSSL_CONF=${TMPDIR}/sysroots/x86_64-linux/usr/lib/ssl/openssl.cnf
  cmake_do_configure
}

PACKAGES += "${PN}-tests"

FILES_${PN}-tests += "${bindir}/libwebsockets-test* \
                      ${datadir}/libwebsockets-test-server/* \
                     "

