SUMMARY = "A basic boot image"
HOMEPAGE = "http://www.jumpnowtek.com"

IMAGE_FEATURES += "package-management"
IMAGE_LINGUAS = "en-us"

inherit image

CORE_OS = " \
    openssh openssh-keygen openssh-sftp-server \
    packagegroup-core-boot \
    tzdata \
"

KERNEL_EXTRA = " \
    kernel-modules \
"

XILINX_EXTRA = " \
    u-boot-zynq-scr \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${KERNEL_EXTRA} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
    echo 'America/New_York' > ${IMAGE_ROOTFS}/etc/timezone
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "basic-image"
