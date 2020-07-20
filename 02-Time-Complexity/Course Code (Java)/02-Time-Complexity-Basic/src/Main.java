public class Main {

    public static void main(String[] args) {

      
        for( int x = 1 ; x <= 9 ; x ++ ){

            int n = (int)Math.pow(10, x);

            long startTime = System.currentTimeMillis();

            long sum = 0;
            for( int i = 0 ; i < n ; i ++ )
                sum += i;

            long endTime = System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^" + x + " : " + (endTime - startTime) + " ms");
            System.out.println("");
        }
    }
}
