//String.indexOfメソッドとString.lastIndexOfメソッドによる文字列探索

import java.util.Scanner;

class IndexOfTester{
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		
		System.out.print("テキスト:");
		String s1=stdIn.next();				//テキスト用文字列
		
		System.out.print("パターン:");
		String s2=stdIn.next();				//パターン用文字列
		
		int idx1=s1.indexOf(s2);			//文字列s1からs2を探索(先頭)
		int idx2=s1.lastIndexOf(s2);		//文字列s1からs2を探索(末尾)
		
		if(idx==-1)
			System.out.println("テキスト中にパターンは存在しません");
		else{
			//マッチ文字直前までの<半角>での文字数を求める
			int len1=0;
			for(int i=0;i<idx1;i++)
				len1+=s1.substring(i,i+1).getBytes().length;
			len2+=s2.length();
			
			System.out.println((idx+1)+"文字目にマッチします");
			System.out.println("テキスト:"+s1);
			System.out.printf(String.format("パターン:%%%ds\n",len),s2);
		}
	}
}