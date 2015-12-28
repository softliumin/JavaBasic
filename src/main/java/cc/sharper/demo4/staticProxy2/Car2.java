package cc.sharper.demo4.staticProxy2;

public class Car2 extends Car
{
	@Override
	public void move()
	{
		System.out.println("汽车开始行驶······");
		long startTime = System.currentTimeMillis();
		super.move();
		long endTime = System.currentTimeMillis();
		
		System.out.println("汽车结束行驶····耗时为："+(endTime-startTime)+"毫秒！");
		
	}
}
