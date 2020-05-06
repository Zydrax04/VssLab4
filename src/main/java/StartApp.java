
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Statistica;
import controller.AppController;
import exception.NotAbleToCreateStatisticsException;

//functionalitati
//F01.	 adaugarea unei noi intrebari pentru un anumit domeniu (enunt intrebare, raspuns 1, raspuns 2, raspuns 3, raspunsul corect, domeniul) in setul de intrebari disponibile;
//F02.	 crearea unui nou test (testul va contine 5 intrebari alese aleator din cele disponibile, din domenii diferite);
//F03.	 afisarea unei statistici cu numarul de intrebari organizate pe domenii.

public class StartApp {

    private static final String file = "E:\\VVSS\\labo2\\src\\intrebari.txt";

    public static void main(String[] args) throws IOException {

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        AppController appController = new AppController();

        boolean activ = true;
        String optiune = "";

        while(activ){

            System.out.println("");
            System.out.println("1.Adauga intrebare");
            System.out.println("2.Creeaza test");
            System.out.println("3.Statistica");
            System.out.println("4.Exit");
            System.out.println("");

            optiune = console.readLine();

            if ("1".equals(optiune)) {
            } else if ("2".equals(optiune)) {
            } else if ("3".equals(optiune)) {
                appController.loadIntrebariFromFile(file);
                Statistica statistica;
                try {
                    statistica = appController.getStatistica();
                    System.out.println(statistica);
                } catch (NotAbleToCreateStatisticsException e) {
                    // TODO
                }
            } else if ("4".equals(optiune)) {
                activ = false;
            }
        }

    }

}
