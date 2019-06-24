package com.mall.study.other;
import java.lang.reflect.Method;

/**
 * @description: 反射测试
 * @author: huangjiang  2018年5月25日 上午10:28:31
 */
public class ReflectTest {
	public static void main(String[] args) throws Exception {
		
		Person person = new Person("小明", 18);
		Class<? extends Person> personClass = person.getClass();
		System.out.println("类名: " + personClass.getName());
		// 获取私有方法
		Method runMethod = personClass.getDeclaredMethod("run");
		// 设置私有方法可访问
		runMethod.setAccessible(true);
		Person person2 = personClass.newInstance();
		runMethod.invoke(person);
		runMethod.invoke(person2);
	}
}


class Person {
	private String name;
	private Integer age;
	
	public void  say(String content) {
		System.out.println(this.name + " say: " + content);
	}
	
	private void run() {
		System.out.println(this.name + " 跑不动了");
	}
	
	public Person(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	public Person() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	
}
