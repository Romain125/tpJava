package org.epita.tp.serie2.backtracking;

import org.epita.tp.serie2.naif.AlgoNaif;

import java.util.ArrayList;
import java.util.List;

public class AlgoBackTracking {

    private List<Dame> dames = new ArrayList<>();
    private final int dimensionPlateau;

    public AlgoBackTracking(int dimensionPlateau) {
        this.dimensionPlateau = dimensionPlateau;
    }

    public AlgoBackTracking(List<Dame> dames, int dimensionPlateau) {
        this.dames = dames;
        this.dimensionPlateau = dimensionPlateau;
    }

    public List<Dame> copieSolution(){
        List<Dame> copie = new ArrayList<>();
        for (Dame dame : dames) {
            copie.add(dame.clone());
        }
        return copie;
    }

    //Possibilité de le faire en statique si on passe les éléments en paramètres...
    public static String solutionToString(List<Dame> dames, int dimensionPlateau){
        boolean[][] plateau = new boolean[dimensionPlateau][dimensionPlateau];
        for (Dame dame : dames) {
            plateau[dame.getLigne()][dame.getColonne()] = true;
        }
        //Tant qu'à faire...on réutilise du code existant :)
        return AlgoNaif.plateauToString(plateau);
    }

    //...Ou en dynamique !
    public String solutionToString(){
        return solutionToString(this.dames, this.dimensionPlateau);
    }

    public List<List<Dame>> listerSolutionsBacktrack() {
        return placerDameSurColonne(0, new ArrayList<>());
    }

    private List<List<Dame>> placerDameSurColonne(int colonne, List<List<Dame>> solutions) {
        if(colonne >= dames.size()){
            Dame dame = new Dame(0, colonne);
            dames.add(dame);
        }
        for (int i = 0; i < dimensionPlateau; i++) {
            Dame dameActive = dames.get(colonne);
            if(estUnPlateauPossible()){
                if(colonne == dimensionPlateau-1){
                    solutions.add(copieSolution());
                }else{
                    placerDameSurColonne(colonne+1, solutions);
                }
            }
            dameActive.avancerLigne();
        }
        dames.remove(colonne);
        return solutions;
    }


    public boolean estUnPlateauPossible() {
        boolean estUnPlateauPossible = true;
        for (int i = 0; i < dames.size() -1 ; i++) {
            Dame dameReference = dames.get(i);
            for (int j = i+1; j < dames.size(); j++) {
                Dame dameCible = dames.get(j);
                estUnPlateauPossible &= !dameReference.peutManger(dameCible);
            }
        }
        return estUnPlateauPossible;
    }

}
