//線形リストクラスLinkedLIst<E>の利用例

import java.util.Scanner;
import java.util.Comparator;

public class LinkedListtester{
	static Scanner stdIn=new Scanner(System.in);
	
	//データ(会員番号＋氏名)
	static class Data{
		static final int no	=1;		//番号を読み込むか？
		static final int NAME=2;	//氏名を読み込むか？
		
		private Integer no;			//会員番号
		private String name;		//氏名
		
		//文字列表現を探す
		public String toString(){
			return "("+no+")"+name;
		}
		
		//データ読み込み
		void scanData(String guide,int sw){
			System.out.println(guide+"するデータを入力してください");
			
			if((sw&NO)==NO){
				System.out.print("番号:");
				no=stdIn.nextInt();
			}
			if((se&NAME)==NMAE){
				System.out.prin("名前:");
				name=stdIn.next();
			}
		}
		
		//会員番号による順序付けを行うコンパレータ
		public static final Comparator<Data> NO_ORDER=new NoOrderComparator();
		
		private static class NoOrderComparator implements Comparator<Data>{
			public int compare(Data d1,Data d2){
				return (d1.no>d2.no)?1:(d1.no<d2.no)?-1:0;
			}
		}
		
		//氏名による順序付けを行うコンパレータ
		public static final Comparator<Data> NAME_ORDER=new NameOrderComparator();
		
		private static class NameOrderComparator implements Comparator<Data>{
			public int compare(Data d1,Data d2){
				return d1.name.compareTo(d2.name);
			}
		}
	}
	
	//メニュー列挙型
	enum Menu{
		ADD_FIRST(	"先頭にノードを挿入"),
		ADD_LAST(	"末尾にノードを挿入"),
		RMV_FIRST(	"先頭ノードを削除"),
		RMV_LAST(	"末尾ノードを削除"),
		RMV_CRNT(	"着目ノードを削除"),
		CLEAR(		"全ノードを削除"),
		SEARCH_NO(	"番号で探索"),
		SEARCH_NAME("名前で探索"),
		NEXT(		"着目ノードを進める"),
		PRINT_CRNT(	"着目ノードを表示"),
		DUMP(		"全ノードを表示"),
		TERMINATE(	"終了");
		
		private final String message;		//表示用文字列
		
		static Menu MenuAt(int idx){		//序数がidxである列挙を返す
			for(Menu m:Menu.values())
				if(m.ordinal()==idx)
					return m;
			return null;
		}
		
		Menu(String string){				//コンストラクタ
			message=string;
		}
		
		String getMessage(){
			return message;
		}
	}
	
	//メニュー選択
	static Menu SelectMenu(){
		int key;
		do{
			for(Menu m:Menu.values()){
				System.out.printf("(%d) %s ",m.ordinal(),m.getMessage());
				if((m.ordinal()%3)==2&&m.ordinal()!=Menu.TERMINATE.ordinal())
					System.out.println();
			}
			System.out.print(":");
			key=stdIn.nextInt();
		}while(key<Menu.ADD_FIRST.ordinal()||key>Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args){
		Menu menu;				//メニュー
		Data data;				//追加用データ参照
		Data ptr;				//探索用データ参照
		Data temp=new Data();	//読み込み用データ
		
		LinkedList<Data>list=new LinkedList<Data>();		//リストを生成
		
		do{
			switch(menu=SelectMenu()){
				case ADD_FIRST:			//先頭にノードを挿入
					data=new Data();
					data.scanData("先頭に挿入",Data.NO|Data.NAME);
					list.addFirst(data);
					break;