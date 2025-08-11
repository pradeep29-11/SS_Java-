
class PrintTextThread extends Thread
{
	String msg;
	int n;

	public PrintTextThread(String msg,int n)
	{
		this.msg = msg;
		this.n  = n;
	}
	public void run()
	{
		try 
		{
			for(int i=0;i<n;i++)
			{
				System.out.println(msg);
				sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
public class NNumberMsg
{
	public static void main(String args[])
	{
		PrintTextThread t1 = new PrintTextThread("India",5);
		PrintTextThread t2 = new PrintTextThread("Australia",5);

		t1.start();
		t2.start();
	}
}