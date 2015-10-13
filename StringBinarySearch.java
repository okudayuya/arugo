import java.util.Arrays;
import java.util.Scanner;

class StringBinarySearch{
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		String[]x={
			"abstract","assert","boolean","break","byte",
			"case","catch","char","double","enum","final","if","void"
		};
		System.out.print("何を探しますか：");
		String ky=stdIn.next();
		
		int idx=Arrays.binarySearch(x,ky);
		
		if(idx<0)
			System.out.println("そのキーワードは存在しません");
		else
			System.out.println("それはx["+idx+"]にあります");
	}
}