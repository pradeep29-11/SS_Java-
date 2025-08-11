
import java.util.*;

class SumThread extends Thread
{
	int a[];
	int start;
	int end;
	int sum;

	public SumThread(int a[],int start,int end)
	{
		this.a = a;
		this.start = start;
		this.end = end;
		this.sum = 0;
	}

	public void run()
	{
		for(int i = start;i<=end;i++)
		{
			sum = sum + a[i];
		}
	}
}
public class SumNNumber
{
	public static void main(String args[]) throws InterruptedException
	{
		Random r = new Random();

		int n = 100;
		int a[] = new int[n];

		for(int i=0 ;i<100;i++)
		{
			a[i] = r.nextInt(1000);
			//a[i] = a[i] + (i+1);
		}

		System.out.println(Arrays.toString(a));

		SumThread t1 = new SumThread(a,0,19);
		SumThread t2 = new SumThread(a,20,39);
		SumThread t3 = new SumThread(a,40,59);
		SumThread t4 = new SumThread(a,60,79);
		SumThread t5 = new SumThread(a,80,99);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		t1.join();
		t2.join();
		t3.join();
		t4.join();
		t5.join();

		int total = t1.sum+t2.sum+t3.sum+t4.sum+t5.sum;

		System.out.println("Total Sum : "+total);
	}
}