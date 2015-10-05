import java.util.Random;
import java.util.Scanner;

public class SequentialSearch {
    public static int seqSearch(int[] array, int target) {//線形探索
        int i = 0;
        int size = 0;
        if (array != null) {
            size = array.length;
        } else {
            return -1;
        }
        
        while (true) {
            if (i == size) {
                return -1;
            }
            if (array[i] == target) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        int max = 1000000;//配列の数
        int[] array = new int[max];
        Random rnd = new Random();
        Scanner KeyNum =new nexScanner(System.in)
        int KeyNum;//keyの入力
        //max分配列に値を入力する
        for (int i = 0; i < max; i++) {
            array[i] = rnd.nextInt(1000000);
        }
        
        long start = System.nanoTime();
        int index = seqSearch(array, keyNum);
        long end = System.nanoTime();
        //表示
        if (index != -1) {
            System.out.println("探したかった数字→" + keyNum + "　は" + index + "番目にあります！");
            System.out.println("array[index]→" + array[index]);
        } else {
            System.out.println("探してた数字→" + keyNum + "はないです");
        }
		//経過時間の表示
        //数が少ない場合はlong t1 = System.nanoTime();を使った方がいい
        System.out.println("かかった時間は・・・:" + (end - start) + "ナノ秒");
    }
}