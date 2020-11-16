package org.epita.tp.serie1;

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

    public static long exercice4(long[] entiers){
        return 0;
    }

    public static boolean exercice5(int age, int pysique, long revenusAnnuels){
        return true;
    }

    public static String exercice6(String numeroClair){
        return "";
    }

    public static long exercice7(String texteMinEtMaj){
        return 0;
    }

    public static long exercice8(int[] entiers){
        return 0;
    }

    public static long exercice9(int[] entiersPositifs){
        return 0;
    }

    public static long exercice10(String nombre){
        return 0;
    }

    public static boolean exercice11(int pieces10ct, int pieces20ct, int pieces50ct, int totalARendre){
        return false;
    }


}