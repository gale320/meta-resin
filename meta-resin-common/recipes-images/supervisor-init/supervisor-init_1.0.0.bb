DESCRIPTION = "Resin Supervisor custom INIT file"
SECTION = "console/utils"
RDEPENDS_${PN} = "resin-device-register resin-device-progress"
LICENSE = "Apache-2.0" 
PR = "r1.22"
LIC_FILES_CHKSUM = "file://${RESIN_COREBASE}/COPYING.Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"
SRC_URI = " \
	   file://supervisor-init \
	   file://inittab \
	   file://tty-replacement \
	   file://resin.conf \
	  "

FILES_${PN} = "${sysconfdir}/* ${base_bindir}/*"

do_compile() {
}

do_install() {
	install -d ${D}${sysconfdir}/init.d
    	install -d ${D}${sysconfdir}/rc5.d
	install -d ${D}${sysconfdir}/default
	install -d ${D}${sysconfdir}
	install -d ${D}${base_bindir}

	install -m 0755 ${WORKDIR}/supervisor-init  ${D}${sysconfdir}/init.d/
	install -m 0755 ${WORKDIR}/resin.conf ${D}${sysconfdir}/

	ln -sf ../init.d/supervisor-init  ${D}${sysconfdir}/rc5.d/S99supervisor-init
	install -m 0755 ${WORKDIR}/inittab ${D}${sysconfdir}/
	install -m 0755 ${WORKDIR}/tty-replacement ${D}${base_bindir}
}

pkg_postinst_${PN} () {
#!/bin/sh -e
# Commands to carry out
}

