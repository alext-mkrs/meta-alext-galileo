This layer depends on meta-clanton-galileo layer.

URI: http://downloadmirror.intel.com/23197/eng/Board_Support_Package_Sources_for_Intel_Quark_v0.8.0.7z
branch: n/a
revision: 0.8.0

Layer maintainer: Alex T <alext.mkrs@gmail.com>

To add this layer when building Galileo images, you'll need to clone the repo
contents into directory where you've unpacked your meta-clanton package, then
pass the layer name to the setup.sh script.

If you already have everything setup, then you'll need to add the path to the
layer directory into your yocto_build/conf/bblayers.conf file manually, because
running setup.sh after it was already run once won't work.

Full set of steps as per the BSP Building Guide + the steps needed to enable
meta-alext-galileo layer are below:

```
tar xzvf meta-clanton_v0.8.0.tar.gz
cd meta-clanton_0.8.0
git clone https://github.com/alext-mkrs/meta-alext-galileo
./setup.sh -e "meta-clanton-galileo meta-alext-galileo"
source poky/oe-init-build-env yocto_build/
bitbake image-full
```
