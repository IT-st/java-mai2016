import helpers.ConsolaHelper;
import helpers.FisierHelper;
import model.Curs;
import model.Cursant;
import model.Trainer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static List<Trainer> traineri = new ArrayList<>();
    private static List<Cursant> cursanti = new ArrayList<>();
    private static List<Curs> cursuri = new ArrayList<>();

    public static void main(String[] args) throws Exception {

/*        Trainer ionel = CursHelper.creeazaTrainerIonel();
        List<Cursant> listaCursanti = CursHelper.creeazaCursanti();

        Curs java = CursHelper.creeazaCurs(ionel, listaCursanti, "JAVA");
        CursHelper.noteazaCursJava(listaCursanti, java);

        System.out.println("Media cursului este " + java.calculeazaNotaCurs());*/

        meniu();

    }

    private static void meniu() {
        int optiune;
        do {
            afiseazaMeniu();

            optiune = ConsolaHelper.citesteIntegerDeLaTastatura("Optiune: ");

            switch (optiune) {
                case 1: Trainer trainer = ConsolaHelper.creeazaTrainerDeLaConsola();
                    traineri.add(trainer);
                    break;
                case 2: ConsolaHelper.afiseazaTraineri(traineri);
                    break;
                case 3: Cursant cursant = ConsolaHelper.creeazaCursantDeLaConsola();
                    cursanti.add(cursant);
                    break;
                case 4: ConsolaHelper.afiseazaCursanti(cursanti);
                    break;
                case 5: Curs curs = ConsolaHelper.creeazaCurs(traineri, cursanti);
                    cursuri.add(curs);
                    break;
                case 6: ConsolaHelper.afiseazaCursuri(cursuri);
                    break;
                case 7: ConsolaHelper.afiseazaCursuriDetaliat(cursuri);
                    break;
                case 8: ConsolaHelper.noteazaCursDeLaConsola(cursuri);
                    break;
                case 9: ConsolaHelper.afiseazaNotaCurs(cursuri);
                    break;
                case 10: afiseazaTraineriSortati(traineri, new SorteazaTrainerDupaNume());
                    break;
                case 11: afiseazaTraineriSortati(traineri, new SorteazaTrainerDupaNumeSiExpertize());
                    break;
                case 12: afiseazaTraineriSortati(traineri);
                    break;
                case 13: traineri = FisierHelper.citesteTraineriDinFisier();
                    break;
                case 14: FisierHelper.save(cursuri, cursanti, traineri);
                    break;
                case 15: FisierHelper.load(cursuri, cursanti, traineri);
                    break;
                case 0:
                    System.out.println("B-bye!");
                    break;
                default:
                    System.out.println("Optiune invalida!");
            }
        } while(optiune != 0);
    }


    private static void afiseazaMeniu() {
        System.out.println("\nStuff you can do: ");
        System.out.println("1. Creeaza trainer");
        System.out.println("2. Afiseaza traineri");
        System.out.println("3. Creeaza cursant");
        System.out.println("4. Afiseaza cursanti");
        System.out.println("5. Creeaza curs");
        System.out.println("6. Afiseaza cursuri");
        System.out.println("7. Afiseaza curs detaliat");
        System.out.println("8. Noteaza curs");
        System.out.println("9. Vezi nota curs");
        System.out.println("10. Afiseaza traineri sortati dupa nume");
        System.out.println("11. Afiseaza traineri sortati dupa nume si numarul expertizelor");
        System.out.println("12. Afiseaza traineri sortati fara comparator (persoana implements comparable)");
        System.out.println("13. Citeste traineri din fisier");
        System.out.println("14. Salveaza");
        System.out.println("15. Incarca");
        System.out.println("0. Iesire");
    }

    public static void afiseazaTraineriSortati(List<Trainer> traineri, Comparator<Trainer> comparator) {
        Collections.sort(traineri, comparator);

        System.out.println("Traineri sortati:");
        for (int i = 0; i < traineri.size(); i++) {
            System.out.println((i + 1) + " " + traineri.get(i));
        }
    }

    private static void afiseazaTraineriSortati(List<Trainer> traineri) {
        Collections.sort(traineri);

        System.out.println("Traineri sortati:");
        for (int i = 0; i < traineri.size(); i++) {
            System.out.println((i + 1) + " " + traineri.get(i));
        }
    }

    private static class SorteazaTrainerDupaNume implements Comparator<Trainer> {
        @Override
        public int compare(Trainer o1, Trainer o2) {
            return o1.getNumeComplet().compareTo(o2.getNumeComplet());
        }
    }

    private static class SorteazaTrainerDupaNumeSiExpertize implements Comparator<Trainer> {
        @Override
        public int compare(Trainer o1, Trainer o2) {
            int resultatExpertize = o1.getAriiExpertiza().size() - o2.getAriiExpertiza().size();

            if(resultatExpertize != 0) {
                return -resultatExpertize;
            } else {
                return o1.getNumeComplet().compareTo(o2.getNumeComplet());
            }
        }
    }

}
