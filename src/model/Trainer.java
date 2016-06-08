package model;

import java.util.ArrayList;
import java.util.List;

public class Trainer extends Persoana {
    private List<String> ariiExpertiza = new ArrayList<>();

    public Trainer(String nume, String prenume){
        super(nume, prenume);
    }

    public void setAriiExpertiza(List<String> ariiExpertiza){
        this.ariiExpertiza = ariiExpertiza;
    }

    public List<String> getAriiExpertiza(){
        return ariiExpertiza;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append(getNumeComplet());
        sb.append(", ").append(ariiExpertiza);
        return sb.toString();
    }
}
