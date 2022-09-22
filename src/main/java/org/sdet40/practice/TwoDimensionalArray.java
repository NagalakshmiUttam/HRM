package org.sdet40.practice;

public class TwoDimensionalArray {

	public static void main(String[] args) {
		String[][] arr=new String[2][2];
		arr[0][0]="a1";
		arr[0][1]="a2";
		arr[1][0]="b1";
		arr[1][1]="b2";
		
		for(int i=0; i<=arr.length; i++)
		{
			for(int j=0; j<=i+1; j++)
			{
				System.out.print(arr[i][j]+" ");
		}
			System.out.println();
		}
	}
}
		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
		
	


