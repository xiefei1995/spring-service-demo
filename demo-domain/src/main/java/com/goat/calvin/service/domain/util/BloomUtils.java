package com.goat.calvin.service.domain.util;

import com.google.common.base.Charsets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;


/**
 * @author xiefei15
 * @version 1.0.0
 * @since 2021/2/25 16:25
 */

public class BloomUtils {

    /**
     *  创建bf
     */

    BloomFilter<String> bf = BloomFilter.create(Funnels.stringFunnel(Charsets.UTF_8),1,0.03D);

}
