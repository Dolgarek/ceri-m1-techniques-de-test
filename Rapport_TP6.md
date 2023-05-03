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