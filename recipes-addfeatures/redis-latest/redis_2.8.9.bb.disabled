SUMMARY = "Redis key-value store"
DESCRIPTION = "Redis is an open source, advanced key-value store."
HOMEPAGE = "http://redis.io"
SECTION = "libs"
LICENSE = "BSD"
LIC_FILES_CHKSUM="file://COPYING;md5=6b461289550ee3815f95e4dcef58cc5e"

SRC_URI = "http://download.redis.io/releases/redis-${PV}.tar.gz \
           file://hiredis-use-default-CC-if-it-is-set.patch \
           file://adjust_lua_flags.patch \
           file://oe-use-libc-malloc.patch \
           file://redis.conf \
           file://init-redis-server \
"

inherit update-rc.d

INITSCRIPT_NAME = "redis-server"
INITSCRIPT_PARAMS = "defaults 87"

SRC_URI[md5sum] = "3c106b0f1128dc930684e2da88b2a03d"
SRC_URI[sha256sum] = "7834c37f2ff186c46aef8e4a066dfbf1d6772a285aa31c19c58162f264f1007f"

do_install() {
    export PREFIX=${D}/${prefix}
    oe_runmake install

    install -d ${D}/${sysconfdir}/redis
    install -m 0755 ${WORKDIR}/redis.conf ${D}/${sysconfdir}/redis/redis.conf

    install -d ${D}/${sysconfdir}/init.d 
    install -m 0755 ${WORKDIR}/init-redis-server ${D}/${sysconfdir}/init.d/redis-server

    install -d ${D}/var/lib/redis/
}

