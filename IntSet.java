﻿//int型の集合
public class IntSet{
	private int max;	//集合の容量
	private int num;	//集合の要素数
	private int[] set;	//集合本体
	
	//コンストラクタ
	public class IntSet(int capacity){
		num=0;
		max=capacity;
		try{
			set=new int[max];				//集合本体用の配列を作成
		}
		catch (OutOfMemoryError e){			//配列の作成に失敗
			max=0;
		}
	}
	
	//集合化からnを探してインデックス(見つからなければ-1)を返す
	public int indexOf(int n){
		for(int i=0;i<num;i++)
			if(set[i]==n)
				return i;	//含まれる
		return -1;			//含まれない
	}
	
	//集合nに入っているか
	public boolean contains(int n){
		return(indexOf(n) !=-1)? true:false;
	}
	
	//集合にnを追加
	public boolean add(int n){
		if(num>=max||contains(n)==true)		//満杯or nが含まれている
			return false;
		else{
			set[num++]=n;					//末尾に追加
			return true;
		}
	}
	
	//集合からnを削除
	public boolean remove(int n){
		int idx;					//nが格納されている要素のインデックス
		
		if(num<=0||(idx=indexOf(n))==-1)//空or　nが含まれていない
			return false;
		else{
			num--;
			for(int i=idx;i<num;i++)	//set[idx]を削除して
				set[i]=set[i+1];		//それ以降の要素をずらす
			return true;
		}
	}
	
	//集合の容量
	public int capacity(){
		return max;
	}
	
	//集合の要素数
	public int size(){
		return num;
	}
	
	//集合sにコピー
	public void copyTo(IntSet s){
		int n=(s.max<num)?s.max:num;	//コピーする要素
		for(int i=0;<n;i++)
			s.set[i]=set[i];
		s.num=n;
	}
	
	//集合sをコピー
	public void copyFrom(IntSet s){
		int n=(max<s.num)? max:s.num;	//コピーする要素
		for(int i=0;i<n;i++)
			set[i]=s.set[i];
		num=n;
	}
	
	//集合sと等しいか
	public boolean equailTo(IntSet s){
		if(num!=s.num)					//集合要素が等しくない
			return false;				//集合も等しくない
		
		for(inti=0;i<num;i++){
			int j=0;
			for(;j<s.num;j++)
				if(set[i]==s.set[j])
					break;
			if(j==s.num)				//set[i]はsに含まれない
				return false;
		}
		return true;
	}
	
	//集合s1とs2の和集合をコピー
	public void unionOf(IntSet s1,IntSets2){
		copyFrom(s1);					//集合s1をコピー
		for(int i=0;i<s2.num;i++)		//集合s2をコピー
			add(s2.set[i]);
	}
	
	//"{a b c}"形式の文字列表現に変換
	public String toString(){
		StringBuffer temp=new StringBuffer("{");
		for(int i=0;i<num;i++)
			temp.append(set[i]+" ");
		temp.append("}");
		return temp.toString();
	}
}