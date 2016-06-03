set shdir=%~dp0
set "shdir=%shdir:\=/%"
c:
cd C:\cygwin\bin 
bash --login -i -c '%shdir%build.sh'
pause
PATH_TO_YOUR_NDK/ndk-build