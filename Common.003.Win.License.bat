

cd .\bin

rd /s/q .\org\hy\common\license\junit


jar cvfm hy.common.license.jar MANIFEST.MF LICENSE org

copy hy.common.license.jar ..
del /q hy.common.license.jar
cd ..

