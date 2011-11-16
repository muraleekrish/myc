package com.mycove.util.xml;

/*
 * Created on Jul 4, 2007
 *
 * Copyright (c) 2006 Savant Technologies Pvt Ltd. India. All Rights Reserved.
 *
 * This software is the confidential and proprietary information of Savant Technologies Pvt Ltd. India.
 * You shall not disclose or use this Confidential Information without the express written agreement of Savant Technologies Pvt Ltd. India 
 * 
 */

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;

/**
 * @author Karthikeyan Chellamuthu
 */
public class XMLMarshalHandler {

	public String getXML(Object obj) throws MarshalException,
			ValidationException {
		StringWriter sw = null;
		String result;
		try {
			sw = new StringWriter();

			Marshaller.marshal(obj, sw);
			result = sw.toString();
		} finally {
			try {
				if (sw != null)
					sw.close();
			} catch (IOException IOE) {
			}
		}

		return result;
	}

	public Object getObject(Object obj, String xmlContent) throws Exception {
		if (obj == null) {
			throw new Exception("Object should not be null");
		}
		if (xmlContent == null || xmlContent.trim().length() == 0) {
			throw new Exception("XMLContent should not be null or empty");
		}
		try {
			StringReader reader = new StringReader(xmlContent);
			obj = Unmarshaller.unmarshal(obj.getClass(), reader);
		}

		catch (Exception e) {
			throw e;
		}
		return obj;
	}

	public Object getObject(Object obj, InputStream xmlContent)
			throws Exception {
		if (obj == null) {
			throw new Exception("Object should not be null");
		}
		if (xmlContent == null) {
			throw new Exception("InputStream should not be null");
		}
		byte[] buff = null;
		ByteArrayOutputStream baos = null;
		try {
			int read = 0;
			baos = new ByteArrayOutputStream();
			buff = new byte[1024];
			while ((read = xmlContent.read(buff)) > 0) {
				baos.write(buff, 0, read);
			}

			StringReader reader = new StringReader(baos.toString());
			obj = Unmarshaller.unmarshal(obj.getClass(), reader);
		} finally {
			try {
				if (baos != null)
					baos.close();
			} catch (IOException IOE) {
			}
			try {
				if (xmlContent != null && xmlContent.available() > 0)
					xmlContent.close();
			} catch (IOException IOE) {
			}
		}

		return obj;
	}
}
