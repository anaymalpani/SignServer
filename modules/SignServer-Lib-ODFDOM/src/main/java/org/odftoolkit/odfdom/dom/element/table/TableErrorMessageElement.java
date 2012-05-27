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

package org.odftoolkit.odfdom.dom.element.table;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.table.TableTitleAttribute;
import org.odftoolkit.odfdom.dom.attribute.table.TableDisplayAttribute;
import org.odftoolkit.odfdom.dom.attribute.table.TableMessageTypeAttribute;

import org.odftoolkit.odfdom.dom.element.text.TextPElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element table:error-message}.
 *
 */
public abstract class TableErrorMessageElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "error-message" );

	public static final String  DEFAULT_VALUE_TABLE_DISPLAY_ATTRIBUTE = TableDisplayAttribute.DEFAULT_VALUE_FALSE;

	/**
	 * Create the instance of <code>TableErrorMessageElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TableErrorMessageElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element table:error-message}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>TableTitleAttribute</code> , See {@odf.attribute table:title}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTableTitleAttribute()
	{
		TableTitleAttribute attr = (TableTitleAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "title" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TableTitleAttribute</code> , See {@odf.attribute table:title}
	 *
	 * @param tableTitleValue   The type is <code>String</code>
	 */
	public void setTableTitleAttribute( String tableTitleValue )
	{
		TableTitleAttribute attr =  new TableTitleAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( tableTitleValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TableDisplayAttribute</code> , See {@odf.attribute table:display}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getTableDisplayAttribute()
	{
		TableDisplayAttribute attr = (TableDisplayAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "display" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( DEFAULT_VALUE_TABLE_DISPLAY_ATTRIBUTE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TableDisplayAttribute</code> , See {@odf.attribute table:display}
	 *
	 * @param tableDisplayValue   The type is <code>Boolean</code>
	 */
	public void setTableDisplayAttribute( Boolean tableDisplayValue )
	{
		TableDisplayAttribute attr =  new TableDisplayAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( tableDisplayValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TableMessageTypeAttribute</code> , See {@odf.attribute table:message-type}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTableMessageTypeAttribute()
	{
		TableMessageTypeAttribute attr = (TableMessageTypeAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "message-type" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return TableMessageTypeAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TableMessageTypeAttribute</code> , See {@odf.attribute table:message-type}
	 *
	 * @param tableMessageTypeValue   The type is <code>String</code>
	 */
	public void setTableMessageTypeAttribute( String tableMessageTypeValue )
	{
		TableMessageTypeAttribute attr =  new TableMessageTypeAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( tableMessageTypeValue );
	}

	/**
	 * Create child element {@odf.element text:p}.
	 *
	 * @return   return  the element {@odf.element text:p}
	 * DifferentQName 
	 */
	public TextPElement newTextPElement()
	{
		TextPElement  textP = ((OdfFileDom)this.ownerDocument).newOdfElement(TextPElement.class);
		this.appendChild( textP);
		return  textP;
	}                   
               
}
