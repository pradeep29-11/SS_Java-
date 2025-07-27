
class IndiaThread implements Runnable
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("India");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
class AustraliaThread implements Runnable
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println("Austria");
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}
public class RunnableDemo
{
	public static void main(String args[])
	{
		System.out.println("Hii");

		IndiaThread t1 = new IndiaThread(); 	// Thread-0
		Thread tob1 = new Thread(t1);

		AustraliaThread ob = new AustraliaThread();
		Thread t2 = new Thread(ob);

		tob1.start();
		t2.start();
	}
}