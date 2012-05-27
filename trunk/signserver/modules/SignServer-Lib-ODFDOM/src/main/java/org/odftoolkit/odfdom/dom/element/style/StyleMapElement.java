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

package org.odftoolkit.odfdom.dom.element.style;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.style.StyleConditionAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleApplyStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBaseCellAddressAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element style:map}.
 *
 */
public abstract class StyleMapElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "map" );


	/**
	 * Create the instance of <code>StyleMapElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public StyleMapElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element style:map}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  StyleMapElement}
	 *
     * @param styleConditionAttributeValue  The mandatory attribute {@odf.attribute  style:condition}"
     * @param styleApplyStyleNameAttributeValue  The mandatory attribute {@odf.attribute  style:apply-style-name}"
     *
	 */
	public void init(String styleConditionAttributeValue, String styleApplyStyleNameAttributeValue)
	{
		setStyleConditionAttribute( styleConditionAttributeValue );
		setStyleApplyStyleNameAttribute( styleApplyStyleNameAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleConditionAttribute</code> , See {@odf.attribute style:condition}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleConditionAttribute()
	{
		StyleConditionAttribute attr = (StyleConditionAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "condition" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleConditionAttribute</code> , See {@odf.attribute style:condition}
	 *
	 * @param styleConditionValue   The type is <code>String</code>
	 */
	public void setStyleConditionAttribute( String styleConditionValue )
	{
		StyleConditionAttribute attr =  new StyleConditionAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleConditionValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleApplyStyleNameAttribute</code> , See {@odf.attribute style:apply-style-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleApplyStyleNameAttribute()
	{
		StyleApplyStyleNameAttribute attr = (StyleApplyStyleNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "apply-style-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleApplyStyleNameAttribute</code> , See {@odf.attribute style:apply-style-name}
	 *
	 * @param styleApplyStyleNameValue   The type is <code>String</code>
	 */
	public void setStyleApplyStyleNameAttribute( String styleApplyStyleNameValue )
	{
		StyleApplyStyleNameAttribute attr =  new StyleApplyStyleNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleApplyStyleNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBaseCellAddressAttribute</code> , See {@odf.attribute style:base-cell-address}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBaseCellAddressAttribute()
	{
		StyleBaseCellAddressAttribute attr = (StyleBaseCellAddressAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "base-cell-address" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBaseCellAddressAttribute</code> , See {@odf.attribute style:base-cell-address}
	 *
	 * @param styleBaseCellAddressValue   The type is <code>String</code>
	 */
	public void setStyleBaseCellAddressAttribute( String styleBaseCellAddressValue )
	{
		StyleBaseCellAddressAttribute attr =  new StyleBaseCellAddressAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBaseCellAddressValue );
	}

}
