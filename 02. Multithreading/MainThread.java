
class IndiaThread extends Thread
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("India");
				sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}

class AustraliaThread extends Thread
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("Australi");
				sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}
public class MainThread
{
	public static void main(String args[])
	{
		IndiaThread t1 = new IndiaThread();
		AustraliaThread t2 = new AustraliaThread();

		t1.start();
		t2.start();
		
		try 
		{
			for(int i=0;i<10;i++)
			{
				System.out.println("Main");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}
}