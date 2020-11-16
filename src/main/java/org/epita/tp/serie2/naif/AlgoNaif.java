package org.epita.tp.serie2.naif;

import java.util.List;

public class AlgoNaif {

    private /*final*/ int taillePlateau;
    private /*final*/ boolean[][] plateau;

    public AlgoNaif(int taillePlateau) {
    }

    public AlgoNaif(boolean[][] plateau) {
    }

    public boolean[][] getPlateau() {
        return plateau;
    }

    public List<boolean[][]> listerSolutionsNaif(){
        return null;
    }

    public void coupSuivant() {
        return;
    }

    public boolean estUneSolution() {
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

    public static boolean[][] copierPlateau(boolean [][] plateau) {
        return null;
    }

    public static String plateauToString(boolean[][] plateau){
        return "";
    }

    @Override
    public String toString() {
        return "";
    }

}
