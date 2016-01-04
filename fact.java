//階乗を求めるプログラム
public class fact {
  static int fact(int n){//再帰プログラムの使用
    return n == 0 ? 1 : n * fact(n - 1);
  }

  public static void main(String[] args){
    for(int i = 0; i < 13; i++){
      System.out.println(i + " : " + fact(i));
    }
  }
}