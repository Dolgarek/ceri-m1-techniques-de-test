# UCE Génie Logiciel Avancé : Techniques de tests

### QUEZEL-PERRON Théo
#### GRP ILSEN-Alt
![namebadge](https://img.shields.io/static/v1?label=Nom&message=Théo%20QUEZEL-PERRON&color=e942f5)
![groupbadge](https://img.shields.io/static/v1?label=Groupe&message=ILSEN-ALT-Gr1&color=lightgrey)

[![<Dolgarek>](https://circleci.com/gh/Dolgarek/ceri-m1-techniques-de-test.svg?style=svg)](https://www.youtube.com/watch?v=dQw4w9WgXcQ)
[![codecov](https://codecov.io/gh/Dolgarek/ceri-m1-techniques-de-test/branch/master/graph/badge.svg?token=632K7U2LMS)](https://codecov.io/gh/Dolgarek/ceri-m1-techniques-de-test)
![Checkstyle](docs/badges/checkstyle-result.svg)
[![Javadocs](https://img.shields.io/static/v1?label=JAVADOCS&message=LINK&color=blue)](https://dolgarek.github.io/ceri-m1-techniques-de-test/)

# Rapport TP6

## Test

Après avoir remplacer la pokemonFactory dans notre fichier de test IPokemonFactoryTest par RocketPokemonFactory
on peut se rendre de compte immédiatement de plusieurs problèmes en lancant les tests:

- La fonction shouldGetPokemon attend un Bulbizarre mais reçois un MISSINGNO
- La fonction shouldThrowPokedexExceptionWhenNegativeValue ne throw pas d'erreur car -1 est assigné à Ash's pikachu
- La fonction shouldThrowPokedexExceptionWhenOutOfBOund ne throw pas d'erreur car aucune vérification sur la limite de taille supérieure est pas de List mais une map

## Inspection du code

En regardant le code d'un peu plus près on se rend compte de plusieurs choses:

- La RocketPokemonFactory ne fait jamais appel à PokemonMetadataProvider pour construire les pokémons
- La classe préfère initialiser des noms fixes dans une map non modifiable post initialisation et générer aléatoirement la plupart des data (atk, def, ...)
- Les IV sont fixes (0 ou 1)
- Si id inexistant retourne MISSINGNO

En conclusion même si l'implémentation semble fonctionnel elle ne répond au critère de qualité de notre implémentation.
Parmis les problèmes existants, une partie des métadata ne sont pas générer à partir de l'espèce mais automatique.
La classe introduit un pokémon bug "MISSINGNO" qui n'est pas viable.
Un pokémon appelé pikachu ash existe et possède une puissance folle.
Le pokemon généré peux avoir un id complétement éronné etc etc ..
Vous trouverez tout de même une nouvelle classe IRocketPokemonFactory ayant pour but de tester chacune de ces fonctions.


## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Le projet consiste à mettre en place un outil d’analyse statistique pour le jeu Pokémon GO.  
Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 1ère séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu, le projet dans son intégralité doit être déposé sur la plateforme.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
