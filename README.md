Description:
============

This Yocto layer is a collection of various fixes and feature additions
for Intel Galileo board's Linux image (based on Yocto).

These recipes are intended for Galileo Board Support Package (BSP) versions 0.7.5 or v0.9.0.

**URI:** http://downloadmirror.intel.com/23197/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.9.0.7z

**URI:** http://downloadmirror.intel.com/23171/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.7.5.7z

**Layer maintainer:** Alex T <alext.mkrs@gmail.com>

This layer depends on the layers from the abovementioned BSP.
See README files in recipe directories for any additional dependencies.

Due to the fact this is a collection of assorted fixes and feature adds, and even for
different BSP versions, all recipes and bbappend files are disabled by default.
You should enable those you're interested in by removing `.disabled` from the filenames.

Usage:
======

**NOTE:** this is for BSP 0.9.0, for 0.7.5 `bitbake` target names are different, see BSP Build Guide.

* If starting from scratch:
```
tar xzvf meta-clanton_v0.9.0.tar.gz
cd meta-clanton_0.9.0
git clone https://github.com/alext-mkrs/meta-alext-galileo
./setup.sh -e "meta-alext-galileo"
source poky/oe-init-build-env yocto_build/
<Remove the `.disabled` suffix from recipe filenames you're interested in>
bitbake image-full-galileo
```

* If you already have the Yocto build file structure in place:
```
cd YourExistingLayersDir
git clone https://github.com/alext-mkrs/meta-alext-galileo
<Append the full path to the cloned layer dir to the existing list
in your `yocto_build/conf/bblayers.conf` file>
<Remove the `.disabled` suffix from recipe filenames you're interested in>
bitbake image-full-galileo
```

