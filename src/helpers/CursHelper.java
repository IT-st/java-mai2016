package helpers;


import exceptii.CursantNecunoscut;
import exceptii.ListaGoala;
import exceptii.TrainerNecalificat;
import model.Curs;
import model.Cursant;
import model.Trainer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by spacvalentin on 19.03.2016.
 */
public class CursHelper {

    public static Cursant creeazaCursant(String nume, String prenume) {
        return new Cursant(nume, prenume);
    }


    public static Trainer creeazaTrainer(String nume, String prenume, List<String> expertize) throws ListaGoala {
        if(expertize == null || expertize.isEmpty()) {
            throw new ListaGoala("Lista de expertize e goala");
        }

        Trainer trainer = new Trainer(nume, prenume);
        trainer.setAriiExpertiza(expertize);

        return trainer;
    }


    public static Curs creeazaCurs(Trainer ionel, List<Cursant> cursanti, String domeniu)
            throws ListaGoala, TrainerNecalificat {
        Curs java;
        java = new Curs(domeniu, ionel);
        java.setCursanti(cursanti);

        return java;
    }


    public static void noteazaCurs(Curs curs, Cursant cursant, Double nota) throws CursantNecunoscut {
        curs.noteaza(cursant, nota);
    }



    /**
    *   Metode ce creeaza date de test (dummy data)
    *
    */

    public static void noteazaCursJava(List<Cursant> listaCursanti, Curs java) {
        try {
            for (Cursant cursant : listaCursanti) {
                CursHelper.noteazaCurs(java, cursant, 4.3);
            }
        } catch (CursantNecunoscut e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }


    public static Trainer creeazaTrainerIonel() throws ListaGoala {
        List<String> expertizeIonel = new ArrayList<>();
        expertizeIonel.add("JAVA");
        expertizeIonel.add("C++");

        return CursHelper.creeazaTrainer("Ionescu", "Ionel", expertizeIonel);
    }


    public static List<Cursant> creeazaCursanti(){
        Cursant ana = CursHelper.creeazaCursant("Marinescu", "Ana");
        Cursant maria = CursHelper.creeazaCursant("Georgescu", "Maria");

        List<Cursant> listaCursanti = new ArrayList<>();
        listaCursanti.add(ana);
        listaCursanti.add(maria);
        return listaCursanti;
    }
}
