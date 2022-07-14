package fourteGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameLogic {
	static HashMap<String,Integer> expressionValueMap=new HashMap<String, Integer>();
	static ArrayList<String> answerList=new ArrayList<String>();
public void gameLogic() {
	
	
	Scanner sc=new Scanner(System.in);
	int number[]= new int[4];
	System.out.println("Enter 4 numbers between 0 and 9");
	for(int i=0;i<number.length;i++)
	{
		number[i]=sc.nextInt();
	}
	System.out.println("Enter the answer");
	int answer=sc.nextInt();
	System.out.println("Enter the answer expression");
	String str=sc.next();
	checkAnswer(number,answer);
	boolean isAnswerFound=false;
	for(String lStr:answerList)
	{
		if(str.equals(lStr))
		{
			System.out.println("Answer is correct");
			isAnswerFound=true;
			break;
		}
		
	}
	if(!isAnswerFound)
	{
		System.out.println("Incorrect Answer");
	}
	
	
}

private void checkAnswer(int[] number, int answer) {
	for(int eachValue=0;eachValue<number.length;eachValue++)
	{
		for(int nextValue=eachValue+1;nextValue<number.length;nextValue++)
		{
			addition(number[eachValue],number[nextValue]);
			subtraction(number[eachValue],number[nextValue]);
			multiplication(number[eachValue],number[nextValue]);
			division(number[eachValue],number[nextValue]);
		}
	}
	
	findAnswer(answer);
	
}

private void findAnswer(int answer) {
	boolean isAnswerFound=false;
	for(Map.Entry<String, Integer> eachCombination:expressionValueMap.entrySet())
	{

		for(Map.Entry<String, Integer> nextCombination:expressionValueMap.entrySet())
		{
			int value1=eachCombination.getValue();
			int value2=nextCombination.getValue();
			if(eachCombination.equals(nextCombination))
				continue;
			isAnswerFound= findNumberByAddition(eachCombination.getValue(),nextCombination.getValue(),answer);
			if(isAnswerFound)
			{
				answerList.add(eachCombination.getKey()+"+"+nextCombination.getKey());
				isAnswerFound=false;
			}
			
			 isAnswerFound=findNumberBySubtraction(eachCombination.getValue(),nextCombination.getValue(),answer);
			 if(isAnswerFound)
				{
				 if(eachCombination.getValue()>nextCombination.getValue())
					 answerList.add(eachCombination.getKey()+"-"+nextCombination.getKey());
				 else
					 answerList.add(nextCombination.getKey()+"+"+eachCombination.getKey());
				 
					isAnswerFound=false;
				}
			 isAnswerFound=findNumberByMultiplication(eachCombination.getValue(),nextCombination.getValue(),answer);
			 if(isAnswerFound)
			 {
				 answerList.add(eachCombination.getKey()+"*"+nextCombination.getKey());
				 isAnswerFound=false;
			 }
			 isAnswerFound=findNumberByDivision(eachCombination.getValue(),nextCombination.getValue(),answer);
			 if(isAnswerFound)
				{
				 if(eachCombination.getValue()>nextCombination.getValue())
					 answerList.add(eachCombination.getKey()+"/"+nextCombination.getKey());
				 else
					 answerList.add(nextCombination.getKey()+"/"+eachCombination.getKey());
				 
					isAnswerFound=false;
				}
			 
		}
	}
	//System.out.println(answerList);
	
}

private boolean findNumberByDivision(Integer value, Integer value2, int answer) {
	if(value<=value2&&answer*value==value2)
	{
		return true;
	}
	else if(value>value2&&answer*value2==value)
	{
		return true;
	}
	return false;
}
private boolean findNumberByMultiplication(Integer value, Integer value2, int answer) {
	if(answer%value==0&&answer/value==value2)
		return true;
	return false;
}
private boolean findNumberBySubtraction(Integer value, Integer value2, int answer) {
	if(answer+value==value2)
		return true;
	return false;
}
private boolean findNumberByAddition(Integer value1, Integer value2, int answer) {
	if(answer-value1==value2)
	{
		return true;
	}
	return false;
}
private void addition(int i, int j) {

	expressionValueMap.put("("+i+"+"+j+")", doAddition(i, j));
	expressionValueMap.put("("+j+"+"+i+")", doAddition(i, j));
	expressionValueMap.put(i+"+"+j, doAddition(i, j));
	expressionValueMap.put(i+"+"+j, doAddition(i, j));
}
private void subtraction(int i, int j) {
	if(i>j)
	{
		String str="("+i+"-"+j+")";
		expressionValueMap.put("("+i+"-"+j+")", doSubtraction(i, j));
		expressionValueMap.put(i+"-"+j, doSubtraction(i, j));
	}
	else
	{
		String str="("+j+"-"+i+")";
		expressionValueMap.put("("+j+"-"+i+")", doSubtraction(j, i));
		expressionValueMap.put(j+"-"+i, doSubtraction(j, i));
	}
}
private void multiplication(int i, int j) {
	expressionValueMap.put("("+i+"*"+j+")", doMultiplication(i, j));
	expressionValueMap.put("("+j+"*"+i+")", doMultiplication(i, j));
}
private void division(int i, int j) {
	if(i>j)
	{
		String str="("+i+"/"+j+")";
		if(doDivision(i, j)!=0)
		expressionValueMap.put(str, doDivision(i, j));
	}
	else
	{
		String str="("+j+"/"+i+")";
		if(doDivision(j, i)!=0)
		expressionValueMap.put(str, doDivision(j, i));
	}
	
}
public int doAddition(int number1,int number2)
{
	return number1+number2;
}
public int doSubtraction(int number1,int number2)
{
	return number1-number2;
}
public int doMultiplication(int number1,int number2)
{
	return number1*number2;
}
public int doDivision(int number1,int number2)
{
	return (number1%number2)!=0?0:(number1/number2);
}
}
