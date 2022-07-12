package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/11 9:28
 */
public class Demo676 {

	/**
	 * 输入的词换一个字符和字典里的匹配
	 */
	class MagicDictionary {

		class DataDict {
			private String str;
			private int length;

			public String getStr() {
				return str;
			}

			public void setStr(String str) {
				this.str = str;
			}

			public int getLength() {
				return length;
			}

			public void setLength(int length) {
				this.length = length;
			}

			DataDict(String str) {
				this.str = str;
				this.length = str.length();
			}

		}

		List<DataDict> list;

		public MagicDictionary() {
			list = new ArrayList<>();
		}

		public void buildDict(String[] dictionary) {
			for (String s : dictionary) {
				list.add(new DataDict(s));
			}
		}

		public boolean search(String searchWord) {
			if (list == null || list.size() == 0) return false;
			for (int i = 0; i < list.size(); i++) {
				// 找到长度一致的
				if (list.get(i).length == searchWord.length()) {
					int sameCount = 0;
					for (int j = 0; j < searchWord.length(); j++) {
						if (list.get(i).str.charAt(j) == searchWord.charAt(j)) {
							sameCount++;
						}
					}
					if (sameCount == searchWord.length() - 1) return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		char[] arr = new char[26];
		System.out.println(arr.length);
	}
}
