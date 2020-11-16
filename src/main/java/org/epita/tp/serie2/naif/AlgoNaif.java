package org.epita.tp.serie2.naif;

import java.util.ArrayList;
import java.util.List;

public class AlgoNaif {

    private final int taillePlateau;
    private final boolean[][] plateau;

    public AlgoNaif(int taillePlateau) {
        this.taillePlateau = taillePlateau;
        plateau = new boolean[taillePlateau][taillePlateau];
        for (int colonne = 0; colonne < taillePlateau; colonne++) {
            plateau[0][colonne] = true;
        }
    }

    public AlgoNaif(boolean[][] plateau) {
        this.taillePlateau = plateau.length;
        this.plateau = plateau;
    }

    public boolean[][] getPlateau() {
        return copierPlateau(plateau);
    }

    public List<boolean[][]> listerSolutions(){
        List<boolean[][]> solutions = new ArrayList<>();
        boolean aEncoreDesSolutionsPossible = true;

        while(aEncoreDesSolutionsPossible){
            try {
                if(estUneSolution()){
                    boolean[][] solution = copierPlateau(plateau);
                    solutions.add(solution);
                }
                coupSuivant();
            } catch (Exception e) {
                aEncoreDesSolutionsPossible = false;
            }
        }
        return solutions;
    }

    public void coupSuivant() throws Exception {
        coupSuivantColonne(0);
    }

    private void coupSuivantColonne(int colonne) throws Exception {
        boolean cycleComplet = avancerLigne(colonne);
        if(cycleComplet){
            if(colonne+1 >= taillePlateau){
                throw new Exception("Vous avez épuisé toutes les possibilités");
            }
            coupSuivantColonne(colonne+1);
        }
    }

    private boolean avancerLigne(int colonne) {
        boolean damePresente = plateau[plateau.length-1][colonne];
        if(damePresente){
            plateau[plateau.length-1][colonne] = false;
            plateau[0][colonne] = true;
            return true;
        }

        for (int ligne = 0; ligne < plateau.length - 1; ligne++) {
            damePresente = plateau[ligne][colonne];
            if(damePresente){
                plateau[ligne][colonne] = false;
                plateau[ligne+1][colonne] = true;
                return false;
            }
        }
        return false;
    }

    public boolean estUneSolution() {
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                if(plateau[ligne][colonne]){
                    boolean etatOk = verifierLigne(colonne);
                    etatOk &= verifierColonne(ligne);
                    etatOk &= verifierDiagonaleDroite(colonne - ligne);
                    etatOk &= verifierDiagonaleGauche(colonne + ligne);
                    if(!etatOk){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean verifierColonne(int colonne) {
        int nombreDeDames = 0;
        for (int ligne = 0; ligne < plateau[colonne].length; ligne++) {
            if(plateau[ligne][colonne]){
                nombreDeDames++;
            }
        }
        return nombreDeDames<2;
    }

    public boolean verifierLigne(int ligne) {
        int nombreDeDames = 0;
        for (int colonne = 0; colonne < plateau.length; colonne++) {
            if(plateau[ligne][colonne]){
                nombreDeDames++;
            }
        }
        return nombreDeDames<2;
    }

    public boolean verifierDiagonaleDroite(int diagonaleDroite) {
        int nombreDeDames = 0;
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            if(diagonaleDroite+ligne>=0 && diagonaleDroite+ligne<taillePlateau){
                int colonne = diagonaleDroite+ligne;
                if(plateau[ligne][colonne]){
                    nombreDeDames++;
                }
            }
        }
        return nombreDeDames<2;
    }

    public boolean verifierDiagonaleGauche(int diagonaleGauche) {
        int nombreDeDames = 0;
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            if(diagonaleGauche-ligne>=0 && diagonaleGauche-ligne<taillePlateau){
                int colonne = diagonaleGauche-ligne;
                if(plateau[ligne][colonne]){
                    nombreDeDames++;
                }
            }
        }
        return nombreDeDames<2;
    }

    public static boolean[][] copierPlateau(boolean [][] plateau) {
        //Ici on peut utilise un plateau.clone(), mais cela ne fonctionne pas sur les objets sous-jacents
        //Il faudrait une option de deepCopy.
        boolean [][] copy = new boolean[plateau.length][plateau[0].length];
        for (int i = 0; i < plateau.length; i++) {
            //Ceci dit, on pourrait utiliser un clone() à la place de cette boucle
            for (int j = 0; j < plateau[i].length; j++) {
                copy[i][j] = plateau[i][j];
            }
        }
        return copy;
    }

    public static String plateauToString(boolean[][] plateau){
        String representation = "";
        for (int ligne = 0; ligne < plateau.length; ligne++) {
            for (int colonne = 0; colonne < plateau[ligne].length; colonne++) {
                boolean damePresente = plateau[ligne][colonne];
                representation += "|";
                if(damePresente){
                    representation += "X";
                }else{
                    representation += " ";
                }
            }
            representation+="|\n";
        }
        return representation;
    }

    @Override
    public String toString() {
        return plateauToString(this.plateau);
    }

}
