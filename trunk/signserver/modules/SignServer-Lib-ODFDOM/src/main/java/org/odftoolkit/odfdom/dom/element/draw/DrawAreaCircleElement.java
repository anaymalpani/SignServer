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
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkTypeAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkHrefAttribute;
import org.odftoolkit.odfdom.dom.attribute.office.OfficeTargetFrameNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.xlink.XlinkShowAttribute;
import org.odftoolkit.odfdom.dom.attribute.office.OfficeNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.draw.DrawNohrefAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgCxAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgCyAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgRAttribute;

import org.odftoolkit.odfdom.dom.element.svg.SvgTitleElement;
import org.odftoolkit.odfdom.dom.element.svg.SvgDescElement;
import org.odftoolkit.odfdom.dom.element.office.OfficeEventListenersElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element draw:area-circle}.
 *
 */
public abstract class DrawAreaCircleElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.DRAW), "area-circle" );

	/**
	 * The value set of {@odf.attribute xlink:show}.
	 */
	 public enum XlinkShowAttributeValue {
	 
	 NEW( XlinkShowAttribute.Value.NEW.toString() ), REPLACE( XlinkShowAttribute.Value.REPLACE.toString() );
              
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
	 * Create the instance of <code>DrawAreaCircleElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public DrawAreaCircleElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element draw:area-circle}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  DrawAreaCircleElement}
	 *
     * @param svgCxAttributeValue  The mandatory attribute {@odf.attribute  svg:cx}"
     * @param svgCyAttributeValue  The mandatory attribute {@odf.attribute  svg:cy}"
     * @param svgRAttributeValue  The mandatory attribute {@odf.attribute  svg:r}"
     *
	 */
	public void init(String svgCxAttributeValue, String svgCyAttributeValue, String svgRAttributeValue)
	{
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
	 * Receives the value of the ODFDOM attribute representation <code>OfficeTargetFrameNameAttribute</code> , See {@odf.attribute office:target-frame-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getOfficeTargetFrameNameAttribute()
	{
		OfficeTargetFrameNameAttribute attr = (OfficeTargetFrameNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.OFFICE), "target-frame-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>OfficeTargetFrameNameAttribute</code> , See {@odf.attribute office:target-frame-name}
	 *
	 * @param officeTargetFrameNameValue   The type is <code>String</code>
	 */
	public void setOfficeTargetFrameNameAttribute( String officeTargetFrameNameValue )
	{
		OfficeTargetFrameNameAttribute attr =  new OfficeTargetFrameNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( officeTargetFrameNameValue );
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
		return null;
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
	 * Receives the value of the ODFDOM attribute representation <code>OfficeNameAttribute</code> , See {@odf.attribute office:name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getOfficeNameAttribute()
	{
		OfficeNameAttribute attr = (OfficeNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.OFFICE), "name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>OfficeNameAttribute</code> , See {@odf.attribute office:name}
	 *
	 * @param officeNameValue   The type is <code>String</code>
	 */
	public void setOfficeNameAttribute( String officeNameValue )
	{
		OfficeNameAttribute attr =  new OfficeNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( officeNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>DrawNohrefAttribute</code> , See {@odf.attribute draw:nohref}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getDrawNohrefAttribute()
	{
		DrawNohrefAttribute attr = (DrawNohrefAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.DRAW), "nohref" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>DrawNohrefAttribute</code> , See {@odf.attribute draw:nohref}
	 *
	 * @param drawNohrefValue   The type is <code>String</code>
	 */
	public void setDrawNohrefAttribute( String drawNohrefValue )
	{
		DrawNohrefAttribute attr =  new DrawNohrefAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( drawNohrefValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgCxAttribute</code> , See {@odf.attribute svg:cx}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgCxAttribute()
	{
		SvgCxAttribute attr = (SvgCxAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "cx" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgCxAttribute</code> , See {@odf.attribute svg:cx}
	 *
	 * @param svgCxValue   The type is <code>String</code>
	 */
	public void setSvgCxAttribute( String svgCxValue )
	{
		SvgCxAttribute attr =  new SvgCxAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgCxValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgCyAttribute</code> , See {@odf.attribute svg:cy}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgCyAttribute()
	{
		SvgCyAttribute attr = (SvgCyAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "cy" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgCyAttribute</code> , See {@odf.attribute svg:cy}
	 *
	 * @param svgCyValue   The type is <code>String</code>
	 */
	public void setSvgCyAttribute( String svgCyValue )
	{
		SvgCyAttribute attr =  new SvgCyAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgCyValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgRAttribute</code> , See {@odf.attribute svg:r}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgRAttribute()
	{
		SvgRAttribute attr = (SvgRAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "r" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgRAttribute</code> , See {@odf.attribute svg:r}
	 *
	 * @param svgRValue   The type is <code>String</code>
	 */
	public void setSvgRAttribute( String svgRValue )
	{
		SvgRAttribute attr =  new SvgRAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgRValue );
	}

	/**
	 * Create child element {@odf.element svg:title}.
	 *
	 * @return   return  the element {@odf.element svg:title}
	 * DifferentQName 
	 */
	public SvgTitleElement newSvgTitleElement()
	{
		SvgTitleElement  svgTitle = ((OdfFileDom)this.ownerDocument).newOdfElement(SvgTitleElement.class);
		this.appendChild( svgTitle);
		return  svgTitle;
	}                   
               
	/**
	 * Create child element {@odf.element svg:desc}.
	 *
	 * @return   return  the element {@odf.element svg:desc}
	 * DifferentQName 
	 */
	public SvgDescElement newSvgDescElement()
	{
		SvgDescElement  svgDesc = ((OdfFileDom)this.ownerDocument).newOdfElement(SvgDescElement.class);
		this.appendChild( svgDesc);
		return  svgDesc;
	}                   
               
	/**
	 * Create child element {@odf.element office:event-listeners}.
	 *
	 * @return   return  the element {@odf.element office:event-listeners}
	 * DifferentQName 
	 */
	public OfficeEventListenersElement newOfficeEventListenersElement()
	{
		OfficeEventListenersElement  officeEventListeners = ((OdfFileDom)this.ownerDocument).newOdfElement(OfficeEventListenersElement.class);
		this.appendChild( officeEventListeners);
		return  officeEventListeners;
	}                   
               
}
