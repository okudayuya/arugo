//KMPによる文字列探索
	static int kmpMatch(String txt,String pat){
		int pt=1;							//txtをなぞるカーソル
		int pp=0;							//patをなぞるカーソル
		int[] skip=new int[pat.length()+1];	//スキップテーブル
		
		//スキップテーブルの作成
		skip[pt]=0;
		while (pt !=pat.length()){
			if(pat.charAt(pt)==pat.charAt(pp))
				skip[++pt]=++p;
			else if(pp==0)
				skip[++pt]=pp;
			else
				pp=skip[pp];
		}
		
		//探索
		pt=pp=0;
		while(pt !=txt.length()&&pp !=pat.length()){
			if(txt.charAt(pp)==pat.charat(pp)){
				pt++;
				pp++;
			}
			else if(pp==0)
				pt++;
			else
				pp=skip[pp];
		}
		
		if(pp==pat.length()
			return pt-pp;
		return -1;
	}
	