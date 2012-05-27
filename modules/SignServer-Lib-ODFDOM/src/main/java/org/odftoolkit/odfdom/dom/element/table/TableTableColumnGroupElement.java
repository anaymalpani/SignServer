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
import org.odftoolkit.odfdom.dom.attribute.table.TableDisplayAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element table:table-column-group}.
 *
 */
public abstract class TableTableColumnGroupElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "table-column-group" );

	public static final String  DEFAULT_VALUE_TABLE_DISPLAY_ATTRIBUTE = TableDisplayAttribute.DEFAULT_VALUE_TRUE;

	/**
	 * Create the instance of <code>TableTableColumnGroupElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TableTableColumnGroupElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element table:table-column-group}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
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
	 * Create child element {@odf.element table:table-column-group}.
	 *
	 * @return   return  the element {@odf.element table:table-column-group}
	 * DifferentQName 
	 */
	public TableTableColumnGroupElement newTableTableColumnGroupElement()
	{
		TableTableColumnGroupElement  tableTableColumnGroup = ((OdfFileDom)this.ownerDocument).newOdfElement(TableTableColumnGroupElement.class);
		this.appendChild( tableTableColumnGroup);
		return  tableTableColumnGroup;
	}                   
               
	/**
	 * Create child element {@odf.element table:table-columns}.
	 *
	 * @return   return  the element {@odf.element table:table-columns}
	 * DifferentQName 
	 */
	public TableTableColumnsElement newTableTableColumnsElement()
	{
		TableTableColumnsElement  tableTableColumns = ((OdfFileDom)this.ownerDocument).newOdfElement(TableTableColumnsElement.class);
		this.appendChild( tableTableColumns);
		return  tableTableColumns;
	}                   
               
	/**
	 * Create child element {@odf.element table:table-column}.
	 *
	 * @return   return  the element {@odf.element table:table-column}
	 * DifferentQName 
	 */
	public TableTableColumnElement newTableTableColumnElement()
	{
		TableTableColumnElement  tableTableColumn = ((OdfFileDom)this.ownerDocument).newOdfElement(TableTableColumnElement.class);
		this.appendChild( tableTableColumn);
		return  tableTableColumn;
	}                   
               
	/**
	 * Create child element {@odf.element table:table-header-columns}.
	 *
	 * @return   return  the element {@odf.element table:table-header-columns}
	 * DifferentQName 
	 */
	public TableTableHeaderColumnsElement newTableTableHeaderColumnsElement()
	{
		TableTableHeaderColumnsElement  tableTableHeaderColumns = ((OdfFileDom)this.ownerDocument).newOdfElement(TableTableHeaderColumnsElement.class);
		this.appendChild( tableTableHeaderColumns);
		return  tableTableHeaderColumns;
	}                   
               
}
