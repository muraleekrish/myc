package com.mycove.util.email;

import java.util.HashMap;
import java.util.Map;

import com.mycove.twilio.sdk.TwilioRestClient;
import com.mycove.twilio.sdk.TwilioRestException;
import com.mycove.twilio.sdk.TwilioRestResponse;

public class MakeTwilioSms {
    /* Twilio REST API version */
    public static final String APIVERSION = "2010-04-01";
    public static final String ACCOUNTSID = "ACc3171c134df98bf926def4c9a504d584";
    public static final String AUTHTOKEN = "1d9b8001b920825d87cd050da3543c9e";
    public static void main(String args[]){
    	
        /* Instantiate a new Twilio Rest Client */
        TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN, null);

        //build map of server admins
        Map<String,String> admins = new HashMap<String,String>();
        admins.put("1 201-993-0724", "anand");
       // admins.put("4158675310", "Helen");
       // admins.put("4158675311", "Virgil");
        
    	// Iterate over all our server admins
        for (Map.Entry<String, String> entry : admins.entrySet()) {
    		// Send a new outgoinging SMS by POST'ing to the SMS resource */
    		// YYY-YYY-YYYY must be a Twilio validated phone number

            //build map of post parameters 
            Map<String,String> params = new HashMap<String,String>();
            params.put("From", "((415) 599-2671)");
            params.put("To", entry.getKey());
            params.put("Body", "Hi " + entry.getValue() + ", Testing SMS Funtion(Testing Process-Savant Pvt");

            TwilioRestResponse response;
            try {
                response = client.request("/"+APIVERSION+"/Accounts/"+client.getAccountSid()+"/SMS/Messages", "POST", params);
            
                if(response.isError())
                	System.out.println("Error send SMS: "+response.getHttpStatus()+"\n"+response.getResponseText());
                else {
                	System.out.println("Success sending SMS: " + response.getResponseText());
                }
            } catch (TwilioRestException e) {
                e.printStackTrace();
            }
        }       

    }
}
