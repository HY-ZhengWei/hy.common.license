#!/bin/sh

cd ./bin

rm -R ./org/hy/common/license/junit


jar cvfm hy.common.license.jar MANIFEST.MF LICENSE org

cp hy.common.license.jar ..
rm hy.common.license.jar
cd ..

