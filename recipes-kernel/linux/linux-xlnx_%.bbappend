FILESEXTRAPATHS_prepend := "${THISDIR}/linux-xlnx:"

KERNEL_IMAGETYPES_remove = "zImage"

KBUILD_DEFCONFIG_zynq = ""

SRC_URI += "file://defconfig"
