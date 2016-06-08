package model;

public class Cursant extends Persoana{

    public Cursant(String nume, String prenume) {
        super(nume, prenume);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(getNumeComplet());
        return sb.toString();
    }
}
