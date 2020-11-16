package org.epita.tp.serie1;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.epita.tp.serie1.ExercicesSupplementaires.*;

public class TestsExercicesSupplementaires {

    @Test
    @DisplayName("Exercice 1 doit retourner la somme des carrés des entiers passés en paramètres")
    public void test_exercice1_1(){
        assertThat(exercice1(1, 2, 3)).isEqualTo(14);
        assertThat(exercice1(14,9,-9,1,4,3)).isEqualTo(384);
    }

    @Test
    @DisplayName("Exercice 1 doit retourner -1 en cas de tableau vide")
    public void test_exercice1_2(){
        assertThat(exercice1()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Exercice 2 doit effectuer la moyenne et retourner l'entier correspondant arrondi à l'inférieur")
    public void test_exercice2_1(){
        float[] jeuDeTest1 = {10, 20};
        assertThat(exercice2(jeuDeTest1)).isEqualTo(15);

        float[] jeuDeTest2 = {11,12,13,14,15,16};
        assertThat(exercice2(jeuDeTest2)).isEqualTo(13);
    }


    @Test
    @DisplayName("Exercice 2 doit envoyer une exception en cas de tableau vide")
    public void test_exercice2_2(){
        float[] jeuDeTestVide = {};
        Throwable throwable = catchThrowable(() -> exercice2(jeuDeTestVide));
        assertThat(throwable)
                .isNotNull()
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("Exercice 3 doit trouver l'index de la valeur la plus éloignée de zéro")
    public void test_exercice3_1(){
        long[] jeuDeTest1 = {1,-2,10,-15,3};
        assertThat(exercice3(jeuDeTest1)).isEqualTo(3);

    }

    @Test
    @DisplayName("Exercice 3 doit retourner l'index du positif en cas d'égalité positif/négatif")
    public void test_exercice3_2(){
        long[] jeuDeTest2 = {-10,10,3,-5};
        assertThat(exercice3(jeuDeTest2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Exercice 3 doit prendre le dernier index en cas d'égalité positive")
    public void test_exercice3_3(){
        long[] jeuDeTest3 = {-10,10,3,10};
        assertThat(exercice3(jeuDeTest3)).isEqualTo(1);
    }

    @Test
    @DisplayName("Exercice 4 doit être capable de calculer l'élément N de la suite de Fibonacci")
    public void test_exercice4(){
        assertThat(exercice4(10)).isEqualTo(55);
        assertThat(exercice4(16)).isEqualTo(987);

        //exercice4(80); -> très très long
        assertThat(exercice4(10)).isEqualTo(exercice4_optimise(10));
        assertThat(exercice4(16)).isEqualTo(exercice4_optimise(16));

        long debut = System.currentTimeMillis();
        exercice4(30);
        long fin = System.currentTimeMillis();
        long tempsExecution = fin-debut;

        debut = System.currentTimeMillis();
        exercice4_optimise(30);
        fin = System.currentTimeMillis();
        long tempsExecutionOptimise = fin-debut;

        assertThat(tempsExecutionOptimise).isLessThanOrEqualTo(tempsExecution);

    }

    @Test
    @DisplayName("Exercice 5 : Jessica-Marie-Sue-Hellen ne sort qu'avec des jeune beaux aisé ou des vieux très riches")
    public void test_exercice5(){
        boolean jeuneBeauRiche = exercice5(21, 9, 60000);
        boolean jeuneMoyenRiche = exercice5(21, 7, 90000);
        boolean vieuxRiche = exercice5(90, 2, 2000000);

        assertThat(jeuneBeauRiche).isTrue();
        assertThat(jeuneMoyenRiche).isFalse();
        assertThat(vieuxRiche).isTrue();

    }

    @Test
    @DisplayName("Exercice 6 doit masquer tous les caractères sauf les 4 derniers")
    public void test_exercice6(){
        assertThat(exercice6("123456789012")).isEqualTo("########9012");
        assertThat(exercice6("1234 5678 9012")).isEqualTo("##########9012");
        assertThat(exercice6("MomNomEstPersonne")).isEqualTo("#############onne");
        assertThat(exercice6("42")).isEqualTo("42");
    }

    @Test
    @DisplayName("Exercice 7 doit transformer les chaînes de caractères en maj ou min selon la majorité")
    public void test_exercice7(){
        assertThat(exercice7("Toto")).isEqualTo("toto");
        assertThat(exercice7("TITi")).isEqualTo("TITI");
        assertThat(exercice7("taTA")).isEqualTo("taTA");
    }

    @Test
    @DisplayName("Exercice 8 doit trouver le maximum de la multiplication de deux entiers adjacents")
    public void test_exercice8(){
        assertThat(exercice8(new int[]{1, 2, 3})).isEqualTo(6);
        assertThat(exercice8(new int[]{9, 5, 10, 2, 24, -1, -48})).isEqualTo(50);
        assertThat(exercice8(new int[]{-23, 4, -5, 99, -27, 329, -2, 7, -921})).isEqualTo(-14);
    }

    @Test
    @DisplayName("Exercice 9 doit trouver le chiffre minimum composé des numéros en entrée (hors doublons)")
    public void test_exercice9(){
        assertThat(exercice9(new int[]{1, 3, 1})).isEqualTo(13);
        assertThat(exercice9(new int[]{5, 7, 5, 9, 7})).isEqualTo(579);
        assertThat(exercice9(new int[]{9, 1, 3, 1, 7, 4, 6, 6, 7})).isEqualTo(134679);
    }

    @Test
    @DisplayName("Exercice 10 doit trouver le plus grand nombre parmi un nombre séparé N fois")
    public void test_exercice10(){
        assertThat(exercice10("1234",1)).isEqualTo(234);
        assertThat(exercice10("1234",2)).isEqualTo(34);
        assertThat(exercice10("1234",3)).isEqualTo(4);
        assertThat(exercice10("2020",1)).isEqualTo(202);
        assertThat(exercice10("202043621",3)).isEqualTo(204362);
    }

    @Test
    @DisplayName("Exercice 11 peut savoir s'il est en capacité de rendre la monnaie")
    public void test_exercice11(){
        assertThat(exercice11(0, 0, 0, 50)).isFalse();
        assertThat(exercice11(2, 2, 2, 200)).isFalse();
        assertThat(exercice11(1,2,2,10)).isTrue();
        assertThat(exercice11(1,2,2,80)).isTrue();
        assertThat(exercice11(1,2,2,90)).isTrue();
        assertThat(exercice11(0,2,5,80)).isFalse();
        assertThat(exercice11(1,1,1,55)).isFalse();
    }
    
}
