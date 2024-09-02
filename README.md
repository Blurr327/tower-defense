# Tower Defense Project
Pour lancer le jeu depuis vscode : 
Ouvrir le dossier du projet
Aller dans le dossier src
Aller dans le dossier main
Puis lancer Game.java
(En réalité, ouvrir n'importe quelle fichier .java et appuyer sur F5 lance le jeu)

Pour lancer le jeu depuis le terminal linux : 
naviguez vers tower defense
run : find . -name "*.class" -type f -delete
puis 
```javac -source 11 -target 11 -cp bin src/**/*.java```
et enfin 
java -cp bin main.Game