SUMMARY = "A console development image with some C/C++ dev tools"

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

DEV_SDK = " \
    binutils binutils-symlinks \
    coreutils \
    cpp cpp-symlinks \
    diffutils \
    elfutils elfutils-binutils \
    file \
    gcc gcc-symlinks \
    g++ g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ libstdc++-dev \
    libtool \
    ltrace \
    make \
    mtd-utils \
    perl-modules \
    pkgconfig \
    python3-modules \
    strace \
"

EXTRA_TOOLS = " \
    bzip2 \
    curl \
    dosfstools \
    e2fsprogs-mke2fs \
    ethtool \
    fbset \
    findutils \
    grep \
    i2c-tools \
    ifupdown \
    iperf3 \
    iproute2 \
    iptables \
    less \
    lsof \
    netcat-openbsd \
    ntp ntp-tickadj \
    parted \
    procps \
    sysfsutils \
    tcpdump \
    util-linux \
    util-linux-blkid \
    unzip \
    wget \
    zip \
"

SECURITY_TOOLS = " \
    checksec \
    nmap \
"

SYSTEMD_STUFF = " \
    systemd-analyze \
    systemd-bash-completion \
"

IMAGE_INSTALL += " \
    ${CORE_OS} \
    ${DEV_SDK} \
    ${EXTRA_TOOLS} \
    ${KERNEL_EXTRA} \
    ${SECURITY_TOOLS} \
    ${SYSTEMD_STUFF} \
"

set_local_timezone() {
    ln -sf /usr/share/zoneinfo/EST5EDT ${IMAGE_ROOTFS}/etc/localtime
}

ROOTFS_POSTPROCESS_COMMAND += " \
    set_local_timezone ; \
"

export IMAGE_BASENAME = "console-image"
