package helpers;

import model.Curs;
import model.Cursant;
import model.Trainer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by spacvalentin on 20.03.2016.
 */
public class FisierHelper {

    public static List<Trainer> citesteTraineriDinFisier() {
        String numeFisier = ConsolaHelper.citesteStringDeLaTastatura("Introdu calea fisierului (0 pt a iesi): ");

        if(!"0".equalsIgnoreCase(numeFisier)) {
            return citesteTraineriDinFisier(numeFisier);
        }

        return Collections.emptyList();
    }

    private static List<Trainer> citesteTraineriDinFisier(String numeFisier) {
        List<Trainer> traineri = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(numeFisier));
            String line;
            while((line = reader.readLine()) != null) {
                Trainer t = construiesteTrainer(reader, line);
                traineri.add(t);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Eroare! Fisierul nu a fost gasit!");
        } catch (IOException e) {
            System.out.println("A aparut o eroare. Incearca din nou");
        }

        return traineri;
    }

    private static Trainer construiesteTrainer(BufferedReader reader, String numeSiPrenume)
            throws IOException {
        String[] numePrenume = numeSiPrenume.split(",");
        String[] listaExpertize = reader.readLine().split(",");
        Trainer trainer =new Trainer(numePrenume[0], numePrenume[1]);
        trainer.setAriiExpertiza(Arrays.asList(listaExpertize));

        return trainer;
    }

    public static void save(List<Curs> cursuri, List<Cursant> cursanti, List<Trainer> traineri) {

        ContainerSalvare container = new ContainerSalvare();
        container.setCursanti(cursanti);
        container.setCursuri(cursuri);
        container.setTraineri(traineri);

        try {
            ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream("salvat.out"));
            stream.writeObject(container);
        } catch (IOException e) {
            System.out.println("A aparut o eroare. Incearca din nou");
        }


    }

    public static void load(List<Curs> cursuri, List<Cursant> cursanti, List<Trainer> traineri) {
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("salvat.out"));
            ContainerSalvare container = (ContainerSalvare)input.readObject();
            restaureazaListe(cursuri, cursanti, traineri, container);
        } catch (FileNotFoundException e) {
            System.out.println("Eroare! Fisierul nu a fost gasit!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("A aparut o eroare. Incearca din nou");
        }

    }

    public static void restaureazaListe(List<Curs> cursuri, List<Cursant> cursanti,
                                        List<Trainer> traineri, ContainerSalvare container) {
        cursuri.clear();
        cursuri.addAll(container.getCursuri());

        cursanti.clear();
        cursanti.addAll(container.getCursanti());

        traineri.clear();
        traineri.addAll(container.getTraineri());
    }
}
