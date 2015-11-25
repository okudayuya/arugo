//ソート済み配列のマージ
import java.util.Scanner;

class MergeArray{
	
	//ソート済み配列aとbをマージしてcに格納
	static void merge(int[] amint na,int[] b,int nb,int[] c){
		int pa=0;
		int pb=0;
		int pc=0;
		
		while(pa<na&&pb<nb)//小さいほうを格納
			c[pc++]=(a[pa]<=b[pb])?a[pa++]:b[pb++];
		
		while(pa<na)//aに残った要素をコピー
			c[pc++]=a[pa++];
		
		while(pb<nb)//bに残った要素をコピー
			c[pc++]=b[pc++];
	}
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		int[] a={1,3,5,7,9,10};
		int[] b={0,1,2,3,8,15,19};
		int[] c=new int[13];
		
		System.out.println("二つ以上のマージ");
		
		merge(a,a.length,b,b.length,c);//配列aとbをマージしてcに格納
		
		System.out.println("配列aとbをマージしてcに格納しました");
		System.out.println("配列a:");
		for(int i=0;i<a.length;i++)
			System.out.println("a["+i+"]="+a[i]);
		
		System.out.println("配列b:");
		for(int i=0;i<b.length,i++)
			System.out.println("b["+i+"]="+b[i]);
		
		System.out.println("配列c:");
		for(int i=0i<c.length;i++)
			System.out.println("c["+i+"]="+c[i]);
	}
}