package org.epita.tp.serie2;

import org.epita.tp.serie2.backtracking.AlgoBackTracking;
import org.epita.tp.serie2.backtracking.Dame;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestsAlgoBackTracking {

    @Test
    public void test_exercice2_1_1(){
        //Copie
    }

    @Test
    public void test_exercice2_1_2(){
        List<Dame> dames = new ArrayList<>();
        dames.add(new Dame(0,0));
        dames.add(new Dame(1,1));
        dames.add(new Dame(2,2));
        dames.add(new Dame(2,3));
        assertThat(AlgoBackTracking.solutionToString(dames, 4))
            .isEqualTo("|X| | | |\n| |X| | |\n| | |X|X|\n| | | | |\n");
    }

    @Test
    public void test_exercice2_2_1(){
        Dame dame1 = new Dame(0,0);
        Dame dame2 = new Dame(0,1);
        assertThat(dame1.estSurLaMemeLigneQue(dame2))
                .isTrue();
    }

    @Test
    public void test_exercice2_2_2(){
        Dame dame1 = new Dame(1,0);
        Dame dame2 = new Dame(2,0);
        assertThat(dame1.estSurLaMemeColonneQue(dame2))
                .isTrue();
    }

    @Test
    public void test_exercice2_2_3(){
        Dame dame1 = new Dame(0,1);
        Dame dame2 = new Dame(1,0);
        assertThat(dame1.estSurLaMemeDiagonaleGaucheQue(dame2))
                .isTrue();
    }

    @Test
    public void test_exercice2_2_4(){
        Dame dame1 = new Dame(0,0);
        Dame dame2 = new Dame(1,1);
        assertThat(dame1.estSurLaMemeDiagonaleDroiteQue(dame2))
                .isTrue();
    }

    @Test
    public void test_exercice2_3(){
        List<Dame> dames = new ArrayList<>();
        dames.add(new Dame(0,0));
        dames.add(new Dame(1,1));
        dames.add(new Dame(2,2));
        dames.add(new Dame(2,3));
        AlgoBackTracking backTracking = new AlgoBackTracking(dames, 4);
        assertThat(backTracking.estUnPlateauPossible()).isFalse();

        List<Dame> dames2 = new ArrayList<>();
        dames2.add(new Dame(0,0));
        dames2.add(new Dame(1,2));
        AlgoBackTracking backTracking2 = new AlgoBackTracking(dames2, 4);
        assertThat(backTracking2.estUnPlateauPossible()).isTrue();

    }

    @Test
    public void test_exercice2_4(){
        AlgoBackTracking backTrack4x4 = new AlgoBackTracking(4);
        assertThat(backTrack4x4.listerSolutionsBacktrack().size()).isEqualTo(2);
        AlgoBackTracking backTrack8x8 = new AlgoBackTracking(8);
        assertThat(backTrack8x8.listerSolutionsBacktrack().size()).isEqualTo(92);
    }

}
