package com.mycove.sec.action;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.*;

public class LoginForm extends ActionForm
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String action="add";
    private String username=null; 
    private String password=null;
   private String usertype=null;

public void setAction(String action){
    this.action=action;
}

public String getAction(){
   return this.action;
}

public void setUsername(String username){
    this.username=username;
}

public String getUsername(){
    return this.username;
}

public void setPassword(String password){
   this.password=password;
}

public String getPassword(){
   return this.password;
}

public void setUsertype(String usertype){
   this.usertype=usertype;
}

public String getUsertype(){
   return this.usertype;
}

public void reset(ActionMapping mapping,
HttpServletRequest request){

   this.username=null;
   this.password=null;
   this.usertype=null;
   this.action="add";

}

} 
