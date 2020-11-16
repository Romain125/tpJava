package org.epita.tp.serie1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.epita.tp.serie1.ExercicesSupplementaires.*;
import static org.assertj.core.api.Assertions.assertThat;

public class TestsExercicesSupplementaires {

    @Test
    @DisplayName("Exercice1 doit retourner la somme des carrés des entiers passés en paramètres")
    public void test_exercice1_1(){
        assertThat(exercice1(1, 2, 3)).isEqualTo(14);
        assertThat(exercice1(14,9,-9,1,4,3)).isEqualTo(384);
    }

    @Test
    @DisplayName("Exercice1 doit retourner -1 en cas de tableau vide")
    public void test_exercice1_2(){
        assertThat(exercice1()).isEqualTo(-1);
    }

    @Test
    @DisplayName("Exercice2 doit effectuer la moyenne et retourner l'entier correspondant arrondi à l'inférieur")
    public void test_exercice2_1(){
        float[] jeuDeTest1 = {10, 20};
        assertThat(exercice2(jeuDeTest1)).isEqualTo(15);

        float[] jeuDeTest2 = {11,12,13,14,15,16};
        assertThat(exercice2(jeuDeTest2)).isEqualTo(13);
    }


    @Test
    @DisplayName("Exercice2 doit envoyer une exception en cas de tableau vide")
    public void test_exercice2_2(){
        float[] jeuDeTestVide = {};
        Throwable throwable = catchThrowable(() -> exercice2(jeuDeTestVide));
        assertThat(throwable)
                .isNotNull()
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("Exercice3 doit trouver l'index de la valeur la plus éloignée de zéro")
    public void test_exercice3_1(){
        long[] jeuDeTest1 = {1,-2,10,-15,3};
        assertThat(exercice3(jeuDeTest1)).isEqualTo(3);

    }

    @Test
    @DisplayName("Exercice3 doit retourner l'index du positif en cas d'égalité positif/négatif")
    public void test_exercice3_2(){
        long[] jeuDeTest2 = {-10,10,3,-5};
        assertThat(exercice3(jeuDeTest2)).isEqualTo(1);
    }

    @Test
    @DisplayName("Exercice3 doit prendre le dernier index en cas d'égalité positive")
    public void test_exercice3_3(){
        long[] jeuDeTest3 = {-10,10,3,10};
        assertThat(exercice3(jeuDeTest3)).isEqualTo(1);
    }

    @Test
    public void test_exercice4(){

    }

    @Test
    public void test_exercice5(){

    }

    @Test
    public void test_exercice6(){

    }

    @Test
    public void test_exercice7(){

    }

    @Test
    public void test_exercice8(){

    }

    @Test
    public void test_exercice9(){

    }

    @Test
    public void test_exercice10(){

    }

    @Test
    public void test_exercice11(){

    }
    
}
