//TreeMapクラス
import java.util.*;
public class TreeMapSample {
public static void main(String[] args){
// Mapの実装であるHashMapクラスのインスタンス生成，今回はキーも値も文字列型
// ジェネリクス（総称型）を使っている（復習）
TreeMap<String,String> map = new TreeMap<String,String>();
map.put("red","赤"); // 要素の追加
map.put("blue","青");
map.put("green","緑");
map.put("green","緑"); // 同じ要素を追加しても要素は重複されない
System.out.println(map.get("blue")); // キーを指定して表示
System.out.println("");
for(String key:map.keySet()){ // 要素の一覧を表示； 拡張For文（復習）
System.out.println(key+" = "+map.get(key));
}
System.out.println("");
map.remove("green"); //キーを指定して削除
for(String key:map.keySet()){ // 要素の一覧を表示； 拡張For文（復習）
System.out.println(key+" = "+map.get(key));
}
}
}
