package com.example;
import java.io.*;
import java.net.*;
public class client {
    
String nomeServer="localhost";
int portaServer=6789;
Socket mioSocket;
BufferedReader tastiera;
String stringaUtente;
String stringaRicevutaDalServer;
DataOutputStream outVersoServer;
BufferedReader inDalServer;

public Socket conetti(){
System.out.println("2 client partito in esecuzione...");;
try{

tastiera=new BufferedReader(new InputStreamReader(System.in));
mioSocket=new Socket(nomeServer,portaServer);
outVersoServer=new DataOutputStream(mioSocket.getOutputStream());
inDalServer=new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

}
catch(UnknownHostException e){
System.err.println("host sconosciuto");

}
catch(Exception e)
{
System.out.println(e.getMessage());
System.out.println("errore durante la connessione");
System.exit(1);
}
return mioSocket;
}
public void comunica(){


    try {
      tastiera=new BufferedReader(new InputStreamReader(System.in)) ;
      System.out.println("METTI NUMERO");
stringaRicevutaDalServer=tastiera.readLine();
outVersoServer.writeBytes(stringaRicevutaDalServer+"\n");
 System.out.println("METTI OPERATORE");
stringaRicevutaDalServer=tastiera.readLine();
outVersoServer.writeBytes(stringaRicevutaDalServer+"\n");;
  System.out.println("METTI SECONDO NUMERO");
stringaRicevutaDalServer=tastiera.readLine();
outVersoServer.writeBytes(stringaRicevutaDalServer+"\n");;
 int numeroricevuto=Integer.parseInt(inDalServer.readLine())  ;            
        

    } catch (Exception e) {
      e.printStackTrace();
    }
}
public static void main(String[]args){

client c1=new client();
c1.conetti();
c1.comunica();


}

}









 

