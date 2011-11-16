package com.mycove.util.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FormUtil {

	public static String setNullToBlank(String s){
		if ( s == null || s.equals("null") )
			return ("");
		s = replace(s,"\"","&quot;",true);
		return s;
	}
	public static Double setNullToZero(Double s){
		if ( s == null || s.equals("null") )
			return (new Double(0));
		return s;
	}
	public static Long setNullToZero(Long s){
		if ( s == null || s.equals("null") )
			return (new Long(0));
		return s;
	}
	public static String setNullToBlank(int i){
		if ( i < 0 )
			return ("");
		return String.valueOf(i);
	}

	public static String setNullToBlank(float f){
		if ( f < 0 )
			return ("");
		return String.valueOf(f);
	}

	public static String setNullToBlank(double f){
		if ( f < 0 )
			return ("");
		return String.valueOf(f);
	}

	public static String setNullToZero(String s){
		if ( s == null || s.equals("null") )
			return ("0");
		return s;
	}

    public static boolean isNull(String s) {
        if ( (s == null) || (s.length() < 1) )
            return true;
        return false;
    }

	public static boolean isNull(Date d) {
        if ( d == null )
            return true;
        return false;
    }

    public static boolean isNull(String s1, String s2) {
        return isNull(s1, s2, false);
    }

    public static boolean isNull(String s1, String s2, boolean all) {
        if(all) {
            if ( isNull(s1) && isNull(s2) ) return true;
        } else {
            if ( isNull(s1) || isNull(s2) ) return true;
        }
        return false;
    }

    public static boolean isNull(String s1, String s2, String s3) {
        return isNull(s1, s2, s3, false);
    }

    public static boolean isNull(String s1, String s2, String s3, boolean all) {
        if(all) {
            if ( isNull(s1) && isNull(s2) && isNull(s3)) return true;
        } else {
            if ( isNull(s1) || isNull(s2) || isNull(s3)) return true;
        }
        return false;
    }

    public static boolean isNotNull(String s) {
        return !isNull(s);
    }

	public static boolean isNotNull(Date d) {
        return !isNull(d);
    }

    public static boolean isNotNull(String s1, String s2) {
        return !isNull(s1, s2);
    }

    public static boolean isNotNull(String s1, String s2, boolean all) {
        return !isNull(s1, s2, !all);
    }

    public static boolean isNotNull(String s1, String s2, String s3) {
        return !isNull(s1, s2, s3);
    }

    public static boolean isNotNull(String s1, String s2, String s3, boolean all) {
        return !isNull(s1, s2, s3, !all);
    }

    public static String getYear(Date d){
		if ( d != null){
            Calendar _cal = new GregorianCalendar();
            _cal.setTime(d);
			return String.valueOf( _cal.get(Calendar.YEAR) );
		}
		else
			return "";
	}

	public static String getMonth(Date d){
		if ( d != null){
            Calendar _cal = new GregorianCalendar();
            _cal.setTime(d);
            // add zero to front if less than 9
            if(_cal.get(Calendar.MONTH) < 9)
            {
                return "0" + (String.valueOf( _cal.get(Calendar.MONTH) + 1) );
            }
			else
			{
                return String.valueOf( _cal.get(Calendar.MONTH) + 1 );
            }
		}
		else
			return "";
	}

	public static String getDate(Date d){
		if ( d != null){
            Calendar _cal = new GregorianCalendar();
            _cal.setTime(d);
			return String.valueOf( _cal.get(Calendar.DATE) );
		}
		else
			return "";
	}
	
	public static String getPhoneAreaCode(String phoneNumber){
		if ( phoneNumber != null && !phoneNumber.equals("null"))
			return phoneNumber.substring(0,3);
		else
			return null;
	}

	public static String getPhonePrefix(String phoneNumber){
		if ( phoneNumber != null && !phoneNumber.equals("null"))
			return phoneNumber.substring(3,6);
		else
			return null;
	}

	public static String getPhoneSuffix(String phoneNumber){
		if ( phoneNumber != null && !phoneNumber.equals("null"))
			return phoneNumber.substring(6,10);
		else
			return null;
	}
	
	public static String formatPhoneNumber(String phone){
		if (phone != null && !phone.equals("null")){
			StringBuffer formatPhone = new StringBuffer();
			formatPhone.append("(" + getPhoneAreaCode(phone) + ") ");
			formatPhone.append(getPhonePrefix(phone) + "-" );
			formatPhone.append(getPhoneSuffix(phone));
			return formatPhone.toString();
		}
		else
			return "";
	}

	public static String formatPhoneNumber(String phone, String ext){
		if (phone != null && !phone.equals("null")){
			StringBuffer formatPhone = new StringBuffer();
			formatPhone.append("(" + getPhoneAreaCode(phone) + ")");
			formatPhone.append(getPhonePrefix(phone) + "-" );
			formatPhone.append(getPhoneSuffix(phone));
			if (setNullToBlank(ext).length() != 0)
				formatPhone.append(" x " + ext);
			return formatPhone.toString();
		}
		else
			return "";
	}

	public static String formatPhone(String phone)
    {
		if (isNotNull(phone) && !phone.equals("null") && phone.length() == 7)
        {
			StringBuffer formatPhone = new StringBuffer();
			formatPhone.append(phone.substring(0,3) + "-" );
			formatPhone.append(phone.substring(3));
			return formatPhone.toString();
		}
		else
			return "";
	}

	public static String formatZip(String zip){
		if (isNotNull(zip) && !zip.equals("null"))
        {
            if(zip.length() > 5)
            {
                if(zip.indexOf("-") > 0)
                {
                    return zip;
                }
			    StringBuffer formatZipSb = new StringBuffer();
			    formatZipSb.append(zip.substring(0, 5)  + "-" );
			    formatZipSb.append(zip.substring(5));
			    return formatZipSb.toString();
			}
			else
			{
                return zip;
            }
		}
		else
			return "";
	}
	
	public static String replace(String str, String o, String n, boolean all) {
	 	if (str.equals(""))
			return str;
		StringBuffer result = null;
		int oldpos = 0;
		do {
			int pos = str.indexOf(o, oldpos);
			if (pos < 0)
				break;
			if (result == null)
				result = new StringBuffer();
			result.append(str.substring(oldpos, pos));
			result.append(n);
			pos += o.length();
			oldpos = pos;
		} while (all);

		if (oldpos == 0) {
			return str;
		} else {
			result.append(str.substring(oldpos));
			return new String(result);
		}
	}

	public static String removeEscape(String str)
    {
	 	if (isNull(str) || str.equals(""))
			return str;
		String oneApost = "'";
		String escChar = "\\|";
		
		str = str.replaceAll(escChar, oneApost);

		return str;
	}
	
	public static double round(double value, int decimalPlace)
	{
		double power_of_ten = 1;
		while (decimalPlace-- > 0)
			power_of_ten *= 10.0;
		return Math.round(value * power_of_ten) / power_of_ten;
	}

	public static boolean isNotNull(Object obj) {
		if(obj != null)
			return true;
		else
			return false;
	}
	public static boolean isNull(Object obj) {
		if(obj == null)
			return true;
		else
			return false;
	}
	
	public static boolean isNullOrBlank(String str) {
		if(str != null && str.trim().length()>0)
			return false;
		else
			return true;
	}
	public static boolean isNullOrBlank(String[] str) {
		if(str!= null)
			return false;
		else
		return true;
	}
}
