//マージソート

import java.util.Scanner;

class MergeSort{
	static int[] buff;	//作業用配列
	
	//a[left]～a[right]を再帰的にマージソート
	static void _mergesort(int[] a,int left,int right){
		if(left<right){
			int i;
			int center=(left+right)/2;
			int p=0;
			int j=0;
			int k=left;
			
			_mergesort(a,left,center);		//前半部をマージソート
			_mergesort(a,center+1,right);	//後半部をマージソート
			
			for(i=left;i<=center;i++)
				buff[p++]=a[i];
			
			while(i<=right && j<p)
				a[k++]=(buff[j]<=a[i])?buff[j++]:a[i++];
			
			while(j<p)
				a[k++]=buff[j++];
		}
	}
	
	//マージソート
	static void mergesort(int[] a,int n){
		buff=new int[n];	//作業用配列を生成
		
		_mergesort(a,0,n-1);//配列全体をマージソート
		
		buff=null;			//作業用配列を格納
	}
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		
		System.out.println("マージソート");
		System.out.print("要素数:");
		int nx=stdIn.nextInt();
		int[] x=new int[nx];
		
		for(int i=0;i<nx;i++){
			System.out.print("x["+i+"]:");
			x[i]=stdIn.nextInt();
		}
		
		mergesort(x,nx);	//配列xをマージソート
		
		System.out.println("昇順にソートしました");
		for(int i=0;i<nx;i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}
