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
import org.odftoolkit.odfdom.dom.attribute.db.DbDataSourceSettingIsListAttribute;
import org.odftoolkit.odfdom.dom.attribute.db.DbDataSourceSettingNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.db.DbDataSourceSettingTypeAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element db:data-source-setting}.
 *
 */
public abstract class DbDataSourceSettingElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "data-source-setting" );


	/**
	 * Create the instance of <code>DbDataSourceSettingElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public DbDataSourceSettingElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element db:data-source-setting}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  DbDataSourceSettingElement}
	 *
     * @param dbDataSourceSettingNameAttributeValue  The mandatory attribute {@odf.attribute  db:data-source-setting-name}"
     * @param dbDataSourceSettingTypeAttributeValue  The mandatory attribute {@odf.attribute  db:data-source-setting-type}"
     *
	 */
	public void init(String dbDataSourceSettingNameAttributeValue, String dbDataSourceSettingTypeAttributeValue)
	{
		setDbDataSourceSettingNameAttribute( dbDataSourceSettingNameAttributeValue );
		setDbDataSourceSettingTypeAttribute( dbDataSourceSettingTypeAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>DbDataSourceSettingIsListAttribute</code> , See {@odf.attribute db:data-source-setting-is-list}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getDbDataSourceSettingIsListAttribute()
	{
		DbDataSourceSettingIsListAttribute attr = (DbDataSourceSettingIsListAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "data-source-setting-is-list" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DbDataSourceSettingIsListAttribute</code> , See {@odf.attribute db:data-source-setting-is-list}
	 *
	 * @param dbDataSourceSettingIsListValue   The type is <code>Boolean</code>
	 */
	public void setDbDataSourceSettingIsListAttribute( Boolean dbDataSourceSettingIsListValue )
	{
		DbDataSourceSettingIsListAttribute attr =  new DbDataSourceSettingIsListAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( dbDataSourceSettingIsListValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>DbDataSourceSettingNameAttribute</code> , See {@odf.attribute db:data-source-setting-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDbDataSourceSettingNameAttribute()
	{
		DbDataSourceSettingNameAttribute attr = (DbDataSourceSettingNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "data-source-setting-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DbDataSourceSettingNameAttribute</code> , See {@odf.attribute db:data-source-setting-name}
	 *
	 * @param dbDataSourceSettingNameValue   The type is <code>String</code>
	 */
	public void setDbDataSourceSettingNameAttribute( String dbDataSourceSettingNameValue )
	{
		DbDataSourceSettingNameAttribute attr =  new DbDataSourceSettingNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( dbDataSourceSettingNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>DbDataSourceSettingTypeAttribute</code> , See {@odf.attribute db:data-source-setting-type}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDbDataSourceSettingTypeAttribute()
	{
		DbDataSourceSettingTypeAttribute attr = (DbDataSourceSettingTypeAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DB), "data-source-setting-type" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DbDataSourceSettingTypeAttribute</code> , See {@odf.attribute db:data-source-setting-type}
	 *
	 * @param dbDataSourceSettingTypeValue   The type is <code>String</code>
	 */
	public void setDbDataSourceSettingTypeAttribute( String dbDataSourceSettingTypeValue )
	{
		DbDataSourceSettingTypeAttribute attr =  new DbDataSourceSettingTypeAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( dbDataSourceSettingTypeValue );
	}

	/**
	 * Create child element {@odf.element db:data-source-setting-value}.
	 *
	 * @return   return  the element {@odf.element db:data-source-setting-value}
	 * DifferentQName 
	 */
	public DbDataSourceSettingValueElement newDbDataSourceSettingValueElement()
	{
		DbDataSourceSettingValueElement  dbDataSourceSettingValue = ((OdfFileDom)this.ownerDocument).newOdfElement(DbDataSourceSettingValueElement.class);
		this.appendChild( dbDataSourceSettingValue);
		return  dbDataSourceSettingValue;
	}                   
               
}
