package cc.sharper.demo4.dynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test
{
	/**
	 * JDK动态代理测试类
	 */
	public static void main(String[] args)
	{
		Car car = new Car();
		InvocationHandler h = new TimeHandler(car);
		
		Class<?> cls = car.getClass();//被代理对象的Class对象，最好先生成，方便之后再newProxyInstance里面直接调用
		/**
		 * 被代理类的类加载器
		 * loader 类加载器 interfaces 实现接口 h InvocationHandler
		 */
		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);
		m.move();

	}

}
