/*
 * Druid - a distributed column store.
 * Copyright (C) 2012  Metamarkets Group Inc.
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package com.metamx.druid.query.dimension;

import com.metamx.druid.query.extraction.DimExtractionFn;
import org.codehaus.jackson.annotate.JsonSubTypes;
import org.codehaus.jackson.annotate.JsonTypeInfo;

/**
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", defaultImpl = LegacyDimensionSpec.class)
@JsonSubTypes(value = {
    @JsonSubTypes.Type(name = "default", value = DefaultDimensionSpec.class),
    @JsonSubTypes.Type(name = "extraction", value = ExtractionDimensionSpec.class)
})
public interface DimensionSpec
{
  public String getDimension();
  public String getOutputName();
  public DimExtractionFn getDimExtractionFn();
  public byte[] getCacheKey();
}
