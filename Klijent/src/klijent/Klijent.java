
package klijent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Klijent {

   
    public static void main(String[] args) throws IOException {
        Socket soket = new Socket("localhost",8900);
        Scanner s = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        Scanner sp = new Scanner(System.in);
        BufferedReader in = new BufferedReader(new InputStreamReader(soket.getInputStream()));
        PrintWriter out = new PrintWriter(soket.getOutputStream(), true);
        
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        out.println(s.nextLine());
        out.println(s.nextLine());
        String kk = in.readLine();
        System.out.println(kk);
        if(kk.equals("Konekcija nije uspela!")){
            in.close();
            out.close();
            soket.close();
            System.exit(0);
            
        }
        System.out.println(in.readLine());
        out.println(s.nextInt());
        out.println(sc.nextLine());
        out.println(sp.nextDouble());
        String ss;
        while((ss = in.readLine())!=null){
            System.out.println(ss);
        }
        in.close();
        out.close();
        soket.close();
        System.exit(0);
        
    }
    
}
