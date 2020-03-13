FILESEXTRAPATHS_prepend := "${THISDIR}/linux-xlnx:"

KERNEL_IMAGETYPES_remove = "zImage"

SRC_URI += "file://defconfig"
