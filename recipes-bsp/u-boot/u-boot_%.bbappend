FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

UBOOT_SUFFIX = "img"

SPL_BINARY = "spl/boot.bin"

SRC_URI += "file://0001-Add-bootz-support.patch"
