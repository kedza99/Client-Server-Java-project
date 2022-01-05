
package server;


public class Korisnik {
    private String sifra;
    private String kIme;

    public Korisnik(String kIme, String sifra) {
        this.sifra = sifra;
        this.kIme = kIme;
    }

    public String getSifra() {
        return sifra;
    }

    public String getkIme() {
        return kIme;
    }
    
}
