//二文探索(昇順)
import java.util.Scanner;
class BinarySearchTest{
    public static int NOT_NUM = -1; //ありえない値を入れる
    public static void main(String[] args){
    	Scanner stdIn=new Scanner(System.in);
        System.out.println("要素数は:");
        int n=stdIn.nextInt();
        int []arr=new int[n];
        for(int a=0;a<n;a++){
        	System.out.println("x["+a+"]:");
        	arr[a]=stdIn.nextInt();
        }
        System.out.println("検索するKey");
        int num=stdIn.nextInt();

        int p = binariSearch(arr, num);  //二分探索をする

        if(p == NOT_NUM){
            System.out.println(num + "は見つからないです");
        }
        else{
            System.out.println("arr[" + p + "]で発見です");
        }
    }

    //二分探索で配列を検索。（引数：配列、検索したい値）*******
    public static int binariSearch(int[] arr, int num){
        int l = 0;
        int r = arr.length-1;
        int m;
        int val = NOT_NUM;

        //左と右が入れ替わるまで繰り返す
        while(l<=r){
            m = (l+r) / 2;  //中央を求める

            if(arr[m] < num){
                l = m + 1;
            }
            else if(arr[m] > num){
                r = m - 1;
            }
            else{
                val = m;
                break;
            }
        }
        return val;
    }
}