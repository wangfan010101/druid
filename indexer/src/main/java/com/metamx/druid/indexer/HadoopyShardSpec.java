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

package com.metamx.druid.indexer;

import com.metamx.druid.shard.ShardSpec;
import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * ShardSpec + a shard ID that is unique across this run. The shard ID is used for grouping and partitioning.
 * There is one HadoopyShardSpec per Bucket, and our shardNum matches the Bucket shardNum.
 */
public class HadoopyShardSpec
{
  private final ShardSpec actualSpec;
  private final int shardNum;

  @JsonCreator
  public HadoopyShardSpec(
      @JsonProperty("actualSpec") ShardSpec actualSpec,
      @JsonProperty("shardNum") int shardNum
  )
  {
    this.actualSpec = actualSpec;
    this.shardNum = shardNum;
  }

  @JsonProperty
  public ShardSpec getActualSpec()
  {
    return actualSpec;
  }

  @JsonProperty
  public int getShardNum()
  {
    return shardNum;
  }

  @Override
  public String toString()
  {
    return "HadoopyShardSpec{" +
           "actualSpec=" + actualSpec +
           ", shardNum=" + shardNum +
           '}';
  }
}
