//文字配列からの探索
import java.util.Arrays;
import java.util.Scanner;

class StringBinarySearch{
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		String[]x={//キーワード(アルファベット順)
			"abstract","assert","boolean","break","byte",
			"case","catch","char","double","enum","final","if","void"
		};
		System.out.print("何を探しますか：");//キーの読み込み
		String ky=stdIn.next();//キーの入力
		
		int idx=Arrays.binarySearch(x,ky);//配列xから値がkyの要素を探索
		
		if(idx<0)
			System.out.println("そのキーワードは存在しません");//存在しない場合
		else
			System.out.println("それはx["+idx+"]にあります");//存在する場合
	}
}