FILESEXTRAPATHS:prepend := "${THISDIR}/linux-xlnx:"

KERNEL_IMAGETYPES:remove = "zImage"

KBUILD_DEFCONFIG_zynq = ""

SRC_URI += "file://defconfig"
