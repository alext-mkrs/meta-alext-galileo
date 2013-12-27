**URI:** http://downloadmirror.intel.com/23197/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.8.0.7z

**branch:** n/a

**revision:** 0.8.0

**Layer maintainer:** Alex T <alext.mkrs@gmail.com>

This layer depends on the following layers from the above archive:

- meta-clanton-galileo (elfutils fix)
- meta-oe/meta-networking (ntp)

You'll need to have them listed to build the image successfully.

All recipes and bbappend files are by default enabled. You can disable
those you're not interested in by adding `.disabled` to the filenames.

To add this layer when building Galileo images, you'll need to clone the repo
contents into directory where you've unpacked your meta-clanton package, then
pass the layer name to the setup.sh script.

If you already have everything setup, then you'll need to add the path to the
layer directory into your yocto_build/conf/bblayers.conf file manually, because
running setup.sh after it was already run once won't work.

Full set of steps as per the BSP Building Guide + the steps needed to enable
meta-alext-galileo layer from scratch are below:

```
tar xzvf meta-clanton_v0.8.0.tar.gz
cd meta-clanton_0.8.0
git clone https://github.com/alext-mkrs/meta-alext-galileo
./setup.sh -e "meta-clanton-galileo meta-alext-galileo"
source poky/oe-init-build-env yocto_build/
bitbake image-full
```
