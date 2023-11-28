import myMath.CalAdd;
import myMath.CalMul;
import myMath.subMath.CalSub;
//import myMath.* ===> 不包含 myMath.subMath.* 若用*載入, 則子套件需要額外載入

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        /* ch1 ~ ch4 */

        byte x1 = 0b111;
        int y1 = 1_000_000; //當數值很長時可以使用底線做區隔
        System.out.println("x= " + x1);
        System.out.println("y= " + y1);

        System.out.printf("int的範圍 %d ~ %d%n", Integer.MIN_VALUE, Integer.MAX_VALUE);

        char ch1 = '\u0041'; //\\u表示 16進制, 以4位數為一組
        System.out.println("\\u0041 = unicode值65 為字元: " + ch1);
        final double PI1 = 3.14159;

        int x2 = 100;
        System.out.printf("x=%10d%n", x2);
        System.out.printf("x=1234567890%n");

        int x3, y3, z3;
        x3 = y3 = z3 = 100; //依序由右向左指定
        System.out.printf("x3= %d, y3= %d, z3= %d", x3, y3, z3);

        int x4, y4, z4;
        x4 = (y4 = 10) + (z4 = 100);
        System.out.println("\nx4= " + x4);

        double f = 25.0 / 3.0;
        System.out.printf("f= %5.2f", f);

        double x5 = Math.pow(2, 3); //2的3次方, 回傳double型態
        System.out.println("\n" + x5);

        double x6 = 100.0 / 0; //結果的型態會是字串
        double y6 = -10.0 / 0; //結果的型態會是字串
        System.out.printf("x6= %s, x6= %s", x6, y6);

        boolean a1 = false;
        int i1 = 5;
        // && 和 & 差異在於，若&&運算子左方已經可以確認結果則右方不會執行
        // && 和 & 差異在於，若&運算子左方已經可以確認結果則右還是會執行
        System.out.println("\n操作 && 結果= " + (a1 && (i1++ == 5)));
        System.out.println("i= " + i1); //因為&&右方沒執行所以 i1 = 5
        System.out.println("操作 & 結果= " + (a1 & (i1++ == 5)));
        System.out.println("i= " + i1); //因為&右方有執行所以 i1 = 6
        // ^ (XOR) 一真一假才是真
        boolean a2 = true;
        boolean b2 = false;
        System.out.println("ture ^ true = " + (a2 ^ a2));
        System.out.println("ture ^ false = " + (a2 ^ b2));

        byte x7, x8;
        // x7 = 128; //超出byte的最大範圍127, 會報錯
        // System.out.println("x7= " + x7);

        x8 = 127; //落在byte的範圍內, 所以可以由int轉byte
        System.out.println("x8= " + x8); //印出來會是10進制

        short a3, b3, c3;
        a3 = 5;
        b3 = 5;
        // c3 = a3 + b3; // 會出錯 int+int 無法變short
        System.out.println("short min= " + Short.MIN_VALUE);

        //強制型態轉換
//        int x9 = 7;
//        int y9 = 2;
//        double z9;
//
//        z9 = x9 / y9;
//        System.out.println("z9= " + z9); // 3.0
//        z9 = (double) x9 / y9; //強制轉double 3.5
//        System.out.println("z9= " + z9);
//        System.out.println("(int)z9= " + (int) z9); // 3 無條件捨去小數位數


        //標準輸出
//        int x10, y10;
//        Scanner scanner = new Scanner(System.in);
//
//        String str1;
//        System.out.print("請輸入姓名: ");
//        str1 = scanner.nextLine(); //接收字串, 若字串含有空白則需以nextLine接受, 若無空白則可單純使用next()接收字串
//        System.out.printf("姓名是: %s\n", str1);
//
//        System.out.print("請輸入兩個整數, 數字間用空白或tab隔開 : " );
//        x10 = scanner.nextInt(); //接收整數
//        y10 = scanner.nextInt();
//        System.out.println("輸入的第一個數字是: " + x10 );
//        System.out.println("輸入的第二個數字是: " + y10 );

        /* ch1 ~ ch4 */

        /* ch5 */
        int x11 = 5;
        switch (x11) {
            case 0:
                System.out.println("x11= 0");
                break;
            case 5:
                System.out.println("x11 = 5");
                break;
            default:
                System.out.println("nothing");
                break;
        }

        // 迴圈標籤 (讓開發者知道會跳到哪裡)
        testlable:
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print("*");
                if (j >= i) {
                    System.out.println(""); //換行
                    continue testlable; //跳到有testlabe的迴圈處, 也可根據實際需求跳到內層迴圈
                }
            }
        }

        //測試質數
//        boolean prime = true;
//        boolean isInt = false;
//        int num1 = 0;
//
//        String tempNum1;
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("請輸入要測試是否為質數的數字: ");
//
//        tempNum1 = scanner.next(); //先用字串接
//
//        //檢測輸入的數字是否是整數, 跟是否>1
//        while (!isInt) { //判斷是否為整數
//            try {
//                num1 = Integer.parseInt(tempNum1); //轉為整數, 若失敗跳到catch重新輸入
//                if (num1 > 1) { //成功則判斷是否>1, 不是就繼續輸入
//                    isInt = true;
//                } else {
//                    System.out.print("請輸入大於1的正整數: ");
//                    tempNum1 = scanner.next();
//                }
//            } catch (Exception e) {
//                System.out.print("請輸入正整數: ");
//                tempNum1 = scanner.next();
//                isInt = false;
//            }
//        }
//
//        //檢查是否為質數, 質數 = 只能被1和自己整除
//        if (num1 == 2)
//            System.out.printf("%d 是質數", num1);
//        else {
//            for (int i = 2; i < num1; i++) {
//                if (num1 % i == 0) { //被1和自己以外的數字整除時表示不為質數
//                    System.out.printf("%d 不是質數", num1);
//                    prime = false;
//                    break;
//                }
//            }
//            if (prime) {
//                System.out.printf("%d 是質數", num1);
//            }
//        }
        //測試質數
        /* ch5 */

        /*ch6*/
        System.out.printf("Math.pow(-1,1)= %15.14f%n\n", Math.pow(-1,1) ); //15個整數 + 14個小數
        System.out.printf("Math.pow(-1,2)= %15.14f%n", Math.pow(-1,2) );
        /*ch6*/

        /*ch8*/
        //8-6-3 java 方法傳遞 陣列, 物件時 為call by reference
        SmallMath smallMath1 = new SmallMath();
        smallMath1.x = 10;
        smallMath1.y = 20;
        System.out.printf("轉換前x= %d, y= %d\n",smallMath1.x, smallMath1.y);
        smallMath1.swap(smallMath1);
        System.out.printf("轉換後x= %d, y= %d\n",smallMath1.x, smallMath1.y);
        //8-6-3

        //8-6-5
        SmallMath smallMath2 = new SmallMath();
        int[] values = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(smallMath2.add(1,3,5));
        System.out.println(smallMath2.add(1,values));
        //8-6-5

        //8-7-4
        SmallMath smallMath3 = new SmallMath();
        smallMath3.printInfo(999);
        //8-7-4

        // 8-8
        //匿名陣列 ==> 若只會用到一次, 則可考慮使用匿名陣列
        int[] data1 = {1,2,3,4,5};                       //未來仍可使用data存取此陣列, 會佔用記憶體資源
        System.out.println(add(data1));
        System.out.println(add(new int[] {1,2,3,4,5})); //匿名陣列, 在此宣告後生命週期即立刻結束, 故不會佔用記憶體資源
        // 8-8

        // 8-9
        //recursive - factorial
        System.out.println(factorial(10));
        // 8-9

        // 8-10-2
        int discNum = 5;
        hannoi(discNum,'A','B','C');
        // 8-10-2
        /*ch8*/

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
        char ch1x = 'A';
        char ch2 = '5';
        char chinese = '中'; //中文屬於字母字元, 其餘一律皆否
        System.out.println("A 是大寫字母: " + Character.isUpperCase(ch1x));
        System.out.println("A 是小寫字母: " + Character.isLowerCase(ch1x));
        System.out.println("A 是字母字元: " + Character.isLetter(ch1x));
        System.out.println("A 是數字字元: " + Character.isDigit(ch1x));
        System.out.println("5 是數字字元: " + Character.isDigit(ch2));
        System.out.println("5 是字母或數字: " + Character.isLetterOrDigit(ch2));
        System.out.println("A 是字母或數字: " + Character.isLetterOrDigit(ch1x));
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

        // 12-4
        // String vs StringBuffer vs StringBuilder
        // 三者皆會配置記憶體
        // String配置後內容於同一記憶體內不能異動 ===> ex: String str = "ABC" => str = "DEF", 實際上str會指向另外一塊含有"DEF"的新記憶體區塊, 原"ABC"R記憶體區塊則待java清理機制回收
        // StringBuffer & StringBuilder配置後內容於同一記憶體仍可異動, 如上例, 於同一記憶體區塊內"ABC"會改為"DEF", 且這兩種物件會有緩衝區, 即除了原本的字串長度外, 預設會另外提供16的長度給使用者擴充, 當擴充的文字超過緩衝區容量時 就會改以 原容量*2+2的方式擴充
        // StringBuffer與StringBuilder的方法完全相同, 差別在於效率 StringBuilder > StringBuffer, 但StringBuilder只能在single thread使用, 若multi thread 都會針對此物件做修改則使用 StringBuffer

        // 12-4-2 StringBuffer
        String str = "明志科技大學";
        StringBuffer bstr = new StringBuffer(str);
        System.out.println("\n字串緩衝區物件內容: " + bstr + "測試");
        System.out.println("字串緩衝區物件長度: " + bstr.length());      //6
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //6 + 16 = 22

        //更改緩衝區容量
        bstr.ensureCapacity(10);                       //因比原本的22小, 所以不會變更, 仍然是22
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //22
        bstr.ensureCapacity(30);                       //變較大時會調整容量, 原容量*2 + 2
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //22 * 2 + 2 = 46

        //更改緩衝區物件長度
        bstr.setLength(8);
        System.out.println("字串緩衝區物件內容: " + bstr + "測試");       //明志科技大學  測試, 變長會在後面多null
        System.out.println("字串緩衝區物件長度: " + bstr.length());      //8
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //22 * 2 + 2 = 46
        bstr.setLength(4);
        System.out.println("字串緩衝區物件內容: " + bstr);               //明志科技, 變短字串就會被刪除
        System.out.println("字串緩衝區物件長度: " + bstr.length());      //4
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //22 * 2 + 2 = 46
        bstr.append("國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國");
        System.out.println("字串緩衝區物件內容: " + bstr);               //明志科技國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國國
        System.out.println("字串緩衝區物件長度: " + bstr.length());      //72
        System.out.println("字串緩衝區物件容量: " + bstr.capacity());    //46 * 2 + 2 = 94, 當append的字串超過原本的緩衝區時, 會自動放大
        // 12-4-2

        // 12-4-3
        String str18 = "Java1";
        char[] ch7 = {'入','門','邁','向','高','手','之','路'};
        char[] ch8 = {'王','者','歸','來'};
        StringBuffer bstr2 = new StringBuffer(str18);
        bstr2.append('4');                  //Java14                            在最後加上字元
        bstr2.append(ch8);                  //Java14王者歸來                     在最後加上字元陣列
        bstr2.insert(6, ch7);         //Java14入門邁向高手之路王者歸來       在index6往後挪 插入 ch7 字元陣列
        bstr2.deleteCharAt(15);       //Java14入門邁向高手之路王歸來         刪除index15字元
        bstr2.delete(15, 17);               //Java14入門邁向高手之路王             刪除index 15 ~ 16的連續字元
        bstr2.append(ch8, 1, 3);  //Java14入門邁向高手之路王者歸來       在最後加上 該字元陣列從index1的地方開始加3個字
        System.out.println(bstr2);

        // 字串反轉
        StringBuffer str21 = new StringBuffer("台灣科技大學");
        System.out.println("字串反轉前: " + str21);
        str21.reverse();
        System.out.println("字串反轉後: " + str21);
        // 12-4-3

        // 12-4-4 字串設定與取代
        StringBuffer bstr3 = new StringBuffer("Java 10入門邁向高手之路王者歸來");
        bstr3.setCharAt(6, '4');            //於index6 將字元0改為4
        bstr3.replace(7,9,"快樂學習");  //於index7-8的文字取代掉, 其餘不變 ==> 入門 取代為 快樂學習
        System.out.println(bstr3);
        // 12-4-4 字串設定與取代

        // 12-4-5 複製子字串, 與12-4-4差異在於 此方式會將原本的字元覆蓋掉
        StringBuffer bstr4 = new StringBuffer("Java 入門邁向高手之路王者歸來");
        char[] ch10 = {'入','門','徹','底','研','究','之','路'};
        bstr4.getChars(7, 11, ch10, 2); // 複製 bstr4的index7 ~ 10, 貼到ch10 index2開始的位置
        System.out.print("ch10: ");
        for(char i:ch10) {
            System.out.print(i); //入門邁向高手之路
        }
        // 12-4-5 複製子字串

        // 12-6 字串陣列
        String[] topSchools = new String[3];
        topSchools[0] = "明志科大";
        topSchools[1] = "台灣科大";
        topSchools[2] = "台北科大";
        System.out.println();
        for(int i = 0; i<topSchools.length; i++){
            System.out.println("science and technology university: " + topSchools[i]);
        }

        //列印出副檔名為java
        String[] files = {"ch1.docx", "ch2.java", "ch3.xlsx", "ch4.java", "ch5.c"};
        for(String s:files) {
            if(s.endsWith("java")) {
                System.out.println(s);
            }
        }
        // 12-6 字串陣列

        // 12 practice
        //計算小龍女出現次數
        String str23 = "小龍女神鵰俠侶是楊過與小龍科女的故事，我喜歡小龍女在古墓的生活片段，小龍女清新脫俗美若天仙。小龍女女小龍小龍女小小小小龍女";
        //String str23 = "小龍女小龍女";
        String[] spStr23 = str23.split("");
        String[] matchStr = {"小","龍","女"};
        int count = 0, pointer1 = 0, pointer2 = 0, tempCount = 0;
        //BigO(n)
        while(pointer1 < str23.length()) {
            //兩個字元相等
            if(spStr23[pointer1].equals(matchStr[pointer2])) {
                tempCount++;
                if (tempCount == matchStr.length) {
                    count++;
                    tempCount=0;
                }
                pointer2++;
                if(pointer2 >= matchStr.length) {
                    pointer2 = 0;
                }
                pointer1++;
            } //兩個字元不相等時, 但該字元 = 比對字元的第一個字元 需額外處理 ex: 小小龍女 vs 小龍女
            else if (spStr23[pointer1].equals(matchStr[0])) {
                tempCount = 0;
                pointer2 = 0;
                pointer1++;
                pointer2++;
                tempCount++;
            } //兩個字元不相等
            else {
                tempCount = 0;
                pointer1++;
                pointer2++;
                if(pointer2 >= matchStr.length) {
                    pointer2 = 0;
                }
            }
        }
        System.out.println("小龍女出現次數: " + count);
        // 12 practice

        // 13-2-1 正規表達式
        //str.matches(String regex) 回傳str是否符合regex正規表達式 true or false
        //str.replace() 在str找到所有的para1字串 or para1字元, 全部以para2字串 or para1字元 取代(兩個參數需同類型), 或者是用指定的位置取代(看參數怎麼放)
        //str.replaceAll(String regex, String replacement)    將str全部符合regex正規表達式的字串用replacement取代
        //str.replaceFirst(String regex, String replacement)  將str第一個符合regex正規表達式的字串用replacement取代

        //判斷一個字元是否為數字
        char ch11 = '8';
        System.out.println("ch11='8' 是否為數字: " + Character.isDigit(ch11)); //true

        //判斷字串是否為1個數字
        String str24 = "8";
        System.out.println("str24=\"8\" 是否為1個數字: " + str24.matches("\\d")); //true

        //判斷字串是否為兩個數字
        String str25 = "88";
        String str26 = "988";
        String str27 = "0911-123-123";
        System.out.println("str25=\"88\" 是否為2個數字: " + str25.matches("\\d\\d")); //true
        System.out.println("str25=\"88\" 是否為2個數字: " + str25.matches("\\d{2}")); //true  --> 另一種寫法, {2}代表 \\d有幾次
        System.out.println("str26=\"988\" 是否為2個數字: " + str26.matches("\\d{2}")); //false, 此例有三個數字
        System.out.println("str27=\"0911-123-123\" 是否為台灣的電話號碼格式: " + str27.matches("\\d{4}-\\d{3}-\\d{3}") ); // - <= 減號非特殊符號, 是在判斷每x位數號碼後是否有 - 的符號
        System.out.println("str27=\"0911-123-123\" 是否為台灣的電話號碼格式: " + str27.matches("(\\d{4})(-\\d{3})(-\\d{3})") ); //同上, 但是以小括號分組, 讓regex條件更清晰, 若需判斷是否含( 則以 => \\(
        // 13-2-1 正規表達式

        // 13-2-6 正規表達式 管道 | ==> OR條件
        //此例可判斷前面2碼的區碼有沒有包含小括號, 都屬於市話
        String str28 = "02-12345678";
        String str29 = "(02)-12345678";
        System.out.println("str28=\"02-12345678\" 是否為市話號碼: " + str28.matches("\\(\\d{2}\\)-\\d{8}|\\d{2}-\\d{8}")); //true
        System.out.println("str28=\"(02)-12345678\" 是否為市話號碼: " + str29.matches("\\(\\d{2}\\)-\\d{8}|\\d{2}-\\d{8}")); //true

        // 13-2-7 正規表達式 問號 ? ==> 可有可無的文字
        String str30 = "02-12345678"; //有區碼
        String str31 = "12345678";    //無區碼
        String pattern1 = "(\\d{2}-)?\\d{8}"; // 小括號內除可分組之外, 若在後面加上問號 表示這組條件可有可無 ==> 意即: 最前面有無  2數字加減號  都無所謂, 但後面一定要有個數字
        System.out.println("str30=\"02-12345678\" 是否為市話: " + str30.matches(pattern1));   //true
        System.out.println("str31=\"12345678\" 是否為市話: " + str31.matches(pattern1));      //true

        // 13-2-8 正規表達式 星號 * ==> 可出現0~多次
        String str32 = "jhonson";
        String str33 = "jhonnason";
        String str34 = "jhonnanananson";
        String str35 = "jhonxxx";
        String pattern2 = "jhon(na)*son"; //表示 jhon ... son  中間可以出現 0~多次的na
        System.out.println("str32=\"jhonson\" 是否符合 jhon(na)*son 條件: " + str32.matches(pattern2));   //true
        System.out.println("str33=\"jhonnason\" 是否符合 jhon(na)*son 條件: " + str33.matches(pattern2));   //true
        System.out.println("str34=\"jhonnanananson\" 是否符合 jhon(na)*son 條件: " + str34.matches(pattern2));   //true
        System.out.println("str35=\"jhonxxx\" 是否符合 jhon(na)*son 條件: " + str35.matches(pattern2));   //false 因為後面沒有jhon後面沒有son

        // 13-2-9 正規表達式 加號 + ==> 可出現1~多次 (最少一次)
        String str36 = "jhonson";
        String str37 = "jhonnason";
        String str38 = "jhonnanananson";
        String str39 = "jhonxxx";
        String pattern3 = "jhon(na)+son"; //表示 jhon ... son  中間可以出現 0~多次的na
        System.out.println("str36=\"jhonson\" 是否符合 jhon(na)+son 條件: " + str36.matches(pattern3));   //false 因為na一次都沒有
        System.out.println("str37=\"jhonnason\" 是否符合 jhon(na)+son 條件: " + str37.matches(pattern3));   //true
        System.out.println("str38=\"jhonnanananson\" 是否符合 jhon(na)+son 條件: " + str38.matches(pattern3)); //false, 因為jhon後面出現多次na後 又多了一個n 導致結尾變 nson
        System.out.println("str39=\"jhonnaxxx\" 是否符合 jhon(na)+son 條件: " + str39.matches(pattern3));   //false 因為後面沒有jhonna後面沒有son

        // 13-2-10 正規表達式 透過大括號 {} 設定比對的次數
        // 以下X可為 表達式 或 字串
        // X?        X出現0至1次
        // X*        X出現0至多次
        // X+        X出現1至多次
        // X{n}      X出現n次
        // X{n,}     X出現n至多次 ==> 實測 逗號後面必須指定數字
        // X{,m}     X出現0至m次  ==> 實測 逗號前面必須指定數字
        // X{n,m}    X出現n至m次

        // 特數字元表
        // .        除換行字元以外的任意字元，但只能代表一個字元
        // \d       0-9的整數
        // \D       非0-9的字元
        // \s       空白、定位、tab、換行、換頁字元
        // \S       非\s之字元
        // \w       數字、字母、底線 之字元 即 [A-Za-z0-9_]
        // \W       非w之字元

        //字元分類
        // [a-z]        意即 a-z的小寫字元
        // [A-Z]        意即 A-Z的大寫字元
        // [aeiouAeiou] 意即 英文的母音字元(大小寫)
        // [2-5]        意即 2-5的整數
        // [^a-z]       意即非a-z的字元, 其他依此類推 ^表示反向的意思

        //sample
        // \\w+         意即 數字、字母、底線 可出現1~多次 ex:wf14w6e54f2f1 符合此條件
        // John\\w*     意即 前面四個字元一定要是John，後面 數字、字母、底線 可出現0~多次 ex:Johnwef1v7kf_fe 符合此條件
        // \\d+         意即 1~多次的0-9數字
        // .ad          意即 ad前面只能有一個非換行字元的任意字元  ex: @ad 符合此條件
        // .*           意即 非換行字元的萬用字元可出現0~多次 ex: fjwijefiojijfkjkdkfkefev24544e51!@_#_%^%__13 符合此條件
        // .*apple.*    意即要查詢的文字是否內文有含apple

        // (son){3,5} 相當於如下的正則條件
        // sonsonson|sonsonsonson|sonsonsonsonson
        String str40 = "son";
        String str41 = "sonson";
        String str42 = "sonsonson";
        String str43 = "sonsonsonson";
        String str44 = "sonsonsonsonson";
        String str45 = "sonsonsonsonsonson";
        String pattern4 = "(son){3,5}"; //要加小括號, 且此判斷只能有son的字串, 前後或中間都不能有其他字元
        System.out.println("str40=\"son\" 是否出現3~5次son " + str40.matches(pattern4));                    //false
        System.out.println("str41=\"sonson\" 是否出現3~5次son " + str41.matches(pattern4));                 //false
        System.out.println("str42=\"sonsonabcdson\" 是否出現3~5次son " + str42.matches(pattern4));          //true
        System.out.println("str43=\"sonsonsonson\" 是否出現3~5次son " + str43.matches(pattern4));           //true
        System.out.println("str44=\"sonsonsononson\" 是否出現3~5次son " + str44.matches(pattern4));         //true
        System.out.println("str45=\"sonsonsonsonsonsonson\" 是否出現3~5次son " + str45.matches(pattern4));  //false

        // 13-5-1 replaceFirst()
        String str46 = "Hello! Java! I love Java.";
        String pattern5 = "Java";
        System.out.println("str46.replaceFirst()= " + str46.replaceFirst(pattern5, "Python")); //Hello! Python! I love Java 單純只取代指定字串
        System.out.println("str46原字串= " + str46);                                                       //Hello! Java! I love Java. (原字串不受影響)
        pattern5 = ".*Java.*";
        System.out.println("str.replaceFirst()= " +  str46.replaceFirst(pattern5, "Python"));  //Python 含有Java字串的整個字串都會被Python取代
        System.out.println("str46原字串= " + str46);                                                       //Hello! Java! I love Java. (原字串不受影響)

        // 13-5-2 replaceAll()
        pattern5 = "Java";
        System.out.println("str46.replaceAll()= " + str46.replaceAll(pattern5, "Python")); //Hello! Python! I love Python 單純只取代指定字串
        System.out.println("str46原字串= " + str46);                                                       //Hello! Java! I love Java. (原字串不受影響)
        pattern5 = ".*Java.*";
        System.out.println("str.replaceAll()= " +  str46.replaceAll(pattern5, "Python"));  //Python 含有Java字串的整個字串都會被Python取代
        System.out.println("str46原字串= " + str46);

        // 13-6-1 正則表達式 基本字串比對
        String str47 = "0952-001-001";
        String str48 = "請撥打 0952-001-001 與之聯繫";
        String pattern6 = "\\d{4}-\\d{3}-\\d{3}";
        String pattern7 = ".*\\d{4}-\\d{3}-\\d{3}.*";
        System.out.println("str47=\"0952-001-001\" 是否符合pattern: \\\\d{4}-\\\\d{3}-\\\\d{3} " + Pattern.matches(pattern6, str47));                       //true
        System.out.println("str48=\"請撥打 0952-001-001 與之聯繫\" 是否符合pattern: \\\\d{4}-\\\\d{3}-\\\\d{3} " + Pattern.matches(pattern6, str48));       //false, 因為前後有其他字元
        System.out.println("str47=\"0952-001-001\" 是否符合pattern: .*\\\\d{4}-\\\\d{3}-\\\\d{3}.* " + Pattern.matches(pattern7, str47));                   //true
        System.out.println("str48=\"請撥打 0952-001-001 與之聯繫\" 是否符合pattern: .*\\\\d{4}-\\\\d{3}-\\\\d{3}.* " + Pattern.matches(pattern7, str48));   //true

        // 13-6-2 正則表達式 字串搜尋
        String msg = "Please call my secretary using 0930-939-939 or 0952-001-008, thank you!";
        String pattern8 = "\\d{4}-\\d{3}-\\d{3}";
        Pattern p = Pattern.compile(pattern8);          //編譯正則表達式
        Matcher m = p.matcher(msg);

        // find傳回true後, 表示有找到, 且group(), start(), end() 會記錄本次找到對應的值, 最終超出範圍時則會斷開迴圈
        while(m.find()) {
            System.out.println(m.group() + " 字串找到了, 起始索引是 " + m.start() + " 終止索引是 " + m.end());
        }

        // 13-6-3 正則表達式 字串取代
        String str49 = "CIA Mark told CIA Linda that secret USB had given to CIA Peter.";
        String pattern9 = "CIA \\w*"; //找到CIA 後的連續字串符合 a-zA-Z0-9_ 的字串 並將其取代為**   (因為\\w後面有* 表示連續的0~多個)

        String replaceStr = "C*A **";
        Pattern p2 = Pattern.compile(pattern9);
        Matcher m2 = p2.matcher(str49);
        System.out.println(m2.replaceFirst(replaceStr)); //C*A ** told CIA Linda that secret USB had given to CIA Peter.
        System.out.println(m2.replaceAll(replaceStr));   //C*A ** told C*A ** that secret USB had given to C*A **.

        String pattern10 = "CIA \\w"; //找到CIA 後的第一個字串符合 a-zA-Z0-9_ 的字串 並將其取代為** (因為\\w後面沒有* 表示1個) ==> 故本次取代是第一個字母 變成 兩個 星號
        Pattern p3 = Pattern.compile(pattern10);
        Matcher m3 = p3.matcher(str49);
        System.out.println(m3.replaceFirst(replaceStr)); //C*A **ark told CIA Linda that secret USB had given to CIA Peter.
        System.out.println(m3.replaceAll(replaceStr));   //C*A **ark told C*A **inda that secret USB had given to C*A **eter.
        // 13

        // ch14 14 繼承
        // 14-1-11 父子類別擁有相同成員變數名稱
        Son son1 = new Son();
        son1.printInfo();

        // 14-2-1 IS-A (繼承), HAS-A (聚合, 組合)
        //可以判斷 ObjectA 是否屬於某一種 ObjectB，換言之可判斷ObjectA是否有繼承ObjectB
        Fish fish = new Fish();
        Bird bird = new Bird();
        Eagle eagle = new Eagle();
        System.out.println("fish is animal? => " + (fish instanceof Animal));   // true
        System.out.println("bird is animal? => " + (bird instanceof Animal));   // true
        // System.out.println("bird is plant? => " + (bird instanceof Plant));  // false --> 實測會報錯
        System.out.println("eagle is animal? => " + (eagle instanceof Animal)); // true
        System.out.println("eagle is animal? => " + (eagle instanceof Bird));   // true

        // 14-3 java class分檔案
        HomeTown homeTown = new HomeTown("徐州","江蘇", "中國");
        Employee employee = new Employee(10, 29, 'F', "周佳", homeTown);
        employee.printInfo();

        // 14-4-6 override
        Creature creature = new Creature();
        Cat cat = new Cat();
        creature.moving();
        cat.moving();

        // 14-6-1 編譯時期多型(靜態多形)、執行時期多形(動態多型)
        //1.編譯時期多型(靜態多形) ==> 編譯時決定的多形，即為一般常用的多形，可以透過參數型態...等 重新定義父類別方法
        //2.執行時期多形(動態多型) ==> 執行時決定的多形，有向上和向下轉型的差別

        // 靜態多形
        Cat1 cat1 = new Cat1();
        cat1.moving();
        cat1.moving("貓可以跳");
        cat1.moving("跳得很高", "Hally");

        // 動態多形 需滿足1.繼承關係 2.子類別有Override父類別的方法 3.父類別變數 參考到 子類別物件(如下的宣告方式) ==> 故父類別必須要先有該方法才可以被此轉型變數呼叫
        Animal1 animal1 = new Cat1(); //宣告Animal1的變數, 但本質是Cat1, 故Cat1向上轉型為Animal1
        animal1.moving(); //貓也可以活動 會呼叫Cat1的moving

        Animal1 animal2 = new Cat1();
        Animal1 animal3 = new Animal1(); //正常宣告, 無法向下轉型
        Cat1 cat1d = (Cat1) animal2;     //需強轉型 ===> animal2(本質是Cat1)向下轉型為Cat1
        //Cat1 cat2d = (Cat1) animal3;   //向下轉型會失敗
        cat1d.moving();                  //貓也可以活動 call Cat1的moving
        //cat2d.moving();

        //靜態綁定 ==> overload
        //動態綁定 ==> override

        // 14-8-1 巢狀類別(Nested classes)有三種: 1.內部類別(inner class), 2.方法類部內別(Method-local inner class), 3.匿名內部類別(Anonymous inner class)
        // 1.inner class
        School school = new School();       //建立外部類別實例
        School.Mis mis = school.new Mis();  //建立內部類別實例   School.Mis mis = School.new Mis()  ==> 用類別建立會錯誤
        System.out.println("inner class 學生人數: " + mis.getStudentNum());

        // 2.method-local inner class
        School1 school1 = new School1();
        school1.college();

        // 3.Anonymous class
        School3 school3 = new School3() {
            final int students = 10000;
            public void getStudentNum() {
                System.out.println("anonymous1 class 學生總人數: " + students);
            }
        };
        school3.getStudentNum();//由上方先建立匿名類別物件變數後再呼叫
        new School3() {
            final int students = 10000;
            //方法名稱不一定要和School3一樣, 可以當作新的class撰寫
            public void getStudentNum123() {
                System.out.println("anonymous2 class 學生總人數: " + students);
            }
        }.getStudentNum123(); //直接由匿名類別呼叫, 如果只呼叫一次可以這麼做, 省建立一個物件

        // ch14 14 繼承

        // ch19 package 套件
            //若於上方使用import myMath.CalAdd; (import package.class) 則此處可以省略myMath
        CalAdd calAdd = new CalAdd();
        int ps1 = calAdd.add(5, 88);
        System.out.println("呼叫package: myMath.CalAdd.add(5, 88): " + ps1);

        //myMath套件底下的另一個類別
        CalMul calMul = new CalMul();
        int ps2 = calMul.mul(3, 2);
        System.out.println("呼叫package: myMath.CalMul.mul(3, 2): " + ps2);

        //子套件
        CalSub calSub = new CalSub();
        int ps3 = calSub.subtract(99, 100);
        System.out.println("package: myMath.subMath.CalSub.subtract(99, 100): " + ps3);

        //修飾子存取權限
        // public:          所有地方皆可使用
        // protected:       本身、同一個套件 或 子類別 可使用
        // (no modifier):   本身、同一個套件 可使用
        // private:         本身 可以使用
        // ch19 package 套件

        // ch20 異常處理
        int x9, x10;
        Scanner scanner1 = new Scanner(System.in);
        System.out.println("請輸入兩個整數, 數字間請用空白隔開");
        try {
            x9 = scanner1.nextInt();
            x10 = scanner1.nextInt();
            System.out.println(x9 + " / " + x10 + " 的結果是: " + (x9 / x10));
        } catch (ArithmeticException | InputMismatchException e) { // | 代表 or 的意思
            System.out.println("輸入錯誤: " + e);
        } catch (RuntimeException e) {
            System.out.println("程式發生runtime異常");
        } finally {
            System.out.println("無論前面發生什麼事此段都會執行");
        }
        System.out.println("try catch結束");
    }

    // 8-8 function
    public static int add(int[] num) {
        int sum = 0;
        for(int x: num)
            sum += x;
        return sum;
    }
    // 8-8 function

    // 8-9 function
    public static int factorial(int fac) {
        if(fac == 1 || fac == 0) {
            return 1;
        }
        return fac * factorial(fac - 1);
    }
    // 8-9 function

    // 8-10-2 function
    public static void hannoi(int discNum, char from, char buffer, char to) {
        if(discNum == 1) {
            System.out.printf("將碟子從 %C ", from);
            System.out.printf("移動到 %C \n", to);
        } else {
            hannoi(discNum - 1, from, to, buffer);
            System.out.printf("將碟子從 %C ", from);
            System.out.printf("移動到 %C \n", to);
            hannoi(discNum - 1, buffer, from, to);
        }
    }
    // 8-10-2 function
}

/*ch8*/
class SmallMath {
    // 8-6-3
    public int x, y;
    void swap(SmallMath B) {
        int temp = B.x;
        B.x = B.y;
        B.y = temp;
    }
    // 8-6-3

    // 8-6-5 y為可變參數(本質是陣列), 可接受多個參數
    int add(int x, int ...y){
        int total = x;
        //foreach格式
        for(int num:y){
            total += num;
        }
        return total;
    }
    // 8-6-5

    // 8-7-4
    int a874 = 10;
    void printInfo(int a874){
        System.out.println("local a874= " + a874);
        System.out.println("member a874= " + this.a874);
    }
    // 8-7-4

}
/*ch8*/

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

// 14-1-11
class Father {
    protected int x = 50;
}

class Son extends Father{
    protected int x = 100;
    public void printInfo() {
        System.out.println("列印父類別 super.x= " + super.x);
        System.out.println("列印 x= " + x);
    }
}
// 14-1-11

// 14-2-1
class Animal {}
class Plant {}
class Fish extends Animal {}
class Bird extends Animal {}
class Eagle extends Bird {}
// 14-2-1

// 14-4-6 override
class Creature {
    public void moving() {
        System.out.println("生物可以移動");
    }
}

class Cat extends Creature{
    @Override //不加override也沒關係, 但建議增加
    public void moving() {
        System.out.println("貓可以跳得很高");
    }
}
// 14-4-6 override

// 14-6-1 overload
class Animal1 {
    public void moving() {
        System.out.println("動物可以活動");
    }
}
class Cat1 extends Animal1{

    @Override //重新定義父類別的moving
    public void moving() {
        System.out.println("貓也可以活動");
    }

    // 多載moving(overload, polymorphism)
    public void moving(String msg) {
        System.out.println(msg);
    }

    // 多載moving(overload, polymorphism)
    public void moving(String msg, String name) {
        System.out.println(name + " 的貓可以 " + msg);
    }
}
// 14-6-1 overload

// 14-8-1
class School {
    int students = 10000;
    class Mis {
        int students_mis = 300;
        public int getStudentNum() {
            return students_mis;
        }
    }
}
// 14-8-1

// 14-8-2
class School1 {
    public void college() {
        int students = 10000;
        class Mis {
            int students_mis = 400;
            public int getStudentNum() {
                return students_mis;
            }
        }

        Mis mis = new Mis();
        System.out.println("method class 學生人數: " + mis.getStudentNum());
    }
}
// 14-8-2

// 14-8-3
class School3 {
    int students = 10000;
    public void getStudentNum() {
        System.out.println("學生總人數: " + students);
    }
}
// 14-8-3
