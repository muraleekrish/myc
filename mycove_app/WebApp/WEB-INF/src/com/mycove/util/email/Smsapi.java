package com.mycove.util.email;

import java.net.*; 
import java.io.*; 
  
public class Smsapi { 
    public static void main(String[] args) throws Exception { 
        URL myurl = new URL("http://s2.freesmsapi.com</STRONG>/messages/send?skey=dbf80d62d891f5843cb8ad7c11d92b91&message=YOUR_MESSAGE&senderid=YOUR_SENDERID&recipient=9994031031"); 
        BufferedReader in = new BufferedReader( 
        new InputStreamReader(myurl.openStream())); 
  
        String inputLine; 
  
        while ((inputLine = in.readLine()) != null) 
        System.out.println(inputLine); 
  
        in.close(); 
    } 
} 
