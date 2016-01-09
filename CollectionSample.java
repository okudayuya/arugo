//Collections.sortを使った文字列ソート
import java.util.*;
public class CollectionSample{
	public static void main(String[] args){
		//ジェネリクスの使用
		List<String> array= new ArrayList<String>();
		array.add("s");//要素の追加
		array.add("a");
		array.add("d");
		array.add("r");
		array.add("w");
		array.add("e");
		Collections.sort(array);
		for(String string:array){//拡張for文
			System.out.println(string);
		}
	}
}