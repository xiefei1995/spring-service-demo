package com.goat.calvin.service.provider.springstudy.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * [自定义事件监听器，只需要继承ApplicationListener指定监听事件并重写监听方法即可]
 *
 * @author xiefei
 * @date 2022/6/29 17:26
 */
@Component
public class MyEventListener implements ApplicationListener<MyEvent> {

	/**
	 * 方法级别的监听
	 */
	@Override
	//@EventListener(MyEvent.class)
	public void onApplicationEvent(MyEvent myEvent) {
		if (myEvent.getName().equals("calvin")) {
			System.out.println("---------------------监听生效啦---------------------");
		}
	}
}
