#!/bin/bash

# Qos = 3 for VCU
/sbin/devmem 0xfd370008 w 0x3
/sbin/devmem 0xfd37001C w 0x3
/sbin/devmem 0xfd380008 w 0x3
/sbin/devmem 0xfd38001c w 0x3
/sbin/devmem 0xfd390008 w 0x3
/sbin/devmem 0xfd39001c w 0x3
/sbin/devmem 0xfd3a0008 w 0x3
/sbin/devmem 0xfd3a001c w 0x3
/sbin/devmem 0xfd3b0008 w 0x3
/sbin/devmem 0xfd3b001c w 0x3

# 16 outstanding request for VCU
/sbin/devmem 0xfd380004 w 0xF
/sbin/devmem 0xfd390004 w 0xF
/sbin/devmem 0xfd3A0004 w 0xF
/sbin/devmem 0xfd3B0004 w 0xF
/sbin/devmem 0xfd380018 w 0xF
/sbin/devmem 0xfd390018 w 0xF
/sbin/devmem 0xfd3A0018 w 0xF
/sbin/devmem 0xfd3B0018 w 0xF
