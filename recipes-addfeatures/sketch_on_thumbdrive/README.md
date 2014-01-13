Description
===========

This recipe enables persistent sketch storage on USB thumbdrive for the case
when all of the below is true at the same time:

- you're booting from SPI (not from SD card);
- you have the thumbdrive connected to Galileo's host USB port during boot;
- there's a `sketch` directory in the root of the thumbdrive;

In such a case the init script will remove the default sketch dir created
in RAM and replace it with a symlink to the thumbdrive's sketch dir.
No changes needed on the IDE side, it will use it transparently.

If you plugged the thumbdrive in after booting Galileo, you still can enable
this feature, but you'll need to run the `/etc/init.d/set_sketch_dir.sh`
manually, either through SSH or serial console or from a sketch using
`system()` or `popen()` or equivalent.

Image preparation
=================

As long as the SPI image is fixed, you'll need to compile your own with this
recipe enabled and then create a *.cap or *.bin file using BSP Build Guide or
script from http://github.com/alext-mkrs/galileo-fw and flash it to the board.
