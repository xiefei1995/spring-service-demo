package com.goat.calvin.service.provider.springstudy.event;

import org.springframework.context.ApplicationEvent;

/**
 * [自定义事件：只需要继承ApplicationEvent就能够成为一个自定义事件]
 *
 * @author xiefei
 * @date 2022/6/29 17:21
 */
public class MyEvent extends ApplicationEvent {

	private String name;

	/**
	 * 继承并重写父类的有参构造方法
	 */
	public MyEvent(Object source, String name) {
		super(source);
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
