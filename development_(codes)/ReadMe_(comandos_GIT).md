# Comandos básicos para usar en GitHub
Hecho por Javier Flores.
## Creación de llave SSH (Linkear pc a repositorio)
>Se debe de descargar GitBash para utilizar todos estos Comandos
En GitBash se siguen los siguientes pasos:
- Comando: ssh-keygen -t rsa -b 4096
- cd .ssh
- cat id_rsa.pub
- copiar la llave que se da
Ir a GitHub:
- Configuración: SSH and GPG keys: Crear llave SSH: Darle un nombre y pegar la llave adquirida en GitBash.
- Ingresar al repositorio a copiar en GitHub
- Code: SSH: Copiar link.
En GitBash:
>Se debe de mover a la carpeta donde se quiere copiar el repositorio.
- Usar comando: git clone "link copiado de GitHub"

Con esto hecho, el repositorio ya debe de haberse creado en tus archivos.

## Actualizar repositorio en pc
>En GitBash, debe de estar en la carpeta del repositorio, para verificar puede usar "pwd" para ver la ruta donde se encuentra.
- Use git fetch para ver si se han creado ramas nuevas, si es el caso se crean en su pc.
- Use git pull origin dev para bajar los cambios de GitHub a su repositorio.

Con esto, la actualización se completa con éxito.

## Cambiar cosas del repositorio
Para ellos simplemente debe de cambiar, eliminar o agregar archivos o carpetas dentro de la carpeta del repositorio, con ello después podrá subir los cambios.
En caso de que se arrepienta de algún cambio que hizo, puede usar los siguientes comandos:
- git checkout -- "nombre del archivo": Este comando revierte un archivo a como se encuentra en GitHub antes de algún cambio hecho.
- git -- hard: Este comando resetea el repositorio de su pc a como esta en GitHub.
>Los siguientes comandos se usan cuando se arrepiente de algún archivo subido a git add . 
Pudiera darse el caso que hayas hecho "git add" de un archivo que ahora pretendes descartar. En ese caso ese archivo está almacenado provisionalmente, en el espacio que se conoce como "staging area".
- git -- hard: Resetea también los cambios hechos en git add .
Si desea revertir sólo un archivo de los subidos a git add, debe de usar los dos comandos siguientes:
- git reset HEAD "nombre del archivo"
- git checkout -- "nombre del archivo"
Nótese que si desea subir otra vez el archivo después de usar estos comandos, deberá de usar git add de nuevo.

## Subir cosas al repositorio
Una vez que haya hecho los cambios necesarios, deberá de seguir los siguientes pasos para subir esos archivos:
- En GitBash, en el repositorio, use git checkout -b "feat/iniciales": Crea la rama desde la cual se sube los archivos.
- git add .
- git commit -m "Mensaje de lo que se sube"
- git pull origin "feat/iniciales"
- El link de retorno, se copia y se abre en Google.
- Se configura el nombre del PR y se colocan comentarios si así lo desea.
- Arriba a la izquierda configure que el cambio se hará a la rama dev desde la rama "feat/iniciales"
- Presione donde dice create Pull Request.

Listo, con esto se subirán los cambios a GitHub.

>Nota: Después de subir algo, debe de eliminar su rama, esto se hace con:

- git checkout dev
- git branch -D "feat/iniciales"