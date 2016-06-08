package model;

import java.io.Serializable;

public class Persoana implements Comparable<Persoana>, Serializable {
    private String nume;
    private String prenume;

    public Persoana(String nume, String prenume) {
        this.nume = nume;
        this.prenume = prenume;
    }

    public String getNume(){
        return nume;
    }

    public String getPrenume(){
        return prenume;
    }

    public String getNumeComplet() {
        return nume + " " + prenume;
    }


    @Override
    public int compareTo(Persoana o) {
        return this.prenume.compareTo(o.getPrenume());
    }
}
