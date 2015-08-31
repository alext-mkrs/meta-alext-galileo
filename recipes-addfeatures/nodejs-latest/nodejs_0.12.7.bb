DESCRIPTION = "nodeJS Evented I/O for V8 JavaScript"
HOMEPAGE = "http://nodejs.org"
LICENSE = "MIT & BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14115ff11211df04b031ec7d40b6d31b"

DEPENDS = "openssl"

SRC_URI = "http://nodejs.org/dist/v${PV}/node-v${PV}.tar.gz \
"

SRC_URI[md5sum] = "5523ec4347d7fe6b0f6dda1d1c7799d5"
SRC_URI[sha256sum] = "b23d64df051c9c969b0c583f802d5d71de342e53067127a5061415be7e12f39d"

S = "${WORKDIR}/node-v${PV}"

# v8 errors out if you have set CCACHE
CCACHE = ""

ARCHFLAGS_arm = "${@bb.utils.contains('TUNE_FEATURES', 'callconvention-hard', '--with-arm-float-abi=hard', '--with-arm-float-abi=softfp', d)}"
ARCHFLAGS ?= ""

# Node is way too cool to use proper autotools, so we install two wrappers to forcefully inject proper arch cflags to workaround gypi
do_configure () {
    export LD="${CXX}"

    ./configure --prefix=${prefix} --without-snapshot ${ARCHFLAGS}
}

do_compile () {
    export LD="${CXX}"
    make BUILDTYPE=Release
}

do_install () {
    oe_runmake install DESTDIR=${D}
}

RDEPENDS_${PN} = "curl python-shell python-datetime python-subprocess python-crypt python-textutils python-netclient "
RDEPENDS_${PN}_class-native = ""

FILES_${PN} += "${libdir}/node/wafadmin ${libdir}/node_modules ${libdir}/dtrace ${datadir}/systemtap/tapset/node.stp"
BBCLASSEXTEND = "native"
