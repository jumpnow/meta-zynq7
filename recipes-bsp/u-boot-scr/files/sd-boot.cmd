setenv console ttyPS0,115200
setenv fdtfile zynq-zc706.dtb
setenv bootpart 0:2
setenv bootdir /boot
setenv mmcroot /dev/mmcblk0p2 ro
setenv mmcrootfstype ext4 rootwait
load mmc ${bootpart} ${fdt_addr_r} ${bootdir}/${fdtfile}
load mmc ${bootpart} ${kernel_addr_r} ${bootdir}/uImage
setenv bootargs console=${console} root=${mmcroot} rootfstype=${mmcrootfstype}
bootm ${kernel_addr_r} - ${fdt_addr_r}
