# Travaux pratiques
***
## Règles
* Les exercices d'une série peuvent être fait dans le désordre mais sous-parties d'exercices doivent être fait dans l'ordre indiqué
* Vous devez écrire le test correspondant à l'énoncé avant d'écrire du code.
* Un exercice n'est considéré réussi que si toutes les assertions composant le test fonctionnent simultanément.
***
# Série 1 - Exercices supplémentaires
## Exercice 1
Soit un tableau d'entiers, retourner la somme des carrés de ces entiers :
```
[1,2,3] = 1²+2²+3² = 14
[14,9,-9,1,4,3] -> 384
```
Un tableau vide doit renvoyer -1
```
[] -> -1
```
## Exercice 2
Ecrire une méthode qui permet de calculer la moyenne d'un tableau de décimaux. La moyenne doit être un entier arrondi à l'inférieur.
Un tableau vide doit renvoyer une exception.
```
[10, 20] -> (10+20)/2 = 15
[11,12,13,14,15, 16] -> 13
[] -> Exception
```

## Exercice 3
Soit un tableau d'entiers relatifs, trouvez l'index de l'élément le plus éloigné de zéro.   
```
[1,-2,10,-15,3] -> 3 (car c'est l'index de -15, l'entier le plus éloigné de 0) 
```
S'il y a égalité, entre deux nombres, l'un positif, le second négatif, prenez le positif.   
```
[-10,10,3,-5] -> 1
```
S'il y a égalité entre deux nombres positifs, prenez le premier index.
```
[-10,10,3,10] -> 1
```

## Exercice 4
Ecrire le code pour calculer le n-ième élément de la suite de Fibonacci.  
Pour rappel, la suite de Fibonacci est défini comme telle :  
f(0) = 0  
f(1) = 1  
f(n) = f(n-1) + f(n-2)   
```
f(2) = f(0)+f(1) = 1
f(3) = f(1)+f(2) = 2
f(10) = f(9)+f(8) = 55
f(16) = 987
```
Essayez de calculer f(80), que constatez-vous ?  
A votre avis, pourquoi ?  
Essayez de trouver une optimisation afin de faire tourner f(80) dans un délai correct.

## Exercice 5
Jessica-Marie-Sue-Hellen est une femme...difficile. Elle n'accepte de sortir qu'avec des hommes selon les critères suivants :  
* Âge : Il doit avoir entre 18 et 35 ans
* Physique : Au minimum 8/10
* Revenus annuels : Au minimum 50 000€/an, mais si c'est au delà de 1 000 000€/an, on oublie le reste des critères !
Ecrire une méthode permettant de modéliser la chance d'un homme à sortir avec Jessica-Marie-Sue-Helen
```
21, 9, 60000 -> true
21, 7, 90000 -> false
90, 2, 2000000 -> true
```

## Exercice 6
En général, lorsque vous payer, vous recevez un ticket de carte bleue avec le numéro de votre carte masquée. Seuls restent les 4 derniers numéros, le reste étant remplacé par des #.  
Le but de cet exercice est d'écrire une méthode permettant de remplacer tous les caractères d'une chaîne de caractère par des # (sauf les 4 derniers).  
```
123456789012 -> ########9012
1234 5678 9012 -> ##########9012
MomNomEstPersonne -> #############onne
42 -> 42
```

## Exercice 7 
Le but est de prendre un texte et de la convertir soit :  
- Tout en majuscules si le texte comprend une majorité de majuscules.  
- Tout en minuscules si le texte comprend une majorité de minuscules.  
- En cas d'égalité, on ne convertira rien !  
```
"Toto" -> "toto"
"TITi" -> "TITI"
"taTA" -> "taTA"
```

## Exercice 8
Soit un tableau d'entiers relatifs. Trouvez le maximum de la multiplication de deux entiers adjacents.
```
[1, 2, 3] -> 6
[9, 5, 10, 2, 24, -1, -48] -> 50
[-23, 4, -5, 99, -27, 329, -2, 7, -921] -> -14
```
Le cas du tableau vide n'est pas à prendre en compte.

## Exercice 9
Soit un tableau d'entiers positifs compris entre 0 et 9, trouvez chiffre minimum résultat de la combinaison des numéros du tableau. Les doublons sont à ignorer.  
```
[1, 3, 1] -> 13
[5, 7, 5, 9, 7] -> 579
[9, 1, 3, 1, 7, 4, 6, 6, 7] -> 134679
```

## Exercice 10
Attention, celui-ci n'est pas évident !  
Soit une chaîne de caractère représentant un nombre et un nombre n de virgules.
Votre but est de trouver le plus grand chiffre possible après avoir inséré K virgules dans cette chaîne de caractères. Il ne peut pas y avoir deux virgules à la suite.
```
'1234',1 = 234 car c'est le max de ('1','234'), ('12','34') et ('123','4').
'1234',2 = 34 car c'est le max de ('1','2','34'), ('1','23','4') et ('12','3','4'). 
'1234',3 = 4
'2020',1 = 202
```

## Exercice 11
Le but ici est de modéliser le rendu-monnaie d'une machine à café. Une machine possède trois attributs à sa création : Un nombre de pièces de 10ct, un nombre de pièces de 20ct, et un nombre de pièces de 50ct.  
On cherche simplement à savoir si le rendu est possible. Il n'est pas nécessaire de trouver le rendu optimal. 
```
new MachineACafe(0,0,0).peutRendre(50) -> false
new MachineACafe(2,2,2).peutRendre(200) -> false
new MachineACafe(1,2,2).peutRendre(10) -> true
new MachineACafe(1,2,2).peutRendre(80) -> true
new MachineACafe(1,2,2).peutRendre(90) -> true
new MachineACafe(0,2,5).peutRendre(80) -> false
new MachineACafe(1,1,1).peutRendre(55) -> false
```

***

# Série 2 - Enigme des 8 dames
Aux échecs, le plateau standard est de taille 8x8 et une dame peut se déplacer (et capturer) n'importe quelle pièce présente sur une même une ligne, colonne, ou diagonale. 
Le but de cet exercice est de trouver les solutions à une énigme célèbre : Peut-on placer 8 dames sur un échiquier sans qu'aucune ne puisse en capturer une autre ?  
En dérivent plusieurs questions : Combien existe-t-il de solutions? Cette énigme est-elle également valable pour des plateaux d'autres tailles?  
Tout au long de cette série, nous allons modéliser et essayer de répondre à ces différentes questions.   
*Conseil : Travaillez avec un plateau de 4x4 pour commencer. Pensez à faire le nécessaire pour rendre cette taille variable en fonction d'un paramètre d'entrée.*  

## Exercice 1 - Algorithme naïf
Cet exercice propose de modéliser un algorithme naïf. Cet algorithme n'est pas optimisé mais est une excellent exercice pour la manipulation de boucles et la réflexion algorithmique.  
Le plateau est modélisé par un tableau de bouléens bidimentionnel (true s'il y a une dame sur la case, false sinon). 
````
plateau[ligne][colonne]
````

### Exercice 1.1
Pour éviter certains soucis de référencement mémoire, il est nécessaire d'avoir une méthode utilitaire permettant de copier un tableau :  
* Contenu plateau == Contenu copie(plateau)
* Référence mémoire plateau <> Référence mémoire copy(plateau) 

### Exercice 1.2
Ecrire deux constructeurs : 
* Le premier prend en entrée un nombre, qui sera la dimension du plateau
* Le second prend en entrée un plateau et copie sur son plateau interne les valeurs du plateau en entrée
### Exercice 1.3
Il est toujours plus agréable de travailler avec une représentation visuelle. Implémentez une méthode permettant de représenter votr plateu de la manière suivante :  
* [[true, false, true, false],[false, true, false, false],[false, false, false, false],[false, false, false, true]]
->   
```
   0 1 2 3
0 |X| |X| |  
1 | |X| | |  
2 | | | | |  
3 | | | |X|  
```
Les numéros ne sont pas obligatoires, mais sont là pour vous indiquer le sens de numérotation : Les colonnes sont numérotées de gauche à droite et les lignes de haut en bas !
Faites en sorte que la méthode toString de votre objet appelle cette méthode.  
### Exercice 1.4
Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une ligne donnée
```
Soit le plateau en entrée :
|X| |X| |  
| |X| | |  
| | | | |  
| | | |X|  
verifierLigne(0)-> false
verifierLigne(1)-> true
```
### Exercice 1.5
Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une colonne donnée
```
Soit le plateau en entrée :
|X| |X|X|  
| |X| | |  
| | | | |  
| | | |X|  
verifierColonne(0)-> true
verifierColonne(3)-> false
```
### Exercice 1.6
Ecrire un algorithme qui vérifie qu'il n'y a pas plus d'une dame pour une diagonale 'droite' (qui va vers la droite en descendant) donnée.
Pour plus de simplicité, on peut leur donner un numéro qui correspond au numéro de la colonne de laquelle part une diagonale.
i.e : 
```
Diagonale droite 0 :
|O| | | |  
| |O| | |  
| | |O| |  
| | | |O|  

Diagonale droite 3 :
| | | |O|  
| | | | |  
| | | | |  
| | | | |  

Diagonale droite -2 :
| | | | |  
| | | | |  
|O| | | |  
| |O| | |  
```
```
Soit le plateau en entrée :
|X| |X|X|  
| |X| | |  
| | | | |  
| | | |X|  
verifierDiagonaleDroite(0)-> false
verifierDiagonaleDroite(1)-> true
verifierDiagonaleDroite(2)-> true
```

### Exercice 1.7
Effectuer le même travail pour les diagonales gauches.
*Attention, les diagonales droites sont numérotées de -3 à 3, et les diagonales gauches sont numérotées de 0 à 7*  
e.g :  
```
Diagonale gauche 0 :
|O| | | |  
| | | | |  
| | | | |  
| | | | |  

Diagonale gauche 3 :
| | | |O|  
| | |O| |  
| |O| | |  
|O| | | |  

Diagonale gauche 7 :
| | | | |  
| | | | |  
| | | | |  
| | | |0|  
```

```
Soit le plateau en entrée :
|X| |X|X|  
| |X| | |  
| | | | |  
| | | |X|  
verifierDiagonaleGauche(0)-> true
verifierDiagonaleGauche(2)-> false
verifierDiagonaleGauche(7)-> true
```

### Exercice 1.8
Ecrire une méthode qui parcours de tableau et qui vérifie les ligne/colonnes/diagonales-gauche/diagonales-droite des cases occupées.
```
Soit le plateau en entrée :
| | | | |  
|X| | | |  
| | | | |  
| | | |X|  
estUneSolution() -> true
```
```
Soit le plateau en entrée :
| | |X| |  
| | | |X|  
| | | | |  
| | | | |  
estUneSolution() -> false
```

### Exercice 1.9
Pour l'algorithme naïf, nous allons partir de la position suivante et nous allons itérer pour essayer la totalité des possibilités une à une.
```
Position de départ :
|X|X|X|X|  
| | | | |  
| | | | |  
| | | | |  
```
Le but est de déplacer la dame de la colonne la plus à gauche d'une case vers le bas.  
S'il faut déplacer une dame vers le bas alors qu'elle est déjà à la dernière case de sa colonne, nous la repositionnons sur la première case de sa colonne (tout en haut) et nous déplaçons la dame de la colonne suivante d'une case vers le bas.
```
Exemple 1 : 
|X|X|X|X|  
| | | | |  
| | | | |  
| | | | |  

Coup suivant :
| |X|X|X|  
|X| | | |  
| | | | |  
| | | | |  
```

```
Exemple 2 : 
| |X|X|X|  
| | | | |  
| | | | |  
|X| | | |  

Coup suivant :
|X| |X|X|  
| |X| | |  
| | | | |  
| | | | |  
```

```
Exemple 3 : 
| | | | |  
| | |X| |  
| | | |X|  
|X|X| | |  

Coup suivant :
|X|X| | |  
| | | | |  
| | |X|X|  
| | | | |  
```
S'il n'y a plus de coup disponibles, il faut lever une erreur.
```
Exemple 3 : 
| | | | |  
| | | | |  
| | | | |  
|X|X|X|X|  

Coup suivant -> Exception ! 
```

### Exercice 1.10
Vous avez maintenant toutes les composantes pour implémenter votre recherche de solution. Voici l'algorithme à utiliser :  
* Regarder si votre plateau est une solution au problème (pas deux dames sur la même ligne, colonne, diagonale gauche ou diagonale droite).
* Si c'est cohérent, stocker une copie de cette solution dans une liste
* Passer à la possibilité suivante

Placer 4 dames sur un plateau de 4x4 possède deux solutions.  
Placer 8 dames sur un plateau de 4x4 possède 92 solutions.  

### Exercice 1.11
Une optimisation simple pour votre algorithme revient à initialiser l'état de départ en diagonale :
``` 
| | | |X|  
| | |X| |  
| |X| | |  
|X| | | |  
```
En effet, il est facile de comprendre pourquoi il ne peut pas y avoir de solutions avant cette étape. On évite, de ce fait un grand nombres d'itérations.
Avez-vous d'autres optimisations à proposer ? Il y en a une qui est facile à trouver ! ;)

## Exercice 2 - Algorithme backtracking
Le but est de trouver une méthode beaucoup plus rapide et optimale pour trouver une solution au problème. Cette optimisation passe par deux grands principes :
* Le plateau n'est plus modélisé. Nous ne manipulerons plus qu'une collection de dames ayant chacune une position (x,y) (ou ligne, colonne). Cela nous permet d'éviter les accès et les parcours d'un tableau bi-dimensionnel.
* Nous allons effectuer un changement radical dans l'approche des différents coups à tester.

### Exercice 2.1 
De la même manière que l'exercice précédent, commencez par écrire les méthodes permettant :
* D'effectuer une copie d'un ensemble de Dames
* D'avoir une représentation visuelle de cet ensemble

### Exercice 2.2
Ecrire des méthodes pour vérifier que deux dames ne sont pas :
* Sur la même ligne
```
verifierLigne( Dame(0,1), Dame(0,2) ) -> false
verifierLigne( Dame(4,1), Dame(0,2) ) -> true
```
* Sur la même colonne
```
verifierColonne( Dame(0,1), Dame(0,2) ) -> true
verifierColonne( Dame(4,2), Dame(0,2) ) -> false
```
* Sur la même diagonale gauche
```
verifierDiagonaleGauche( Dame(0,3), Dame(1,2) ) -> false
verifierDiagonaleGauche( Dame(0,0), Dame(1,1) ) -> true
```
* Sur la même diagonale droite
```
verifierDiagonaleGauche( Dame(0,3), Dame(1,2) ) -> true
verifierDiagonaleGauche( Dame(0,0), Dame(1,1) ) -> false
```

### Exercice 2.3
Ecrire un algorithme qui compare toutes les dames d'une collection entre elles. La comparaison est un regroupement des 4 vérifications du sous-exercice 2.2.
```
[dame1, dame2, dame3, dame4] doit comparer :
- dame1/dame2
- dame1/dame3
- dame1/dame4
- dame2/dame3
- dame2/dame4
- dame3/dame4

[Dame(0,0), Dame(2,1), Dame(3,3)] -> false
[Dame(0,0), Dame(1,1), Dame(2,3)] -> false
[Dame(0,0), Dame(12,3), Dame(15,10)] -> true
```

### Exercice 2.4
Voilà comment se déroule l'algorithme de backtracking. Nous continuons à raisonner par colonne, mais cette fois-ci, nous partons d'un plateau vide.  
Le but est de positionner les dames une à une jusqu'à ce que nous en ayons posé N (N étant la dimension du plateau).  
La dame de la colonne en cours est positionnée sur la première case disponible :
* Si le plateau est dans un état correct, on passe à la dame de la colonne suivante
* Si le plateau est dans un état incorrect, on teste la case suivante
* S'il n'y a plus de case disponible dans la colonne, on retire la dame courante et on avance la dame de la colonne précédente
```
La colonne courante est la colonne 0, nous placons la première dame :
|X| | | |  
| | | | |  
| | | | |  
| | | | |  

Après vérification, le plateau est dans un état cohérent, nous passons donc à la colonne suivante.
On place la dame de la colonne courante sur la première case disponible.
|X|X| | |  
| | | | |  
| | | | |  
| | | | |  

L'état n'est pas bon, on fait avancer la dame de la colonne courante d'une case : 
|X| | | |  
| |X| | |  
| | | | |  
| | | | |  

L'état n'est toujours pas bon...on continue d'avancer d'une case :
|X| | | |  
| | | | |  
| |X| | |  
| | | | |  

L'état est bon, on passe à la 3eme colonne...et au bout de 4 itérations, on se rend compte qu'il n'y a plus de places disponibles sur la troisième colonne 
|X| |?| |  
| | |?| |  
| |X|?| |  
| | |?| |

On enlève alors la dame de la troisième colonne et on avance la dame de la seconde colonne :
|X| | | |  
| | | | |  
| | | | |  
| |X| | | 

L'état est possible, on peut alors passer (de nouveau) sur la troisième colonne...
```
Placer 4 dames sur un plateau de 4x4 possède deux solutions.  
Placer 8 dames sur un plateau de 4x4 possède 92 solutions.  

### Exercice 2.5 (bonus)
Pour ceux qui ont effectué l'exercice 1, faites un comparatif de performances entre les deux algorithmes. L'algorithme de backtracking devrait être beaucoup plus rapide.  
Prenez un peu de temps pour y réfléchir et essayez de comprendre pourquoi.

***
## Série 3 - 'The GAME'
Le but de cet exercice est de développer le jeu ['The Game'](https://boardgamegeek.com/boardgame/173090/game) en ligne de commande dans son mode 1 joueur. 
Le joueur interagira avec le programme via ligne de commande.  

Matériel : 
* 98 cartes, numérotées de 2 à 98

Mise en place : 
* Il y a 4 piles sur la table, DEUX piles ASCENDANTES commençant par 1, et DEUX piles DESCENDANTES commençant par 99
* Le joueur reçoit 8 cartes

```
Exemple :
Piles ascendantes : [01][01]
Piles descendantes : [99][99]
Main : [12][69][73][42][02][98][55][80]
```

But du jeu : 
* Placer la totalité des cartes de sa main et de la pioche sur les 4 piles de la table

Les règles sont les suivantes :
* Lors de son tour, le joueur doit OBLIGATOIREMENT jouer : 
    * DEUX cartes de sa main au MINIMUM s'il reste des cartes dans la pioche
    * UNE carte de sa main au MINIMUM si la pioche est vide
    * Il peut en jouer plus s'il le souhaite 
    * S'il ne peut pas jouer de cartes, la partie est perdue
* A la fin de son tour, le joueur pioche jusqu'à avoir 8 cartes de nouveau. Si la pioche est vide, il termine son tour sans piocher.
* Sur le piles ascendantes, on ne peut placer de cartes que dans l'ordre croissant. On peut également y poser une carte plus petite si et seulement si la différence numérique entre les deux cartes vaut exactement 10 (et vice-versa sur les piles descendantes)
```
Exemple :
Piles ascendantes : [01][01]
Piles descendantes : [99][99]
Main : [12][69][73][42][02][98][55][80]

Julie joue le 98 sur une pile descendante :
Piles ascendantes : [01][01]
Piles descendantes : [99][98]
Main : [12][69][73][42][02][55][80]

Julie joue le 12 sur une pile ascendante :
Piles ascendantes : [12][01]
Piles descendantes : [99][98]
Main : [69][73][42][02][55][80]

Julie pourrait s'arrêter là mais elle décide de continuer.

Julie joue le 02 sur le 12. Elle a le droit malgré le fait que ce soit une pile ascendante car la différence est de 10 exactement :
Piles ascendantes : [02][01]
Piles descendantes : [99][98]
Main : [69][73][42][55][80]

Puis, Julie termine son tour, elle pioche jusque avoir 8 cartes en main.
```

Fin de partie :
* Une partie est gagnée si le joueur a placé toutes les cartes de sa main et que la pioche est vide
* Une partie est perdue si un joueur ne peu plus poser de cartes

## Exercice 1 
Faites la modélisation du problème et gardez en tête le principe de base de la modélisation objet : un objet ne doit avoir qu'une seule responsabilité.  
Posez-vous également la question : Si vous deviez implémenter n'importe quel autre jeu de cartes, quelle partie de votre code pourriez-vous réutiliser ?  
Pensez également à utiliser des structures telles que des énumérations.  
Effectuez la modélisation sur papier avant de vous attaquer à la suite des exercices. Une fois les exercices terminés, comparez votre modélisation avec celle proposée.

## Exercice 2
Créez une classe Carte. La classe carte n'a qu'un seul attribut qui est son numéro, un getter et une méthode toString lui donnant une représentationgraphique de la forme `[03]`

## Exercice 3
Créez une classe Deck. Elle possède : 
* Une collection de Cartes (attardez-vous sur le choix de la collection ici)
* Une méthode d'initialisation
* Une méthode permettant de savoir s'il reste des cartes dans la pioche
* Une méthode permettant de piocher (enlever la première carte de la collection et la renvoyer)
* Une méthode toString renvoyant la représentation suivante `Deck : [[[42]` (42 étant le nombre de cartes restantes)
* Une méthode de mélange 
Le mélange d'une collection est un excellent exercice algorithmique. Pour les plus téméraires d'entre vous, n'hésitez pas à implémenter la méthode vous-mêmes.
Pour les autre, pensez-y au moins quelques minutes, et utilisez la méthode présente dans le JDK `Collections.shuffle(List l)`.

## Exercice 4
Créez une classe Player. Un joueur possède :
* Un nom (qu'on demandera au début de la partie) 
* Une main (une collection de cartes). Là aussi, pensez à la collection à utiliser et un getter associé
* Une méthode permettant de recevoir une carte (et de l'ajouter à sa main)
* Une méthode retournant permettant de recherche et de retourner un carte de la main du joueur en fonction d'un entier passé en paramètre. Si un joueur ne possède pas la carte demandée, cela lève une UnavailableCardException (qu'il faudra créer).
* Une méthode permettant de jouer une carte (l'enlever de sa main et la retourner). Si un joueur ne possède pas la carte demandée, cela lève une UnavailableCardException.
* Une méthode toString

## Exercice 5
Créez un objet Stack (représentant les piles de cartes sur la table). Une Stack possède :
* Un attribut concernant l'ordre (ascendant ou descendant)
* La dernière carte ayant été jouée sur la pile
* Une méthode permettant de mettre une carte sur le haut de la pile
* Une méthode toString

## Exercice 6
Créez un objet Table. Une table possède :
* Une collection de 4 Stacks et un getter associé
* Une méthode permettant de jouer une carte sur un numéro de Stack (pensez à vérifier qu'il est possible de jouer cette carte et que ne numéro de la stack existe). Si ce n'est pas possible, créez et renvoyez les exceptions suivantes : NotAValidStackException, NotAValidPlayExceptio.
* Une méthode toString

## Exercice 7
Il ne reste plus qu'à créer l'objet Game, qui coordonne l'ensemble de tous les objets que nous avons créé jusqu'à maintenant. 

### Exercice 7.1
L'objet Game possède les attributs suivants : 
* Un joueur
* Une table
* Un deck
Le constructeur nous servira à faire la mise en place : 
* Création et mélange d'un deck
* Création d'une table 
* Création d'un joueur
Pour communiquer avec le joueur à travers l'invit de commadne, on utilisera la méthode suivante : 
```java
Scanner sc = new Scanner(System.in); 
sc.next(); //C'est cette instruction qui laisse la main à l'utilisateur
```

### Exercice 7.2
Le déroulé du jeu se fait de la manière suivante : Tant que le jeu n'est pas terminé, un joueur joue son tour, puis pioche pour re-remplir sa main.
A vous ensuite d'implémenter les différentes méthodes pour permettre le bon déroulé du jeu.  
*Conseils : Faites de TOUTES PETITES méthodes et n'hésitez pas à découper votre logique. Cela permet de donner une définition à un bloc d'instructions au travers d'un nom de méthode ou de variable. A titre indicatif, la classe Game du corrigé contient 18 méthodes, et certaines d'entre elles font une à deux lignes.*

### Exercice 7.3
Détendez-vous et faites quelques parties, vous l'avez bien mérité ;)