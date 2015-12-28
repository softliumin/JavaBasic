package cc.sharper.demo4.staticProxy;

public class RealSubject extends Subject
{

	@Override
	public void request()
	{
		System.out.println("From real subject.");
	}

}
