FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

KERNEL_IMAGETYPES:remove = "zImage"

SRC_URI += "file://defconfig"

unset KBUILD_DEFCONFIG

do_configure:prepend () {
        cp "${WORKDIR}/defconfig" "${B}/.config"  
}
