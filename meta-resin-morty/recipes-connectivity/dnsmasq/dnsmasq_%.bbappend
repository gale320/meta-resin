FILES_${PN} += "${exec_prefix}/lib/tmpfiles.d/"

do_install_append() {
    # /etc/resolv.conf is now a symlink to /run/resolv.conf (poky b80da02ce9b683f96393fe0ea1f5f1a5f1a07c89) so we remove it from the package install and use systemd tmpfiles to specify dnsmasq listening on 127.0.0.2
    rm ${D}${sysconfdir}/resolv.conf
    install -d ${D}${exec_prefix}/lib/tmpfiles.d/
    echo 'w /run/resolv.conf - - - - # we use dnsmasq at 127.0.0.2 so that user containers can run their own dns cache and forwarder and not conflict with dnsmasq on the host\\nnameserver 127.0.0.2\\n' >> ${D}${exec_prefix}/lib/tmpfiles.d/systemd-dnsmasq.conf
}
