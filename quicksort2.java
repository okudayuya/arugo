//クイックソート(非再帰版)
	static void quicksort2(int[] a,int left,int right){
		IntStack lstack=new IntStack(right-left+1);//スタックの生成
		IntStack rstack=new IntStack(rghit-left+1);//スタックの生成
		
		lstack.push(left);
		rstack.push(right);
		
		while(lstack.isEmpty() !=true){
			int pl=left=lstack.pop();		//左カーソル
			int pr=right=rstacl.pop();		//右カーソル
			int x=a[(left+right)/2];		//枢軸は中央の要素
			
			do{
				while(a[pl]<x) pl++;
				while(a[pr]>x) pr--;
				if(pl<=pr)
					swap(a,pl++,pr--);
			}while(pl<=pr);
			
			if(left<pr){
				lstack.push(left);
				rstack.push(pr);
			}
			if(pl<right){
				lstack.push(pl);
				rstack.push(right);
			}
		}
	}