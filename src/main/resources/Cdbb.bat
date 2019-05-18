@echo off
set argC=0
for %%x in (%*) do Set /A argC+=1
if /I "%argC%" NEQ "1" (
	echo USAGE: .\Cdbb.bat [file path]
) else (
	java -jar Cdbb-0.1-jar-with-dependencies.jar %1
)