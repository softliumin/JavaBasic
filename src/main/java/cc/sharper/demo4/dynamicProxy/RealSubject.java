package cc.sharper.demo4.dynamicProxy;

public class RealSubject implements Subject
{

	public void request()
	{
		System.out.println("From real subject!");
	}

}
