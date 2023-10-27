public class Main {
    public static void main(String[] args) {


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
