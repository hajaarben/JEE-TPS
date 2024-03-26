package pres;

import dao.IDao;
import metier.IMetier;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Pres2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner=new Scanner(new File("config.txt"));

        String daoClassName=scanner.nextLine();
        Class<?> cDao= Class.forName(daoClassName);
        IDao dao=(IDao) cDao.newInstance();

        String metierClassName=scanner.nextLine();
        Class<?> cMetier= Class.forName(metierClassName);
        Constructor<?> constructor = cMetier.getConstructor(IDao.class);
        IMetier metier=(IMetier) constructor.newInstance(dao);

        Method method=cMetier.getMethod("setDao",IDao.class);
        //metier.setDao(dao);
        method.invoke(metier,dao);

        System.out.println("Résultat=>"+metier.calcul());
        scanner.close();
    }
}

