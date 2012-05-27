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

package org.odftoolkit.odfdom.dom.element.db;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.db.DbAdditionalColumnStatementAttribute;
import org.odftoolkit.odfdom.dom.attribute.db.DbRowRetrievingStatementAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element db:auto-increment}.
 *
 */
public abstract class DbAutoIncrementElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "auto-increment" );


	/**
	 * Create the instance of <code>DbAutoIncrementElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public DbAutoIncrementElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element db:auto-increment}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>DbAdditionalColumnStatementAttribute</code> , See {@odf.attribute db:additional-column-statement}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDbAdditionalColumnStatementAttribute()
	{
		DbAdditionalColumnStatementAttribute attr = (DbAdditionalColumnStatementAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "additional-column-statement" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DbAdditionalColumnStatementAttribute</code> , See {@odf.attribute db:additional-column-statement}
	 *
	 * @param dbAdditionalColumnStatementValue   The type is <code>String</code>
	 */
	public void setDbAdditionalColumnStatementAttribute( String dbAdditionalColumnStatementValue )
	{
		DbAdditionalColumnStatementAttribute attr =  new DbAdditionalColumnStatementAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( dbAdditionalColumnStatementValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>DbRowRetrievingStatementAttribute</code> , See {@odf.attribute db:row-retrieving-statement}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDbRowRetrievingStatementAttribute()
	{
		DbRowRetrievingStatementAttribute attr = (DbRowRetrievingStatementAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "row-retrieving-statement" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DbRowRetrievingStatementAttribute</code> , See {@odf.attribute db:row-retrieving-statement}
	 *
	 * @param dbRowRetrievingStatementValue   The type is <code>String</code>
	 */
	public void setDbRowRetrievingStatementAttribute( String dbRowRetrievingStatementValue )
	{
		DbRowRetrievingStatementAttribute attr =  new DbRowRetrievingStatementAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( dbRowRetrievingStatementValue );
	}

}
