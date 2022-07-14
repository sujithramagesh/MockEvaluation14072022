package otherPrograms;

public class FibonacciAndPrime {
public static void main(String[] args) {
	new FibonacciAndPrime().getFibonacciPrime();
}

private void getFibonacciPrime() {
	int number[]=new int[50];
	int n1=0,n2=1;
	int sum=n1+n2;
	boolean isPrime=checkPrime(sum);
	int primeIndex=0;
	if(isPrime)
	{
		System.out.println(sum+" ");
		primeIndex++;
	}
	n1=n2;
	for(int i=1;i<number.length;i++)
	{
		if(primeIndex==10)
			break;
		n2=sum;
		sum=n1+n2;
		isPrime=checkPrime(sum);
		if(isPrime)
		{
			System.out.println(sum+" ");
			primeIndex++;
		}
		n1=n2;
	}
}

private boolean checkPrime(int number) {
	int count=0;
	for(int i=1;i<=(number/2);i++)
	{
		if(number%i==0)
			count++;
	}
	if(count==1)
	{
		return true;
	}
	return false;
		
}

}
