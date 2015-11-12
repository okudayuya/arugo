//バブルソート2
import java.util.Scanner;

class BubbleSort2{
	//昇順ソートを行うクラス
    public static void main(String[] args) {
    	Scanner stdIn=new Scanner(System.in);
    	//データの入力
    	System.out.print("要素数:");
    	int x=stdIn.nextInt();
    	int[] data=new int[x];
    	
    	for(int i=0;i<x;i++){
    		System.out.print("x["+i+"]:");
    		data[i]=stdIn.nextInt();
    	}
    	//昇順ソート
        for(int i=0; i < data.length-1; i++) {
            for(int j=0; j < data.length-i-1; j++) {
            	if(data[j] > data[j+1]) {
            		int asc = data[j];
            		data[j] = data[j+1];
            		data[j+1] = asc;
            	}
            }
        }
        //ソート後の結果を出力
        for(int i = 0; i < data.length; i++) {
        	System.out.print(data[i]+" ");
        }
    }
}