package cc.sharper.demo4.dynamicProxy2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TimeHandler implements InvocationHandler
{
	//代理类和被代理类进行关联，这是必须的
	public TimeHandler(Object target)
	{
		super();
		this.target = target;
	}
	private Object target;

	/* 文档的解释：
	 * proxy - the proxy instance that the method was invoked on
	 *
	 * 参数： proxy 被代理对象 method 被代理对象的方法 args 方法的参数
	 * 
	 * 返回值： Object 方法的返回值
	 */
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		long starttime = System.currentTimeMillis();
		System.out.println("汽车开始行驶....");
		
		method.invoke(target,args);//
		
		long endtime = System.currentTimeMillis();
		System.out.println("汽车结束行驶....  汽车行驶时间：" + (endtime - starttime) + "毫秒！");
		
		System.out.println("******"+proxy.getClass());//class com.sun.proxy.$Proxy0
		return null;
	}

}
