package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import cn.hutool.core.collection.CollectionUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author xiefei
 * @date 2022/7/7 10:45
 */
public class Demo648 {

	/**
	 * 在英语中，我们有一个叫做 词根(root) 的概念，
	 * 可以词根后面添加其他一些词组成另一个较长的单词——我们称这个词为 
	 * 继承词(successor)。例如，词根an，跟随着单词 other(其他)，
	 * 可以形成新的单词 another(另一个)。
	 * 现在，给定一个由许多词根组成的词典 dictionary
	 * 和一个用空格分隔单词形成的句子 sentence。
	 * 你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，
	 * 则用最短的词根替换它。
	 * <p>
	 * 你需要输出替换之后的句子
	 */

	public String replaceWords(List<String> dictionary, String sentence) {
		StringBuilder sb = new StringBuilder("");
		String[] strs = sentence.split(" ");
		for (int i = 0; i < strs.length; i++) {
			sb.append(changeRoot(dictionary, strs[i]));
			sb.append(" ");
		}
		return sb.toString().trim();
	}


	public String changeRoot(List<String> dictionary, String str) {
		for (int i = 0; i < dictionary.size(); i++) {
			if (str.startsWith(dictionary.get(i))) {
				List<String> incur = new ArrayList<>(dictionary);
				String s = dictionary.get(i);
				incur.remove(s);
				// 注意这里要最短的
				return changeRoot(incur, s);
			}
		}
		return str;
	}
}
