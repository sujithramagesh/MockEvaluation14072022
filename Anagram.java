package otherPrograms;

import java.util.Arrays;
import java.util.Scanner;

public class Anagram {
	public static void main(String[] args) {
		new Anagram().checkAnagram();

	}

	private void checkAnagram() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the first String");
		String str1=sc.nextLine();
		System.out.println("Enter the second String");
		String str2=sc.nextLine();
		if(str1.length()!=str2.length())
		{
			System.out.println("The Given Strings should be of same length");
		}
		char ch1[]=str1.toLowerCase().toCharArray();
		char ch2[]=str2.toLowerCase().toCharArray();
		
		ch1=sortACharArray(ch1);
		ch2=sortACharArray(ch2);
		str1=convertArraytoString(ch1);
		str2=convertArraytoString(ch2);
		if(str1.equals(str2)) {
			System.out.println("Given strings are Anagram");
		}
		else
		{
			System.out.println("Given strings are not an Anagram");
		}
	}
	

	private char[] sortACharArray(char[] ch1) {
		for(int i=0;i<ch1.length;i++)
		{
			for(int j=0;j<ch1.length;j++)
			{
				if(ch1[i]>ch1[j]) {
					char temp=ch1[i];
					ch1[i]=ch1[j];
					ch1[j]=temp;
				}
			}
		}
		return ch1;
	}

	private String convertArraytoString(char[] ch1) {
		String str="";
		for(int i=0;i<ch1.length;i++)
		{
			str+=ch1[i];
		}
		return str;
	}

	private void printArray(char[] ch1) {
		for(int i=0;i<ch1.length;i++)
		{
			System.out.print(ch1[i]+" ");
		}
		System.out.println();
	}
	

}
