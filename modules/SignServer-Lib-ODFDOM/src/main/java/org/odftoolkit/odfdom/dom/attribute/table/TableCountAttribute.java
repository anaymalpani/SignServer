/************************************************************************
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 *
 * Use is subject to license terms.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy
 * of the License at http://www.apache.org/licenses/LICENSE-2.0. You can also
 * obtain a copy of the License at http://odftoolkit.org/docs/license.txt
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ************************************************************************/

/*
 * This file is automatically generated.
 * Don't edit manually.
 */    
package org.odftoolkit.odfdom.dom.attribute.table;

import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfAttribute;
import org.odftoolkit.odfdom.OdfElement;
     
/**
 * DOM implementation of OpenDocument attribute  {@odf.attribute table:count}.
 *
 */
public class TableCountAttribute extends OdfAttribute {

	public static final OdfName ATTRIBUTE_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "count" );
	public static final String DEFAULT_VALUE = "1";

	/**
	 * Create the instance of OpenDocument attribute {@odf.attribute table:count}.
	 * 
	 * @param ownerDocument       The type is <code>OdfFileDom</code>
	 */
	public TableCountAttribute(OdfFileDom ownerDocument) {
		super(ownerDocument, ATTRIBUTE_NAME);
	}
	
	/**
	 * Returns the attribute name.
	 * 
	 * @return the <code>OdfName</code> for {@odf.attribute table:count}.
	 */
	@Override
	public OdfName getOdfName() {
		return ATTRIBUTE_NAME;
	}
	
	/**
	 * @return Returns the name of this attribute.
	 */
	@Override
	public String getName() {
		return ATTRIBUTE_NAME.getLocalName();
	}

	/**
	 * @param value The <code>int</code> value of the attribute.
	 */
	public void setIntValue(int value) {
    	//2DO: need validate value against PositiveInteger 
 		super.setValue(String.valueOf(value));
	}
    
	/**
	 * @return Returns the <code>int</code> value of the attribute
	 */
	public int intValue(){
		String value = super.getValue();
		try {
        	//2DO: need validate value against PositiveInteger
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			// TODO: validation handling/logging
			throw (e);
		}
	}
	/**
	 * @param attrValue The <code>String</code> value of the attribute.
	 * @throws IllegalArgumentException If the provided attribute value is invalid
	 */
	@Override
	public void setValue(String attrValue) {
		try{
			//2DO: need validate value against PositiveInteger
			super.setValue(Integer.toString(Integer.parseInt(attrValue)));	
		}  catch (NullPointerException e) {
			// TODO: validation handling/logging
			throw new IllegalArgumentException(e);
		} catch (IllegalArgumentException e) {
			// TODO: validation handling/logging
			throw (e);
		}
	}
    
	/**
	 * @return Returns the <code>String</code> value of the attribute
	 */
	@Override
	public String getValue(){
		try{
			//2DO: need validate value against PositiveInteger
			return String.valueOf(Integer.parseInt(super.getValue()));		
		} catch (IllegalArgumentException e) {
			// TODO: validation handling/logging
			throw new NumberFormatException("the value of table:count is not valid");
		}
	}
	/**
	 * Returns the default value of {@odf.attribute table:count} dependent of its element name
	 * 
	 * @return the default value as <code>String</code>, 
	 *         return <code>null</code> if the default value does not exist
	 */
	@Override
	public String getDefault() {
		OdfElement parentElement = (OdfElement)getOwnerElement();
		String defaultValue = null;
		if (parentElement != null) {
			defaultValue = DEFAULT_VALUE;			
		}
		return defaultValue;
	}

	/**
	 * Default value indicator. As the attribute default value is dependent from its element, the attribute has only a default, when a parent element exists.
	 * 
	 * @return <code>true</code> if {@odf.attribute table:count} has an element parent 
	 *         otherwise return <code>false</code> as undefined.
	 */
	@Override
	public boolean hasDefault() {
		return getOwnerElement() == null ? false : true;
	}
	
	/**
	 * @return Returns whether this attribute is known to be of type ID (i.e. xml:id ?)
	 */
	@Override
	public boolean isId() {
		return false;
    
	}
}
