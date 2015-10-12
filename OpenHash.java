//ハッシュ　オープンアドレス法
public class OpenHash<K,V>{
	//パケットの状態
	enum Status {OCCUPIED,EMPTY,DELETED};//{データ格納,空,削除済み}
	
	//パケット
	static class Bucket<K,V>{
		private K key;		 //キー値
		private V data;		 //データ
		private Status stat;//状態
	}
	
	//コンストラクタ
	Bucket(){
		stat=Status.EMPTY;//パケットは空
	}
	
	//全フィールドに値を設定
	void set(K key,V data,Status start){
		this.key=key;	//キー値
		this.data=data; //データ
		this.stat		//状態
	}
	
	//状態を設定
	void setStat(Status stat){
		this.stat=stat;
	}
	
	//キー値を返す
	K getKey(){
		return key;
	}
	
	//データを返す
	V getValue(){
		return data;
	}
	
	//キーのハッシュ値を返す
	public int hashCode(){
		return key.hashCode();
	}
}

private int size;				//ハッシュ表の大きさ
private Bucket<K,V>[] table;	//ハッシュ表

//コンストラクタ
public OpenHash(int size){
	try{
		table=new Bucket[size];
		for(int i=0;i<size;i++)
			table[i]=new Bucket<K,V>();
		this.size=size;
	}catch (OutOfMeoryError e){	//表が生成できなかったとき
		this.size=0;
	}
}
//ハッシュ値を求める
public int hashValue(Object key){
	return key.hashCode() % size;
}

//再ハッシュ値を求める
public int rehashValue(int hash){
	return (hash+1)%size;
}

//キー値keyを持つパケットの探索
private Bucket<K,V> serachNode(K key){
	int hash=hashValue(key);	//探索するデータのハッシュ値
	Bucket<K,V>p=table[hash];	//着目パケット
	
	for(int=i;p.stat !=Status.EMPTY&&i<size;i++){
		if(p.stat==Status.OCCUPIED&&p.getkey().equals(key))
			return p;
		hash=rehashValue(hash);	//再ハッシュ
		p=table[hash];
	}
	return null;
}

//キー値key・データdataを持つ要素の追加
public int add(K key,V data){
	if(search(key)!=null)
		return 1;				//キー登録済みのキー
		
	int hash=hashValue(key);	//追加するデータのハッシュ値
	Bucket<K,V>p=table[hash];	//着目するパケット
	for(int i=0;i<size;i++){
		if(p.stat==Status.EMPTY||p.stat==Status.DELETED){
			p.set(key,data,Status.OCCUPIED);
				return 0;
		}
		hash=rehashValue(hash);	//再ハッシュ
		p=table[hash];
	}
	return 2;
}

//キー値のkeyを持つ要素の削除
public int remove(K key){
	Bucket<K,V>p=searchNode(key);//着目パケット
	if(p==null)
		return 1;				 //このキー値は登録されていない
	
	p.setstat(Status.DELETED);
	return 0;
}
	