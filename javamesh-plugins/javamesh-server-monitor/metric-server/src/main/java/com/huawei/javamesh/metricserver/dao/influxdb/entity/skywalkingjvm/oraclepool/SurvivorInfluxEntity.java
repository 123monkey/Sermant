/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2021-2021. All rights reserved.
 */

package com.huawei.javamesh.metricserver.dao.influxdb.entity.skywalkingjvm.oraclepool;

import com.huawei.javamesh.metricserver.dao.influxdb.entity.MemoryPoolInfluxEntity;
import com.influxdb.annotations.Measurement;

/**
 * Survivor类型Oracle memory pool Influxdb持久化实体
 */
@Measurement(name = "oracle_pool_survivor_space")
public class SurvivorInfluxEntity extends MemoryPoolInfluxEntity {
}