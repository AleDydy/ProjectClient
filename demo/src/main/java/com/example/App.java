package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 
 *
 */
public class App {
    public static void main( String[] args ) {
        try {

            Socket s=new Socket("localhost", 3000);

            BufferedReader in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            DataOutputStream out=new DataOutputStream(s.getOutputStream());

            System.out.println("ora contatto il server...");

            out.writeBytes("ciao, sono il client" + "\n");

            String messfromserver=in.readLine();

            System.out.println("ecco il messaggio ricevuto dal server: " + messfromserver);

            s.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
