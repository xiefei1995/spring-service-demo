package com.goat.calvin.service.infra.config;//package com.hikcreate.hdsp.service.supervise.infra.config;
//
//import cn.hutool.core.date.DateUtil;
//import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
//import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
//
//import java.util.Collection;
//import java.util.Date;
//
///**
// * @author houxi
// * @version 1.0
// * @date 2020/8/12 16:22
// */
//public class PreciseShardingRule implements PreciseShardingAlgorithm<Date> {
//
//    @Override
//    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Date> preciseShardingValue) {
//        StringBuffer tableName = new StringBuffer();
//        tableName.append(preciseShardingValue.getLogicTableName())
//                .append("_").append(DateUtil.format(preciseShardingValue.getValue(), "yyyyMM"));
//        return tableName.toString();
//    }
//
//}
