/**
 * 
 */
package com.mycove.vo;

/**
 * @author Karthikeyan
 *
 */
public class Filter {

	private String fieldName;
	private Object value;
	/**
	 * @param userId
	 * @param userName
	 */
	public Filter(String fieldName, Object value) {
		this.fieldName = fieldName;
		this.value = value;
	}
	/**
	 * @return the fieldName
	 */
	public String getFieldName() {
		return fieldName;
	}
	/**
	 * @param fieldName the fieldName to set
	 */
	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}
	/**
	 * @return the fieldValue
	 */
	public Object getValue() {
		return value;
	}
	/**
	 * @param fieldValue the fieldValue to set
	 */
	public void setValue(Object value) {
		this.value = value;
	}
	
	
}
