//順列の生成
public class perm0 {
  public static void main(String[] args){
    int[] perm = new int [4];
    boolean[] flag = new boolean [5];
    // 一つ目の数字を選ぶ
    for(int n1 = 1; n1 <= 4; n1++){
      if(flag[n1]) continue;
      perm[0] = n1;
      flag[n1] = true;
      // 二つ目の数字を選ぶ
      for(int n2 = 1; n2 <= 4; n2++){
        if(flag[n2]) continue;
        perm[1] = n2;
        flag[n2] = true;
        // 三つ目の数字を選ぶ
        for(int n3 = 1; n3 <= 4; n3++){
          if(flag[n3]) continue;
          perm[2] = n3;
          flag[n3] = true;
          // 四つ目の数字を選ぶ
          for(int n4 = 1; n4 <= 4; n4++){
            if(flag[n4]) continue;
            perm[3] = n4;
            flag[n4] = true;
            // 順列を出力
            for(int n: perm){
              System.out.print(n + " ");
            }
            System.out.println();
            flag[n4] = false;
          }
          flag[n3] = false;
        }
        flag[n2] = false;
      }
      flag[n1] = false;
    }
  }
}