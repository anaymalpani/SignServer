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

package org.odftoolkit.odfdom.dom.element.form;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.OdfElement;
import org.odftoolkit.odfdom.dom.attribute.form.FormNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormControlImplementationAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormIdAttribute;
import org.odftoolkit.odfdom.dom.attribute.xml.XmlIdAttribute;
import org.odftoolkit.odfdom.dom.attribute.xforms.XformsBindAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormDisabledAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormMaxLengthAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormPrintableAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormTabIndexAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormTabStopAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormTitleAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormValueAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormConvertEmptyToNullAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormLinkedCellAttribute;
import org.odftoolkit.odfdom.dom.attribute.form.FormEchoCharAttribute;

import org.odftoolkit.odfdom.dom.element.office.OfficeEventListenersElement;

/**
 * DOM implementation of OpenDocument element  {@odf.element form:password}.
 *
 */
public abstract class FormPasswordElement extends OdfElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "password" );


	/**
	 * Create the instance of <code>FormPasswordElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public FormPasswordElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element form:password}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}

	/**
	 * Initialization of the mandatory attributes of {@link  FormPasswordElement}
	 *
     * @param formIdAttributeValue  The mandatory attribute {@odf.attribute  form:id}"
     * @param xmlIdAttributeValue  The mandatory attribute {@odf.attribute  xml:id}"
     *
	 */
	public void init(String formIdAttributeValue, String xmlIdAttributeValue)
	{
		setFormIdAttribute( formIdAttributeValue );
		setXmlIdAttribute( xmlIdAttributeValue );
	}

	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormNameAttribute</code> , See {@odf.attribute form:name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormNameAttribute()
	{
		FormNameAttribute attr = (FormNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormNameAttribute</code> , See {@odf.attribute form:name}
	 *
	 * @param formNameValue   The type is <code>String</code>
	 */
	public void setFormNameAttribute( String formNameValue )
	{
		FormNameAttribute attr =  new FormNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formNameValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormControlImplementationAttribute</code> , See {@odf.attribute form:control-implementation}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormControlImplementationAttribute()
	{
		FormControlImplementationAttribute attr = (FormControlImplementationAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "control-implementation" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormControlImplementationAttribute</code> , See {@odf.attribute form:control-implementation}
	 *
	 * @param formControlImplementationValue   The type is <code>String</code>
	 */
	public void setFormControlImplementationAttribute( String formControlImplementationValue )
	{
		FormControlImplementationAttribute attr =  new FormControlImplementationAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formControlImplementationValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormIdAttribute</code> , See {@odf.attribute form:id}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormIdAttribute()
	{
		FormIdAttribute attr = (FormIdAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "id" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormIdAttribute</code> , See {@odf.attribute form:id}
	 *
	 * @param formIdValue   The type is <code>String</code>
	 */
	public void setFormIdAttribute( String formIdValue )
	{
		FormIdAttribute attr =  new FormIdAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formIdValue );
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
	 * Receives the value of the ODFDOM attribute representation <code>XformsBindAttribute</code> , See {@odf.attribute xforms:bind}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getXformsBindAttribute()
	{
		XformsBindAttribute attr = (XformsBindAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.XFORMS), "bind" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>XformsBindAttribute</code> , See {@odf.attribute xforms:bind}
	 *
	 * @param xformsBindValue   The type is <code>String</code>
	 */
	public void setXformsBindAttribute( String xformsBindValue )
	{
		XformsBindAttribute attr =  new XformsBindAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( xformsBindValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormDisabledAttribute</code> , See {@odf.attribute form:disabled}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getFormDisabledAttribute()
	{
		FormDisabledAttribute attr = (FormDisabledAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "disabled" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( FormDisabledAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormDisabledAttribute</code> , See {@odf.attribute form:disabled}
	 *
	 * @param formDisabledValue   The type is <code>Boolean</code>
	 */
	public void setFormDisabledAttribute( Boolean formDisabledValue )
	{
		FormDisabledAttribute attr =  new FormDisabledAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( formDisabledValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormMaxLengthAttribute</code> , See {@odf.attribute form:max-length}
	 *
	 * @return - the <code>Integer</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Integer getFormMaxLengthAttribute()
	{
		FormMaxLengthAttribute attr = (FormMaxLengthAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "max-length" ) );
		if( attr != null ){
			return Integer.valueOf( attr.intValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormMaxLengthAttribute</code> , See {@odf.attribute form:max-length}
	 *
	 * @param formMaxLengthValue   The type is <code>Integer</code>
	 */
	public void setFormMaxLengthAttribute( Integer formMaxLengthValue )
	{
		FormMaxLengthAttribute attr =  new FormMaxLengthAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setIntValue( formMaxLengthValue.intValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormPrintableAttribute</code> , See {@odf.attribute form:printable}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getFormPrintableAttribute()
	{
		FormPrintableAttribute attr = (FormPrintableAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "printable" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( FormPrintableAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormPrintableAttribute</code> , See {@odf.attribute form:printable}
	 *
	 * @param formPrintableValue   The type is <code>Boolean</code>
	 */
	public void setFormPrintableAttribute( Boolean formPrintableValue )
	{
		FormPrintableAttribute attr =  new FormPrintableAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( formPrintableValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormTabIndexAttribute</code> , See {@odf.attribute form:tab-index}
	 *
	 * @return - the <code>Integer</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Integer getFormTabIndexAttribute()
	{
		FormTabIndexAttribute attr = (FormTabIndexAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "tab-index" ) );
		if( attr != null ){
			return Integer.valueOf( attr.intValue() );
		}
		return Integer.valueOf( FormTabIndexAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormTabIndexAttribute</code> , See {@odf.attribute form:tab-index}
	 *
	 * @param formTabIndexValue   The type is <code>Integer</code>
	 */
	public void setFormTabIndexAttribute( Integer formTabIndexValue )
	{
		FormTabIndexAttribute attr =  new FormTabIndexAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setIntValue( formTabIndexValue.intValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormTabStopAttribute</code> , See {@odf.attribute form:tab-stop}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getFormTabStopAttribute()
	{
		FormTabStopAttribute attr = (FormTabStopAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "tab-stop" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( FormTabStopAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormTabStopAttribute</code> , See {@odf.attribute form:tab-stop}
	 *
	 * @param formTabStopValue   The type is <code>Boolean</code>
	 */
	public void setFormTabStopAttribute( Boolean formTabStopValue )
	{
		FormTabStopAttribute attr =  new FormTabStopAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( formTabStopValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormTitleAttribute</code> , See {@odf.attribute form:title}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormTitleAttribute()
	{
		FormTitleAttribute attr = (FormTitleAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "title" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormTitleAttribute</code> , See {@odf.attribute form:title}
	 *
	 * @param formTitleValue   The type is <code>String</code>
	 */
	public void setFormTitleAttribute( String formTitleValue )
	{
		FormTitleAttribute attr =  new FormTitleAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formTitleValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormValueAttribute</code> , See {@odf.attribute form:value}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormValueAttribute()
	{
		FormValueAttribute attr = (FormValueAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "value" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormValueAttribute</code> , See {@odf.attribute form:value}
	 *
	 * @param formValueValue   The type is <code>String</code>
	 */
	public void setFormValueAttribute( String formValueValue )
	{
		FormValueAttribute attr =  new FormValueAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formValueValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormConvertEmptyToNullAttribute</code> , See {@odf.attribute form:convert-empty-to-null}
	 *
	 * @return - the <code>Boolean</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public Boolean getFormConvertEmptyToNullAttribute()
	{
		FormConvertEmptyToNullAttribute attr = (FormConvertEmptyToNullAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "convert-empty-to-null" ) );
		if( attr != null ){
			return Boolean.valueOf( attr.booleanValue() );
		}
		return Boolean.valueOf( FormConvertEmptyToNullAttribute.DEFAULT_VALUE );
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormConvertEmptyToNullAttribute</code> , See {@odf.attribute form:convert-empty-to-null}
	 *
	 * @param formConvertEmptyToNullValue   The type is <code>Boolean</code>
	 */
	public void setFormConvertEmptyToNullAttribute( Boolean formConvertEmptyToNullValue )
	{
		FormConvertEmptyToNullAttribute attr =  new FormConvertEmptyToNullAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setBooleanValue( formConvertEmptyToNullValue.booleanValue() );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormLinkedCellAttribute</code> , See {@odf.attribute form:linked-cell}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormLinkedCellAttribute()
	{
		FormLinkedCellAttribute attr = (FormLinkedCellAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "linked-cell" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormLinkedCellAttribute</code> , See {@odf.attribute form:linked-cell}
	 *
	 * @param formLinkedCellValue   The type is <code>String</code>
	 */
	public void setFormLinkedCellAttribute( String formLinkedCellValue )
	{
		FormLinkedCellAttribute attr =  new FormLinkedCellAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formLinkedCellValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>FormEchoCharAttribute</code> , See {@odf.attribute form:echo-char}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getFormEchoCharAttribute()
	{
		FormEchoCharAttribute attr = (FormEchoCharAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.FORM), "echo-char" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return FormEchoCharAttribute.DEFAULT_VALUE;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>FormEchoCharAttribute</code> , See {@odf.attribute form:echo-char}
	 *
	 * @param formEchoCharValue   The type is <code>String</code>
	 */
	public void setFormEchoCharAttribute( String formEchoCharValue )
	{
		FormEchoCharAttribute attr =  new FormEchoCharAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( formEchoCharValue );
	}

	/**
	 * Create child element {@odf.element form:properties}.
	 *
	 * @return   return  the element {@odf.element form:properties}
	 * DifferentQName 
	 */
	public FormPropertiesElement newFormPropertiesElement()
	{
		FormPropertiesElement  formProperties = ((OdfFileDom)this.ownerDocument).newOdfElement(FormPropertiesElement.class);
		this.appendChild( formProperties);
		return  formProperties;
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
