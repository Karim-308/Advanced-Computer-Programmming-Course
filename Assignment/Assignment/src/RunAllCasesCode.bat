@echo off
javac *.java
java App NormalCase.arxml
java App EmptyFile.arxml
java App NotValid.txt
pause
