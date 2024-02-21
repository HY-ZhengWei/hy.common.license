

del /Q hy.common.license.jar
del /Q hy.common.license-sources.jar


call mvn clean package
cd .\target\classes


rd /s/q .\org\hy\common\license\junit
del  /q .\org\hy\common\license\LicenseFactory.class



jar cvfm hy.common.license.jar META-INF/MANIFEST.MF META-INF org

copy hy.common.license.jar ..\..
del /q hy.common.license.jar
cd ..\..





cd .\src\main\java
xcopy /S ..\resources\* .
jar cvfm hy.common.license-sources.jar META-INF\MANIFEST.MF META-INF org 
copy hy.common.license-sources.jar ..\..\..
del /Q hy.common.license-sources.jar
rd /s/q META-INF
cd ..\..\..

pause