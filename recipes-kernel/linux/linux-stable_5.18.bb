require linux-stable.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "zc706-zynq7"

KERNEL_DEVICETREE = "\
    zynq-zc702.dtb \
    zynq-zc706.dtb \
"

LINUX_VERSION = "5.18"

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-stable-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "5.18.5"
SRCREV = "71563d69a8ec34d41857aca6040e90d54f566ee4"
SRC_URI = " \
    git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;branch=linux-${LINUX_VERSION}.y \
    file://defconfig \
    file://0001-Enable-on-board-NAND-flash.patch \
    file://0002-Consolidate-NAND-into-one-partition.patch \
"
