#!/bin/sh

cd ./bin


rm -R ./org/hy/common/license/junit


jar cvfm hy.common.license.jar MANIFEST.MF META-INF org

cp hy.common.license.jar ..
rm hy.common.license.jar
cd ..





cd ./src
jar cvfm hy.common.license-sources.jar MANIFEST.MF META-INF org 
cp hy.common.license-sources.jar ..
rm hy.common.license-sources.jar
cd ..
