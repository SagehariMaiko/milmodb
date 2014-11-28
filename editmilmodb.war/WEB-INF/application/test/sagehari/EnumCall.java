package sagehari;

public class EnumCall {
    /**
     * メイン処理
     * @param arg
     */
    public static void main(String arg[]) {
        // 文字列"1"からenumに変換しています。
        SampleEnum enuma1 = SampleEnum.getEnum("1");
 
        if (enuma1.equals(SampleEnum.AAA)) {
            System.out.println("取得したenum型：" + enuma1.toString());
        }
 
        // 文字列からenumに変換出来ない場合はnullになります。
        SampleEnum enuma2 = SampleEnum.getEnum("3");
        System.out.println("取得出来ない場合はnullが返却されます。：" + enuma2);
    }
    /**
     * enumクラス
     */
    public enum SampleEnum {
 
        AAA("1"),
        BBB("2");
 
        // メンバ変数の定義
        // このメンバ変数は必須です。
        private String name;
 
        /**
         * このメソッドも必須です。
         * @return enum型のvalue部分を返却します。
         */
        public String getName() {
            return name;
        }
 
        // コンストラクタの実装
        private SampleEnum (String name) {
          this.name = name;
        }
 
        // メソッドのオーバーライド
        public String toString() {
          return name;
        }
 
        /**
         * このメソッドは、文字列を元に、enumを返却します。
         * 例えば、値に1を指定すると、AAA(enum)を返却します。
         * @param str
         * @return
         */
        public static SampleEnum getEnum(String str) {
            // enum型全てを取得します。
            SampleEnum[] enumArray = SampleEnum.values();
 
            // 取得出来たenum型分ループします。
            for(SampleEnum enumStr : enumArray) {
                // 引数とenum型の文字列部分を比較します。
                if (str.equals(enumStr.name.toString())){
                    return enumStr;
                }
            }
            return null;
        }
    }
    
}
