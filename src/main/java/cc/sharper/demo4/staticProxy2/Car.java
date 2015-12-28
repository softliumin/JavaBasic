package cc.sharper.demo4.staticProxy2;

import java.util.Random;

public class Car implements Moveable
{

	@Override
	public void move()
	{
		try
		{
			Thread.sleep(new Random().nextInt(1000));
			System.out.println("汽车在行驶中！");
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}

}
