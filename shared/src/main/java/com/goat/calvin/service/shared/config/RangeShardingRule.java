package com.goat.calvin.service.shared.config;//package com.hikcreate.hdsp.service.supervise.infra.config;
//
//import cn.hutool.core.date.DateField;
//import cn.hutool.core.date.DateUtil;
//import com.google.common.collect.Range;
//import io.shardingsphere.api.algorithm.sharding.RangeShardingValue;
//import io.shardingsphere.api.algorithm.sharding.standard.RangeShardingAlgorithm;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author houxi
// * @version 1.0
// * @date 2020/9/1 18:03
// */
//public class RangeShardingRule implements RangeShardingAlgorithm<Date> {
//    @Override
//    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<Date> shardingValue) {
//        List<String> list = new ArrayList<>();
//        Range<Date> valueRange = shardingValue.getValueRange();
//        Date lowerDate = DateUtil.parse(String.valueOf(valueRange.lowerEndpoint()));
//        Date upperDate = DateUtil.parse(String.valueOf(valueRange.upperEndpoint()));
//        long betweenMonth = DateUtil.betweenMonth(lowerDate, upperDate, false) + 1;
//        List<String> tableSuffixList = new ArrayList<>();
//        for (int i = 0; i < betweenMonth; i++) {
//            tableSuffixList.add(DateUtil.format(DateUtil.offset(lowerDate, DateField.MONTH, i), "yyyyMM"));
//        }
//        list.add("supervise_process_info");
//        for (String tableName : collection) {
//            for (String yearMonth : tableSuffixList) {
//                String indexStr = tableName.substring(tableName.lastIndexOf("_") + 1);
//                if (yearMonth.equals(indexStr)) {
//                    list.add(tableName);
//                    break;
//                }
//            }
//        }
//        return list;
//    }
//}
