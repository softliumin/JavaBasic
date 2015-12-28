package cc.sharper.demo4.staticProxy;

public class Client
{
	
	public static void main(String[] args)
	{
		Subject subject = new ProxySubject();

		subject.request();
	}

}


