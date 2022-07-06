package com.goat.calvin.service.provider.domain.leetcode.daylywork;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.*;

/**
 * @author xiefei
 * @date 2022/7/6 9:39
 */
public class Demo736 {
	/**
	 * 表达式可以为整数，let 表达式，add 表达式，mult 表达式，或赋值的变量。
	 * 表达式的结果总是一个整数。(整数可以是正整数、负整数、0)
	 * let 表达式采用 "(let v1 e1 v2 e2 ... vn en expr)" 的形式，
	 * 其中 let 总是以字符串 "let"来表示，接下来会跟随一对或多对交替的变量和表达式，
	 * 也就是说，第一个变量 v1被分配为表达式 e1 的值，
	 * 第二个变量 v2 被分配为表达式 e2 的值，依次类推；
	 * 最终 let 表达式的值为 expr表达式的值。
	 * add 表达式表示为 "(add e1 e2)" ，其中 add 总是以字符串 "add" 来表示，
	 * 该表达式总是包含两个表达式 e1、e2 ，
	 * 最终结果是 e1 表达式的值与 e2 表达式的值之 和 。
	 * mult 表达式表示为 "(mult e1 e2)" ，
	 * 其中 mult 总是以字符串 "mult" 表示，该表达式总是包含两个表达式 e1、e2，
	 * 最终结果是 e1 表达式的值与 e2 表达式的值之 积 。
	 * 在该题目中，变量名以小写字符开始，之后跟随 0 个或多个小写字符或数字。
	 * 为了方便，"add" ，"let" ，"mult" 会被定义为 "关键字" ，不会用作变量名。
	 * 最后，要说一下作用域的概念。计算变量名所对应的表达式时，在计算上下文中，
	 * 首先检查最内层作用域（按括号计），然后按顺序依次检查外部作用域。
	 * 测试用例中每一个表达式都是合法的。有关作用域的更多详细信息，请参阅示例。
	 */

	// 先进先出的枚举
	Map<String, Deque<Integer>> scope = new HashMap<String, Deque<Integer>>();
	int start = 0;

	public int evaluate(String expression) {
		return innerEvaluate(expression);
	}

	public int innerEvaluate(String expression) {
		// 非表达式，可能为：整数或变量
		if (expression.charAt(start) != '(') {
			if (Character.isLowerCase(expression.charAt(start))) {
				// 变量
				String var = parseVar(expression);
				return scope.get(var).peek();
			} else {
				// 整数
				return parseInt(expression);
			}
		}
		int ret;
		start++;
		// 移除左括号
		// "let" 表达式
		if (expression.charAt(start) == 'l') {
			start += 4;
			List<String> vars = new ArrayList<String>();
			// 移除 "let "
			while (true) {
				// let 表达式的最后一个 expr 表达式的值:最后一个值一定是数字
				if (!Character.isLowerCase(expression.charAt(start))) {
					ret = innerEvaluate(expression);
					break;
				}
				String var = parseVar(expression);
				if (expression.charAt(start) == ')') {
					// let 表达式的最后一个 expr 表达式的值
					ret = scope.get(var).peek();
					break;
				}
				vars.add(var);
				start++;
				// 移除空格
				int e = innerEvaluate(expression);
				scope.putIfAbsent(var, new ArrayDeque<Integer>());
				scope.get(var).push(e);
				start++; // 移除空格
			}
			for (String var : vars) {
				// 清除当前作用域的变量
				scope.get(var).pop();
			}
			// 移除 "add "
		} else if (expression.charAt(start) == 'a') {
			start += 4;
			int e1 = innerEvaluate(expression);
			start++; // 移除空格
			int e2 = innerEvaluate(expression);
			ret = e1 + e2;
			// "mult" 表达式
		} else {
			start += 5;
			int e1 = innerEvaluate(expression);
			start++;
			int e2 = innerEvaluate(expression);
			ret = e1 * e2;
		}
		// 移除右括号
		start++;
		return ret;
	}

	/**
	 * 解析整数：每次传递过来的expression都是全量的
	 */
	public int parseInt(String expression) {
		int n = expression.length();
		int ret = 0, sign = 1;
		if (expression.charAt(start) == '-') {
			sign = -1;
			start++;
		}
		// 遇到非数字直接退出了
		while (start < n && Character.isDigit(expression.charAt(start))) {
			ret = ret * 10 + (expression.charAt(start) - '0');
			start++;
		}
		return sign * ret;
	}

	public String parseVar(String expression) {
		int n = expression.length();
		StringBuffer ret = new StringBuffer();
		while (start < n && expression.charAt(start) != ' ' && expression.charAt(start) != ')') {
			ret.append(expression.charAt(start));
			start++;
		}
		return ret.toString();
	}
}
