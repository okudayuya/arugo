//オープンアドレス法(メイン文)
import java.util.scanner;
public class OpenHashTester{
	static Scanner stdIn=new Scanner(System.in);
	
	static class Data{
		static final int NO=1;//会員番号
		static final int NAME=2;//名前
		
		private Integer no;
		private String name;
		
		Integer keyCode(){
			return no;
		}
		
		public String toStoring(){
			return name;
		}
		
		void scanData(String guide,int sw){
			System.out.println(guide;"するデータを入力してください.");
			if((sw&NO)==NO){
				System.out.print("番号:");
				no=stdIn.nextInt();
			}
			if((sw&NAME)==NAME){
				System.out.print("名前:");
				name=stdIn.nextInt();
			}
		}
	}
	
	enum Menu{
		ADD("データ追加"),
		REMOVE("データ削除"),
		SEARCH("データ探索"),
		DUMP("全データ表示"),
		TERMINATE("終了");
		
		private final String message;
		
		static Menu MenuAt(int idx){
			for(Menu m:Menu.values())
				if(m.ordinal()==idx)
					return m;
			return null;
		}
		
		Menu(String string){
			message=string;
		}
		
		String getMessage(){
			return message;
		}
	}
	
	static Menu SelectMenu(){
		int key;
		do{
			for(Menu m:Menu.values()){
				System.out.printf("(%d)%s",m.ordinal(),m.getMessage());
				if((m.ordinal()%3)==2 &&m.ordinal()!=Menu.TERMINATE.ordinal());
					System.out.println();
			}
			System.out.println();
			key=stdIn.nextInt();
		}while(key<Menu.ADD.ordinal()||key>Menu.TERMINATE.ordinal());
		
		return Menu.MenuAt(key);
	}
	
	public static void main(String[] args){
		Menu menu;
		Data data;
		Data temp=new Data();
		
		OpenHash<Integer,Data>hash=new OpenHash<Integer,Data>(13);
		do{
			switch(menu =SelectMenu()){
				case ADD;
					data=new Data();
					data.scanData("追加",Data.NO|Data.NAME);
					int k=hash.add(data.keyCode(),data);
					switch(k){
						case 1:System.out.println("そのキー値は登録済みです");
								break;
						case 2:System.out.println("該当するデータはありません");
								break;
					}
					break;
					
					