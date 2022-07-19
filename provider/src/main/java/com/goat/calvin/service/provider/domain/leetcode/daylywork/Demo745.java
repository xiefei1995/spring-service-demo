package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import org.bouncycastle.util.Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiefei
 * @date 2022/7/14 9:20
 */
public class Demo745 {
	class WordFilter {
		Map<String, Integer> dictionary;

		public WordFilter(String[] words) {
			dictionary = new HashMap<String, Integer>();
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				int m = word.length();
				// 计算所有字符串的前后缀的自己组合
				for (int prefixLength = 1; prefixLength <= m; prefixLength++) {
					for (int suffixLength = 1; suffixLength <= m; suffixLength++) {
						dictionary.put(word.substring(0, prefixLength) + "#" + word.substring(m - suffixLength), i);
					}
				}
			}
		}

		public int f(String pref, String suff) {
			return dictionary.getOrDefault(pref + "#" + suff, -1);
		}
	}
}
