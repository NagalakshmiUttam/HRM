package org.sdet40.practice;

public class ThreeDimensionalArray 
{

	public static void main(String[] args) {
		String[][] arr=new String[3][3];
		
		arr[0][0]="a1";
		arr[0][1]="a2";
		arr[0][2]="a3";
		arr[1][0]="b1";
		arr[1][1]="b2";
		arr[1][2]="b3";
		arr[2][0]="c1";
		arr[2][1]="c2";
		arr[2][2]="c3";
		
		for(int i=0; i<arr.length; i++)
		{
			for(int j=0; j<=i+1; j++)
			{
				for(int k=0; k<=j+1; k++)
			
			{
				System.out.print(arr[i][j]+" ");
				 System.out.println();
			}
		}
		
	}
	}
}
	
