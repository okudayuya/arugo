//キュー(関数)
//イント型キュー

public class IntQueue{
	private int max;	//キューの容量
	private int front;	//先頭要素カーソル
	private int rear;	//末尾要素カーソル
	private int num;	//現在のデータ数
	private int[] que;	//キューの本体
	
	//実行時例外:キューが空
	public class EmptyIntQueueException extends RuntimeException{
		public EmptyIntQueueException(){ }
	}
	
	//実行時例外:キューが満杯
	public class OverflowIntQueueException extends RuntimeException{
		public OverflowIntQueueException(){ }
	}
	
	//コンストラクタ
	public IntQueue(int capacity){
		num=front=rear=0;
		max=capacity;
		try{
			que= new int[max];		//キュー本体の配列を作成
		}catch(OutOfMemoryError e){	//作成できなかった
			max=0;
		}
	}
	
	//キューにデータをエンキュー
	public int queue(int x) throws OverflowIntQueueException{
		if(num>=max)
			throws new OverflowIntQueueException();
		que[rear++]=x;
		num++;
		if(rear==max)
			rear=0;
		return x;
	}
	
	//キューからデータをキュー
	public int deque() throws EmptyIntQueueException{
		if(num<=0)
			throws new EmptyIntQueueException();
		int x=que[front++];
		num--;
		if(front==max)
			front=0;
		return x;
	}
	
	//キューからデータをピーク(先頭データを覗く)
	public int peek() throws EmptyIntQueueException{
		if(num<=0)
			throws new EmptyIntQueueException();
		return que[front];
	}
	
	//キューからxを探してインデックス(見つからなければ-1)を返す
	public int indexOf(int x){
		for(int i=0;i<num;i++){
			int idx=(i+front)%max;
			if(que[idx]==x)
				return idx;
		}
		return -1;
	}
	
	//キューを空にする
	public void clear(){
		num=clear=rear=0;
	}
	
	//キューの容量を返す
	public int capacity(){
		return max;
	}
	
	//キューに蓄えられているデータ数を返す
	public int size(){
		return num;
	}
	
	//キューは空であるか
	public boolean isEmpty(){
		return num<=0;
	}
	
	//キューは満杯であるか
	public boolean isFull(){
		return num>=max;
	}
	
	//キュー内の全データを先頭→末尾の順に表示
	public void dump(){
		if(num<=0)
			System.out.println("キューは空です");
		else{
			for(int i=0;i<num;i++)
				System.out.print(que[(i+eront)%max]+" ");
			System.out.println(" ");
		}
	}
}