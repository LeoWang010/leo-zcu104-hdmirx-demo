
bin_PROGRAMS = pcie_transcode
lib_LIBRARIES = libpcie_lib.a

AM_DEFAULT_SOURCE_EXT = .c

pcie_transcode_INC_DIR = ../pcie_transcode_app/app/pcie_transcode/include
pcie_lib_INC_DIR = ../pcie_transcode_app/lib/pcie_lib/include

PCI_CFLAGS = $(GST_CFLAGS) $(pkg-config --cflags  gstreamer-1.0 gstreamer1.0-plugins-base libdrm libv4l2 libmediactl)
PCI_LIBS = $(GST_LIBS) $(pkg-config --libs gstreamer-1.0 gstreamer1.0-plugins-base libdrm libv4l2 libmediactl) -lgstvideo-1.0

pcie_transcode_SOURCES = \
			app/pcie_transcode/src/pcie_main.c \
			app/pcie_transcode/src/pcie_src.c
libpcie_lib_a_SOURCES =  \
			lib/pcie_lib/src/pcie_abstract.c

nodist_pcie_transcode_SOURCES = \
		$(pcie_transcode_INC_DIR)/pcie_main.h \
		$(pcie_transcode_INC_DIR)/pcie_src.h

libpcie_lib_a_includedir = /usr/include
libpcie_lib_a_include_HEADERS = \
		$(pcie_lib_INC_DIR)/pcie_abstract.h

pcie_transcode_CFLAGS = $(PCI_CFLAGS) -I$(pcie_transcode_INC_DIR) -I$(pcie_lib_INC_DIR) -I../recipe-sysroot/usr/include/drm -I../recipe-sysroot/usr/include
libpcie_lib_a_CFLAGS = -I$(pcie_lib_INC_DIR)

pcie_transcode_LDFLAGS = -L$(CURDIR) -lpcie_lib $(PCI_LIBS)
