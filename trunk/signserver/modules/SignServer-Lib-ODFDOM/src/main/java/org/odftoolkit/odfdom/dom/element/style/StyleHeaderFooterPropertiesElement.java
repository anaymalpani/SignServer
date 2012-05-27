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
import org.odftoolkit.odfdom.dom.element.OdfStylePropertiesBase;
import org.odftoolkit.odfdom.dom.style.props.OdfStyleProperty;
import org.odftoolkit.odfdom.dom.style.props.OdfStylePropertiesSet;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMinHeightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoMarginAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBorderRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBorderLineWidthAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBorderLineWidthTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBorderLineWidthBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBorderLineWidthLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleBorderLineWidthRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingTopAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingBottomAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingLeftAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoPaddingRightAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoBackgroundColorAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleShadowAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleDynamicSpacingAttribute;

import org.odftoolkit.odfdom.dom.element.office.OfficeBinaryDataElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element style:header-footer-properties}.
 *
 */
public abstract class StyleHeaderFooterPropertiesElement extends OdfStylePropertiesBase
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "header-footer-properties" );


	/**
	 * Create the instance of <code>StyleHeaderFooterPropertiesElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public StyleHeaderFooterPropertiesElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element style:header-footer-properties}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

    public final static OdfStyleProperty Height = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "height"));
    public final static OdfStyleProperty MinHeight = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "min-height"));
    public final static OdfStyleProperty MarginLeft = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-left"));
    public final static OdfStyleProperty MarginRight = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-right"));
    public final static OdfStyleProperty MarginTop = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-top"));
    public final static OdfStyleProperty MarginBottom = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-bottom"));
    public final static OdfStyleProperty Margin = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin"));
    public final static OdfStyleProperty Border = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border"));
    public final static OdfStyleProperty BorderTop = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-top"));
    public final static OdfStyleProperty BorderBottom = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-bottom"));
    public final static OdfStyleProperty BorderLeft = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-left"));
    public final static OdfStyleProperty BorderRight = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-right"));
    public final static OdfStyleProperty BorderLineWidth = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width"));
    public final static OdfStyleProperty BorderLineWidthTop = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-top"));
    public final static OdfStyleProperty BorderLineWidthBottom = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-bottom"));
    public final static OdfStyleProperty BorderLineWidthLeft = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-left"));
    public final static OdfStyleProperty BorderLineWidthRight = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-right"));
    public final static OdfStyleProperty Padding = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding"));
    public final static OdfStyleProperty PaddingTop = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-top"));
    public final static OdfStyleProperty PaddingBottom = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-bottom"));
    public final static OdfStyleProperty PaddingLeft = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-left"));
    public final static OdfStyleProperty PaddingRight = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-right"));
    public final static OdfStyleProperty BackgroundColor = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "background-color"));
    public final static OdfStyleProperty Shadow = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "shadow"));
    public final static OdfStyleProperty DynamicSpacing = 
        OdfStyleProperty.get(OdfStylePropertiesSet.HeaderFooterProperties, OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "dynamic-spacing"));


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgHeightAttribute</code> , See {@odf.attribute svg:height}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgHeightAttribute()
	{
		SvgHeightAttribute attr = (SvgHeightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "height" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgHeightAttribute</code> , See {@odf.attribute svg:height}
	 *
	 * @param svgHeightValue   The type is <code>String</code>
	 */
	public void setSvgHeightAttribute( String svgHeightValue )
	{
		SvgHeightAttribute attr =  new SvgHeightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgHeightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMinHeightAttribute</code> , See {@odf.attribute fo:min-height}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMinHeightAttribute()
	{
		FoMinHeightAttribute attr = (FoMinHeightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "min-height" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMinHeightAttribute</code> , See {@odf.attribute fo:min-height}
	 *
	 * @param foMinHeightValue   The type is <code>String</code>
	 */
	public void setFoMinHeightAttribute( String foMinHeightValue )
	{
		FoMinHeightAttribute attr =  new FoMinHeightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMinHeightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMarginLeftAttribute</code> , See {@odf.attribute fo:margin-left}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMarginLeftAttribute()
	{
		FoMarginLeftAttribute attr = (FoMarginLeftAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-left" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMarginLeftAttribute</code> , See {@odf.attribute fo:margin-left}
	 *
	 * @param foMarginLeftValue   The type is <code>String</code>
	 */
	public void setFoMarginLeftAttribute( String foMarginLeftValue )
	{
		FoMarginLeftAttribute attr =  new FoMarginLeftAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMarginLeftValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMarginRightAttribute</code> , See {@odf.attribute fo:margin-right}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMarginRightAttribute()
	{
		FoMarginRightAttribute attr = (FoMarginRightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-right" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMarginRightAttribute</code> , See {@odf.attribute fo:margin-right}
	 *
	 * @param foMarginRightValue   The type is <code>String</code>
	 */
	public void setFoMarginRightAttribute( String foMarginRightValue )
	{
		FoMarginRightAttribute attr =  new FoMarginRightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMarginRightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMarginTopAttribute</code> , See {@odf.attribute fo:margin-top}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMarginTopAttribute()
	{
		FoMarginTopAttribute attr = (FoMarginTopAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-top" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMarginTopAttribute</code> , See {@odf.attribute fo:margin-top}
	 *
	 * @param foMarginTopValue   The type is <code>String</code>
	 */
	public void setFoMarginTopAttribute( String foMarginTopValue )
	{
		FoMarginTopAttribute attr =  new FoMarginTopAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMarginTopValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMarginBottomAttribute</code> , See {@odf.attribute fo:margin-bottom}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMarginBottomAttribute()
	{
		FoMarginBottomAttribute attr = (FoMarginBottomAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin-bottom" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMarginBottomAttribute</code> , See {@odf.attribute fo:margin-bottom}
	 *
	 * @param foMarginBottomValue   The type is <code>String</code>
	 */
	public void setFoMarginBottomAttribute( String foMarginBottomValue )
	{
		FoMarginBottomAttribute attr =  new FoMarginBottomAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMarginBottomValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoMarginAttribute</code> , See {@odf.attribute fo:margin}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoMarginAttribute()
	{
		FoMarginAttribute attr = (FoMarginAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "margin" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoMarginAttribute</code> , See {@odf.attribute fo:margin}
	 *
	 * @param foMarginValue   The type is <code>String</code>
	 */
	public void setFoMarginAttribute( String foMarginValue )
	{
		FoMarginAttribute attr =  new FoMarginAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foMarginValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBorderAttribute</code> , See {@odf.attribute fo:border}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBorderAttribute()
	{
		FoBorderAttribute attr = (FoBorderAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBorderAttribute</code> , See {@odf.attribute fo:border}
	 *
	 * @param foBorderValue   The type is <code>String</code>
	 */
	public void setFoBorderAttribute( String foBorderValue )
	{
		FoBorderAttribute attr =  new FoBorderAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBorderValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBorderTopAttribute</code> , See {@odf.attribute fo:border-top}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBorderTopAttribute()
	{
		FoBorderTopAttribute attr = (FoBorderTopAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-top" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBorderTopAttribute</code> , See {@odf.attribute fo:border-top}
	 *
	 * @param foBorderTopValue   The type is <code>String</code>
	 */
	public void setFoBorderTopAttribute( String foBorderTopValue )
	{
		FoBorderTopAttribute attr =  new FoBorderTopAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBorderTopValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBorderBottomAttribute</code> , See {@odf.attribute fo:border-bottom}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBorderBottomAttribute()
	{
		FoBorderBottomAttribute attr = (FoBorderBottomAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-bottom" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBorderBottomAttribute</code> , See {@odf.attribute fo:border-bottom}
	 *
	 * @param foBorderBottomValue   The type is <code>String</code>
	 */
	public void setFoBorderBottomAttribute( String foBorderBottomValue )
	{
		FoBorderBottomAttribute attr =  new FoBorderBottomAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBorderBottomValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBorderLeftAttribute</code> , See {@odf.attribute fo:border-left}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBorderLeftAttribute()
	{
		FoBorderLeftAttribute attr = (FoBorderLeftAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-left" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBorderLeftAttribute</code> , See {@odf.attribute fo:border-left}
	 *
	 * @param foBorderLeftValue   The type is <code>String</code>
	 */
	public void setFoBorderLeftAttribute( String foBorderLeftValue )
	{
		FoBorderLeftAttribute attr =  new FoBorderLeftAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBorderLeftValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBorderRightAttribute</code> , See {@odf.attribute fo:border-right}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBorderRightAttribute()
	{
		FoBorderRightAttribute attr = (FoBorderRightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "border-right" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBorderRightAttribute</code> , See {@odf.attribute fo:border-right}
	 *
	 * @param foBorderRightValue   The type is <code>String</code>
	 */
	public void setFoBorderRightAttribute( String foBorderRightValue )
	{
		FoBorderRightAttribute attr =  new FoBorderRightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBorderRightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBorderLineWidthAttribute</code> , See {@odf.attribute style:border-line-width}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBorderLineWidthAttribute()
	{
		StyleBorderLineWidthAttribute attr = (StyleBorderLineWidthAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBorderLineWidthAttribute</code> , See {@odf.attribute style:border-line-width}
	 *
	 * @param styleBorderLineWidthValue   The type is <code>String</code>
	 */
	public void setStyleBorderLineWidthAttribute( String styleBorderLineWidthValue )
	{
		StyleBorderLineWidthAttribute attr =  new StyleBorderLineWidthAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBorderLineWidthValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBorderLineWidthTopAttribute</code> , See {@odf.attribute style:border-line-width-top}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBorderLineWidthTopAttribute()
	{
		StyleBorderLineWidthTopAttribute attr = (StyleBorderLineWidthTopAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-top" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBorderLineWidthTopAttribute</code> , See {@odf.attribute style:border-line-width-top}
	 *
	 * @param styleBorderLineWidthTopValue   The type is <code>String</code>
	 */
	public void setStyleBorderLineWidthTopAttribute( String styleBorderLineWidthTopValue )
	{
		StyleBorderLineWidthTopAttribute attr =  new StyleBorderLineWidthTopAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBorderLineWidthTopValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBorderLineWidthBottomAttribute</code> , See {@odf.attribute style:border-line-width-bottom}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBorderLineWidthBottomAttribute()
	{
		StyleBorderLineWidthBottomAttribute attr = (StyleBorderLineWidthBottomAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-bottom" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBorderLineWidthBottomAttribute</code> , See {@odf.attribute style:border-line-width-bottom}
	 *
	 * @param styleBorderLineWidthBottomValue   The type is <code>String</code>
	 */
	public void setStyleBorderLineWidthBottomAttribute( String styleBorderLineWidthBottomValue )
	{
		StyleBorderLineWidthBottomAttribute attr =  new StyleBorderLineWidthBottomAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBorderLineWidthBottomValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBorderLineWidthLeftAttribute</code> , See {@odf.attribute style:border-line-width-left}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBorderLineWidthLeftAttribute()
	{
		StyleBorderLineWidthLeftAttribute attr = (StyleBorderLineWidthLeftAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-left" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBorderLineWidthLeftAttribute</code> , See {@odf.attribute style:border-line-width-left}
	 *
	 * @param styleBorderLineWidthLeftValue   The type is <code>String</code>
	 */
	public void setStyleBorderLineWidthLeftAttribute( String styleBorderLineWidthLeftValue )
	{
		StyleBorderLineWidthLeftAttribute attr =  new StyleBorderLineWidthLeftAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBorderLineWidthLeftValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleBorderLineWidthRightAttribute</code> , See {@odf.attribute style:border-line-width-right}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleBorderLineWidthRightAttribute()
	{
		StyleBorderLineWidthRightAttribute attr = (StyleBorderLineWidthRightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "border-line-width-right" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleBorderLineWidthRightAttribute</code> , See {@odf.attribute style:border-line-width-right}
	 *
	 * @param styleBorderLineWidthRightValue   The type is <code>String</code>
	 */
	public void setStyleBorderLineWidthRightAttribute( String styleBorderLineWidthRightValue )
	{
		StyleBorderLineWidthRightAttribute attr =  new StyleBorderLineWidthRightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleBorderLineWidthRightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoPaddingAttribute</code> , See {@odf.attribute fo:padding}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoPaddingAttribute()
	{
		FoPaddingAttribute attr = (FoPaddingAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoPaddingAttribute</code> , See {@odf.attribute fo:padding}
	 *
	 * @param foPaddingValue   The type is <code>String</code>
	 */
	public void setFoPaddingAttribute( String foPaddingValue )
	{
		FoPaddingAttribute attr =  new FoPaddingAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foPaddingValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoPaddingTopAttribute</code> , See {@odf.attribute fo:padding-top}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoPaddingTopAttribute()
	{
		FoPaddingTopAttribute attr = (FoPaddingTopAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-top" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoPaddingTopAttribute</code> , See {@odf.attribute fo:padding-top}
	 *
	 * @param foPaddingTopValue   The type is <code>String</code>
	 */
	public void setFoPaddingTopAttribute( String foPaddingTopValue )
	{
		FoPaddingTopAttribute attr =  new FoPaddingTopAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foPaddingTopValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoPaddingBottomAttribute</code> , See {@odf.attribute fo:padding-bottom}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoPaddingBottomAttribute()
	{
		FoPaddingBottomAttribute attr = (FoPaddingBottomAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-bottom" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoPaddingBottomAttribute</code> , See {@odf.attribute fo:padding-bottom}
	 *
	 * @param foPaddingBottomValue   The type is <code>String</code>
	 */
	public void setFoPaddingBottomAttribute( String foPaddingBottomValue )
	{
		FoPaddingBottomAttribute attr =  new FoPaddingBottomAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foPaddingBottomValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoPaddingLeftAttribute</code> , See {@odf.attribute fo:padding-left}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoPaddingLeftAttribute()
	{
		FoPaddingLeftAttribute attr = (FoPaddingLeftAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-left" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoPaddingLeftAttribute</code> , See {@odf.attribute fo:padding-left}
	 *
	 * @param foPaddingLeftValue   The type is <code>String</code>
	 */
	public void setFoPaddingLeftAttribute( String foPaddingLeftValue )
	{
		FoPaddingLeftAttribute attr =  new FoPaddingLeftAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foPaddingLeftValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoPaddingRightAttribute</code> , See {@odf.attribute fo:padding-right}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoPaddingRightAttribute()
	{
		FoPaddingRightAttribute attr = (FoPaddingRightAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "padding-right" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoPaddingRightAttribute</code> , See {@odf.attribute fo:padding-right}
	 *
	 * @param foPaddingRightValue   The type is <code>String</code>
	 */
	public void setFoPaddingRightAttribute( String foPaddingRightValue )
	{
		FoPaddingRightAttribute attr =  new FoPaddingRightAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foPaddingRightValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoBackgroundColorAttribute</code> , See {@odf.attribute fo:background-color}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoBackgroundColorAttribute()
	{
		FoBackgroundColorAttribute attr = (FoBackgroundColorAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "background-color" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoBackgroundColorAttribute</code> , See {@odf.attribute fo:background-color}
	 *
	 * @param foBackgroundColorValue   The type is <code>String</code>
	 */
	public void setFoBackgroundColorAttribute( String foBackgroundColorValue )
	{
		FoBackgroundColorAttribute attr =  new FoBackgroundColorAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foBackgroundColorValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleShadowAttribute</code> , See {@odf.attribute style:shadow}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleShadowAttribute()
	{
		StyleShadowAttribute attr = (StyleShadowAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "shadow" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleShadowAttribute</code> , See {@odf.attribute style:shadow}
	 *
	 * @param styleShadowValue   The type is <code>String</code>
	 */
	public void setStyleShadowAttribute( String styleShadowValue )
	{
		StyleShadowAttribute attr =  new StyleShadowAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleShadowValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleDynamicSpacingAttribute</code> , See {@odf.attribute style:dynamic-spacing}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getStyleDynamicSpacingAttribute()
	{
		StyleDynamicSpacingAttribute attr = (StyleDynamicSpacingAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "dynamic-spacing" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleDynamicSpacingAttribute</code> , See {@odf.attribute style:dynamic-spacing}
	 *
	 * @param styleDynamicSpacingValue   The type is <code>Boolean</code>
	 */
	public void setStyleDynamicSpacingAttribute( Boolean styleDynamicSpacingValue )
	{
		StyleDynamicSpacingAttribute attr =  new StyleDynamicSpacingAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( styleDynamicSpacingValue.booleanValue() );
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
               
}
