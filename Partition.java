//クイックソート
import java.util.Scanner;

class Partition{
	
	//配列の要素の値の交換
	static void swap(int[] a,int idx1,int isx2){
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	
	//配列を分割する
	static void partition(int[] a,int n){
		int pl=0;		//左カーソル
		int pr=n-1;		//右カーソル
		int x=a[n/2];	//枢軸(中央の要素)
		
		do{
			while(a[pl]<x) pl++;
			while(a[pr]>x) pr++;
			if(pl<=pr)
				swap(a,pl++,pr--);
		}while(pl<=pr);
		
		System.out.println("枢軸の値は"+x*"です");
		
		System.out.println("枢軸以下のグループ");
		for(int i=0;i<=pl-1;i++)
			System.out,print(a[i]+" ");
		System.out.println();
	}
	
	System.out.println("枢軸と一致するグループ");
	for(int i=pr+1;i<n;i++)
		System.out.print(a[i]+" ");
	System.out.println();
}

public static void main(String[] args){
	Scanner stdIn=new Scanner(System.in);
	
	System.out.println("配列を分割します");
	System.out.print("要素数:");
	int nx=stdIn.next int();
	int[] x=new int[nx];
	
	for(int i=0;i<nx;i++){
		System.out.print("x["+i+"]:");
		x[i]=stdIn.nextInt();
	}
	partition(x,nx);
}
}