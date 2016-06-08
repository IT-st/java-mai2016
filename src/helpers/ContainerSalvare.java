package helpers;

import model.Curs;
import model.Cursant;
import model.Trainer;

import java.io.Serializable;
import java.util.List;

/**
 * Created by spacvalentin on 20.03.2016.
 */
public class ContainerSalvare implements Serializable{
    private List<Trainer> traineri;
    private List<Cursant> cursanti;
    private List<Curs> cursuri;

    public List<Trainer> getTraineri() {
        return traineri;
    }

    public void setTraineri(List<Trainer> traineri) {
        this.traineri = traineri;
    }

    public List<Cursant> getCursanti() {
        return cursanti;
    }

    public void setCursanti(List<Cursant> cursanti) {
        this.cursanti = cursanti;
    }

    public List<Curs> getCursuri() {
        return cursuri;
    }

    public void setCursuri(List<Curs> cursuri) {
        this.cursuri = cursuri;
    }
}
