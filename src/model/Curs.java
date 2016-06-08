package model;

import exceptii.CursantNecunoscut;
import exceptii.ListaGoala;
import exceptii.TrainerNecalificat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Curs implements Serializable{

    private String topic;
    private Trainer trainer;
    private List<Cursant> cursanti;
    private Map<Cursant, Double> note;

    public Curs(String topic, Trainer trainer) throws TrainerNecalificat{
        this.topic = topic;
        this.note = new HashMap<>();
        setTrainer(trainer);
    }

    public  void setCursanti(List<Cursant> cursanti) throws ListaGoala {
        if(cursanti.isEmpty()) {
            throw new ListaGoala("Lista e goala");
        }
        this.cursanti = cursanti;
    }

    public List<Cursant> getCursanti(){
        return cursanti;
    }

    public void setTrainer(Trainer trainer) throws TrainerNecalificat {
        boolean trainerulEsteCalificatPentruCurs = false;
        for (String arieExpertiza : trainer.getAriiExpertiza()){
            if (topic.equals(arieExpertiza)){
                trainerulEsteCalificatPentruCurs = true;
            }
        }
        if (!trainerulEsteCalificatPentruCurs){
            throw new TrainerNecalificat("Trainer necalificat");
        }
        this.trainer = trainer;
    }

    public String getTopic() {
        return topic;
    }

    public void noteaza(Cursant cursant, Double nota)
            throws CursantNecunoscut {
        if(cursanti.contains(cursant)) {
            if(!note.containsKey(cursant)) {
                note.put(cursant, nota);
            }
        } else {
            throw new CursantNecunoscut("Cursantul nu a participat la curs");
        }

    }

    public Double calculeazaNotaCurs() {
        Double sum = 0d;

        for(Double nota : note.values()) {
            sum = sum + nota;
        }

        return sum / this.note.size();
    }

    public Trainer getTrainer() {
        return trainer;
    }
}
