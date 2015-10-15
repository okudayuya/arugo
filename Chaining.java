//チェイン法
public class Chaining {

    //キー
    class Key {

        // キー文字列 
        String str;

        public Key(String s) {
            this.str = s;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj != null && obj instanceof Key) {
                return this.str.equals(((Key)obj).str);
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int sum = 0;
            for(int i=0, len=str.length(); i<len; i++) {
                sum += (int)str.charAt(i);
            }
            return sum;
        }

        @Override
        public String toString() {
            return str;
        }
    }

    //連結リストのセル
    private class Cell {

        // キー 
        Key key;
        // データ 
        String data;
        //次のセル
        Cell next;

        private Cell(Key key, String data) {
            this.key = key;
            this.data = data;
        }
    }

    // データを格納するハッシュ表
    Cell[] table;
    // ハッシュ表のサイズ
    int bucketSize;
    // table に登録されているデータの個数 
    int elementSize;

    // デフォルトのハッシュ表のサイズ 
    static final int DEFAULT_BUCKET_SIZE = 50;

    // コンストラクタ
    public Chaining() {
        this(DEFAULT_BUCKET_SIZE);
    }

    // コンストラクタ @param bucketSize ハッシュ表のサイズ/
    public Chaining(int bucketSize) {
        this.table = new Cell[bucketSize];
        this.bucketSize = bucketSize;
        this.elementSize = 0;
    }

    // ハッシュコード @param key キー @return 与えられたキーのハッシュコードをハッシュ表のサイズで割った余りを返す
    private int hash(Key key) {
        return key.hashCode() % this.bucketSize;
    }

    // 検索 @param key キー @return キーに対応するデータ（登録されていない場合は null）
    public String find(String key) {
        return this.find(new Key(key));
    }
    // 検索 @param key キー @return キーに対応するデータ（登録されていない場合は null
    public String find(Key key) {
        for(Cell cell=this.table[hash(key)]; cell!=null; cell=cell.next) {
            if(key.equals(cell.key)) {
                return cell.data;
            }
        }
        return null;
    }

    // 登録 @param key キー @param data データ @return true：成功・false：既に同じキーが登録されている場合
    public boolean insert(String key, String data) {
        return this.insert(new Key(key), data);
    }
    // 登録 @param key キー @param data データ @return true：成功・false：既に同じキーが登録されている場合
    public boolean insert(Key key, String data) {
        if(find(key) != null) {
            return false;
        }

        Cell cell = new Cell(key, data);
        int hash = hash(key);
        cell.next = this.table[hash];
        this.table[hash] = cell;
        elementSize++;
        return true;
    }

    // 削除 @param key キー @return  true：成功・false：キーが登録されていない場合
    public boolean delete(String key) {
        return this.delete(new Key(key));
    }
    // 削除 @param key キー @return  true：成功・false：キーが登録されていない場合
    public boolean delete(Key key) {
        int hash = hash(key);
        if(this.table[hash] == null) {
            return false;
        }

        // リストの先頭
        if(key.equals(this.table[hash].key)) {
            Cell cell = this.table[hash];
            this.table[hash] = cell.next;
            elementSize--;
            return true;
        }

        // リストの 2 番目以降のセル
        for(Cell cellq=this.table[hash], cellp=cellq.next; cellp!=null; cellq=cellp, cellp=cellp.next) {
            if(key.equals(cellp.key)) {
                cellq.next = cellp.next;
                elementSize--;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< this.bucketSize; i++) {
            sb.append("バケット: ").append(i).append(", ");
            for(Cell cell=table[i]; cell!=null; cell=cell.next) {
                sb.append("[key: ").append(cell.key).append(", data: ").append(cell.data).append("]");
            }
            sb.append("\n");
        }
        sb.append("要素の個数: ").append(this.elementSize);
        return sb.toString();
    }

    // 実行 @param args
    public static void main(String[] args) {


        Chaining hash = new Chaining(15);

        // 登録
        System.out.println("登録");
        String[] words = new String[]{"one", "two", "three", "four", "five", "one", "six", "seven", "eight", "nine", "ten"};
        for(int i=0, len=words.length; i<len; i++) {
            if(hash.insert(words[i], "登録順： " + (i+1))) {
                System.out.println("登録成功： " + (i+1) + "番目　" + words[i]);
            } else {
                System.out.println("登録失敗： 既に同じキーのデータが登録されています．　" + (i+1) + "番目　" + words[i]);
            }
        }
        System.out.println(hash.toString());
        System.out.println();

        // 検索
        System.out.println("検索");
        String[] keys1 = new String[]{"ten", "one", "ones"};
        String result;
        for(int i=0, len=keys1.length; i<len; i++) {
            result = hash.find(keys1[i]);
            if(result != null) {
                System.out.println("検索成功： [key: " + keys1[i] + ", data: " + result + "]");
            } else {
                System.out.println("検索失敗：見つかりませんでした．　[key: " + keys1[i] + "]");
            }
        }
        System.out.println(hash.toString());
        System.out.println();

        // 削除
        System.out.println("削除");
        String[] keys2 = new String[]{"ten", "tens"};
        for(int i=0, len=keys2.length; i<len; i++) {
            if(hash.delete(keys2[i])) {
                System.out.println("削除成功： [key: " + keys2[i] + "]");
            } else {
                System.out.println("削除失敗：キーが登録されていません．．　[key: " + keys2[i] + "]");
            }
        }
        System.out.println(hash.toString());
        System.out.println();
    }
}