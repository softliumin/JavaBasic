package cc.sharper.demo4.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


public class Client
{

	public static void main(String[] args)
	{
		//被代理类
		RealSubject realSubject = new RealSubject();

		//代理类
		InvocationHandler handler = new DynamicSubject(realSubject);
		
		LiuMin liu = new LiuMin();
		Class<?> classType3 = liu.getClass();
		
		Class<?> classType = handler.getClass();//代理类
		Class<?> classType2 = realSubject.getClass();//被代理类
		//系统类加载器
		
		System.out.println(classType.getClassLoader()==classType2.getClassLoader());//true

		// 下面的代码一次性生成代理

		/** loader the class loader to define the proxy class  代理类的类加载器
		 * 
		 */
//		ClassLoader loader, 类加载器
//		Class<?>[] interfaces,被代理类实现的接口  必须是
//		InvocationHandler h 代理类
//		Subject subject = (Subject) Proxy.newProxyInstance(classType.getClassLoader(), 
//				realSubject.getClass().getInterfaces(),handler);
		
		Subject subject = (Subject) Proxy.newProxyInstance(classType2.getClassLoader(), 
				realSubject.getClass().getInterfaces(),handler);
		
//		Moveable m = (Moveable) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), h);

		subject.request();
		//System.out.println("++"+subject.getClass());

	}

}
