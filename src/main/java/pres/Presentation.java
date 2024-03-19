package pres;

import ext.DaoImpl2;
import metier.IMetierImpl;

public class Presentation {
    public static void main(String[] args) {
        /*
        Injection des dépendances par
        instanciation statique => new = couplage fort => la poubelle
         */
        DaoImpl2 dao=new DaoImpl2();
        IMetierImpl metier=new IMetierImpl(dao);
        //metier.setDao(dao);
        System.out.println("Résultat="+metier.calcul());


    }
}
