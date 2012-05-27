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
import org.odftoolkit.odfdom.dom.attribute.fo.FoColumnCountAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoColumnGapAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element style:columns}.
 *
 */
public abstract class StyleColumnsElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "columns" );


	/**
	 * Create the instance of <code>StyleColumnsElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public StyleColumnsElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element style:columns}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  StyleColumnsElement}
	 *
     * @param foColumnCountAttributeValue  The mandatory attribute {@odf.attribute  fo:column-count}"
     *
	 */
	public void init(int foColumnCountAttributeValue)
	{
		setFoColumnCountAttribute( Integer.valueOf(foColumnCountAttributeValue) );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoColumnCountAttribute</code> , See {@odf.attribute fo:column-count}
	 *
	 * @return - the <code>Integer</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Integer getFoColumnCountAttribute()
	{
		FoColumnCountAttribute attr = (FoColumnCountAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "column-count" ) );
		if( attr != null ){
			return Integer.valueOf( attr.intValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoColumnCountAttribute</code> , See {@odf.attribute fo:column-count}
	 *
	 * @param foColumnCountValue   The type is <code>Integer</code>
	 */
	public void setFoColumnCountAttribute( Integer foColumnCountValue )
	{
		FoColumnCountAttribute attr =  new FoColumnCountAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setIntValue( foColumnCountValue.intValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoColumnGapAttribute</code> , See {@odf.attribute fo:column-gap}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoColumnGapAttribute()
	{
		FoColumnGapAttribute attr = (FoColumnGapAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "column-gap" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoColumnGapAttribute</code> , See {@odf.attribute fo:column-gap}
	 *
	 * @param foColumnGapValue   The type is <code>String</code>
	 */
	public void setFoColumnGapAttribute( String foColumnGapValue )
	{
		FoColumnGapAttribute attr =  new FoColumnGapAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foColumnGapValue );
	}

	/**
	 * Create child element {@odf.element style:column-sep}.
	 *
     * @param styleWidthAttributeValue  the <code>String</code> value of <code>StyleWidthAttribute</code>, see {@odf.attribute  style:width} at specification
	 * @return   return  the element {@odf.element style:column-sep}
	 * DifferentQName 
	 */
    
	public StyleColumnSepElement newStyleColumnSepElement(String styleWidthAttributeValue)
	{
		StyleColumnSepElement  styleColumnSep = ((OdfFileDom)this.ownerDocument).newOdfElement(StyleColumnSepElement.class);
		styleColumnSep.setStyleWidthAttribute( styleWidthAttributeValue );
		this.appendChild( styleColumnSep);
		return  styleColumnSep;      
	}
    
	/**
	 * Create child element {@odf.element style:column}.
	 *
     * @param styleRelWidthAttributeValue  the <code>String</code> value of <code>StyleRelWidthAttribute</code>, see {@odf.attribute  style:rel-width} at specification
	 * @return   return  the element {@odf.element style:column}
	 * DifferentQName 
	 */
    
	public StyleColumnElement newStyleColumnElement(String styleRelWidthAttributeValue)
	{
		StyleColumnElement  styleColumn = ((OdfFileDom)this.ownerDocument).newOdfElement(StyleColumnElement.class);
		styleColumn.setStyleRelWidthAttribute( styleRelWidthAttributeValue );
		this.appendChild( styleColumn);
		return  styleColumn;      
	}
    
}
