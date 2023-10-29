import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        int[][] arr1 = new int[3][5];
        int num = 1;

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = num;
                num++;
                System.out.printf("arr1[%d][%d]= %2d, ", i, j, arr1[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        arr1 = new int[9][9];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                arr1[i][j] = (j + 1) * (i + 1);
                System.out.printf("%d * %d =%2d    ", j + 1, i + 1, arr1[i][j]);
            }
            System.out.println();
        }

        System.out.println("args.length= " + args.length);

        for (int i = 0; i < args.length; i++) {
            System.out.printf("args[%d]= %s     ", i, args[i]);
        }

        int[] data = {5, 6, 8, 9};
        double sum = 0;
        double average, sd, sd2;

        for (int i = 0; i < data.length; i++) {
            sum += data[i];
        }
        average = sum / data.length;

        sum=0;
        for (int i = 0; i < data.length; i++) {
            sum += Math.pow((data[i] - average), 2);
        }
        sd2 = sum / data.length;

        sd = Math.pow(sd2, 0.5);

        System.out.printf("\naverage= %4.2f\n", average);
        System.out.printf("variance= %4.2f\n", sd2);
        System.out.printf("standard deviation= %4.2f\n", sd);


        // 9-3-3 靜態成員初始化
        NBATeam nbaTeam1 = new NBATeam("Curry");
        NBATeam nbaTeam2 = new NBATeam("Durant");
        NBATeam nbaTeam3 = new NBATeam();
        nbaTeam1.output();
        nbaTeam2.output();
        nbaTeam3.output();
        NBATeam.team = "Golden State";
        nbaTeam1.output();
        nbaTeam2.output();
        nbaTeam3.output();
        // 9-3-3 靜態成員初始化

        // 9-3-3-* 實測一般與靜態初始化區塊的建構順序與差異
        new Child();
        System.out.println("------------------------------------------");
        new Child();
        // ***static 和 non-static initial block區別***
        //      類別的靜態成員變數及static block最先執行，依出現的順序執行，僅被執行一次。
        //      static block前有static關鍵字，但non-static block沒有。
        //      static block不論建構了多少實例，只會在第一次建構前執行一次，non-static block則是每次建構都被執行。
        //      static block的順序先於non-static block。
        //      !!!!! static block是在JVM的class loader載入該類別時被執行，non-static block是在建構實例時被執行。 !!!!!
        //      static block僅能存取靜態成員變數及方法，無法存取非靜態成員變數及方法，non-static block可以存取靜態及非靜態的成員變數及方法。
        //      (由於!!!!!的關係)所以parent 1.靜態成員變數 和 2.static block執行後, 會先執行child 1.靜態成員變數 和 2.static block, 再回來執行parent no-static block, parent constructor
        // ***static 和 non-static initial block區別***
        // 9-3-3-* 實測一般與靜態初始化區塊的建構順序與差異

        // 10-2-1 Random()
            double[] ran = new double[10];
            int[] dice = new int[10];
            for(int i = 0; i < ran.length; i++) {
                //產生 0 ~ 0.9 的隨機數字
                ran[i] = Math.random();
                System.out.printf("ran[%d]= %1.2f\n", i, ran[i]);

                //產生 2 ~ 6 的隨機數字, Math.random() * (區間上限 - 區間下限 + 1) + 區間下限
                dice[i] = (int)(Math.random() * (6-2+1)) + 2;
                System.out.printf("dice[%d]= %d\n", i, dice[i]);
            }

            //nexInt, nextDouble...  java有提供隨機產生器, 隨機產生對應型態的數字
            Random rand = new Random();
            int tempInt = rand.nextInt(6) + 1;  // ==> 隨機產生 0 ~ 5, 後面 +1 則變成產生 1 ~ 6
            System.out.println("tempInt= " + tempInt);
        // 10-2-1 Random()

        // 10-2-1 lottery
            int lotteryBuy = 5;                                 //購買張數
            int[] lotteryNum = new int[50];                     //儲存樂透號碼1~49, 因為第0項不使用, 故宣告50的長度
            for(int i = 1; i <= lotteryBuy; i++){               //處理第x組樂透號碼
                for(int j = 1; j < lotteryNum.length; j++) {
                    lotteryNum[j] = j;                        //將樂透號碼1~49分別存在陣列, j = 0 沒有放東西, 方便line:114判斷
                }
                int counter = 1;                                //計算每一組是否已達六個數字
                System.out.printf("第%d組:\t", i);
                while (counter <= 6) {
                    int n = (int) (Math.random() * (49 - 1 + 1)) + 1;   //產生1~49的隨機數字
                    if(lotteryNum[n] == 0) {                        //判斷本組 該數字是否已經產生過
                        continue;
                    }
                    System.out.printf("%d\t", lotteryNum[n]);
                    lotteryNum[n] = 0;                                  //被產生的數字就將其改為 0
                    counter++;
                }
                System.out.println();
            }
        // 10-2-1 lottery

        // 11-1 Date
            Date date = new Date();
            System.out.println("現在系統日期: " + date);
            System.out.println("從 1970/01/01 00:00:00 到建立前2行Date物件的毫秒數: " + date.getTime());
            System.out.println("自 1970/01/01 00:00:00 到程式執行這一段的毫秒數:     " + System.currentTimeMillis());
            System.out.println("從 1970/01/01 00:00:00 到建立前4行Date物件的毫秒數: " + date.getTime()); //證明和前兩行的毫秒數相同

            //猜數字遊戲, 並透過時間方法紀錄總共花的時間
            int target = 51;
            int guess;
            Scanner scanner = new Scanner(System.in);
            long startTime, endTime;
            startTime = System.currentTimeMillis(); //紀錄遊戲開始前的時間
            for(;;) {
                System.out.println("0~99猜一個正整數");
                //guess = scanner.nextInt(); //記錄使用者猜的數字
                  guess = 51;
                if(guess == target) {
                    endTime = System.currentTimeMillis(); //紀錄遊戲結束的時間
                    System.out.println("恭喜猜對!");
                    System.out.println("總共花費的時間(s)= " + ((endTime - startTime)/1000));
                    break;
                }
                System.out.println("答錯了, 請再猜一個數字");
            }
        // 11-1 Date

        // 11-2 java.time.*
            //LocalDate(yyyy-MM-dd), LocalTime(HH:mm:ss.zzz), LocalDateTime(yyyy-MM-ddTHH:mm:ss:zzz)
            LocalDate today = LocalDate.now(); //default yyyy-MM-dd, 取得現在系統日期
            //以下舉例LocalDate有的對應方法, LocalTime和LocalDateTime也有各自的方法
            System.out.println("today= " + today);
            System.out.println("today.getYear()= " + today.getYear());              //2023
            System.out.println("today.getMonth()=  " + today.getMonth());           //OCTOBER
            System.out.println("today.getMonthValue()=  " + today.getMonthValue()); //10
            System.out.println("today.getDayOfWeek()=  " + today.getDayOfWeek());   //SATURDAY
            System.out.println("today.getDayOfMonth()=  " + today.getDayOfMonth()); //28  (10/28)
            System.out.println("today.getDayOfYear()=  " + today.getDayOfYear());   //301 (今年的第301天)
        // 11-2

        // 11-2-4 時間戳
        Instant datetime = Instant.now();
        System.out.println("時間戳: " + datetime); //GMT + 0
        // 11-2-4 時間戳

        // Duration, Period ==> 計算時間差, Duration只接受時間戳為參數, Period只接受LocalDateTime為參數
        Instant time1 = Instant.now();
        Thread.sleep(1000);
        Instant time2 = Instant.now();
        Duration dur = Duration.between(time1, time2);
        System.out.println("time diff = " + dur);
        System.out.println("Days= " + dur.toDays());
        System.out.println("Hours= " + dur.toHours());
        System.out.println("Minutes= " + dur.toMinutes());
        System.out.println("Seconds= " + dur.toSeconds());
        System.out.println("Millis= " + dur.toMillis());
        System.out.println("Nanos= " + dur.toNanos());

        // 12-1
        char ch1 = 'A';
        char ch2 = '5';
        char chinese = '中'; //中文屬於字母字元, 其餘一律皆否
        System.out.println("A 是大寫字母: " + Character.isUpperCase(ch1));
        System.out.println("A 是小寫字母: " + Character.isLowerCase(ch1));
        System.out.println("A 是字母字元: " + Character.isLetter(ch1));
        System.out.println("A 是數字字元: " + Character.isDigit(ch1));
        System.out.println("5 是數字字元: " + Character.isDigit(ch2));
        System.out.println("5 是字母或數字: " + Character.isLetterOrDigit(ch2));
        System.out.println("A 是字母或數字: " + Character.isLetterOrDigit(ch1));
        System.out.println("中是 字母字元: " + Character.isLetter(chinese));

        //測試控制字元
        // \n, \t ...等逸出字元皆屬於控制字元
        System.out.println("\\n 是控制字元: " + Character.isISOControl('\n'));

        //傳回字元於該基底的數字, 若不屬於則回傳-1
        System.out.println("9於16進制底下中所代表的數值: " + Character.digit('9', 16));
        System.out.println("F於16進制底下中所代表的數值: " + Character.digit('F', 16));
        System.out.println("G於16進制底下中所代表的數值: " + Character.digit('G', 16)); //16進位最多只到F
        // 12-1

        // 12-3-1 字串長度, 字串比較
            char[] ch3 = {'台', '灣', '科', '技', '大', '學'};
            char[] ch4 = {'T','A','I','W','A','N','-','T','E','C','H'};
            String str1 = new String(ch3); //str1雖內容與str2相同, 但指向不同的記憶體空間
            String str2 = new String(ch3);
            String str3 = new String(); //建立空字串
        System.out.println("str1 == str2 ? ==> " + (str1 == str2)); //運算式要加括號, 不然會變成str1先上前面的字串後才做相等比較
        str1 = str2; //這會造成st1變成和str2指向相同的記憶體空間
        System.out.println("After expression str1 == str2 ? ==> " + (str1 == str2));
        System.out.println("str3字串長度= " + str3.length());
        System.out.println("str3字串是否為空字串 "+ str3.isEmpty());
        // 12-3-1

        // 12-3-3 字元搜尋, 找不到回傳-1
        String str4 = "Ming-Chi Institute of Technology";
        System.out.println("字元 i 最先出現的位置= " + str4.indexOf('i'));                               //1
        System.out.println("字元 i 最後出現的位置= " + str4.lastIndexOf('i'));                        //13
        System.out.println("字元 i 從index 7起最先出現的位置= " + str4.indexOf('i', 7));      //7
        System.out.println("字元 i 從index 5起最後出現的位置= " + str4.lastIndexOf('i', 12)); //7 表示從 index 0 ~ 12之間, 最後一次出現i的位置在7, 相當於從12開始往前找第一次出現i的位置
        // 12-3-3 字元搜尋

        // 12-3-4 子字串搜尋, 找不到回傳-1
        String str5 = "小龍女神鵰俠侶是楊過與小龍女的故事我最喜歡小龍女在古墓的日子小龍女";
        String subStr5 = "小龍女";
        System.out.println("小龍女最先出現的位置= " + str5.indexOf(subStr5));                  //0  第一次找到小龍女後 回傳 "小"的位置
        System.out.println("小龍女最後出現的位置= " + str5.lastIndexOf(subStr5));              //30 最後一次找到小龍女後 回傳 "小" 的位置
        System.out.println("小龍女最先出現的位置= " + str5.indexOf(subStr5, 15));     //21 從index15開始往後第一次找到小龍女後 回傳 "小"的位置
        System.out.println("小龍女最先出現的位置= " + str5.lastIndexOf(subStr5, 15)); //11 從index15開始往前第一次找到小龍女後 回傳 "小"的位置
        // 12-3-4 子字串搜尋

        // 12-3-4 是否包含子字串
        String str6 = "台灣科技大學";
        String str7 = "台灣";
        System.out.println("台灣科技大學是否包含子字串\"台灣\"= " + str6.contains(str7)); //true
        // 12-3-4 是否包含子字串

        // 12-3-5 擷取"字串"的 子字串 或 字元
        String str8 = "神鵰俠侶是楊過與小龍女的故事";
        System.out.println("str8[2]的字元= " + str8.charAt(2));                          //俠
        System.out.println("str8[5 ~ final]的字串= " + str8.substring(5));      //楊過與小龍女的故事, 沒給endindex預設就會擷取到最後
        System.out.println("str[5 ~ 10]的字串= " + str8.substring(5, 11));               //楊過與小龍女       擷取 str8 [ 5 ~ (11 -1) ] 的字串
        char[] ch = str8.toCharArray();                                                 //將字串 轉為 字元陣列
        System.out.println("列印部分字元= " + ch[0] + ch[1] + ch[2] + ch[3]);             //神雕俠侶, 因為無法用字串str8[0]取得單一字元

        //getChars
        char[] ch5 = new char[15];
        str8.getChars(5, 11, ch5, 3); //從str8擷取index 5 ~ 10 的字元, 複製到 ch5的字元陣列, 並且從ch5[3]的位置開始貼上
        for(char element:ch5){
            System.out.print(element + "\t");
        }
        // 12-3-5 擷取"字串"的 子字串 或 字元

        // 12-3-6 字串取代
        String str9  = "Mjng-Chj Instjtute of Technology";
        String str10 = "Ming-Chi Institute of Technology";
        String str11 = "神雕俠侶是楊過與郭襄的故事";

        System.out.println("\nstr9取代前= " + str9);
        String str9rp = str9.replace('j','i'); //字元j 取代為 i, 取代後不影響原字串
        System.out.println("str9取代後= " + str9);
        System.out.println("str9取代後的回傳值= " + str9rp);
        String str11rp = str11.replace("郭襄", "小龍女");
        System.out.println("str11取代後= " + str11);
        System.out.println("str11取代後的回傳值= " + str11rp);

        //移除字串前後的空白、tab、換行符號
        String str12 = "\t 大俠楊過\t \n";
        String str12trim = str12.trim(); //移除後不影響原字串
        System.out.println("str12移除空白後=" + str12);
        System.out.println("str12移除空白後的回傳值=" + str12trim);
        // 12-3-6 字串取代

        // 12-3-8 字串比較
        char[] ch6 = {'明','志','科','技','大','學'};
        String str13 = new String(ch6);
        String str14 = new String(ch6);

        System.out.println("使用 str13 == str14 判斷: " + (str13 == str14)); // false, 因為記憶體位置不同
        System.out.println("使用 str13.equals(str14) 判斷: " + (str13.equals(str14))); //true 只比較字串內容

        //考慮或不考慮 大小寫 比較字串
        String str15= "A123456";
        String str16= "a123456";
        System.out.println("視大小寫不同為相異的比較結果= " + str15.compareTo(str16));           //-32, 根據兩個字串相比看誰得字元順序大決定要回傳>0或<0的數值, 若等於0則表示兩者相等
        System.out.println("視大小寫不同為相等的比較結果= " + str15.compareToIgnoreCase(str16)); //0

        // startsWith(), endsWith(),  前綴, 後綴
        String str17 = "Ming-Chi Institute of Technology";
        System.out.println("前綴是否為Min: " + str17.startsWith("Min")); //true
        System.out.println("後綴是否為logy: " + str17.endsWith("logy")); //true
        System.out.println("index3 起前綴是否為Min: " + str17.startsWith("Min", 3)); //false, 從index 3開始比較前綴
        System.out.println("index3 前綴是否為g-: " + str17.startsWith("g-", 3));     //false, 從index 3開始比較前綴
        // 12-3-8 字串比較

        // 12-3-9 字串轉換String.valueOf() ==> 可將char, int, long, float, double, boolean型態轉為字串
        char[] str19 = {'明','志','科','技','大','學'};
        System.out.println(String.valueOf(str19));                 //明志科技大學
        String str19vf = String.valueOf(str19, 2,4);    //不影響原字串, 會另外回傳
        System.out.println(String.valueOf(str19, 2,4)); //科技大學
        System.out.println(str19vf);                               //科技大學
        System.out.println("str19轉換後= " + str19[3]);             //技
        // 12-3-9 字串轉換

        // 12-3-10 字串split ==> 將字串透過分隔符號切為 字串陣列
        String str20 = "神雕俠侶 是 楊過 與 小龍女 的故事  !"; //驚嘆號前面有兩個空白
        //System.out.println("str20[2]= " + str20[2]); //在 字串 轉成 字串陣列 之前, 無法用index取得對應字串
        String[] str20sp = str20.split("\\s"); //透過\s 正規表達式的空白 切割, 但若有連續空白則每一組的第二個空白會被切進陣列之中當成空白的字串
        System.out.println("str20.split(\\s)切割後= " + str20sp[2]); //楊過
        for(int i = 0; i < str20sp.length; i++) {
            System.out.printf("str20sp[%d]= %s, ", i, str20sp[i]);
        }


        // 12-3-10 字串split ==> 將字串透過分隔符號切為 陣列
    }
}

// 9-3-3 靜態成員初始化
class NBATeam {
    //static 無this
    public static String team = "Warriors"; //預設值, 但會被下面的初始化區塊覆蓋掉
    public  String name;

    //當初始化預設值較複雜時, 可採用初始化區塊來完成, 可分為一般初始化區塊和靜態初始化區塊
    //靜態成員也可以放在一般初始化區塊, 反之不行
    //一般初始化區塊
    {
        this.name = "default";
    }

    //靜態初始化區塊
    static {
        int a1 = (int)(Math.random()*10);
        int a2 = (int)(Math.random()*10);
        System.out.println("a1: " + a1);
        System.out.println("a2: " + a2);
        if(a1 > a2) {
            team = "Hawks";
        } else if(a1 < a2) {
            team = "76ers";
        } else {
            team = "Bulls";
        }
    }

    public NBATeam () {

    }

    public NBATeam (String name) {
        this.name = name;
    }

    public void output() {
        System.out.println("Team:" + team);
        System.out.println("Name:" + this.name + "\n");
    }
}
// 9-3-3 靜態成員初始化

// 9-3-3-* 實測一般與靜態初始化區塊的建構順序與差異
class Parent {
    private static Foo foo = new Foo("Parent");
    {
        System.out.println("parent non-static block");
    }
    static {
        System.out.println("parent static-block");
    }
    public Parent() {
        System.out.println("Parent() constructor");
    }
}

class Child extends Parent{
    private static Foo foo = new Foo("Child");
    {
        System.out.println("child non-static block");
    }
    static {
        System.out.println("child static block");
    }
    public Child() {
        System.out.println("Child() constructor");
    }
}

class Foo {
    Foo(String str) {
        System.out.println("Foo() is called by " + str);
    }
}
// 9-3-3-*
