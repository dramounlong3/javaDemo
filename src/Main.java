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


    }
}