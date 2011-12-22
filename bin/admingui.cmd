@echo off

rem library classpath
if "%SIGNSERVER_HOME%" == "" (
  set SIGNSRV_HOME=..
  rem It must work to call both as bin\signserver.cmd or from within bin
  if not exist signserver.cmd set SIGNSRV_HOME=.
 ) else (
    set SIGNSRV_HOME=%SIGNSERVER_HOME%
) 
  
if "%APPSRV_HOME%" == "" (
    echo You must set APPSRV_HOME before running the SignServer AdminGUI.
    goto end
)

rem check that we have built the classes
if not exist %SIGNSRV_HOME%\lib\SignServer-AdminGUI.jar  (
    echo You must build SignServer before using the cli, use 'ant'.
    goto end
)

set class_name=org.signserver.admin.gui.SignServerAdminGUIApplication

rem check that we have built the classes
if not exist %SIGNSRV_HOME%\lib\SignServer-AdminGUI.jar  (
    echo SignServer AdminGUI not available. Build it by running 'ant'.
    goto end
)

rem Construct the classpath
set MAIN_CLASSPATH=%SIGNSRV_HOME%\conf;%SIGNSRV_HOME%\lib\SignServer-AdminGUI.jar

rem Application server dependencies
if exist %APPSRV_HOME%\lib\appserv-rt.jar (
    set JEE_CLASSPATH=%CLASSPATH%;%SIGNSRV_HOME%\conf\glassfish;%APPSRV_HOME%\lib\appserv-rt.jar
)
if exist %APPSRV_HOME%\client\jbossall-client.jar  (
    set JEE_CLASSPATH=%CLASSPATH%;%SIGNSRV_HOME%\conf\jboss;%APPSRV_HOME%\client\jbossall-client.jar
)

set CLASSPATH=%MAIN_CLASSPATH%;%JEE_CLASSPATH%
rem echo %CLASSPATH%

rem Fixup arguments, we have to do this since windows normally only 
rem supports %1-%9 as command line arguments
shift
set a=%0
set b=%1
set c=%2
set d=%3
set e=%4
set f=%5
set g=%6
set h=%7
set i=%8
set j=%9
rem echo %a% %b% %c% %d% %e% %f% %g% %h% %i% %j%
if "%JAVA_HOME%" == "" (
  java -cp %CLASSPATH% -splash:%SIGNSRV_HOME%\res\admingui-splash.png %class_name% %a% %b% %c% %d% %e% %f% %g% %h% %i% %j% -connectfile %SIGNSRV_HOME%/conf/admingui.properties -defaultconnectfile %SIGNSRV_HOME%/conf/admingui_default.properties
) else (
  "%JAVA_HOME%\bin\java" -cp %CLASSPATH% -splash:%SIGNSRV_HOME%\res\admingui-splash.png %class_name% %a% %b% %c% %d% %e% %f% %g% %h% %i% %j% -connectfile %SIGNSRV_HOME%/conf/admingui.properties -defaultconnectfile %SIGNSRV_HOME%/conf/admingui_default.properties

)
:end
