LINUX_VERSION = "5.15"
KBRANCH = "xlnx_rebase_v5.15"
SRCREV = "d33b584c51f4d4d5904fe4f20eedc7b254ea2e02"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

KERNEL_IMAGETYPES:remove = "zImage"

SRC_URI += "file://defconfig"

unset KBUILD_DEFCONFIG

do_configure:prepend () {
        cp "${WORKDIR}/defconfig" "${B}/.config"  
}
