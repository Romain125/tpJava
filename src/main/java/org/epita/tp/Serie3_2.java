package org.epita.tp;

import java.util.ArrayList;
import java.util.List;

public class Serie3_2 {

    private List<String> arrayList = new ArrayList<>();
    private /* final */ int dimensionPlateau;

    public Serie3_2(int dimensionPlateau) {

    }

    public Serie3_2(List<String> arrayList, int dimensionPlateau) {

    }

    public List<List<Dame>> listerSolutionsBacktrack() {
        return null;
    }

    public boolean estUnPlateauPossible() {
        return true;
    }

    public boolean verifierColonne(int colonne) {
        return true;
    }

    public boolean verifierLigne(int ligne) {
        return true;
    }

    public boolean verifierDiagonaleDroite(int diagonaleDroite) {
        return true;
    }

    public boolean verifierDiagonaleGauche(int diagonaleGauche) {
        return true;
    }

}

class Dame{
    private int ligne;
    private int colonne;

}
