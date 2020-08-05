#
# This is the vct-gst-app application recipe
#
#
SUMMARY = "pcie_transcode application"
SECTION = "PETALINUX/apps"
DESCRIPTION = "gstreamer test applications for VCU in ZynqMP"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=1a59b35f362129863822d80cb0e05bae"

SRC_URI = " \
	file://AUTHORS;subdir=pcie_transcode_app \
	file://autogen.sh;subdir=pcie_transcode_app \
	file://configure.ac;subdir=pcie_transcode_app \
	file://COPYING;subdir=pcie_transcode_app \
	file://Makefile.am;subdir=pcie_transcode_app \
	file://pcie_lib.zip;name=pcie_lib;subdir=pcie_transcode_app/lib/pcie_lib \
	file://pcie_transcode.zip;name=pcie_transcode;subdir=pcie_transcode_app/app/pcie_transcode"

S = "${WORKDIR}/pcie_transcode_app"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base v4l-utils libdrm"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit pkgconfig autotools

# Specify any options you want to pass to the configure script using EXTRA_OECONF:
EXTRA_OECONF = ""

FILES_${PN} += "/usr/bin/pcie_transcode"

do_install() {
	install -d ${D}/${bindir}
	oe_runmake install DESTDIR=${D}
	install -m 0755 ${B}/pcie_transcode ${D}/${bindir}
}
