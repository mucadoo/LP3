@echo off
set "DERBY_OPTS=-Duser.language=en -Dderby.drda.debug=true" 
set DERBY_HOME=%cd%
cd bin
call setNetworkServerCP
call startNetworkServer
@echo on