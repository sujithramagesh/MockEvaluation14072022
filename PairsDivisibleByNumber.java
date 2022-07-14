package otherPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class PairsDivisibleByNumber {
	public static void main(String[] args) {
		new PairsDivisibleByNumber().determineThePairs();
	}

	private void determineThePairs() {
		Scanner sc=new Scanner(System.in);
		boolean isValid=false;
		int num=0;
		while(!isValid)
		{
			System.out.println("Enter the size of the array:Size should be between 2 and 100(including 2&100)");
			num=sc.nextInt();
			if(num>=2&&num<=100)
			{
				isValid=true;
			}
		}
		isValid=false;
		int numberArray[]=new int[num];
		int value;
		System.out.println("Enter the array Elements between 1 and 100");
		for(int i=0;i<num;i++)
		{
			while(!isValid)
			{
				value=sc.nextInt();
				if(value>=1&&value<=100)
				{
					numberArray[i]=value;
					isValid=true;
				}
				else
				{
					System.out.println("Input should be between 1 and 100\nPlease enter a valid input");
				}
			}
			isValid=false;
		}
		numberArray=sortNumberArray(numberArray);
		
		int k=0;
		System.out.println("Enter the number that should divide the pairs sum");
		while(!isValid)
		{
		 k=sc.nextInt();
		 if(k>=1&&k<=100)
		 {
			 isValid=true;
		 }
		}
		for(int i=0;i<numberArray.length;i++)
		{
			for(int j=i+1;j<numberArray.length;j++)
			{
				if((numberArray[i]+numberArray[j])%k==0)
				{
					System.out.println("["+numberArray[i]+","+numberArray[j]+"]");
				}
			}
		}
	}

	private int[] sortNumberArray(int[] numberArray) {
		for(int i=0;i<numberArray.length;i++)
		{
			for(int j=0;j<numberArray.length;j++)
			{
				if(numberArray[i]>numberArray[j])
				{
					int temp=numberArray[i];
					numberArray[i]=numberArray[j];
					numberArray[j]=temp;
				}
			}
		}
		return numberArray;
	}
}
