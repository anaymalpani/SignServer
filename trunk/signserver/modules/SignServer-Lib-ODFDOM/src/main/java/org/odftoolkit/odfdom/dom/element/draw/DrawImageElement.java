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

package org.odftoolkit.odfdom.dom.element.draw;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawFilterNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.xml.XmlIdAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkTypeAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkHrefAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkShowAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkActuateAttribute;

import org.odftoolkit.odfdom.dom.element.office.OfficeBinaryDataElement;
import org.odftoolkit.odfdom.dom.element.text.TextPElement;
import org.odftoolkit.odfdom.dom.element.text.TextListElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element draw:image}.
 *
 */
public abstract class DrawImageElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.DRAW), "image" );

	/**
	 * The value set of {@odf.attribute xlink:show}.
	 */
	 public enum XlinkShowAttributeValue {
	 
	 EMBED( XlinkShowAttribute.Value.EMBED.toString() );
              
		private String mValue;
	 	
		XlinkShowAttributeValue( String value )
		{
			mValue = value;
		}
		
		@Override
		public String toString()
		{
			return mValue;
		}
		
		public static XlinkShowAttributeValue enumValueOf( String value )
	    {
	        for( XlinkShowAttributeValue aIter : values() )
	        {
	            if( value.equals( aIter.toString() ) )
	            {
	                return aIter;
	            }
	        }
	        return null;
	    }
	}
	/**
	 * The value set of {@odf.attribute xlink:actuate}.
	 */
	 public enum XlinkActuateAttributeValue {
	 
	 ONLOAD( XlinkActuateAttribute.Value.ONLOAD.toString() );
              
		private String mValue;
	 	
		XlinkActuateAttributeValue( String value )
		{
			mValue = value;
		}
		
		@Override
		public String toString()
		{
			return mValue;
		}
		
		public static XlinkActuateAttributeValue enumValueOf( String value )
	    {
	        for( XlinkActuateAttributeValue aIter : values() )
	        {
	            if( value.equals( aIter.toString() ) )
	            {
	                return aIter;
	            }
	        }
	        return null;
	    }
	}
	public static final String  DEFAULT_VALUE_XLINK_SHOW_ATTRIBUTE = XlinkShowAttribute.Value.EMBED.toString();
	public static final String  DEFAULT_VALUE_XLINK_ACTUATE_ATTRIBUTE = XlinkActuateAttribute.Value.ONLOAD.toString();

	/**
	 * Create the instance of <code>DrawImageElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public DrawImageElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element draw:image}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  DrawImageElement}
	 *
     * @param xlinkTypeAttributeValue  The mandatory attribute {@odf.attribute  xlink:type}"
     * @param xlinkHrefAttributeValue  The mandatory attribute {@odf.attribute  xlink:href}"
     *
	 */
	public void init(String xlinkTypeAttributeValue, String xlinkHrefAttributeValue)
	{
		setXlinkTypeAttribute( xlinkTypeAttributeValue );
		setXlinkHrefAttribute( xlinkHrefAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>DrawFilterNameAttribute</code> , See {@odf.attribute draw:filter-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDrawFilterNameAttribute()
	{
		DrawFilterNameAttribute attr = (DrawFilterNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DRAW), "filter-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DrawFilterNameAttribute</code> , See {@odf.attribute draw:filter-name}
	 *
	 * @param drawFilterNameValue   The type is <code>String</code>
	 */
	public void setDrawFilterNameAttribute( String drawFilterNameValue )
	{
		DrawFilterNameAttribute attr =  new DrawFilterNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( drawFilterNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>XmlIdAttribute</code> , See {@odf.attribute xml:id}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXmlIdAttribute()
	{
		XmlIdAttribute attr = (XmlIdAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XML), "id" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XmlIdAttribute</code> , See {@odf.attribute xml:id}
	 *
	 * @param xmlIdValue   The type is <code>String</code>
	 */
	public void setXmlIdAttribute( String xmlIdValue )
	{
		XmlIdAttribute attr =  new XmlIdAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xmlIdValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>XlinkTypeAttribute</code> , See {@odf.attribute xlink:type}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXlinkTypeAttribute()
	{
		XlinkTypeAttribute attr = (XlinkTypeAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XLINK), "type" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return XlinkTypeAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XlinkTypeAttribute</code> , See {@odf.attribute xlink:type}
	 *
	 * @param xlinkTypeValue   The type is <code>String</code>
	 */
	public void setXlinkTypeAttribute( String xlinkTypeValue )
	{
		XlinkTypeAttribute attr =  new XlinkTypeAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xlinkTypeValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>XlinkHrefAttribute</code> , See {@odf.attribute xlink:href}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXlinkHrefAttribute()
	{
		XlinkHrefAttribute attr = (XlinkHrefAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XLINK), "href" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XlinkHrefAttribute</code> , See {@odf.attribute xlink:href}
	 *
	 * @param xlinkHrefValue   The type is <code>String</code>
	 */
	public void setXlinkHrefAttribute( String xlinkHrefValue )
	{
		XlinkHrefAttribute attr =  new XlinkHrefAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xlinkHrefValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>XlinkShowAttribute</code> , See {@odf.attribute xlink:show}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXlinkShowAttribute()
	{
		XlinkShowAttribute attr = (XlinkShowAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XLINK), "show" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return DEFAULT_VALUE_XLINK_SHOW_ATTRIBUTE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XlinkShowAttribute</code> , See {@odf.attribute xlink:show}
	 *
	 * @param xlinkShowValue   The type is <code>String</code>
	 */
	public void setXlinkShowAttribute( String xlinkShowValue )
	{
		XlinkShowAttribute attr =  new XlinkShowAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xlinkShowValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>XlinkActuateAttribute</code> , See {@odf.attribute xlink:actuate}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXlinkActuateAttribute()
	{
		XlinkActuateAttribute attr = (XlinkActuateAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XLINK), "actuate" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return DEFAULT_VALUE_XLINK_ACTUATE_ATTRIBUTE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XlinkActuateAttribute</code> , See {@odf.attribute xlink:actuate}
	 *
	 * @param xlinkActuateValue   The type is <code>String</code>
	 */
	public void setXlinkActuateAttribute( String xlinkActuateValue )
	{
		XlinkActuateAttribute attr =  new XlinkActuateAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xlinkActuateValue );
	}

	/**
	 * Create child element {@odf.element office:binary-data}.
	 *
	 * @return   return  the element {@odf.element office:binary-data}
	 * DifferentQName 
	 */
	public OfficeBinaryDataElement newOfficeBinaryDataElement()
	{
		OfficeBinaryDataElement  officeBinaryData = ((OdfFileDom)this.ownerDocument).newOdfElement(OfficeBinaryDataElement.class);
		this.appendChild( officeBinaryData);
		return  officeBinaryData;
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
               
	/**
	 * Create child element {@odf.element text:list}.
	 *
	 * @return   return  the element {@odf.element text:list}
	 * DifferentQName 
	 */
	public TextListElement newTextListElement()
	{
		TextListElement  textList = ((OdfFileDom)this.ownerDocument).newOdfElement(TextListElement.class);
		this.appendChild( textList);
		return  textList;
	}                   
               
}
