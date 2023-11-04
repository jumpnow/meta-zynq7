SUMMARY = "A console development image for the zynq7"

require console-image.bb

DEV_SDK = " \
    binutils binutils-symlinks \
    cmake \
    cpp cpp-symlinks \
    elfutils elfutils-binutils \
    gcc gcc-symlinks \
    g++ g++-symlinks \
    gettext \
    git \
    ldd \
    libstdc++ libstdc++-dev \
    libtool \
    make \
    pkgconfig \
    python3-modules \
"

SECURITY_TOOLS = " \
    checksec \
    nmap \
"

IMAGE_INSTALL += " \
    ${DEV_SDK} \
    ${SECURITY_TOOLS} \
"

export IMAGE_BASENAME = "console-dev-image"
