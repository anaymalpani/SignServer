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

package org.odftoolkit.odfdom.dom.element.text;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.element.OdfStylableElement;
import org.odftoolkit.odfdom.dom.attribute.text.TextStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextBibliographyDataFieldAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element text:index-entry-bibliography}.
 *
 */
public abstract class TextIndexEntryBibliographyElement extends OdfStylableElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "index-entry-bibliography" );


	/**
	 * Create the instance of <code>TextIndexEntryBibliographyElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TextIndexEntryBibliographyElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME, OdfStyleFamily.Text, OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "style-name" )	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element text:index-entry-bibliography}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  TextIndexEntryBibliographyElement}
	 *
     * @param textBibliographyDataFieldAttributeValue  The mandatory attribute {@odf.attribute  text:bibliography-data-field}"
     *
	 */
	public void init(String textBibliographyDataFieldAttributeValue)
	{
		setTextBibliographyDataFieldAttribute( textBibliographyDataFieldAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextStyleNameAttribute</code> , See {@odf.attribute text:style-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextStyleNameAttribute()
	{
		TextStyleNameAttribute attr = (TextStyleNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "style-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextStyleNameAttribute</code> , See {@odf.attribute text:style-name}
	 *
	 * @param textStyleNameValue   The type is <code>String</code>
	 */
	public void setTextStyleNameAttribute( String textStyleNameValue )
	{
		TextStyleNameAttribute attr =  new TextStyleNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textStyleNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextBibliographyDataFieldAttribute</code> , See {@odf.attribute text:bibliography-data-field}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextBibliographyDataFieldAttribute()
	{
		TextBibliographyDataFieldAttribute attr = (TextBibliographyDataFieldAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "bibliography-data-field" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextBibliographyDataFieldAttribute</code> , See {@odf.attribute text:bibliography-data-field}
	 *
	 * @param textBibliographyDataFieldValue   The type is <code>String</code>
	 */
	public void setTextBibliographyDataFieldAttribute( String textBibliographyDataFieldValue )
	{
		TextBibliographyDataFieldAttribute attr =  new TextBibliographyDataFieldAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textBibliographyDataFieldValue );
	}

}
