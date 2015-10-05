//�񕶒T��(����)
import java.util.Scanner;
class BinarySearchTest{
    public static int NOT_NUM = -1; //���肦�Ȃ��l������
    public static void main(String[] args){
    	Scanner stdIn=new Scanner(System.in);
        System.out.println("�v�f����:");
        int n=stdIn.nextInt();
        int []arr=new int[n];
        for(int a=0;a<n;a++){
        	System.out.println("x["+a+"]:");
        	arr[a]=stdIn.nextInt();
        }
        System.out.println("��������Key");
        int num=stdIn.nextInt();

        int p = binariSearch(arr, num);  //�񕪒T��������

        if(p == NOT_NUM){
            System.out.println(num + "�͌�����Ȃ��ł�");
        }
        else{
            System.out.println("arr[" + p + "]�Ŕ����ł�");
        }
    }

    //�񕪒T���Ŕz��������B�i�����F�z��A�����������l�j*******
    public static int binariSearch(int[] arr, int num){
        int l = 0;
        int r = arr.length-1;
        int m;
        int val = NOT_NUM;

        //���ƉE������ւ��܂ŌJ��Ԃ�
        while(l<=r){
            m = (l+r) / 2;  //���������߂�

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