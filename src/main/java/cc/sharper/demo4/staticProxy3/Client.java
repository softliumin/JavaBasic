package cc.sharper.demo4.staticProxy3;

public class Client
{

	public static void main(String[] args)
	{
		Car car = new Car();
		CarLogProxy clp = new CarLogProxy(car);
		CarTimeProxy ctp = new CarTimeProxy(clp);
		ctp.move();
	}

}
