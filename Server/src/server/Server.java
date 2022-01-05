
package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends Thread {
    private Socket soket;
    private List<Korisnik> korisnik;
    private List<PonudaPrakse> pPrakse;
    private int brKlijenta;

    public Server(Socket soket, List<Korisnik> korisnik, List<PonudaPrakse> pPrakse, int brKlijenta) {
        this.soket = soket;
        this.korisnik = korisnik;
        this.pPrakse = pPrakse;
        this.brKlijenta = brKlijenta;
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
            PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
            out.println("Uspesna konekcija, klijenta: " + brKlijenta);
            out.println("Unesite korisnicko ime i sifru:");
            String mi = in.readLine();
            String mii = in.readLine();
            String s = null;
            for(Korisnik i : korisnik){
                if(i.getkIme().equals(mi)  && i.getSifra().equals(mii) ){
                    s ="konekcija uspesna!";
                    out.println("Konekcija uspesna!");
                }    
                 if(s == null){
                out.println("Konekcija nije uspela!");
                in.close();
                out.close();
                soket.close();
            }
            }
          
           
            out.println("Unesite max duzinu trajanja, deo naziva grada i donju granicu plate:");
            int maxD = Integer.parseInt(in.readLine());
            String deoG = in.readLine();
            Double donjaGP = Double.parseDouble(in.readLine());
            for(PonudaPrakse p : pPrakse){
                if(p.getTrPrakse()<= maxD && p.getGrad().contains(deoG)&& p.getPlata()>= donjaGP){
                    out.println(p);
                }
            }in.close();
            out.close();
            soket.close();
            
            
        } catch (IOException ex) {
            System.out.println("IO greska!!!");
        }
    }        
    public static void main(String[] args) throws IOException {
        int brKlijenta = 1;
      List<Korisnik> korisnik = new ArrayList<>();
      List<PonudaPrakse> pPrakse = new ArrayList<>();
      korisnik.add(new Korisnik("Aleksa", "555333"));
      korisnik.add(new Korisnik("Aleksa", "666666"));
      korisnik.add(new Korisnik("Aleksa", "777777"));
      korisnik.add(new Korisnik("Aleksa", "888888"));
      korisnik.add(new Korisnik("Aleksa", "999999"));
      pPrakse.add(new PonudaPrakse(5, "Beograd", 15000));
      pPrakse.add(new PonudaPrakse(6, "Smederevo", 10000));
      pPrakse.add(new PonudaPrakse(7, "NoviSad", 5000));
      pPrakse.add(new PonudaPrakse(20, "Nis", 3000));
      pPrakse.add(new PonudaPrakse(100, "Pristina", 1000));
       
      ServerSocket server = new ServerSocket(8900);
      while(true){
          new Server(server.accept(),korisnik,pPrakse,brKlijenta++).start();
      }
      
       
        
        
      
      
      
      
      
      
    }

    private String toString(String readLine) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
