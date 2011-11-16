package com.mycove.cove.sms;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mycove.twilio.sdk.TwilioRestClient;
import com.mycove.twilio.sdk.TwilioRestException;
import com.mycove.twilio.sdk.TwilioRestResponse;

public class SmsUtil   {
    /* Twilio REST API version */
    public static final String APIVERSION = "2010-04-01";
    public static final String ACCOUNTSID = "ACc3171c134df98bf926def4c9a504d584";
    public static final String AUTHTOKEN = "1d9b8001b920825d87cd050da3543c9e";
    private String msgTo;
    private String subject;
    private String msgBody;
    	
  /*  public SmsUtil() throws Exception
    {
    msgTo = "";
    subject="";
    msgBody="";
    }*/
	/**
	 * @return the msgTo
	 */
	public String getMsgTo() {
		return msgTo;
	}

	/**
	 * @param msgTo the msgTo to set
	 */
	public void setMsgTo(String msgTo) {
		this.msgTo = msgTo;
	}

	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

			/**
	 * @return the msgBody
	 */
	public String getMsgBody() {
		return msgBody;
	}

	/**
	 * @param msgBody the msgBody to set
	 */
	public void setMsgBody(String msgBody) {
		this.msgBody = msgBody;
	}

		public void sendSms(SmsUtil smsUtil)throws Exception
    	{
        /* Instantiate a new Twilio Rest Client */
			 
        TwilioRestClient client = new TwilioRestClient(ACCOUNTSID, AUTHTOKEN, null);

        //build map of server admins
       // Map<String,String> admins = new HashMap<String,String>();
       // admins.put("1 201-993-0724", "anand");
       // admins.put("4158675310", "Helen");
       // admins.put("4158675311", "Virgil");
        
    	// Iterate over all our server admins
       // for (Map.Entry<String, String> entry : admins.entrySet()) {
        
    		// Send a new outgoinging SMS by POST'ing to the SMS resource */
    		// YYY-YYY-YYYY must be a Twilio validated phone number

            //build map of post parameters 
        	System.out.println("phone"+smsUtil.getMsgTo());
        	System.out.println("sub"+smsUtil.getSubject());
            Map<String,String> params = new HashMap<String,String>();
            params.put("From", "((415) 599-2671)");
            //params.put("To", entry.getKey());
            String to = smsUtil.getMsgTo();
            //params.put("To",smsUtil.getMsgTo()); 
            //params.put("To","(201) 993-0724");
            params.put("Body","hi Mr.anand use this 8 digit pin-number (7975-8096) to send reply.. --for example:Type<7975-8096>space<your message>");
            System.out.println(smsUtil.getMsgBody());
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

		/*@Override
    public void run()
    {
    	try
    	{
    		sendSms();
     	}
    	catch (Exception e) {
			e.printStackTrace();
		}
    }*/
}
