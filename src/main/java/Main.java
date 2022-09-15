import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {
    public static void main(String[] args) {
        int[] array = getRandomArray(100_000_000);
        System.out.println(System.currentTimeMillis());
        ArraySum arraySum = new ArraySum(array);
        ForkJoinPool pool = new ForkJoinPool();
        System.out.println(pool.invoke(arraySum));
        System.out.println(System.currentTimeMillis());
        System.out.println(calculate(array));
        System.out.println(System.currentTimeMillis());
    }
    public static int[] getRandomArray(int size){
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10);
        }
        return arr;
    }
    public static int calculate(int[] arr){
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += arr[i];
        }
        return result;
    }
}
