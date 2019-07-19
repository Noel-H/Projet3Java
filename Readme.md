Readme
----------

Guide d'utilisation

1/

a.Telechargez et installer le JRE (Java) a cette adresse : "https://www.java.com/fr/download/"

b.Telechargez l'application a cette adresse : "https://github.com/Noel-H/Projet3Java/archive/master.zip"

c.Decompressez le fichier.

d.Ouvrez un terminal et rendez vous dans le dossier "Projet3Java".

e.Compilez l'application en utilisant la commande : 
"javac -d .\build\ -cp .\lib\* .\src\fr\openclassrooms\project3\Main.java .\src\fr\openclassrooms\project3\controller\Controller.java .\src\fr\openclassrooms\project3\model\gamemode\Challenger.java .\src\fr\openclassrooms\project3\model\gamemode\Defender.java .\src\fr\openclassrooms\project3\model\gamemode\Duel.java .\src\fr\openclassrooms\project3\model\option\Configuration.java .\src\fr\openclassrooms\project3\model\option\Utility.java .\src\fr\openclassrooms\project3\model\Model.java .\src\fr\openclassrooms\project3\view\Displayer.java"

f.Entrez dans le repertoire "build" avec la commande : "cd .\build\"

g.Lancez l'application en utilisant la commande "java fr.openclassrooms.project3.Main"


2/
a.Ajoutez le parametre "-d" pour Activer le mode developper, exemple : "java fr.openclassrooms.project3.Main -d"

b.Certain parametres sont configurable en changeant leur valeur dans le fichier "config.properties", exemple : "developper_mode = false" ou "developper_mode = true"