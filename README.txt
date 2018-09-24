-Directorio ? Código
***Comando add para que git empiece a tener control de versiones: 1 vez
-Stage ? Matiz de control de versiones
***Comando commit para guardar versiones
-Commit ? Control total
***git pull para sincronizar con lo que han hecho los demás: puede pasar que machaque las mismas líneas (conflicto). Lo que tenemos que hacer es bajar y modificar las líneas que generan el conflicto.
***Comando push para subirlo a github
-Sistema de control de versiones de la nube
***Git pull para bajarla de internet: machaca lo que tenemos en local en el workspace, modifica el fichero del workspace
***Comando para saber qué pasa con mi repositorio local y el de la web y no machacar la versión local: fetch, nos quedamos en el control de versines pero no machaca el fichero del workspace + git status: sincroniza con el repositorio.

-Un sprint = fecha fin del sprint, así que para el trabajo tenemos que etiquetar con tag cada versión: V0, V1, V2, V3 (1 tag para cada sprint)
-Una rama para cada funcionalidad, es decir, solo metemos a la master cuando tenemos la funcionalidad programada en otra rama. Para que git controle los conflictos tenemos que ir haiendo git fetch y git status (para que mire si hay conflictos entre las ramas) y git pull para solucionar los conflictos antes de hacer el merge y juntar la rama de la funcionalidad a la principal.

PARA HACER UN MERGE
Cambio a master
Ejecutar el master

