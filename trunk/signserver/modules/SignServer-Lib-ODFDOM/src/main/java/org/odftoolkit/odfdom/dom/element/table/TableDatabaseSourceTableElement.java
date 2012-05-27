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
import org.odftoolkit.odfdom.dom.attribute.table.TableDatabaseNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.table.TableDatabaseTableNameAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element table:database-source-table}.
 *
 */
public abstract class TableDatabaseSourceTableElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "database-source-table" );


	/**
	 * Create the instance of <code>TableDatabaseSourceTableElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TableDatabaseSourceTableElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element table:database-source-table}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  TableDatabaseSourceTableElement}
	 *
     * @param tableDatabaseNameAttributeValue  The mandatory attribute {@odf.attribute  table:database-name}"
     * @param tableDatabaseTableNameAttributeValue  The mandatory attribute {@odf.attribute  table:database-table-name}"
     *
	 */
	public void init(String tableDatabaseNameAttributeValue, String tableDatabaseTableNameAttributeValue)
	{
		setTableDatabaseNameAttribute( tableDatabaseNameAttributeValue );
		setTableDatabaseTableNameAttribute( tableDatabaseTableNameAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>TableDatabaseNameAttribute</code> , See {@odf.attribute table:database-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTableDatabaseNameAttribute()
	{
		TableDatabaseNameAttribute attr = (TableDatabaseNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "database-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TableDatabaseNameAttribute</code> , See {@odf.attribute table:database-name}
	 *
	 * @param tableDatabaseNameValue   The type is <code>String</code>
	 */
	public void setTableDatabaseNameAttribute( String tableDatabaseNameValue )
	{
		TableDatabaseNameAttribute attr =  new TableDatabaseNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( tableDatabaseNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TableDatabaseTableNameAttribute</code> , See {@odf.attribute table:database-table-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTableDatabaseTableNameAttribute()
	{
		TableDatabaseTableNameAttribute attr = (TableDatabaseTableNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TABLE), "database-table-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TableDatabaseTableNameAttribute</code> , See {@odf.attribute table:database-table-name}
	 *
	 * @param tableDatabaseTableNameValue   The type is <code>String</code>
	 */
	public void setTableDatabaseTableNameAttribute( String tableDatabaseTableNameValue )
	{
		TableDatabaseTableNameAttribute attr =  new TableDatabaseTableNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( tableDatabaseTableNameValue );
	}

}
