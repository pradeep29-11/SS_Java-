
class IndiaThread extends Thread
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println(getName()+" : INDAI");
				sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

class AusThread extends Thread
{
	public void run()
	{
		try 
		{
			for(int i=0;i<5;i++)
			{
				System.out.println(getName()+" : Austria");
				sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class ThreadDemo
{
	public static void main(String args[])
	{
		System.out.println("hii");

		IndiaThread ob = new IndiaThread();
		ob.setName("Pradeep");
		ob.start();

		AusThread ob1 = new AusThread();
		ob1.start();


		System.out.println(ob);
	}
}