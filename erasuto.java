public class erasuto{
    public static void main(String[] args)
    {
        // 0 から n-1 までの整数について求める
        int n = 1000;

        
        // 素数ならば true になる真偽変数の配列を用意する
        boolean[] isprime = new boolean[n];
        int i, k;
        
        // 初期化する(0, 1 を除く全ての自然数を素数と仮定する
        isprime[0] = false; isprime[1] = false;
        for (i = 2; i < n; i++)
            isprime[i] = true;
        
        // エラトステネスのふるい
        for (k = 2; k*k < n; k++){
            // 素数の2倍から順に「消して」いく。
            if (isprime[k])
                for (i = k*2; i < n; i += k)
                    isprime[i] = false;
        }
        
        // 素数のみ表示する
        for (i = 2; i < n; i++)
            if (isprime[i])
                System.out.printf("%d, ", i);
    }
}