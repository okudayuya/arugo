﻿//度数ソート
import util.java.Scanner;

class Fsort{
	
	//度数ソート(配列要素の値は0以上max以下)
	static void fsort(int[] a,int n,int max){
		int[] f=new int[max+1];	//累積度数
		int[] b=new int[n];		//作業用目的配列
		
		for(int i=0;	i<n;	i++) f[a[i]]++;			//step1
		for(int i=1;	i<=max	i++) f[i]+=f[i-1];		//step2
		for(int i=n-1;	i>=0;	i--) b[--f[a[i]]]=a[i];	//step3
		for(int i=0;	i<n		i++) a[i]=b[i];			//step4
	}
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		
		System.out.println("度数ソート");
		System.out.print("要素数:");
		int nx=stdIn.nextInt();
		int[] x-new int[nx];
		
		for(int i=0;i<nx;i++){
			do{
				System.out.print("x["+i+"]:");
				x[i]=stdIn.nextInt();
			}while(x[i]<0);
		}
		int max=x[0];
		for(int i=1;i<nx;i++)
			if(x[i]>max) max=x[i];
		
		fsort(x,nx,max);
		
		System.out.println("昇順にソートしました");
		for(int i=0;i<nx;i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}