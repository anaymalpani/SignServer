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

package org.odftoolkit.odfdom.dom.element.chart;

import org.odftoolkit.odfdom.OdfName;
import org.odftoolkit.odfdom.OdfNamespace;
import org.odftoolkit.odfdom.OdfFileDom;
import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import org.odftoolkit.odfdom.dom.style.OdfStyleFamily;
import org.odftoolkit.odfdom.dom.element.OdfStylableElement;
import org.odftoolkit.odfdom.dom.attribute.chart.ChartValuesCellRangeAddressAttribute;
import org.odftoolkit.odfdom.dom.attribute.chart.ChartLabelCellAddressAttribute;
import org.odftoolkit.odfdom.dom.attribute.chart.ChartClassAttribute;
import org.odftoolkit.odfdom.dom.attribute.chart.ChartAttachedAxisAttribute;
import org.odftoolkit.odfdom.dom.attribute.chart.ChartStyleNameAttribute;
import org.odftoolkit.odfdom.dom.attribute.xml.XmlIdAttribute;


/**
 * DOM implementation of OpenDocument element  {@odf.element chart:series}.
 *
 */
public abstract class ChartSeriesElement extends OdfStylableElement
{        
    public static final OdfName ELEMENT_NAME = OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "series" );


	/**
	 * Create the instance of <code>ChartSeriesElement</code> 
	 *
	 * @param  ownerDoc     The type is <code>OdfFileDom</code>
	 */
	public ChartSeriesElement( OdfFileDom ownerDoc )
	{
		super( ownerDoc, ELEMENT_NAME, OdfStyleFamily.Chart, OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "style-name" )	);
	}

	/**
	 * Get the element name 
	 *
	 * @return  return   <code>OdfName</code> the name of element {@odf.element chart:series}.
	 */
	public OdfName getOdfName()
	{
		return ELEMENT_NAME;
	}



	/**
	 * Receives the value of the ODFDOM attribute representation <code>ChartValuesCellRangeAddressAttribute</code> , See {@odf.attribute chart:values-cell-range-address}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getChartValuesCellRangeAddressAttribute()
	{
		ChartValuesCellRangeAddressAttribute attr = (ChartValuesCellRangeAddressAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "values-cell-range-address" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>ChartValuesCellRangeAddressAttribute</code> , See {@odf.attribute chart:values-cell-range-address}
	 *
	 * @param chartValuesCellRangeAddressValue   The type is <code>String</code>
	 */
	public void setChartValuesCellRangeAddressAttribute( String chartValuesCellRangeAddressValue )
	{
		ChartValuesCellRangeAddressAttribute attr =  new ChartValuesCellRangeAddressAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( chartValuesCellRangeAddressValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>ChartLabelCellAddressAttribute</code> , See {@odf.attribute chart:label-cell-address}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getChartLabelCellAddressAttribute()
	{
		ChartLabelCellAddressAttribute attr = (ChartLabelCellAddressAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "label-cell-address" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>ChartLabelCellAddressAttribute</code> , See {@odf.attribute chart:label-cell-address}
	 *
	 * @param chartLabelCellAddressValue   The type is <code>String</code>
	 */
	public void setChartLabelCellAddressAttribute( String chartLabelCellAddressValue )
	{
		ChartLabelCellAddressAttribute attr =  new ChartLabelCellAddressAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( chartLabelCellAddressValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>ChartClassAttribute</code> , See {@odf.attribute chart:class}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getChartClassAttribute()
	{
		ChartClassAttribute attr = (ChartClassAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "class" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>ChartClassAttribute</code> , See {@odf.attribute chart:class}
	 *
	 * @param chartClassValue   The type is <code>String</code>
	 */
	public void setChartClassAttribute( String chartClassValue )
	{
		ChartClassAttribute attr =  new ChartClassAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( chartClassValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>ChartAttachedAxisAttribute</code> , See {@odf.attribute chart:attached-axis}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getChartAttachedAxisAttribute()
	{
		ChartAttachedAxisAttribute attr = (ChartAttachedAxisAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "attached-axis" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>ChartAttachedAxisAttribute</code> , See {@odf.attribute chart:attached-axis}
	 *
	 * @param chartAttachedAxisValue   The type is <code>String</code>
	 */
	public void setChartAttachedAxisAttribute( String chartAttachedAxisValue )
	{
		ChartAttachedAxisAttribute attr =  new ChartAttachedAxisAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( chartAttachedAxisValue );
	}


	/**
	 * Receives the value of the ODFDOM attribute representation <code>ChartStyleNameAttribute</code> , See {@odf.attribute chart:style-name}
	 *
	 * @return - the <code>String</code> , the value or <code>null</code>, if the attribute is not set and no default value defined.
	 */
	public String getChartStyleNameAttribute()
	{
		ChartStyleNameAttribute attr = (ChartStyleNameAttribute) getOdfAttribute( OdfName.get( OdfNamespace.get(OdfNamespaceNames.CHART), "style-name" ) );
		if( attr != null ){
			return String.valueOf( attr.getValue() );
		}
		return null;
	}
		 
	/**
	 * Sets the value of ODFDOM attribute representation <code>ChartStyleNameAttribute</code> , See {@odf.attribute chart:style-name}
	 *
	 * @param chartStyleNameValue   The type is <code>String</code>
	 */
	public void setChartStyleNameAttribute( String chartStyleNameValue )
	{
		ChartStyleNameAttribute attr =  new ChartStyleNameAttribute( (OdfFileDom)this.ownerDocument );
		setOdfAttribute( attr );
		attr.setValue( chartStyleNameValue );
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
	 * Create child element {@odf.element chart:domain}.
	 *
	 * @return   return  the element {@odf.element chart:domain}
	 * DifferentQName 
	 */
	public ChartDomainElement newChartDomainElement()
	{
		ChartDomainElement  chartDomain = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartDomainElement.class);
		this.appendChild( chartDomain);
		return  chartDomain;
	}                   
               
	/**
	 * Create child element {@odf.element chart:mean-value}.
	 *
	 * @return   return  the element {@odf.element chart:mean-value}
	 * DifferentQName 
	 */
	public ChartMeanValueElement newChartMeanValueElement()
	{
		ChartMeanValueElement  chartMeanValue = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartMeanValueElement.class);
		this.appendChild( chartMeanValue);
		return  chartMeanValue;
	}                   
               
	/**
	 * Create child element {@odf.element chart:regression-curve}.
	 *
	 * @return   return  the element {@odf.element chart:regression-curve}
	 * DifferentQName 
	 */
	public ChartRegressionCurveElement newChartRegressionCurveElement()
	{
		ChartRegressionCurveElement  chartRegressionCurve = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartRegressionCurveElement.class);
		this.appendChild( chartRegressionCurve);
		return  chartRegressionCurve;
	}                   
               
	/**
	 * Create child element {@odf.element chart:error-indicator}.
	 *
     * @param chartDimensionAttributeValue  the <code>String</code> value of <code>ChartDimensionAttribute</code>, see {@odf.attribute  chart:dimension} at specification
	 * @return   return  the element {@odf.element chart:error-indicator}
	 * DifferentQName 
	 */
    
	public ChartErrorIndicatorElement newChartErrorIndicatorElement(String chartDimensionAttributeValue)
	{
		ChartErrorIndicatorElement  chartErrorIndicator = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartErrorIndicatorElement.class);
		chartErrorIndicator.setChartDimensionAttribute( chartDimensionAttributeValue );
		this.appendChild( chartErrorIndicator);
		return  chartErrorIndicator;      
	}
    
	/**
	 * Create child element {@odf.element chart:data-point}.
	 *
	 * @return   return  the element {@odf.element chart:data-point}
	 * DifferentQName 
	 */
	public ChartDataPointElement newChartDataPointElement()
	{
		ChartDataPointElement  chartDataPoint = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartDataPointElement.class);
		this.appendChild( chartDataPoint);
		return  chartDataPoint;
	}                   
               
	/**
	 * Create child element {@odf.element chart:data-label}.
	 *
	 * @return   return  the element {@odf.element chart:data-label}
	 * DifferentQName 
	 */
	public ChartDataLabelElement newChartDataLabelElement()
	{
		ChartDataLabelElement  chartDataLabel = ((OdfFileDom)this.ownerDocument).newOdfElement(ChartDataLabelElement.class);
		this.appendChild( chartDataLabel);
		return  chartDataLabel;
	}                   
               
}
