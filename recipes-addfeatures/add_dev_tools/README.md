This recipe adds development tools to the image-full (BSP 0.7.5) or
image-full-galileo (BSP 1.0.0 and above), the one for SD card.

To be able to build the image, you'll need to implement two fixes in the Poky
sources first:

1) http://git.yoctoproject.org/cgit.cgi/poky-contrib/commit/?h=hongxu/fix-su&id=26207e241ddc469b951ffea26dfc0661817d124d
2) https://lists.yoctoproject.org/pipermail/poky/2014-January/009560.html

After building the image, you'll need to boot it and remove two packages to
restore mount and umount from Busybox. Those from util-linux are broken.
You'll see some error messages and even segfaults during this first boot - that's expected.

```
opkg remove --force-depends util-linux-mount util-linux-umount
```

