SRC_URI += "file://user.cfg"

SRC_URI_append = " \
				file://0001-media-xilinx-TPG-Add-IOCTL-to-set-PPC.patch \
				file://0002-Add-2nd-HDMI-support-by-adding-a-dummy-driver.patch \
				file://0003-drm-xlnx_mixer-Dont-enable-primary-plane-by-default.patch \
				file://0004-drm_atomic_helper-Supress-vblank-timeout-warning-mes.patch \
				file://0006-drivers-misc-add-support-for-interrupt-based-PCIe-en.patch \
				file://0007-xilinx_pci_endpoint-Add-resolution-use-case-and-64-b.patch \
				file://0001-sdirxss-update-the-gt-clock-only-when-framerate-is-c.patch \
				file://0008-Added-ioctl-to-support-different-formats.patch \
				file://0001-sdi-tx-Add-fractional-framerate-support-for-SDI-Tx.patch \
"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
