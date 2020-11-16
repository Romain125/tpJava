package org.epita.tp.serie2.backtracking;

public class Dame {

    private int ligne;
    private int colonne;

    public Dame(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public int getDiagonaleGauche() {
        return ligne+colonne;
    }

    public int getDiagonaleDroite() {
        return colonne-ligne;
    }

    public boolean estSurLaMemeColonneQue(Dame dameCible) {
        return dameCible.getColonne() == this.getColonne();
    }

    public boolean estSurLaMemeLigneQue(Dame dameCible) {
        return dameCible.getLigne() == this.getLigne();
    }

    public boolean estSurLaMemeDiagonaleDroiteQue(Dame dameCible) {
        return dameCible.getDiagonaleDroite() == this.getDiagonaleDroite();
    }

    public boolean estSurLaMemeDiagonaleGaucheQue(Dame dameCible) {
        return dameCible.getDiagonaleGauche() == this.getDiagonaleGauche();
    }

    public boolean peutManger(Dame dameCible) {
        return estSurLaMemeColonneQue(dameCible)
                || estSurLaMemeLigneQue(dameCible)
                || estSurLaMemeDiagonaleDroiteQue(dameCible)
                || estSurLaMemeDiagonaleGaucheQue(dameCible);
    }

    public void avancerLigne() {
        this.ligne++;
    }

    public Dame clone(){
        return new Dame(ligne, colonne);
    }
}
