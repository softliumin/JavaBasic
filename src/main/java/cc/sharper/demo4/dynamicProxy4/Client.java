package cc.sharper.demo4.dynamicProxy4;

public class Client
{

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception
	{
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class);
		m.move();

	}

}
