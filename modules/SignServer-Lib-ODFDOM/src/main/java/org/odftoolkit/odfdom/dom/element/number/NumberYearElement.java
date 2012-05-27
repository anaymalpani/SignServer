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

package org.odftoolkit.odfdom.dom.element.number;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.number.NumberStyleAttribute;
import org.odftoolkit.odfdom.dom.attribute.number.NumberCalendarAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element number:year}.
 *
 */
public abstract class NumberYearElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.NUMBER), "year" );


	/**
	 * Create the instance of <code>NumberYearElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public NumberYearElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element number:year}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>NumberStyleAttribute</code> , See {@odf.attribute number:style}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getNumberStyleAttribute()
	{
		NumberStyleAttribute attr = (NumberStyleAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.NUMBER), "style" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>NumberStyleAttribute</code> , See {@odf.attribute number:style}
	 *
	 * @param numberStyleValue   The type is <code>String</code>
	 */
	public void setNumberStyleAttribute( String numberStyleValue )
	{
		NumberStyleAttribute attr =  new NumberStyleAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( numberStyleValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>NumberCalendarAttribute</code> , See {@odf.attribute number:calendar}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getNumberCalendarAttribute()
	{
		NumberCalendarAttribute attr = (NumberCalendarAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.NUMBER), "calendar" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>NumberCalendarAttribute</code> , See {@odf.attribute number:calendar}
	 *
	 * @param numberCalendarValue   The type is <code>String</code>
	 */
	public void setNumberCalendarAttribute( String numberCalendarValue )
	{
		NumberCalendarAttribute attr =  new NumberCalendarAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( numberCalendarValue );
	}

}
