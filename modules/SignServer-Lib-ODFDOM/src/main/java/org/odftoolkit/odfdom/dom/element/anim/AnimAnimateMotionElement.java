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

package org.odftoolkit.odfdom.dom.element.anim;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgPathAttribute;
import org.odftoolkit.odfdom.dom.attribute.svg.SvgOriginAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilCalcModeAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilTargetElementAttribute;
import org.odftoolkit.odfdom.dom.attribute.anim.AnimSubItemAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilAttributeNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilAccumulateAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilAdditiveAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilValuesAttribute;
import org.odftoolkit.odfdom.dom.attribute.anim.AnimFormulaAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilToAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilFromAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilByAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilBeginAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilEndAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilDurAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilRepeatDurAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilRepeatCountAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilRestartAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilRestartDefaultAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilFillAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilFillDefaultAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilAccelerateAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilDecelerateAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilAutoReverseAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilKeyTimesAttribute;
import org.odftoolkit.odfdom.dom.attribute.smil.SmilKeySplinesAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element anim:animateMotion}.
 *
 */
public abstract class AnimAnimateMotionElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.ANIM), "animateMotion" );

	public static final String  DEFAULT_VALUE_SMIL_CALCMODE_ATTRIBUTE = SmilCalcModeAttribute.Value.PACED.toString();

	/**
	 * Create the instance of <code>AnimAnimateMotionElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public AnimAnimateMotionElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element anim:animateMotion}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  AnimAnimateMotionElement}
	 *
     * @param smilAttributeNameAttributeValue  The mandatory attribute {@odf.attribute  smil:attributeName}"
     *
	 */
	public void init(String smilAttributeNameAttributeValue)
	{
		setSmilAttributeNameAttribute( smilAttributeNameAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgPathAttribute</code> , See {@odf.attribute svg:path}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgPathAttribute()
	{
		SvgPathAttribute attr = (SvgPathAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "path" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgPathAttribute</code> , See {@odf.attribute svg:path}
	 *
	 * @param svgPathValue   The type is <code>String</code>
	 */
	public void setSvgPathAttribute( String svgPathValue )
	{
		SvgPathAttribute attr =  new SvgPathAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgPathValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SvgOriginAttribute</code> , See {@odf.attribute svg:origin}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSvgOriginAttribute()
	{
		SvgOriginAttribute attr = (SvgOriginAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SVG), "origin" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SvgOriginAttribute</code> , See {@odf.attribute svg:origin}
	 *
	 * @param svgOriginValue   The type is <code>String</code>
	 */
	public void setSvgOriginAttribute( String svgOriginValue )
	{
		SvgOriginAttribute attr =  new SvgOriginAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( svgOriginValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilCalcModeAttribute</code> , See {@odf.attribute smil:calcMode}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilCalcModeAttribute()
	{
		SmilCalcModeAttribute attr = (SmilCalcModeAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "calcMode" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return DEFAULT_VALUE_SMIL_CALCMODE_ATTRIBUTE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilCalcModeAttribute</code> , See {@odf.attribute smil:calcMode}
	 *
	 * @param smilCalcModeValue   The type is <code>String</code>
	 */
	public void setSmilCalcModeAttribute( String smilCalcModeValue )
	{
		SmilCalcModeAttribute attr =  new SmilCalcModeAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilCalcModeValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilTargetElementAttribute</code> , See {@odf.attribute smil:targetElement}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilTargetElementAttribute()
	{
		SmilTargetElementAttribute attr = (SmilTargetElementAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "targetElement" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilTargetElementAttribute</code> , See {@odf.attribute smil:targetElement}
	 *
	 * @param smilTargetElementValue   The type is <code>String</code>
	 */
	public void setSmilTargetElementAttribute( String smilTargetElementValue )
	{
		SmilTargetElementAttribute attr =  new SmilTargetElementAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilTargetElementValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>AnimSubItemAttribute</code> , See {@odf.attribute anim:sub-item}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getAnimSubItemAttribute()
	{
		AnimSubItemAttribute attr = (AnimSubItemAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.ANIM), "sub-item" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>AnimSubItemAttribute</code> , See {@odf.attribute anim:sub-item}
	 *
	 * @param animSubItemValue   The type is <code>String</code>
	 */
	public void setAnimSubItemAttribute( String animSubItemValue )
	{
		AnimSubItemAttribute attr =  new AnimSubItemAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( animSubItemValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilAttributeNameAttribute</code> , See {@odf.attribute smil:attributeName}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilAttributeNameAttribute()
	{
		SmilAttributeNameAttribute attr = (SmilAttributeNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "attributeName" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilAttributeNameAttribute</code> , See {@odf.attribute smil:attributeName}
	 *
	 * @param smilAttributeNameValue   The type is <code>String</code>
	 */
	public void setSmilAttributeNameAttribute( String smilAttributeNameValue )
	{
		SmilAttributeNameAttribute attr =  new SmilAttributeNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilAttributeNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilAccumulateAttribute</code> , See {@odf.attribute smil:accumulate}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilAccumulateAttribute()
	{
		SmilAccumulateAttribute attr = (SmilAccumulateAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "accumulate" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilAccumulateAttribute</code> , See {@odf.attribute smil:accumulate}
	 *
	 * @param smilAccumulateValue   The type is <code>String</code>
	 */
	public void setSmilAccumulateAttribute( String smilAccumulateValue )
	{
		SmilAccumulateAttribute attr =  new SmilAccumulateAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilAccumulateValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilAdditiveAttribute</code> , See {@odf.attribute smil:additive}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilAdditiveAttribute()
	{
		SmilAdditiveAttribute attr = (SmilAdditiveAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "additive" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilAdditiveAttribute</code> , See {@odf.attribute smil:additive}
	 *
	 * @param smilAdditiveValue   The type is <code>String</code>
	 */
	public void setSmilAdditiveAttribute( String smilAdditiveValue )
	{
		SmilAdditiveAttribute attr =  new SmilAdditiveAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilAdditiveValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilValuesAttribute</code> , See {@odf.attribute smil:values}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilValuesAttribute()
	{
		SmilValuesAttribute attr = (SmilValuesAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "values" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilValuesAttribute</code> , See {@odf.attribute smil:values}
	 *
	 * @param smilValuesValue   The type is <code>String</code>
	 */
	public void setSmilValuesAttribute( String smilValuesValue )
	{
		SmilValuesAttribute attr =  new SmilValuesAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilValuesValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>AnimFormulaAttribute</code> , See {@odf.attribute anim:formula}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getAnimFormulaAttribute()
	{
		AnimFormulaAttribute attr = (AnimFormulaAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.ANIM), "formula" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>AnimFormulaAttribute</code> , See {@odf.attribute anim:formula}
	 *
	 * @param animFormulaValue   The type is <code>String</code>
	 */
	public void setAnimFormulaAttribute( String animFormulaValue )
	{
		AnimFormulaAttribute attr =  new AnimFormulaAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( animFormulaValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilToAttribute</code> , See {@odf.attribute smil:to}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilToAttribute()
	{
		SmilToAttribute attr = (SmilToAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "to" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilToAttribute</code> , See {@odf.attribute smil:to}
	 *
	 * @param smilToValue   The type is <code>String</code>
	 */
	public void setSmilToAttribute( String smilToValue )
	{
		SmilToAttribute attr =  new SmilToAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilToValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilFromAttribute</code> , See {@odf.attribute smil:from}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilFromAttribute()
	{
		SmilFromAttribute attr = (SmilFromAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "from" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilFromAttribute</code> , See {@odf.attribute smil:from}
	 *
	 * @param smilFromValue   The type is <code>String</code>
	 */
	public void setSmilFromAttribute( String smilFromValue )
	{
		SmilFromAttribute attr =  new SmilFromAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilFromValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilByAttribute</code> , See {@odf.attribute smil:by}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilByAttribute()
	{
		SmilByAttribute attr = (SmilByAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "by" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilByAttribute</code> , See {@odf.attribute smil:by}
	 *
	 * @param smilByValue   The type is <code>String</code>
	 */
	public void setSmilByAttribute( String smilByValue )
	{
		SmilByAttribute attr =  new SmilByAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilByValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilBeginAttribute</code> , See {@odf.attribute smil:begin}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilBeginAttribute()
	{
		SmilBeginAttribute attr = (SmilBeginAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "begin" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilBeginAttribute</code> , See {@odf.attribute smil:begin}
	 *
	 * @param smilBeginValue   The type is <code>String</code>
	 */
	public void setSmilBeginAttribute( String smilBeginValue )
	{
		SmilBeginAttribute attr =  new SmilBeginAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilBeginValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilEndAttribute</code> , See {@odf.attribute smil:end}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilEndAttribute()
	{
		SmilEndAttribute attr = (SmilEndAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "end" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilEndAttribute</code> , See {@odf.attribute smil:end}
	 *
	 * @param smilEndValue   The type is <code>String</code>
	 */
	public void setSmilEndAttribute( String smilEndValue )
	{
		SmilEndAttribute attr =  new SmilEndAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilEndValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilDurAttribute</code> , See {@odf.attribute smil:dur}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilDurAttribute()
	{
		SmilDurAttribute attr = (SmilDurAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "dur" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilDurAttribute</code> , See {@odf.attribute smil:dur}
	 *
	 * @param smilDurValue   The type is <code>String</code>
	 */
	public void setSmilDurAttribute( String smilDurValue )
	{
		SmilDurAttribute attr =  new SmilDurAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilDurValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilRepeatDurAttribute</code> , See {@odf.attribute smil:repeatDur}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilRepeatDurAttribute()
	{
		SmilRepeatDurAttribute attr = (SmilRepeatDurAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "repeatDur" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilRepeatDurAttribute</code> , See {@odf.attribute smil:repeatDur}
	 *
	 * @param smilRepeatDurValue   The type is <code>String</code>
	 */
	public void setSmilRepeatDurAttribute( String smilRepeatDurValue )
	{
		SmilRepeatDurAttribute attr =  new SmilRepeatDurAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilRepeatDurValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilRepeatCountAttribute</code> , See {@odf.attribute smil:repeatCount}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilRepeatCountAttribute()
	{
		SmilRepeatCountAttribute attr = (SmilRepeatCountAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "repeatCount" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilRepeatCountAttribute</code> , See {@odf.attribute smil:repeatCount}
	 *
	 * @param smilRepeatCountValue   The type is <code>String</code>
	 */
	public void setSmilRepeatCountAttribute( String smilRepeatCountValue )
	{
		SmilRepeatCountAttribute attr =  new SmilRepeatCountAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilRepeatCountValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilRestartAttribute</code> , See {@odf.attribute smil:restart}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilRestartAttribute()
	{
		SmilRestartAttribute attr = (SmilRestartAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "restart" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return SmilRestartAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilRestartAttribute</code> , See {@odf.attribute smil:restart}
	 *
	 * @param smilRestartValue   The type is <code>String</code>
	 */
	public void setSmilRestartAttribute( String smilRestartValue )
	{
		SmilRestartAttribute attr =  new SmilRestartAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilRestartValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilRestartDefaultAttribute</code> , See {@odf.attribute smil:restartDefault}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilRestartDefaultAttribute()
	{
		SmilRestartDefaultAttribute attr = (SmilRestartDefaultAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "restartDefault" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return SmilRestartDefaultAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilRestartDefaultAttribute</code> , See {@odf.attribute smil:restartDefault}
	 *
	 * @param smilRestartDefaultValue   The type is <code>String</code>
	 */
	public void setSmilRestartDefaultAttribute( String smilRestartDefaultValue )
	{
		SmilRestartDefaultAttribute attr =  new SmilRestartDefaultAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilRestartDefaultValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilFillAttribute</code> , See {@odf.attribute smil:fill}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilFillAttribute()
	{
		SmilFillAttribute attr = (SmilFillAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "fill" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilFillAttribute</code> , See {@odf.attribute smil:fill}
	 *
	 * @param smilFillValue   The type is <code>String</code>
	 */
	public void setSmilFillAttribute( String smilFillValue )
	{
		SmilFillAttribute attr =  new SmilFillAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilFillValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilFillDefaultAttribute</code> , See {@odf.attribute smil:fillDefault}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilFillDefaultAttribute()
	{
		SmilFillDefaultAttribute attr = (SmilFillDefaultAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "fillDefault" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilFillDefaultAttribute</code> , See {@odf.attribute smil:fillDefault}
	 *
	 * @param smilFillDefaultValue   The type is <code>String</code>
	 */
	public void setSmilFillDefaultAttribute( String smilFillDefaultValue )
	{
		SmilFillDefaultAttribute attr =  new SmilFillDefaultAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilFillDefaultValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilAccelerateAttribute</code> , See {@odf.attribute smil:accelerate}
	 *
	 * @return - the <code>Double</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Double getSmilAccelerateAttribute()
	{
		SmilAccelerateAttribute attr = (SmilAccelerateAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "accelerate" ) );
		if( attr != null ){
			return Double.valueOf( attr.doubleValue() );
		}
		return Double.valueOf( SmilAccelerateAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilAccelerateAttribute</code> , See {@odf.attribute smil:accelerate}
	 *
	 * @param smilAccelerateValue   The type is <code>Double</code>
	 */
	public void setSmilAccelerateAttribute( Double smilAccelerateValue )
	{
		SmilAccelerateAttribute attr =  new SmilAccelerateAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setDoubleValue( smilAccelerateValue.doubleValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilDecelerateAttribute</code> , See {@odf.attribute smil:decelerate}
	 *
	 * @return - the <code>Double</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Double getSmilDecelerateAttribute()
	{
		SmilDecelerateAttribute attr = (SmilDecelerateAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "decelerate" ) );
		if( attr != null ){
			return Double.valueOf( attr.doubleValue() );
		}
		return Double.valueOf( SmilDecelerateAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilDecelerateAttribute</code> , See {@odf.attribute smil:decelerate}
	 *
	 * @param smilDecelerateValue   The type is <code>Double</code>
	 */
	public void setSmilDecelerateAttribute( Double smilDecelerateValue )
	{
		SmilDecelerateAttribute attr =  new SmilDecelerateAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setDoubleValue( smilDecelerateValue.doubleValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilAutoReverseAttribute</code> , See {@odf.attribute smil:autoReverse}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getSmilAutoReverseAttribute()
	{
		SmilAutoReverseAttribute attr = (SmilAutoReverseAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "autoReverse" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( SmilAutoReverseAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilAutoReverseAttribute</code> , See {@odf.attribute smil:autoReverse}
	 *
	 * @param smilAutoReverseValue   The type is <code>Boolean</code>
	 */
	public void setSmilAutoReverseAttribute( Boolean smilAutoReverseValue )
	{
		SmilAutoReverseAttribute attr =  new SmilAutoReverseAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( smilAutoReverseValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilKeyTimesAttribute</code> , See {@odf.attribute smil:keyTimes}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilKeyTimesAttribute()
	{
		SmilKeyTimesAttribute attr = (SmilKeyTimesAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "keyTimes" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilKeyTimesAttribute</code> , See {@odf.attribute smil:keyTimes}
	 *
	 * @param smilKeyTimesValue   The type is <code>String</code>
	 */
	public void setSmilKeyTimesAttribute( String smilKeyTimesValue )
	{
		SmilKeyTimesAttribute attr =  new SmilKeyTimesAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilKeyTimesValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>SmilKeySplinesAttribute</code> , See {@odf.attribute smil:keySplines}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getSmilKeySplinesAttribute()
	{
		SmilKeySplinesAttribute attr = (SmilKeySplinesAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.SMIL), "keySplines" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>SmilKeySplinesAttribute</code> , See {@odf.attribute smil:keySplines}
	 *
	 * @param smilKeySplinesValue   The type is <code>String</code>
	 */
	public void setSmilKeySplinesAttribute( String smilKeySplinesValue )
	{
		SmilKeySplinesAttribute attr =  new SmilKeySplinesAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( smilKeySplinesValue );
	}

}
