Description:
============

**URI:** http://downloadmirror.intel.com/23197/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.8.0.7z

**URI:** http://downloadmirror.intel.com/23171/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.7.5.7z

**revision:** 0.8.0 & 0.7.5

**Layer maintainer:** Alex T <alext.mkrs@gmail.com>

This layer depends on the following layers from the above archive:

- meta-clanton-galileo (elfutils fix for BSP 0.8.0)
- meta-oe/meta-networking (ntp for BSP 0.8.0)
- meta-clanton-bsp (USB audio enablement for BSP 0.7.5)
- meta-oe/meta-oe (libav fix for BSP 0.8.0)

You'll need to have these listed in your `bblayers.conf` to build the image successfully.
This will usually be the case already, but worth double-checking.

Due to the fact this is a collection of assorted fixes and feature adds, and even for
different BSP versions, all recipes and bbappend files are disabled by default.
You should enable those you're interested in by removing `.disabled` from the filenames.

Usage:
======
* If starting from scratch:
```
tar xzvf meta-clanton_v0.8.0.tar.gz
cd meta-clanton_0.8.0
git clone https://github.com/alext-mkrs/meta-alext-galileo
./setup.sh -e "meta-clanton-galileo meta-alext-galileo"
source poky/oe-init-build-env yocto_build/
<Remove the `.disabled` suffix from recept filenames you're interested in>
bitbake image-full
```

* If you already have the Yocto build file structure in place:
```
cd YourExistingLayersDir
git clone https://github.com/alext-mkrs/meta-alext-galileo
<Append the full path to the cloned layer dir to the existing list
in your `yocto_build/conf/bblayers.conf` file>
<Remove the `.disabled` suffix from recept filenames you're interested in>
bitbake image-full
```

