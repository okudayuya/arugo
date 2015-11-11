//単純交換ソート
import java.util.Scanner;

class BubbleSort{
	//配列の要素a[idx1]とa[idx2]の値を交換
	static void swap(int[] a,int idx1,int isx2){
		int t=a[idx1];
		a[idx1]=a[idx2];
		a[idx2]=t;
	}
	
	//単純交換ソート
	static void bubblesort(int[] a,int n){
		for(int i=0;i<n-1;i++)
			for(int j=n-1;j>i;j--)
				if(a[j-1]>a[j])
					swap(a,j-1,j);
	}
	
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		
		System.out.print("要素数:");
		int nx=stdIn.nextInt();
		int[] x=new int[nx];
		
		for(int i=0;i<nx;i++){
			System.out.print("x["+i+":");
			x[i]=stdIn.nextInt();
		}
		
		bubblesort(x,nx);
		
		System.out.println("昇順にソートしました");
		for(int i=0;i<nx;i++)
			System.out.println("x["+i+"]="+x[i]);
	}
}