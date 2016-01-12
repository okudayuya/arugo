//局地変数の有効範囲
public class kyokuti {
  public static void main(String[] args){
    int x = 1;
    {
      int y = 2;
      {
        int z = 3;
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
      }
      System.out.println(x);
      System.out.println(y);
      // System.out.println(z);  z は範囲外 (コンパイルエラー)
    }
    System.out.println(x);
    // System.out.println(y);    y は範囲外 (コンパイルエラー)
    // System.out.println(z);    z は範囲外 (コンパイルエラー)
  }
}