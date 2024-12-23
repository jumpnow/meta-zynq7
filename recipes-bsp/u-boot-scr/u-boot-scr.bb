SUMMARY = "U-boot boot scripts for zynq7"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

COMPATIBLE_MACHINE = "zc706-zynq7"

DEPENDS = "u-boot-mkimage-native"

INHIBIT_DEFAULT_DEPS = "1"

DEVICETREE_ADDRESS = "0x2000000"
KERNEL_LOAD_ADDRESS = "0x2080000"

SRC_URI = "file://boot.cmd.sd.zynq"

S = "${UNPACKDIR}"

do_compile() {
    sed -e 's/@@DEFAULT_DTB@@/${DEFAULT_DTB}.dtb/' \
        -e 's/@@DEVICETREE_ADDRESS@@/${DEVICETREE_ADDRESS}/' \
        -e 's/@@KERNEL_LOAD_ADDRESS@@/${KERNEL_LOAD_ADDRESS}/' \
        "${UNPACKDIR}/boot.cmd.sd.zynq" > boot.cmd
    mkimage -A ${UBOOT_ARCH} -T script -C none -n "Boot script" -d boot.cmd boot.scr
}

inherit kernel-arch deploy nopackages

do_deploy() {
    install -d ${DEPLOYDIR}
    install -m 0644 boot.scr ${DEPLOYDIR}
}

addtask do_deploy after do_compile before do_build
