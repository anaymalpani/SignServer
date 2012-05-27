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
import org.odftoolkit.odfdom.dom.attribute.text.TextPrefixAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextSuffixAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextNumberedEntriesAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextSortByPositionAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoLanguageAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoCountryAttribute;
import org.odftoolkit.odfdom.dom.attribute.fo.FoScriptAttribute;
import org.odftoolkit.odfdom.dom.attribute.style.StyleRfcLanguageTagAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextSortAlgorithmAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element text:bibliography-configuration}.
 *
 */
public abstract class TextBibliographyConfigurationElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "bibliography-configuration" );


	/**
	 * Create the instance of <code>TextBibliographyConfigurationElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TextBibliographyConfigurationElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element text:bibliography-configuration}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextPrefixAttribute</code> , See {@odf.attribute text:prefix}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextPrefixAttribute()
	{
		TextPrefixAttribute attr = (TextPrefixAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "prefix" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextPrefixAttribute</code> , See {@odf.attribute text:prefix}
	 *
	 * @param textPrefixValue   The type is <code>String</code>
	 */
	public void setTextPrefixAttribute( String textPrefixValue )
	{
		TextPrefixAttribute attr =  new TextPrefixAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textPrefixValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextSuffixAttribute</code> , See {@odf.attribute text:suffix}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextSuffixAttribute()
	{
		TextSuffixAttribute attr = (TextSuffixAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "suffix" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextSuffixAttribute</code> , See {@odf.attribute text:suffix}
	 *
	 * @param textSuffixValue   The type is <code>String</code>
	 */
	public void setTextSuffixAttribute( String textSuffixValue )
	{
		TextSuffixAttribute attr =  new TextSuffixAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textSuffixValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextNumberedEntriesAttribute</code> , See {@odf.attribute text:numbered-entries}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getTextNumberedEntriesAttribute()
	{
		TextNumberedEntriesAttribute attr = (TextNumberedEntriesAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "numbered-entries" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( TextNumberedEntriesAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextNumberedEntriesAttribute</code> , See {@odf.attribute text:numbered-entries}
	 *
	 * @param textNumberedEntriesValue   The type is <code>Boolean</code>
	 */
	public void setTextNumberedEntriesAttribute( Boolean textNumberedEntriesValue )
	{
		TextNumberedEntriesAttribute attr =  new TextNumberedEntriesAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( textNumberedEntriesValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextSortByPositionAttribute</code> , See {@odf.attribute text:sort-by-position}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getTextSortByPositionAttribute()
	{
		TextSortByPositionAttribute attr = (TextSortByPositionAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "sort-by-position" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( TextSortByPositionAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextSortByPositionAttribute</code> , See {@odf.attribute text:sort-by-position}
	 *
	 * @param textSortByPositionValue   The type is <code>Boolean</code>
	 */
	public void setTextSortByPositionAttribute( Boolean textSortByPositionValue )
	{
		TextSortByPositionAttribute attr =  new TextSortByPositionAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( textSortByPositionValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoLanguageAttribute</code> , See {@odf.attribute fo:language}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoLanguageAttribute()
	{
		FoLanguageAttribute attr = (FoLanguageAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "language" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoLanguageAttribute</code> , See {@odf.attribute fo:language}
	 *
	 * @param foLanguageValue   The type is <code>String</code>
	 */
	public void setFoLanguageAttribute( String foLanguageValue )
	{
		FoLanguageAttribute attr =  new FoLanguageAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foLanguageValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoCountryAttribute</code> , See {@odf.attribute fo:country}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoCountryAttribute()
	{
		FoCountryAttribute attr = (FoCountryAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "country" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoCountryAttribute</code> , See {@odf.attribute fo:country}
	 *
	 * @param foCountryValue   The type is <code>String</code>
	 */
	public void setFoCountryAttribute( String foCountryValue )
	{
		FoCountryAttribute attr =  new FoCountryAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foCountryValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FoScriptAttribute</code> , See {@odf.attribute fo:script}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFoScriptAttribute()
	{
		FoScriptAttribute attr = (FoScriptAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FO), "script" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FoScriptAttribute</code> , See {@odf.attribute fo:script}
	 *
	 * @param foScriptValue   The type is <code>String</code>
	 */
	public void setFoScriptAttribute( String foScriptValue )
	{
		FoScriptAttribute attr =  new FoScriptAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( foScriptValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>StyleRfcLanguageTagAttribute</code> , See {@odf.attribute style:rfc-language-tag}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getStyleRfcLanguageTagAttribute()
	{
		StyleRfcLanguageTagAttribute attr = (StyleRfcLanguageTagAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.STYLE), "rfc-language-tag" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>StyleRfcLanguageTagAttribute</code> , See {@odf.attribute style:rfc-language-tag}
	 *
	 * @param styleRfcLanguageTagValue   The type is <code>String</code>
	 */
	public void setStyleRfcLanguageTagAttribute( String styleRfcLanguageTagValue )
	{
		StyleRfcLanguageTagAttribute attr =  new StyleRfcLanguageTagAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( styleRfcLanguageTagValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextSortAlgorithmAttribute</code> , See {@odf.attribute text:sort-algorithm}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextSortAlgorithmAttribute()
	{
		TextSortAlgorithmAttribute attr = (TextSortAlgorithmAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "sort-algorithm" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextSortAlgorithmAttribute</code> , See {@odf.attribute text:sort-algorithm}
	 *
	 * @param textSortAlgorithmValue   The type is <code>String</code>
	 */
	public void setTextSortAlgorithmAttribute( String textSortAlgorithmValue )
	{
		TextSortAlgorithmAttribute attr =  new TextSortAlgorithmAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textSortAlgorithmValue );
	}

	/**
	 * Create child element {@odf.element text:sort-key}.
	 *
     * @param textKeyAttributeValue  the <code>String</code> value of <code>TextKeyAttribute</code>, see {@odf.attribute  text:key} at specification
	 * @return   return  the element {@odf.element text:sort-key}
	 * DifferentQName 
	 */
    
	public TextSortKeyElement newTextSortKeyElement(String textKeyAttributeValue)
	{
		TextSortKeyElement  textSortKey = ((OdfFileDom)this.ownerDocument).newOdfElement(TextSortKeyElement.class);
		textSortKey.setTextKeyAttribute( textKeyAttributeValue );
		this.appendChild( textSortKey);
		return  textSortKey;      
	}
    
}
