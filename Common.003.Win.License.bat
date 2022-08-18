

cd .\bin


rd /s/q .\org\hy\common\license\junit
del  /q .\org\hy\common\license\LicenseFactory.class


jar cvfm hy.common.license.jar MANIFEST.MF META-INF org

copy hy.common.license.jar ..
del /q hy.common.license.jar
cd ..





cd .\src
jar cvfm hy.common.license-sources.jar MANIFEST.MF META-INF org 
copy hy.common.license-sources.jar ..
del /q hy.common.license-sources.jar
cd ..
