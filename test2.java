//拡張for文　例
class test2 {
	public static void main(String args[]){
		double[]a={1.0,2.0,3.0,4.0,5.0};//配列
		
		for(int i=0;i<a.length;i++)//配列の中身の表示
			System.out.println("a["+i+"]="+a[i]);
		double sum=0;//合計
		for(double i:a)//拡張for文
			sum+=i;
		
		System.out.println("全要素の和は"+sum+"です");//合計の表示
	}
}


