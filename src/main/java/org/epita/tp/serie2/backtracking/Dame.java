package org.epita.tp.serie2.backtracking;

public class Dame {

    private int ligne;
    private int colonne;

    public Dame(int ligne, int colonne) {

    }

    public boolean estSurLaMemeColonneQue(Dame dameCible) {
        return true;
    }

    public boolean estSurLaMemeLigneQue(Dame dameCible) {
        return true;
    }

    public boolean estSurLaMemeDiagonaleDroiteQue(Dame dameCible) {
        return true;
    }

    public boolean estSurLaMemeDiagonaleGaucheQue(Dame dameCible) {
        return true;
    }

    public boolean peutManger(Dame dameCible) {
        return true;
    }

}
