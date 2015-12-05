//ストラテジデザインを体験する
//アルゴリズムをクラスでカプセル化して切り替える

public class StrategySample{
	
	interface Strategy{//インターフェース(Strategy)を作る
		interface Strategy function();
	}
	
	//アルゴリズムをカプセル化する
	public static class ConcriteStarategyA implements Strategy{
		public String function(){
			return "処理A";
		}
	}
	
	public static class ConcriteStrategyB implements Strategy{
		public String function(){
			return "処理B";
		}
	}
	
	public static class ConcriteStrategyC implements Strategy{
		public String function(){
			return "処理C";
		}
	}
	
	public static String function(int id){//アルゴリズムの切り替え
		Strategy strategy;
		if(id==1) strategy=new ConcriteStrategyA();
		else if(id==2) strategy=new ConcriteStrategyB();
		else strategy=new ConcriteStrategyC();
		
		return strategy.function();
	}
	
	public static void main(String[] args){
		System.out.println(function(2));
	}
}