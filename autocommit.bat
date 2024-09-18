@echo off
setlocal

:: Configura la ruta de tu repositorio
set REPO_DIR=C:\Users\a24marcoscv\Documents\2_DAM

:: Cambia al directorio del repositorio
cd /d %REPO_DIR%

:: Verifica si hay cambios en el repositorio
git status --porcelain
if %ERRORLEVEL% neq 0 (
    echo No se pudo verificar el estado del repositorio.
    exit /b %ERRORLEVEL%
)

:: Agrega todos los cambios al área de preparación
git add .

:: Configura el mensaje de commit
set COMMIT_MSG=%1
if "%COMMIT_MSG%"=="" set COMMIT_MSG="Commit automático %date% %time%"

:: Realiza el commit
git commit -m "%COMMIT_MSG%"

:: Empuja los cambios al repositorio remoto
git push

echo Commit y push realizados con éxito.

endlocal