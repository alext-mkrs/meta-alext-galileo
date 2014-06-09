FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://dns_and_dhcpd.cfg"

PRINC := "${@int(PRINC) + 2}"
