/************************************************************************
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER
 *
 * Copyright 2008 Sun Microsystems, Inc. All rights reserved.
 * Copyright 2009 IBM. All rights reserved.
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

package org.odftoolkit.odfdom;

import org.odftoolkit.odfdom.dom.OdfNamespaceNames;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import javax.xml.namespace.NamespaceContext;

/**
 * class keeping some constants for OpenDocument namespaces
 */
public class OdfNamespace implements Comparable, NamespaceContext {

    private static Map<String, String> namesspacesByPrefix;
    private static Map<String, String> namesspacesByUri;

    static {
        namesspacesByPrefix = new HashMap<String, String>();
        namesspacesByUri = new HashMap<String, String>();
        for (OdfNamespaceNames ns : OdfNamespaceNames.values()) {
            namesspacesByPrefix.put(ns.getPrefix(), ns.getNamespaceUri());
            namesspacesByUri.put(ns.getNamespaceUri(), ns.getPrefix());
        }
        //2D:also collect manifest namespace here
    }
    private String mUri;
    private String mPrefix;

    public OdfNamespace(){}
    
    private OdfNamespace(String uri) {
        this(null, uri);
    }

    private OdfNamespace(String prefix, String uri) {
        if (uri != null && uri.length() > 0) {
            mUri = uri;
        }
        if (prefix != null && prefix.length() > 0) {
            mPrefix = prefix;
        }
    }

    /**
    * 
    *@return  return OdfName
    */
    public OdfName getOdfName(String name) {
        int i = name.indexOf(':');
        if (i >= 0) {
            return OdfName.get(this, name.substring(i + 1));
        } else {
            return OdfName.get(this, name);
        }
    }
    private static SortedSet<OdfNamespace> mNamespaces = new TreeSet<OdfNamespace>();

    public static OdfNamespace get(String uri) {
        OdfNamespace newns = new OdfNamespace(uri);
        SortedSet tail = mNamespaces.tailSet(newns);
        if (tail.size() > 0) {
            OdfNamespace result = (OdfNamespace) tail.first();
            if (result.equals(uri)) {
                return result;
            }
        }
        // no namespace found, create a new one        
        mNamespaces.add(newns);
        return newns;
    }

    public static OdfNamespace get( OdfNamespaceNames name ) {
    	return get(name.getPrefix(),name.getNamespaceUri());
    }
    
    public static OdfNamespace get(String prefix, String uri) {
        OdfNamespace newns = new OdfNamespace(prefix, uri);
        SortedSet tail = mNamespaces.tailSet(newns);
        for (Object obj : tail) {
            OdfNamespace result = (OdfNamespace) obj;
            if (tail.first().equals(uri)) {
                if (result.getPrefix().equals(prefix)) {
                    return result;
                } else {
                    // try to find a matching prefix as long as the uri matches
                    continue;
                }
            } else {
                // uri doesn't match any longer. stop searching
                break;
            }
        }
        // no namespace found, create a new one        
        mNamespaces.add(newns);
        return newns;

    }
    
    public boolean hasPrefix() {
        return mPrefix != null;
    }

    public String getPrefix() {
        return mPrefix;
    }

    public String getUri() {
        return mUri;
    }

    @Override
    public boolean equals(Object obj) {
        if (mUri != null) {
            return mUri.equals(obj.toString());
        } else {
            return mUri == obj;
        }
    }

    @Override
    public int hashCode() {
        if (mUri != null) {
            return mUri.hashCode();
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return mUri;
    }

    public static String[] splitQName(String qname) {
        String localpart = qname;
        String prefix = null;
        int colon = qname.indexOf(':');
        if (colon > 0) {
            localpart = qname.substring(colon + 1);
            prefix = qname.substring(0, colon);
        }
        return new String[]{prefix, localpart};
    }

    public static String getPrefixPart(String qname) {
        return splitQName(qname)[0];
    }

    public static String getLocalPart(String qname) {
        return splitQName(qname)[1];
    }

    public int compareTo(Object o) {
        return toString().compareTo(o.toString());
    }
    
    public String getNamespaceURI(String prefix) {
        return namesspacesByPrefix.get(prefix);
    }

    public static String getNamespaceURIByPrefix(String prefix) {
        return namesspacesByPrefix.get(prefix);
    }
    
    public String getPrefix(String namespaceUri) {
        return namesspacesByUri.get(namespaceUri);
    }

    public Iterator getPrefixes(String namespaceuri) {
        return namesspacesByPrefix.keySet().iterator();
    }
}
