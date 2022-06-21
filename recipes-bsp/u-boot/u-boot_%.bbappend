FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

UBOOT_SUFFIX = "img"

SPL_BINARY = "spl/boot.bin"

SRC_URI += "file://0001-Add-bootz-support.patch"

do_configure:append () {
    if [ -f ${B}/.config ]; then
        sed -i '/CONFIG_DEFAULT_DEVICE_TREE/c\CONFIG_DEFAULT_DEVICE_TREE="${DEFAULT_DTB}"' ${B}/.config
        sed -i '/CONFIG_OF_LIST/c\CONFIG_OF_LIST="${DEFAULT_DTB}"' ${B}/.config
    fi
}
