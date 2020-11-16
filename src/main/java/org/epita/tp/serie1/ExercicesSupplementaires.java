package org.epita.tp.serie1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ExercicesSupplementaires {

    public static long exercice1(long...entiers){
        if(entiers.length == 0){
            return -1;
        }

        long somme = 0;
        for (long entier : entiers) {
            somme += entier*entier;
        }
        return somme;
    }


    public static int exercice2(float[] decimaux) throws IllegalArgumentException{
        if(decimaux.length == 0){
            throw new IllegalArgumentException("Il n'est pas possible de faire la moyenne d'un tableau vide");
        }

        float somme = 0;
        for (float decimal : decimaux) {
            somme+=decimal;
        }
        return (int)(somme/ decimaux.length);
    }

    public static int exercice3(long[] entiers){
        long eloignementMax = 0;
        boolean eloignementMaxIsPositive = true;
        int indexMax = 0;

        for (int i = 0; i < entiers.length; i++) {

            long valeurAbsolue = Math.abs(entiers[i]);

            if(valeurAbsolue > eloignementMax ||
                    (valeurAbsolue == eloignementMax && !eloignementMaxIsPositive) ){
                eloignementMax = valeurAbsolue;
                eloignementMaxIsPositive = (entiers[i]>=0);
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static long exercice4(int n){
        if(n <= 1){
            if(n<0){
                throw new IllegalArgumentException("Cannot calculate the Fibonacci of a negative number");
            }
            return n;
        }

        return exercice4(n-1)+exercice4(n-2);
    }

    public static long exercice4_optimise(int n){
        if(n <= 1){
            if(n<0){
                throw new IllegalArgumentException("Cannot calculate the Fibonacci of a negative number");
            }
            return n;
        }

        long nMoinsUn = 0;
        long nMoinsDeux = 1;
        long result = nMoinsDeux+nMoinsUn;

        for (int i = 2; i <= n; i++) {
            nMoinsDeux = nMoinsUn;
            nMoinsUn = result;
            result = nMoinsDeux+nMoinsUn;
        }

        return result;
    }

    public static boolean exercice5(int age, int pysique, long revenusAnnuels){
        return (revenusAnnuels>=1000000)
                || (revenusAnnuels>=50000 && pysique>=8 && age>=18 && age <=35);
    }

    public static String exercice6(String numeroClair){
        int nombreDeCaracteresClair = 4;

        if(numeroClair.length()<= nombreDeCaracteresClair){
            return numeroClair;
        }

        String numeroCrypte = "";
        for (int i = 0; i < numeroClair.toCharArray().length- nombreDeCaracteresClair; i++) {
            numeroCrypte+="#";
        }
        numeroCrypte+=numeroClair.substring(numeroClair.length()- nombreDeCaracteresClair);

        return numeroCrypte;
    }

    public static String exercice7(String texteMinEtMaj){
        int nombreDeMajuscules = 0;
        int nombreDeMinuscules = 0;

        for (char c : texteMinEtMaj.toCharArray()) {
            if(Character.isUpperCase(c)){
                nombreDeMajuscules++;
            }else{
                nombreDeMinuscules++;
            }
        }
        if(nombreDeMajuscules>nombreDeMinuscules){
            return texteMinEtMaj.toUpperCase();
        }
        if(nombreDeMajuscules<nombreDeMinuscules){
            return texteMinEtMaj.toLowerCase();
        }
        return texteMinEtMaj;
    }

    public static long exercice8(int[] entiers){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < entiers.length-1; i++) {
            int produit = entiers[i] * entiers[i + 1];
            if(produit > max){
                max = produit;
            }
        }
        return max;
    }

    public static long exercice9(int[] entiersPositifs){
        TreeSet<Integer> set = new TreeSet<>();
        for (int entiersPositif : entiersPositifs) {
            set.add(entiersPositif);
        }

        int resultat = 0;
        int puissance = 0;
        for (Integer integer : set.descendingSet()) {
            resultat += integer*Math.pow(10, puissance);
            puissance++;
        }

        return resultat;
    }

    public static long exercice10(String nombre, int nombreVirgules){
        if(nombreVirgules == 0){
            return Long.parseLong(nombre);
        }

        long max = 0;
        for (int i = 1; i <= nombre.length()-nombreVirgules ; i++) {
            long avantVirgule = exercice10(nombre.substring(0,i), 0);
            long apresVirgule = exercice10(nombre.substring(i), nombreVirgules-1);
            max = Math.max(max, Math.max(avantVirgule, apresVirgule));
        }
        return max;
    }

    public static boolean exercice11(int pieces10ct, int pieces20ct, int pieces50ct, int totalARendre){
        totalARendre = retrancher(totalARendre, 50, pieces50ct);
        totalARendre = retrancher(totalARendre, 20, pieces20ct);
        totalARendre = retrancher(totalARendre, 10, pieces10ct);
        return totalARendre == 0;
    }

    private static int retrancher(int totalARendre, int valeur, int nbPieces) {
        while(totalARendre >= valeur && nbPieces >0){
            totalARendre -= valeur;
            nbPieces--;
        }
        return totalARendre;
    }

}