class bm{
	//検索パターン
	String pat=null;
	//パターンのサイズ
	int size=0;
	//φテーブル：ジャンプテーブル(1)
	//「照合に失敗した時にカーソルが指している文字」の関数
	int phi[] = new int[26];

	bm(String pattern){
		pat = pattern;
		size = pat.length();
		
		//φテーブル生成
		for(int i=0;i<26;i++){
			phi[i] = size;
		}
		for(int i=0;i<=size;i++){
			phi[(int)(pat.charAt(i))-'a'] = size-i-1;
		}
	}
	
	public int match(String str){
		int index = size-1;
		int k=1;
		int s_size=str.length();
		int pro=0;
		if(size>s_size)return -1;
		while(index<s_size){
			//末尾の文字と照合する
			if(str.charAt(index)==pat.charAt(size-1)){
				//末尾から逆に順次照合していく
				while(k<size && str.charAt(index-k)==pat.charAt(size-k-1))k++;
				//一致したらindex-size+1を返す
				if(k==size)return index-size+1;
				//照合失敗したらカーソルをシフト
				else{
					pro = (int)str.charAt(index-k)-'a';
					if(pro < 0 || pro > 25)index+=size;
					else if(phi[pro]>k)index+=phi[pro]+k;
					else index++;
				}
			}
			else {
				pro = (int)str.charAt(index)-'a';
					if(pro < 0 || pro > 25)index+=size;
					else index+=phi[pro];
				}
		}
		return -1;
	}
	
	public String toString(){
		String str="";
		for(int i=0;i<26;i++){
			str += (char)('a'+i) + ":" + phi[i] + ",";
			if(i==12)str += "\n";
		}
		str += "\b";
		return str;
	}
}

class bmDemo{
	public static void main(String args[]){
		bm x = new bm(args[0]);
		System.out.println(x.match(args[1]));
	}
}