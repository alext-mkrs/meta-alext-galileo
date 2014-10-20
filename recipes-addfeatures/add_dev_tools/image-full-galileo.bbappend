# dev-pkgs breaks i2c communications and Cypress port extender driver as a result.
# Therefore not including it for now.
#IMAGE_FEATURES += "dev-pkgs tools-sdk"
IMAGE_FEATURES += "tools-sdk"
# This is not included into tools-sdk
IMAGE_INSTALL_append = " git motion hostap-daemon redis vim"
#increasing rootfs size to provide more free space
IMAGE_ROOTFS_SIZE = "2097152"