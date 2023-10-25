package com.example;

import java.io.*;
import java.net.*;
import java.util.*;

public class server {
    ServerSocket server=null;
    Socket client=null;
    String stringaRicevuta=null;
    String stringaModificata=null;
    BufferedReader inDaclient;
    DataOutputStream outVersoClient;
    int numeroclient;
    int secondonumero;
    String OPERATORE;
int result;
    /**
     * @return
     */
    public Socket attendi(){

try{
    System.out.println("1 server partito in exe");
    server=new ServerSocket(6798);
    client=server.accept();
    server.close();
    inDaclient=new BufferedReader(new InputStreamReader(client.getInputStream()));
    outVersoClient=new DataOutputStream(client.getOutputStream());
  
}
catch(Exception e)
{
    System.out.println(e.getMessage());
    System.out.println("errore durante istanza del server !");
    System.exit(1);


}

    
return client;
    }

public void comunic(){
    try {
        
   
numeroclient=Integer.parseInt(inDaclient.readLine());

OPERATORE=inDaclient.readLine();
secondonumero=Integer.parseInt(inDaclient.readLine());
if(OPERATORE.equals("+") ){
result=numeroclient+secondonumero;
outVersoClient.writeBytes(String.valueOf(result)+"\n");
}
if(OPERATORE.equals("-") ){
result=numeroclient-secondonumero;
outVersoClient.writeBytes(String.valueOf(result)+"\n");
}

if(OPERATORE.equals("*") ){
result=numeroclient*secondonumero;
outVersoClient.writeBytes(String.valueOf(result)+"\n");
}
if(OPERATORE.equals("/") ){
result=numeroclient/secondonumero;
outVersoClient.writeBytes(String.valueOf(result)+"\n");
}


 } catch (Exception e) {
       e.printStackTrace();
}

}


public static void main(String[]args){

server s1=new server();
s1.attendi();
s1.comunic();


}

}














