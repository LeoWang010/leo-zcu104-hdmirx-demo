#
# This is the vct-qt application recipe
#
#

SUMMARY = "vcu-qt demo application"
LICENSE = "BSD"
HOMEPAGE = "https://gitenterprise.xilinx.com/PAEG/"
LIC_FILES_CHKSUM = "file://qml/main.qml;endline=39;md5=5c1439cba070921c94d015c0692fb26e"

DEPENDS = "qtdeclarative qtgraphicaleffects qtsvg qtmultimedia qtcharts vcu-gst-app"

SRC_URI = "file://vcu_qt.zip;subdir=src \
		file://configure_qos.sh;subdir=src \
		file://qt_env.sh;subdir=src \
		file://run_vcu.sh;subdir=src "

#QT_GIT_PROJECT = "vcu_qt"
#
#PV = "1.0.0+${SRCPV}"
#SRCREV = "${AUTOREV}"
#SRCREV_FORMAT = "vcu_qt"

EXTRA_QMAKEVARS_POST = "-r -spec linux-oe-g++"
S = "${WORKDIR}/src"
VCU_QT_BIN_DIR = "opt/vcu_qt/bin"

do_configure_prepend() {
	mv ${S}/include_mv ${S}/include
	export SDKTARGETSYSROOT=${PKG_CONFIG_SYSROOT_DIR}
}

require recipes-qt/qt5/qt5.inc

do_configure_prepend() {
	mv ${S}/include ${S}/include_mv
}

do_compile_prepend() {
	export SDKTARGETSYSROOT=${PKG_CONFIG_SYSROOT_DIR}
}

do_install() {
	install -d ${D}/${VCU_QT_BIN_DIR}
	oe_runmake install INSTALL_ROOT=${B}
	install -m 0755 ${B}/vcu_qt ${D}/${VCU_QT_BIN_DIR}
	install -m 0755 ${S}/configure_qos.sh ${D}/${VCU_QT_BIN_DIR}
	install -m 0755 ${S}/qt_env.sh ${D}/${VCU_QT_BIN_DIR}
	install -m 0755 ${S}/run_vcu.sh ${D}/${VCU_QT_BIN_DIR}
}

FILES_${PN} += "/opt/vcu_qt/bin/vcu_qt \
		/opt/vcu_qt/bin/configure_qos.sh \
		/opt/vcu_qt/bin/qt_env.sh \
		/opt/vcu_qt/bin/run_vcu.sh "

RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins bash"
