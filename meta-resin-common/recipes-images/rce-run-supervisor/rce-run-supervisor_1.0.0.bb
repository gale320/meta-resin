DESCRIPTION = "rce run supervisor"
SECTION = "console/utils"
LICENSE = "Apache-2.0" 
PR = "r1.2"
LIC_FILES_CHKSUM = "file://${RESIN_COREBASE}/COPYING.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
SRC_URI = "file://rce-run-supervisor"

FILES_${PN} = "${bindir}/*"

do_compile() {
}

do_install() {
	install -d ${D}${bindir}
	install -m 0775 ${WORKDIR}/rce-run-supervisor ${D}${bindir}/rce-run-supervisor
}

pkg_postinst_${PN} () {
#!/bin/sh -e
# Commands to carry out
# Remove networking
}

