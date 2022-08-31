require linux-stable.inc

LIC_FILES_CHKSUM = "file://COPYING;md5=6bc538ed5bd9a7fc9398086aedcd7e46"

KERNEL_CONFIG_COMMAND = "oe_runmake_call -C ${S} CC="${KERNEL_CC}" O=${B} olddefconfig"

COMPATIBLE_MACHINE = "zc706-zynq7"

KERNEL_DEVICETREE = "\
    zynq-zc706.dtb \
"

LINUX_VERSION = "5.15"

FILESEXTRAPATHS:prepend := "${THISDIR}/linux-xlnx-${LINUX_VERSION}:"

S = "${WORKDIR}/git"

PV = "5.15.36"
SRCREV = "7e41fe9f1663e176fca4e76fef0c7e3057aee43b"
SRC_URI = " \
    git://github.com/Xilinx/linux-xlnx.git;protocol=https;branch=xlnx_rebase_v5.15_LTS \
    file://defconfig \
"
