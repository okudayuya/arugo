//挿入ソートを行うクラス
public class Insertion {
    public static void main(String[] args) {
        //データの格納
	int[] data = {3, 2, 8, 7, 5};

	//挿入ソート
	for(int i=1; i < data.length; i++) {
	    for(int j=i; j>=1 && data[j] < data[j-1]; j--) {
		int tmp = data[j];
		data[j] = data[j-1];
		data[j-1] = tmp;
	    }
	}
	//ソート後の結果を出力
    	for(int i=0; i < data.length; i++) {
            System.out.println(data[i]);
    	}
    }
}
//値を適切な箇所に挿入するために値をずらす作業が必要