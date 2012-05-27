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
import org.odftoolkit.odfdom.dom.attribute.style.StyleWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleRelWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleLineStyleAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleAdjustmentAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDistanceBeforeSepAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDistanceAfterSepAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element style:footnote-sep}.
 *
 */
public abstract class StyleFootnoteSepElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "footnote-sep" );


	/**
	 * Create the instance of <code>StyleFootnoteSepElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public StyleFootnoteSepElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element style:footnote-sep}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleWidthAttribute</code> , See {@odf.attribute style:width}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleWidthAttribute()
	{
		StyleWidthAttribute attr = (StyleWidthAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "width" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleWidthAttribute</code> , See {@odf.attribute style:width}
	 *
	 * @param styleWidthValue   The type is <code>String</code>
	 */
	public void setStyleWidthAttribute( String styleWidthValue )
	{
		StyleWidthAttribute attr =  new StyleWidthAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleWidthValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleRelWidthAttribute</code> , See {@odf.attribute style:rel-width}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleRelWidthAttribute()
	{
		StyleRelWidthAttribute attr = (StyleRelWidthAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "rel-width" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleRelWidthAttribute</code> , See {@odf.attribute style:rel-width}
	 *
	 * @param styleRelWidthValue   The type is <code>String</code>
	 */
	public void setStyleRelWidthAttribute( String styleRelWidthValue )
	{
		StyleRelWidthAttribute attr =  new StyleRelWidthAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleRelWidthValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleColorAttribute</code> , See {@odf.attribute style:color}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleColorAttribute()
	{
		StyleColorAttribute attr = (StyleColorAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "color" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleColorAttribute</code> , See {@odf.attribute style:color}
	 *
	 * @param styleColorValue   The type is <code>String</code>
	 */
	public void setStyleColorAttribute( String styleColorValue )
	{
		StyleColorAttribute attr =  new StyleColorAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleColorValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleLineStyleAttribute</code> , See {@odf.attribute style:line-style}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleLineStyleAttribute()
	{
		StyleLineStyleAttribute attr = (StyleLineStyleAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "line-style" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleLineStyleAttribute</code> , See {@odf.attribute style:line-style}
	 *
	 * @param styleLineStyleValue   The type is <code>String</code>
	 */
	public void setStyleLineStyleAttribute( String styleLineStyleValue )
	{
		StyleLineStyleAttribute attr =  new StyleLineStyleAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleLineStyleValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleAdjustmentAttribute</code> , See {@odf.attribute style:adjustment}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleAdjustmentAttribute()
	{
		StyleAdjustmentAttribute attr = (StyleAdjustmentAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "adjustment" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return StyleAdjustmentAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleAdjustmentAttribute</code> , See {@odf.attribute style:adjustment}
	 *
	 * @param styleAdjustmentValue   The type is <code>String</code>
	 */
	public void setStyleAdjustmentAttribute( String styleAdjustmentValue )
	{
		StyleAdjustmentAttribute attr =  new StyleAdjustmentAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleAdjustmentValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleDistanceBeforeSepAttribute</code> , See {@odf.attribute style:distance-before-sep}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleDistanceBeforeSepAttribute()
	{
		StyleDistanceBeforeSepAttribute attr = (StyleDistanceBeforeSepAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "distance-before-sep" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleDistanceBeforeSepAttribute</code> , See {@odf.attribute style:distance-before-sep}
	 *
	 * @param styleDistanceBeforeSepValue   The type is <code>String</code>
	 */
	public void setStyleDistanceBeforeSepAttribute( String styleDistanceBeforeSepValue )
	{
		StyleDistanceBeforeSepAttribute attr =  new StyleDistanceBeforeSepAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleDistanceBeforeSepValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleDistanceAfterSepAttribute</code> , See {@odf.attribute style:distance-after-sep}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleDistanceAfterSepAttribute()
	{
		StyleDistanceAfterSepAttribute attr = (StyleDistanceAfterSepAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "distance-after-sep" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleDistanceAfterSepAttribute</code> , See {@odf.attribute style:distance-after-sep}
	 *
	 * @param styleDistanceAfterSepValue   The type is <code>String</code>
	 */
	public void setStyleDistanceAfterSepAttribute( String styleDistanceAfterSepValue )
	{
		StyleDistanceAfterSepAttribute attr =  new StyleDistanceAfterSepAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleDistanceAfterSepValue );
	}

}
