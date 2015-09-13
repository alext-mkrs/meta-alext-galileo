Description:
============

This Yocto layer is a collection of various fixes and feature additions
for Intel Galileo board's Linux image (based on Yocto).

These recipes are intended for all Galileo Board Support Package (BSP) versions,
including the latest one. See build environment setup instructions under URI below.

**URI:** http://downloadmirror.intel.com/24355/eng/BSP-Patches-and-Build_Instructions.1.0.4.txt

**Layer maintainer:** Alex T <alext.mkrs@gmail.com>

This layer depends on the layers from the abovementioned BSP.
See README files in recipe directories for any additional dependencies and other
specific instructions.

Due to the fact this is a collection of assorted fixes and feature adds, and even for
different BSP versions, all recipes and bbappend files are disabled by default,
except for dmidecode compilation fix, which should be generally applicable and harmless.
You should enable those you're interested in by removing `.disabled` from the filenames.

Please also note that over time, the `image-devtools` branch became more important
and contains more recipes than `master`. Initially it was intended for my "devtools" image only.

Usage:
======

* If starting from scratch:
```
# setup build environment per the README linked above
cd meta-clanton_v1.0.1
git clone https://github.com/alext-mkrs/meta-alext-galileo
./setup.sh -e "meta-alext-galileo"
<Remove the `.disabled` suffix from recipe filenames you're interested in>
<optionally: switch to the image-devtools branch with git checkout image-devtools>
source poky/oe-init-build-env yocto_build/
bitbake image-full-galileo
```

* If you already have the Yocto build file structure in place (e.g. in `./meta-clanton_v1.0.1`):
```
cd ./meta-clanton_v1.0.1
git clone https://github.com/alext-mkrs/meta-alext-galileo
<Append the full path to the cloned layer dir to the existing list
in your `yocto_build/conf/bblayers.conf` file>
<Remove the `.disabled` suffix from recipe filenames you're interested in>
<optionally: switch to the image-devtools branch with git checkout image-devtools>
source poky/oe-init-build-env yocto_build/
bitbake image-full-galileo
```

