
package com.mycove.util.email;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletException;


import  com.way2sms.SMS;


public class SMSAlert 
{
	public void sendSMS(String to, String msg) throws ServletException
	{
		Properties props = new Properties();
   	 	InputStream inputStreamAppRes = null;
   	 	
		try 
		{
			inputStreamAppRes = this.getClass().getClassLoader().getResourceAsStream("mailConfig.properties");
			props.load(inputStreamAppRes);
			String userId = props.getProperty("mycove.sms.alert.UserId");
			String passWord = props.getProperty("mycove.sms.alert.Password");			
			
			SMS objSMS = new SMS();
			
			String proxy = props.getProperty("mycove.sms.proxy");
			objSMS.send(userId, passWord, to, msg,proxy);

		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			//if(e.toString().indexOf("Connection reset")!= -1 || e.toString().indexOf("Connection timed out") != -1)
            //{				
                throw new ServletException("SMS is not sent due to connection failure");
            //}
			//throw new ServletException("SMS is not sent due to connection failure.");
		}
	}
	
	public static void main(String[] args) 
	{
		try 
		{
			new SMSAlert().sendSMS("9994031031", "Test SMS");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println("ErrorMessage:"+e.getMessage());
		}
	}
}


