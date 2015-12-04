// Setの実装であるTreeSetクラスについて体験する
// 自動的に要素がソートされる
import java.util.*;
public class TreeSetSample {
	public static void main(String[] args){
		// Setの実装であるHashクラスのインスタンス生成，今回は文字列型
		// ジェネリクス（総称型）を使っている（復習）
		Set<String> set = new TreeSet<String>();
		set.add("C"); // 要素の追加
		set.add("A");
		set.add("B");
		set.add("B"); // 同じ要素を追加しても要素は重複されない
		
		for(String item:set){ // 要素の一覧を表示； 拡張For文（復習）
			System.out.println(item);
		}
		System.out.println("");
		
		Iterator<String> iter = set.iterator(); // イテレータを使った走査
		while(iter.hasNext()){
			String item = iter.next();
			System.out.println(item);
		}
		System.out.println("");
		
		set.remove("A"); // 要素の削除
		
		for(String item:set){ // 要素の一覧を表示
			System.out.println(item);
		}
	}
}
