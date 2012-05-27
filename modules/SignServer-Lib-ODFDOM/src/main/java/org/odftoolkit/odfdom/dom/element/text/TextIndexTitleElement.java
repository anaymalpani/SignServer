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
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.element.OdfStylableElement;
import org.odftoolkit.odfdom.dom.attribute.text.TextStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextProtectedAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextProtectionKeyAttribute;
import org.odftoolkit.odfdom.dom.attribute.text.TextProtectionKeyDigestAlgorithmAttribute;
import org.odftoolkit.odfdom.dom.attribute.xml.XmlIdAttribute;

import org.odftoolkit.odfdom.dom.element.table.TableTableElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawRectElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawLineElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawPolylineElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawPolygonElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawRegularPolygonElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawPathElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawCircleElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawEllipseElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawGElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawPageThumbnailElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawFrameElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawMeasureElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawCaptionElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawConnectorElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawControlElement;
import org.odftoolkit.odfdom.dom.element.dr3d.Dr3dSceneElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawCustomShapeElement;
import org.odftoolkit.odfdom.dom.element.draw.DrawAElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element text:index-title}.
 *
 */
public abstract class TextIndexTitleElement extends OdfStylableElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "index-title" );


	/**
	 * Create the instance of <code>TextIndexTitleElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public TextIndexTitleElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME, OdfStyleFamily.Section, OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "style-name" )	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element text:index-title}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  TextIndexTitleElement}
	 *
     * @param textNameAttributeValue  The mandatory attribute {@odf.attribute  text:name}"
     *
	 */
	public void init(String textNameAttributeValue)
	{
		setTextNameAttribute( textNameAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextStyleNameAttribute</code> , See {@odf.attribute text:style-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextStyleNameAttribute()
	{
		TextStyleNameAttribute attr = (TextStyleNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "style-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextStyleNameAttribute</code> , See {@odf.attribute text:style-name}
	 *
	 * @param textStyleNameValue   The type is <code>String</code>
	 */
	public void setTextStyleNameAttribute( String textStyleNameValue )
	{
		TextStyleNameAttribute attr =  new TextStyleNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textStyleNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextNameAttribute</code> , See {@odf.attribute text:name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextNameAttribute()
	{
		TextNameAttribute attr = (TextNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextNameAttribute</code> , See {@odf.attribute text:name}
	 *
	 * @param textNameValue   The type is <code>String</code>
	 */
	public void setTextNameAttribute( String textNameValue )
	{
		TextNameAttribute attr =  new TextNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextProtectedAttribute</code> , See {@odf.attribute text:protected}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getTextProtectedAttribute()
	{
		TextProtectedAttribute attr = (TextProtectedAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "protected" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextProtectedAttribute</code> , See {@odf.attribute text:protected}
	 *
	 * @param textProtectedValue   The type is <code>Boolean</code>
	 */
	public void setTextProtectedAttribute( Boolean textProtectedValue )
	{
		TextProtectedAttribute attr =  new TextProtectedAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( textProtectedValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextProtectionKeyAttribute</code> , See {@odf.attribute text:protection-key}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextProtectionKeyAttribute()
	{
		TextProtectionKeyAttribute attr = (TextProtectionKeyAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "protection-key" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextProtectionKeyAttribute</code> , See {@odf.attribute text:protection-key}
	 *
	 * @param textProtectionKeyValue   The type is <code>String</code>
	 */
	public void setTextProtectionKeyAttribute( String textProtectionKeyValue )
	{
		TextProtectionKeyAttribute attr =  new TextProtectionKeyAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textProtectionKeyValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>TextProtectionKeyDigestAlgorithmAttribute</code> , See {@odf.attribute text:protection-key-digest-algorithm}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getTextProtectionKeyDigestAlgorithmAttribute()
	{
		TextProtectionKeyDigestAlgorithmAttribute attr = (TextProtectionKeyDigestAlgorithmAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.TEXT), "protection-key-digest-algorithm" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return TextProtectionKeyDigestAlgorithmAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>TextProtectionKeyDigestAlgorithmAttribute</code> , See {@odf.attribute text:protection-key-digest-algorithm}
	 *
	 * @param textProtectionKeyDigestAlgorithmValue   The type is <code>String</code>
	 */
	public void setTextProtectionKeyDigestAlgorithmAttribute( String textProtectionKeyDigestAlgorithmValue )
	{
		TextProtectionKeyDigestAlgorithmAttribute attr =  new TextProtectionKeyDigestAlgorithmAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( textProtectionKeyDigestAlgorithmValue );
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
	 * Create child element {@odf.element text:h}.
	 *
     * @param textOutlineLevelAttributeValue  the <code>String</code> value of <code>TextOutlineLevelAttribute</code>, see {@odf.attribute  text:outline-level} at specification
	 * @return   return  the element {@odf.element text:h}
	 * DifferentQName 
	 */
    
	public TextHElement newTextHElement(String textOutlineLevelAttributeValue)
	{
		TextHElement  textH = ((OdfFileDom)this.ownerDocument).newOdfElement(TextHElement.class);
		textH.setTextOutlineLevelAttribute( textOutlineLevelAttributeValue );
		this.appendChild( textH);
		return  textH;      
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
               
	/**
	 * Create child element {@odf.element text:numbered-paragraph}.
	 *
     * @param textListIdAttributeValue  the <code>String</code> value of <code>TextListIdAttribute</code>, see {@odf.attribute  text:list-id} at specification
	 * @return   return  the element {@odf.element text:numbered-paragraph}
	 * DifferentQName 
	 */
    
	public TextNumberedParagraphElement newTextNumberedParagraphElement(String textListIdAttributeValue)
	{
		TextNumberedParagraphElement  textNumberedParagraph = ((OdfFileDom)this.ownerDocument).newOdfElement(TextNumberedParagraphElement.class);
		textNumberedParagraph.setTextListIdAttribute( textListIdAttributeValue );
		this.appendChild( textNumberedParagraph);
		return  textNumberedParagraph;      
	}
    
	/**
	 * Create child element {@odf.element table:table}.
	 *
	 * @return   return  the element {@odf.element table:table}
	 * DifferentQName 
	 */
	public TableTableElement newTableTableElement()
	{
		TableTableElement  tableTable = ((OdfFileDom)this.ownerDocument).newOdfElement(TableTableElement.class);
		this.appendChild( tableTable);
		return  tableTable;
	}                   
               
	/**
	 * Create child element {@odf.element text:section}.
	 *
     * @param textDisplayAttributeValue  the <code>String</code> value of <code>TextDisplayAttribute</code>, see {@odf.attribute  text:display} at specification
	 * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:section}
	 * DifferentQName 
	 */
    
	public TextSectionElement newTextSectionElement(String textDisplayAttributeValue, String textNameAttributeValue)
	{
		TextSectionElement  textSection = ((OdfFileDom)this.ownerDocument).newOdfElement(TextSectionElement.class);
		textSection.setTextDisplayAttribute( textDisplayAttributeValue );
		textSection.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textSection);
		return  textSection;      
	}
    
	/**
	 * Create child element {@odf.element text:section}.
	 *
     * @param textConditionAttributeValue  the <code>String</code> value of <code>TextConditionAttribute</code>, see {@odf.attribute  text:condition} at specification
	 * @param textDisplayAttributeValue  the <code>String</code> value of <code>TextDisplayAttribute</code>, see {@odf.attribute  text:display} at specification
	 * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:section}
	 * DifferentQName 
	 */
    
	public TextSectionElement newTextSectionElement(String textConditionAttributeValue, String textDisplayAttributeValue, String textNameAttributeValue)
	{
		TextSectionElement  textSection = ((OdfFileDom)this.ownerDocument).newOdfElement(TextSectionElement.class);
		textSection.setTextConditionAttribute( textConditionAttributeValue );
		textSection.setTextDisplayAttribute( textDisplayAttributeValue );
		textSection.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textSection);
		return  textSection;      
	}
    
	/**
	 * Create child element {@odf.element text:soft-page-break}.
	 *
	 * @return   return  the element {@odf.element text:soft-page-break}
	 * DifferentQName 
	 */
	public TextSoftPageBreakElement newTextSoftPageBreakElement()
	{
		TextSoftPageBreakElement  textSoftPageBreak = ((OdfFileDom)this.ownerDocument).newOdfElement(TextSoftPageBreakElement.class);
		this.appendChild( textSoftPageBreak);
		return  textSoftPageBreak;
	}                   
               
	/**
	 * Create child element {@odf.element text:table-of-content}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:table-of-content}
	 * DifferentQName 
	 */
    
	public TextTableOfContentElement newTextTableOfContentElement(String textNameAttributeValue)
	{
		TextTableOfContentElement  textTableOfContent = ((OdfFileDom)this.ownerDocument).newOdfElement(TextTableOfContentElement.class);
		textTableOfContent.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textTableOfContent);
		return  textTableOfContent;      
	}
    
	/**
	 * Create child element {@odf.element text:illustration-index}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:illustration-index}
	 * DifferentQName 
	 */
    
	public TextIllustrationIndexElement newTextIllustrationIndexElement(String textNameAttributeValue)
	{
		TextIllustrationIndexElement  textIllustrationIndex = ((OdfFileDom)this.ownerDocument).newOdfElement(TextIllustrationIndexElement.class);
		textIllustrationIndex.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textIllustrationIndex);
		return  textIllustrationIndex;      
	}
    
	/**
	 * Create child element {@odf.element text:table-index}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:table-index}
	 * DifferentQName 
	 */
    
	public TextTableIndexElement newTextTableIndexElement(String textNameAttributeValue)
	{
		TextTableIndexElement  textTableIndex = ((OdfFileDom)this.ownerDocument).newOdfElement(TextTableIndexElement.class);
		textTableIndex.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textTableIndex);
		return  textTableIndex;      
	}
    
	/**
	 * Create child element {@odf.element text:object-index}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:object-index}
	 * DifferentQName 
	 */
    
	public TextObjectIndexElement newTextObjectIndexElement(String textNameAttributeValue)
	{
		TextObjectIndexElement  textObjectIndex = ((OdfFileDom)this.ownerDocument).newOdfElement(TextObjectIndexElement.class);
		textObjectIndex.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textObjectIndex);
		return  textObjectIndex;      
	}
    
	/**
	 * Create child element {@odf.element text:user-index}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:user-index}
	 * DifferentQName 
	 */
    
	public TextUserIndexElement newTextUserIndexElement(String textNameAttributeValue)
	{
		TextUserIndexElement  textUserIndex = ((OdfFileDom)this.ownerDocument).newOdfElement(TextUserIndexElement.class);
		textUserIndex.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textUserIndex);
		return  textUserIndex;      
	}
    
	/**
	 * Create child element {@odf.element text:alphabetical-index}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:alphabetical-index}
	 * DifferentQName 
	 */
    
	public TextAlphabeticalIndexElement newTextAlphabeticalIndexElement(String textNameAttributeValue)
	{
		TextAlphabeticalIndexElement  textAlphabeticalIndex = ((OdfFileDom)this.ownerDocument).newOdfElement(TextAlphabeticalIndexElement.class);
		textAlphabeticalIndex.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textAlphabeticalIndex);
		return  textAlphabeticalIndex;      
	}
    
	/**
	 * Create child element {@odf.element text:bibliography}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:bibliography}
	 * DifferentQName 
	 */
    
	public TextBibliographyElement newTextBibliographyElement(String textNameAttributeValue)
	{
		TextBibliographyElement  textBibliography = ((OdfFileDom)this.ownerDocument).newOdfElement(TextBibliographyElement.class);
		textBibliography.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textBibliography);
		return  textBibliography;      
	}
    
	/**
	 * Create child element {@odf.element draw:rect}.
	 *
	 * @return   return  the element {@odf.element draw:rect}
	 * DifferentQName 
	 */
	public DrawRectElement newDrawRectElement()
	{
		DrawRectElement  drawRect = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawRectElement.class);
		this.appendChild( drawRect);
		return  drawRect;
	}                   
               
	/**
	 * Create child element {@odf.element draw:line}.
	 *
     * @param svgX1AttributeValue  the <code>String</code> value of <code>SvgX1Attribute</code>, see {@odf.attribute  svg:x1} at specification
	 * @param svgX2AttributeValue  the <code>String</code> value of <code>SvgX2Attribute</code>, see {@odf.attribute  svg:x2} at specification
	 * @param svgY1AttributeValue  the <code>String</code> value of <code>SvgY1Attribute</code>, see {@odf.attribute  svg:y1} at specification
	 * @param svgY2AttributeValue  the <code>String</code> value of <code>SvgY2Attribute</code>, see {@odf.attribute  svg:y2} at specification
	 * @return   return  the element {@odf.element draw:line}
	 * DifferentQName 
	 */
    
	public DrawLineElement newDrawLineElement(String svgX1AttributeValue, String svgX2AttributeValue, String svgY1AttributeValue, String svgY2AttributeValue)
	{
		DrawLineElement  drawLine = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawLineElement.class);
		drawLine.setSvgX1Attribute( svgX1AttributeValue );
		drawLine.setSvgX2Attribute( svgX2AttributeValue );
		drawLine.setSvgY1Attribute( svgY1AttributeValue );
		drawLine.setSvgY2Attribute( svgY2AttributeValue );
		this.appendChild( drawLine);
		return  drawLine;      
	}
    
	/**
	 * Create child element {@odf.element draw:polyline}.
	 *
     * @param drawPointsAttributeValue  the <code>String</code> value of <code>DrawPointsAttribute</code>, see {@odf.attribute  draw:points} at specification
	 * @param svgViewBoxAttributeValue  the <code>String</code> value of <code>SvgViewBoxAttribute</code>, see {@odf.attribute  svg:viewBox} at specification
	 * @return   return  the element {@odf.element draw:polyline}
	 * DifferentQName 
	 */
    
	public DrawPolylineElement newDrawPolylineElement(String drawPointsAttributeValue, String svgViewBoxAttributeValue)
	{
		DrawPolylineElement  drawPolyline = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawPolylineElement.class);
		drawPolyline.setDrawPointsAttribute( drawPointsAttributeValue );
		drawPolyline.setSvgViewBoxAttribute( svgViewBoxAttributeValue );
		this.appendChild( drawPolyline);
		return  drawPolyline;      
	}
    
	/**
	 * Create child element {@odf.element draw:polygon}.
	 *
     * @param drawPointsAttributeValue  the <code>String</code> value of <code>DrawPointsAttribute</code>, see {@odf.attribute  draw:points} at specification
	 * @param svgViewBoxAttributeValue  the <code>String</code> value of <code>SvgViewBoxAttribute</code>, see {@odf.attribute  svg:viewBox} at specification
	 * @return   return  the element {@odf.element draw:polygon}
	 * DifferentQName 
	 */
    
	public DrawPolygonElement newDrawPolygonElement(String drawPointsAttributeValue, String svgViewBoxAttributeValue)
	{
		DrawPolygonElement  drawPolygon = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawPolygonElement.class);
		drawPolygon.setDrawPointsAttribute( drawPointsAttributeValue );
		drawPolygon.setSvgViewBoxAttribute( svgViewBoxAttributeValue );
		this.appendChild( drawPolygon);
		return  drawPolygon;      
	}
    
	/**
	 * Create child element {@odf.element draw:regular-polygon}.
	 *
     * @param drawConcaveAttributeValue  the <code>boolean</code> value of <code>DrawConcaveAttribute</code>, see {@odf.attribute  draw:concave} at specification
	 * @param drawCornersAttributeValue  the <code>int</code> value of <code>DrawCornersAttribute</code>, see {@odf.attribute  draw:corners} at specification
	 * @return   return  the element {@odf.element draw:regular-polygon}
	 * DifferentQName 
	 */
    
	public DrawRegularPolygonElement newDrawRegularPolygonElement(boolean drawConcaveAttributeValue, int drawCornersAttributeValue)
	{
		DrawRegularPolygonElement  drawRegularPolygon = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawRegularPolygonElement.class);
		drawRegularPolygon.setDrawConcaveAttribute( Boolean.valueOf(drawConcaveAttributeValue) );
		drawRegularPolygon.setDrawCornersAttribute( Integer.valueOf(drawCornersAttributeValue) );
		this.appendChild( drawRegularPolygon);
		return  drawRegularPolygon;      
	}
    
	/**
	 * Create child element {@odf.element draw:path}.
	 *
     * @param svgDAttributeValue  the <code>String</code> value of <code>SvgDAttribute</code>, see {@odf.attribute  svg:d} at specification
	 * @param svgViewBoxAttributeValue  the <code>String</code> value of <code>SvgViewBoxAttribute</code>, see {@odf.attribute  svg:viewBox} at specification
	 * @return   return  the element {@odf.element draw:path}
	 * DifferentQName 
	 */
    
	public DrawPathElement newDrawPathElement(String svgDAttributeValue, String svgViewBoxAttributeValue)
	{
		DrawPathElement  drawPath = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawPathElement.class);
		drawPath.setSvgDAttribute( svgDAttributeValue );
		drawPath.setSvgViewBoxAttribute( svgViewBoxAttributeValue );
		this.appendChild( drawPath);
		return  drawPath;      
	}
    
	/**
	 * Create child element {@odf.element draw:circle}.
	 *
	 * @return   return  the element {@odf.element draw:circle}
	 * DifferentQName 
	 */
	public DrawCircleElement newDrawCircleElement()
	{
		DrawCircleElement  drawCircle = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawCircleElement.class);
		this.appendChild( drawCircle);
		return  drawCircle;
	}                   
               
	/**
	 * Create child element {@odf.element draw:ellipse}.
	 *
	 * @return   return  the element {@odf.element draw:ellipse}
	 * DifferentQName 
	 */
	public DrawEllipseElement newDrawEllipseElement()
	{
		DrawEllipseElement  drawEllipse = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawEllipseElement.class);
		this.appendChild( drawEllipse);
		return  drawEllipse;
	}                   
               
	/**
	 * Create child element {@odf.element draw:g}.
	 *
	 * @return   return  the element {@odf.element draw:g}
	 * DifferentQName 
	 */
	public DrawGElement newDrawGElement()
	{
		DrawGElement  drawG = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawGElement.class);
		this.appendChild( drawG);
		return  drawG;
	}                   
               
	/**
	 * Create child element {@odf.element draw:page-thumbnail}.
	 *
	 * @return   return  the element {@odf.element draw:page-thumbnail}
	 * DifferentQName 
	 */
	public DrawPageThumbnailElement newDrawPageThumbnailElement()
	{
		DrawPageThumbnailElement  drawPageThumbnail = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawPageThumbnailElement.class);
		this.appendChild( drawPageThumbnail);
		return  drawPageThumbnail;
	}                   
               
	/**
	 * Create child element {@odf.element draw:frame}.
	 *
	 * @return   return  the element {@odf.element draw:frame}
	 * DifferentQName 
	 */
	public DrawFrameElement newDrawFrameElement()
	{
		DrawFrameElement  drawFrame = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawFrameElement.class);
		this.appendChild( drawFrame);
		return  drawFrame;
	}                   
               
	/**
	 * Create child element {@odf.element draw:measure}.
	 *
     * @param svgX1AttributeValue  the <code>String</code> value of <code>SvgX1Attribute</code>, see {@odf.attribute  svg:x1} at specification
	 * @param svgX2AttributeValue  the <code>String</code> value of <code>SvgX2Attribute</code>, see {@odf.attribute  svg:x2} at specification
	 * @param svgY1AttributeValue  the <code>String</code> value of <code>SvgY1Attribute</code>, see {@odf.attribute  svg:y1} at specification
	 * @param svgY2AttributeValue  the <code>String</code> value of <code>SvgY2Attribute</code>, see {@odf.attribute  svg:y2} at specification
	 * @return   return  the element {@odf.element draw:measure}
	 * DifferentQName 
	 */
    
	public DrawMeasureElement newDrawMeasureElement(String svgX1AttributeValue, String svgX2AttributeValue, String svgY1AttributeValue, String svgY2AttributeValue)
	{
		DrawMeasureElement  drawMeasure = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawMeasureElement.class);
		drawMeasure.setSvgX1Attribute( svgX1AttributeValue );
		drawMeasure.setSvgX2Attribute( svgX2AttributeValue );
		drawMeasure.setSvgY1Attribute( svgY1AttributeValue );
		drawMeasure.setSvgY2Attribute( svgY2AttributeValue );
		this.appendChild( drawMeasure);
		return  drawMeasure;      
	}
    
	/**
	 * Create child element {@odf.element draw:caption}.
	 *
	 * @return   return  the element {@odf.element draw:caption}
	 * DifferentQName 
	 */
	public DrawCaptionElement newDrawCaptionElement()
	{
		DrawCaptionElement  drawCaption = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawCaptionElement.class);
		this.appendChild( drawCaption);
		return  drawCaption;
	}                   
               
	/**
	 * Create child element {@odf.element draw:connector}.
	 *
     * @param svgViewBoxAttributeValue  the <code>String</code> value of <code>SvgViewBoxAttribute</code>, see {@odf.attribute  svg:viewBox} at specification
	 * @return   return  the element {@odf.element draw:connector}
	 * DifferentQName 
	 */
    
	public DrawConnectorElement newDrawConnectorElement(String svgViewBoxAttributeValue)
	{
		DrawConnectorElement  drawConnector = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawConnectorElement.class);
		drawConnector.setSvgViewBoxAttribute( svgViewBoxAttributeValue );
		this.appendChild( drawConnector);
		return  drawConnector;      
	}
    
	/**
	 * Create child element {@odf.element draw:control}.
	 *
     * @param drawControlAttributeValue  the <code>String</code> value of <code>DrawControlAttribute</code>, see {@odf.attribute  draw:control} at specification
	 * @return   return  the element {@odf.element draw:control}
	 * DifferentQName 
	 */
    
	public DrawControlElement newDrawControlElement(String drawControlAttributeValue)
	{
		DrawControlElement  drawControl = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawControlElement.class);
		drawControl.setDrawControlAttribute( drawControlAttributeValue );
		this.appendChild( drawControl);
		return  drawControl;      
	}
    
	/**
	 * Create child element {@odf.element dr3d:scene}.
	 *
	 * @return   return  the element {@odf.element dr3d:scene}
	 * DifferentQName 
	 */
	public Dr3dSceneElement newDr3dSceneElement()
	{
		Dr3dSceneElement  dr3dScene = ((OdfFileDom)this.ownerDocument).newOdfElement(Dr3dSceneElement.class);
		this.appendChild( dr3dScene);
		return  dr3dScene;
	}                   
               
	/**
	 * Create child element {@odf.element draw:custom-shape}.
	 *
	 * @return   return  the element {@odf.element draw:custom-shape}
	 * DifferentQName 
	 */
	public DrawCustomShapeElement newDrawCustomShapeElement()
	{
		DrawCustomShapeElement  drawCustomShape = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawCustomShapeElement.class);
		this.appendChild( drawCustomShape);
		return  drawCustomShape;
	}                   
               
	/**
	 * Create child element {@odf.element draw:a}.
	 *
     * @param xlinkHrefAttributeValue  the <code>String</code> value of <code>XlinkHrefAttribute</code>, see {@odf.attribute  xlink:href} at specification
	 * @param xlinkTypeAttributeValue  the <code>String</code> value of <code>XlinkTypeAttribute</code>, see {@odf.attribute  xlink:type} at specification
	 * @return   return  the element {@odf.element draw:a}
	 * DifferentQName 
	 */
    
	public DrawAElement newDrawAElement(String xlinkHrefAttributeValue, String xlinkTypeAttributeValue)
	{
		DrawAElement  drawA = ((OdfFileDom)this.ownerDocument).newOdfElement(DrawAElement.class);
		drawA.setXlinkHrefAttribute( xlinkHrefAttributeValue );
		drawA.setXlinkTypeAttribute( xlinkTypeAttributeValue );
		this.appendChild( drawA);
		return  drawA;      
	}
    
	/**
	 * Create child element {@odf.element text:index-title}.
	 *
     * @param textNameAttributeValue  the <code>String</code> value of <code>TextNameAttribute</code>, see {@odf.attribute  text:name} at specification
	 * @return   return  the element {@odf.element text:index-title}
	 * DifferentQName 
	 */
    
	public TextIndexTitleElement newTextIndexTitleElement(String textNameAttributeValue)
	{
		TextIndexTitleElement  textIndexTitle = ((OdfFileDom)this.ownerDocument).newOdfElement(TextIndexTitleElement.class);
		textIndexTitle.setTextNameAttribute( textNameAttributeValue );
		this.appendChild( textIndexTitle);
		return  textIndexTitle;      
	}
    
}
