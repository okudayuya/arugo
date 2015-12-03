//Setの実装であるHashクラスについて体験する

import java.util.*;

public class SetSample{
	
	public static void main(String[] args){
		//Setの実装であるHashクラスのインスタンス生成,降雨会は文字列型
		//ジェネリクス(総称型)を使っている
		Set<String> set=new HashSet<String>();
		set.add("東京");//要素の追加
		set.add("ロンドン");
		set.add("パリ");
		set.add("パリ");//同じ要素を追加しても重複はされない
		
		for(String item:set){//一覧の表示:拡張for文
			System.out.println(item);
		}
		System.out.println(" ");
		
		Iterator<String>iter=set.iterator();//イテレータを使った走査
		while(iter.hasNext()){
			String item=iter=iter.next();
			System.out.println(item);
		}
		
		set.remove("パリ");//要素の削除
		
		for(String item:set){//要素の一覧の表示
			System.out.println(item);
		}
	}
}
		