package org.epita.tp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Serie3_1 {

    private /*final*/ int taillePlateau;
    private /*final*/ boolean[][] plateau;

    public Serie3_1(int taillePlateau) {
    }

    public Serie3_1(boolean[][] plateau) {
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

    private boolean estUneSolution() {
        return true;
    }

    private boolean verifierColonne(int colonne) {
        return true;
    }

    private boolean verifierLigne(int ligne) {
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
