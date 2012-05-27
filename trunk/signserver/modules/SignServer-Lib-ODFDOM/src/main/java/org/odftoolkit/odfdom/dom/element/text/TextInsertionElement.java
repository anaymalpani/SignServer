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
import org.odftoolkit.odfdom.OdfElement;

import org.odftoolkit.odfdom.dom.element.office.OfficeChangeInfoElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element text:insertion}.
 *
 */
public abstract class TextInsertionElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "insertion" );


	/**
	 * Create the instance of <code>TextInsertionElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TextInsertionElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element text:insertion}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}


	/**
	 * Create child element {@odf.element office:change-info}.
	 *
	 * @return   return  the element {@odf.element office:change-info}
	 * DifferentQName 
	 */
	public OfficeChangeInfoElement newOfficeChangeInfoElement()
	{
		OfficeChangeInfoElement  officeChangeInfo = ((OdfFileDom)this.ownerDocument).newOdfElement(OfficeChangeInfoElement.class);
		this.appendChild( officeChangeInfo);
		return  officeChangeInfo;
	}                   
               
}
