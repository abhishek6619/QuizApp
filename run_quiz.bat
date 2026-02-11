@echo off
echo Compiling Java files...

REM Set classpath to include JDBC driver and current directory
set CLASSPATH=.;lib\mysql-connector-java-8.xx.xx.jar

javac -cp "%CLASSPATH%" -d . src\*.java

IF %ERRORLEVEL% NEQ 0 (
    echo Compilation failed. Please check your code.
    pause
    exit /b
)

echo Running Quiz Application...
java -cp "%CLASSPATH%;src" src.QuizMain

pause
