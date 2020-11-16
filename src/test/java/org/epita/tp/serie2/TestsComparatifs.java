package org.epita.tp.serie2;

import org.epita.tp.serie2.backtracking.AlgoBackTracking;
import org.epita.tp.serie2.backtracking.Dame;
import org.epita.tp.serie2.naif.AlgoNaif;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TestsComparatifs {

    @Test
    public void test_exercice2_5(){
        //Comparer le temps d'exécution des deux algorithmes
        long debut = System.currentTimeMillis();
        List<boolean[][]> solutionsNaif = new AlgoNaif(8).listerSolutions();
        long fin = System.currentTimeMillis();
        long tempsNaif = fin-debut;

        debut = System.currentTimeMillis();
        List<List<Dame>> solutionsBacktrack = new AlgoBackTracking(8).listerSolutionsBacktrack();
        fin = System.currentTimeMillis();
        long tempsBacktrack = fin-debut;

        assertThat(solutionsNaif.size()).isEqualTo(solutionsBacktrack.size());
        assertThat(tempsNaif).isGreaterThanOrEqualTo(tempsBacktrack);

    }

    @Test
    @Timeout(10)
    public void experimental(){
        new AlgoBackTracking(12).listerSolutionsBacktrack();
    }


}
