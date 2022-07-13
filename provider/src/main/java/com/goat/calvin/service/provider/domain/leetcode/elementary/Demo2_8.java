package com.goat.calvin.service.provider.domain.leetcode.elementary;

/**
 * @author xiefei
 * @date 2022/7/1 13:25
 */
public class Demo2_8 {

	/**
	 * 给定一个正整数 n ，输出外观数列的第 n 项。
	 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
	 * 你可以将其视作是由递归公式定义的数字字符串序列：
	 * countAndSay(1) = "1"
	 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
	 */
	public String countAndSay(int n) {
		// 递归出口
		if(n==1){
			return "1";
		}
		// 假设我们获得上一次的结果为 s1 = 112213
		String s1 = countAndSay(n - 1);
		// 定义结果
		StringBuilder result = new StringBuilder();
		// 对s1遍历处理获取值
		char local = s1.charAt(0);
		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			// 设定计数器 计算同一个数字出现的次数 count
			if(s1.charAt(i) == local){
				count++;
			}else {
				// 不符合，记录下
				result.append(count);
				result.append(local);
				count = 1;
				local = s1.charAt(i);
			}
		}
		result.append(count);
		result.append(local);
		return result.toString();
	}
}
