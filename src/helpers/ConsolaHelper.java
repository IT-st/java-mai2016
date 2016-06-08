package helpers;

import exceptii.CursantNecunoscut;
import exceptii.ListaGoala;
import exceptii.TrainerNecalificat;
import model.Curs;
import model.Cursant;
import model.Trainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by spacvalentin on 19.03.2016.
 */
public class ConsolaHelper {

    public static String citesteStringDeLaTastatura(String mesajDeAfisat) {
        System.out.println(mesajDeAfisat);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int citesteIntegerDeLaTastatura(String mesajDeAfisat) {
        System.out.println(mesajDeAfisat);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static double citesteDoubleDeLaTastatura(String mesajDeAfisat) {
        System.out.println(mesajDeAfisat);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextDouble();
    }

    /**
     * Vom citi de la tastatura toate informatiile necesare crearii unui trainer
     * Nume, prenume, arii expertiza
     */
    public static Trainer creeazaTrainerDeLaConsola() {
        String nume = citesteStringDeLaTastatura("Introdu numele trainerului: ");
        String prenume = citesteStringDeLaTastatura("Introdu prenumele trainerului: ");

        Trainer trainer = null;
        boolean valid;
        do {
            List<String> expertize = citesteExpertize();
            valid = true;

            try {
                trainer = CursHelper.creeazaTrainer(nume, prenume, expertize);
            } catch (ListaGoala listaGoala) {
                System.out.println("Lista de expertize este goala! Adaugati cel putin o expertiza!");
                valid = false;
            }
        } while (!valid);

        return trainer;
    }

    private static List<String> citesteExpertize() {
        String expertiza;
        List<String> expertize = new ArrayList<>();
        while(true) {
            expertiza = citesteStringDeLaTastatura("Introdu expertizele trainerului (0 pt a iesi): ");
            if("0".equalsIgnoreCase(expertiza)) {
                break;
            } else {
                expertize.add(expertiza);
            }
        }
        return expertize;
    }

    /**
     * Nume, prenume
     */
    public static Cursant creeazaCursantDeLaConsola() {
        String nume = citesteStringDeLaTastatura("Introdu numele cursantului: ");
        String prenume = citesteStringDeLaTastatura("Introdu prenumele cursantului: ");

        return CursHelper.creeazaCursant(nume, prenume);

    }

    //va citi de la tastatura nota unui cursant ales
    public static void noteazaCursDeLaConsola(Curs curs) {
        List<Cursant> cursanti = curs.getCursanti();
        Cursant cursant = null;

        while(true) {
            afiseazaCursanti(cursanti);
            int index = ConsolaHelper.citesteIntegerDeLaTastatura("Introdu indexul cursantului (0 pentru a iesi): ");
            if(index == 0) {
                break;
            } else if(index < 0 || index > cursanti.size()) {
                System.out.println("Invalid index!");
            } else {
                cursant = cursanti.get(index - 1);
                break;
            }
        }

        Double nota = ConsolaHelper.citesteDoubleDeLaTastatura("Introdu nota cursului: ");

        try {
            curs.noteaza(cursant, nota);
        } catch (CursantNecunoscut cursantNecunoscut) {
            cursantNecunoscut.printStackTrace();
        }

    }

    public static Curs creeazaCurs(List<Trainer> traineri, List<Cursant> cursanti) {
        Curs curs =  asigneazaCursuluiDomeniuSiTrainer(traineri);
        asigneazaCursuluiCursanti(curs, cursanti);
        return curs;

    }

    private static Curs asigneazaCursuluiDomeniuSiTrainer(List<Trainer> traineri) {
        Curs curs = null;

        while(true) {
            String domeniu = ConsolaHelper.citesteStringDeLaTastatura("Domeniul cursului: ");

            afiseazaTraineri(traineri);

            int trainerIndex = ConsolaHelper.citesteIntegerDeLaTastatura("Alegeti trainerul (0 pentru a iesi): ");
            if (0 == trainerIndex) {
                break;
            } else if(trainerIndex < 0 || trainerIndex > traineri.size()) {
                System.out.println("Invalid index!");
            } else {
                try {
                    curs = new Curs(domeniu, traineri.get(trainerIndex - 1));
                    break;
                } catch (TrainerNecalificat trainerNecalificat) {
                    System.out.println(trainerNecalificat.getMessage());
                }
            }

        }

        return curs;
    }


    private static void asigneazaCursuluiCursanti(Curs curs, List<Cursant> cursanti) {
        boolean valid;
        afiseazaCursanti(cursanti);

        List<Cursant> cursantiAsignati = new ArrayList<>();

        valid = false;
        while(!valid) {

            while (true) {
                int indexCursant = ConsolaHelper.citesteIntegerDeLaTastatura("Alegeti un cursant pentru curs (0 petru a iesi): ");
                if (0 == indexCursant) {
                    break;
                } else if(indexCursant < 0 || indexCursant > cursanti.size()) {
                    System.out.println("Invalid index!");
                } else {
                    cursantiAsignati.add(cursanti.get(indexCursant - 1));
                }
            }

            valid = true;
            try {
                curs.setCursanti(cursantiAsignati);
            } catch (ListaGoala listaGoala) {
                System.out.println("Lista de cursanti e goala!");
                valid = false;
            }
        }
    }

    public static void noteazaCursDeLaConsola(List<Curs> cursuri) {

        while (true) {
            afiseazaCursuri(cursuri);
            int indexCurs = ConsolaHelper.citesteIntegerDeLaTastatura("Alegeti un curs (0 petru a iesi): ");
            if (0 == indexCurs) {
                break;
            } else if(indexCurs < 0 || indexCurs > cursuri.size()) {
                System.out.println("Invalid index!");
            } else {
                noteazaCursDeLaConsola(cursuri.get(indexCurs - 1));
            }
        }
    }

    public static void afiseazaNotaCurs(List<Curs> cursuri) {

        while (true) {
            afiseazaCursuri(cursuri);
            int indexCurs = ConsolaHelper.citesteIntegerDeLaTastatura("Alegeti un curs (0 petru a iesi): ");
            if (0 == indexCurs) {
                break;
            } else if(indexCurs < 0 || indexCurs > cursuri.size()) {
                System.out.println("Invalid index!");
            } else {
                System.out.println("Nota cursului este " + cursuri.get(indexCurs - 1).calculeazaNotaCurs());
            }
        }
    }

    public static void afiseazaCursuri(List<Curs> cursuri) {
        System.out.println("Cursuri: ");
        for (int i = 0; i < cursuri.size(); i++) {
            System.out.println((i + 1) + " " + cursuri.get(i).getTopic());
        }
    }

    public static void afiseazaTraineri(List<Trainer> traineri) {
        System.out.println("Traineri:");
        for (int i = 0; i < traineri.size(); i++) {
            System.out.println((i + 1) + " " + traineri.get(i));
        }
    }

    public static void afiseazaCursanti(List<Cursant> cursanti) {
        System.out.println("Cursanti:");
        for (int i = 0; i < cursanti.size(); i++) {
            System.out.println((i + 1) + " " + cursanti.get(i));
        }
    }

    public static void afiseazaCursuriDetaliat(List<Curs> cursuri) {
        while (true) {
            afiseazaCursuri(cursuri);
            int indexCurs = ConsolaHelper.citesteIntegerDeLaTastatura("Alegeti un curs (0 petru a iesi): ");
            if (0 == indexCurs) {
                break;
            } else if(indexCurs < 0 || indexCurs > cursuri.size()) {
                System.out.println("Invalid index!");
            } else {
                Curs curs = cursuri.get(indexCurs - 1);
                System.out.println("Topic: " + curs.getTopic());
                System.out.println("Trainer: " + curs.getTrainer());
                System.out.println("Cursanti: " + curs.getCursanti());
            }
        }
    }
}
