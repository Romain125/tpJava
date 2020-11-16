package org.epita.tp.serie2;

import org.assertj.core.api.Assertions;
import org.epita.tp.serie2.naif.AlgoNaif;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.epita.tp.serie2.naif.AlgoNaif.copierPlateau;
import static org.epita.tp.serie2.naif.AlgoNaif.plateauToString;

public class TestsAlgoNaif {

    private static final boolean[][] PLATEAU_TEST =
            {
                    {false, true, true, false},
                    {false, false, true, false},
                    {true, false, false, false},
                    {true, false, false, true},
            };
    private AlgoNaif algoNaifTest = new AlgoNaif(PLATEAU_TEST);

    @Test
    @DisplayName("copierPlateau fait une \"copie profonde\"")
    public void test_exercice2_1_1(){
        assertThat(copierPlateau(PLATEAU_TEST)).isNotSameAs(PLATEAU_TEST);
        assertThat(Arrays.deepEquals(copierPlateau(PLATEAU_TEST), PLATEAU_TEST)).isTrue();
    }

    @Test
    public void test_exercice2_1_2(){
        assertThat(plateauToString(PLATEAU_TEST)).isEqualTo("| |X|X| |\n| | |X| |\n|X| | | |\n|X| | |X|\n");
    }

    @Test
    public void test_exercice2_2_1(){
        assertThat(algoNaifTest.verifierLigne(0)).isFalse();
        assertThat(algoNaifTest.verifierLigne(1)).isTrue();
        assertThat(algoNaifTest.verifierLigne(2)).isTrue();
        assertThat(algoNaifTest.verifierLigne(3)).isFalse();
    }

    @Test
    public void test_exercice2_2_2(){
        assertThat(algoNaifTest.verifierColonne(0)).isFalse();
        assertThat(algoNaifTest.verifierColonne(1)).isTrue();
        assertThat(algoNaifTest.verifierColonne(2)).isFalse();
        assertThat(algoNaifTest.verifierColonne(3)).isTrue();
    }

    @Test
    public void test_exercice2_2_3(){
        assertThat(algoNaifTest.verifierDiagonaleGauche(0)).isTrue();
        assertThat(algoNaifTest.verifierDiagonaleGauche(1)).isTrue();
        assertThat(algoNaifTest.verifierDiagonaleGauche(2)).isFalse();
        assertThat(algoNaifTest.verifierDiagonaleGauche(3)).isFalse();
    }

    @Test
    public void test_exercice2_2_4(){
        assertThat(algoNaifTest.verifierDiagonaleDroite(0)).isTrue();
        assertThat(algoNaifTest.verifierDiagonaleDroite(1)).isFalse();
        assertThat(algoNaifTest.verifierDiagonaleDroite(2)).isTrue();
        assertThat(algoNaifTest.verifierDiagonaleDroite(3)).isTrue();
    }

    @Test
    public void test_exercice2_3(){
        assertThat(algoNaifTest.estUneSolution()).isFalse();

        boolean[][] PLATEAU_TEST_OK =
                {
                        {true, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                };
        AlgoNaif algoNaifTestOk = new AlgoNaif(PLATEAU_TEST_OK);

        assertThat(algoNaifTestOk.estUneSolution()).isTrue();

    }

    @Test
    public void test_exercice2_4() throws Exception {
        boolean[][] PLATEAU_DEPART_AVANT =
                {
                        {true, true, true, true},
                        {false, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                };
        boolean[][] PLATEAU_DEPART_APRES =
                {
                        {false, true, true, true},
                        {true, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                };
        AlgoNaif algoNaif = new AlgoNaif(PLATEAU_DEPART_AVANT);
        algoNaif.coupSuivant();
        assertThat(Arrays.deepEquals(algoNaif.getPlateau(), PLATEAU_DEPART_APRES)).isTrue();
    }

    @Test
    public void test_exercice2_4_2() throws Exception {
        boolean[][] PLATEAU_DEPART_AVANT =
                {
                        {false, true, true, true},
                        {false, false, false, false},
                        {false, false, false, false},
                        {true, false, false, false},
                };
        boolean[][] PLATEAU_DEPART_APRES =
                {
                        {true, false, true, true},
                        {false, true, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                };
        AlgoNaif algoNaif = new AlgoNaif(PLATEAU_DEPART_AVANT);
        algoNaif.coupSuivant();
        assertThat(Arrays.deepEquals(algoNaif.getPlateau(), PLATEAU_DEPART_APRES)).isTrue();
    }

    @Test
    public void test_exercice2_4_3() throws Exception {
        boolean[][] PLATEAU_DEPART_AVANT =
                {
                        {false, false, true, true},
                        {false, false, false, false},
                        {false, false, false, false},
                        {true, true, false, false},
                };
        boolean[][] PLATEAU_DEPART_APRES =
                {
                        {true, true, false, true},
                        {false, false, true, false},
                        {false, false, false, false},
                        {false, false, false, false},
                };
        AlgoNaif algoNaif = new AlgoNaif(PLATEAU_DEPART_AVANT);
        algoNaif.coupSuivant();
        assertThat(Arrays.deepEquals(algoNaif.getPlateau(), PLATEAU_DEPART_APRES)).isTrue();
    }

    @Test
    public void test_exercice2_4_4() {
        boolean[][] PLATEAU_DEPART_AVANT =
                {
                        {false, false, false, false},
                        {false, false, false, false},
                        {false, false, false, false},
                        {true, true, true, true},
                };
        AlgoNaif algoNaif = new AlgoNaif(PLATEAU_DEPART_AVANT);
        Assertions.assertThatThrownBy(() -> algoNaif.coupSuivant())
                .hasMessageContaining("Vous avez épuisé toutes les possibilités");
    }

    @Test
    public void test_exercice2_4_5() {
        AlgoNaif algoNaif4x4 = new AlgoNaif(4);
        List<boolean[][]> solutions4x4 = algoNaif4x4.listerSolutions();
        assertThat(solutions4x4.size()).isEqualTo(2);

        AlgoNaif algoNaif8x8 = new AlgoNaif(8);
        List<boolean[][]> solutions8x8 = algoNaif8x8.listerSolutions();
        assertThat(solutions8x8.size()).isEqualTo(92);
    }



}
