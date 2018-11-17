/*
 * Copyright (C) 2004 Joe Walnes.
 * Copyright (C) 2006, 2007, 2014, 2015 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 * 
 * Created on 04. October 2004 by Joe Walnes
 */
package com.thoughtworks.xstream.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.apache.commons.collections4.map.HashedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.apache.commons.collections4.list.TreeList;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import com.thoughtworks.xstream.converters.DataHolder;


public class MapBackedDataHolder implements DataHolder {
    private final Map<Object, Object> map;

    public MapBackedDataHolder() {
        this(new UnifiedMap<>());
    }

    public MapBackedDataHolder(final Map<Object, Object> map) {
        this.map = map;
    }

    @Override
    public Object get(final Object key) {
        return map.get(key);
    }

    @Override
    public void put(final Object key, final Object value) {
        map.put(key, value);
    }

    @Override
    public Iterator<Object> keys() {
        return Collections.unmodifiableCollection(map.keySet()).iterator();
    }
}
