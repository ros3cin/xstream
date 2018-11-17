/*
 * Copyright (C) 2008, 2014 XStream Committers.
 * All rights reserved.
 *
 * The software in this package is published under the terms of the BSD
 * style license a copy of which has been included with this distribution in
 * the LICENSE.txt file.
 *
 * Created on 09. October 2008 by Joerg Schaible
 */
package com.thoughtworks.xstream.mapper;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.apache.commons.collections4.map.HashedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.apache.commons.collections4.list.TreeList;
/**
 * Mapper that allows aliasing of system attribute names.
 * 
 * @author J&ouml;rg Schaible
 * @since 1.3.1
 */
public class SystemAttributeAliasingMapper extends AbstractAttributeAliasingMapper {

    public SystemAttributeAliasingMapper(final Mapper wrapped) {
        super(wrapped);
    }

    @Override
    public String aliasForSystemAttribute(final String attribute) {
        String alias = nameToAlias.get(attribute);
        if (alias == null && !nameToAlias.containsKey(attribute)) {
            alias = super.aliasForSystemAttribute(attribute);
            if (alias == attribute) {
                alias = super.aliasForAttribute(attribute);
            }
        }
        return alias;
    }
}
