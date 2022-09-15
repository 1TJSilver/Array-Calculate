
import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class ArraySum extends RecursiveTask<Integer> {
    private int[] array;

    public ArraySum(int[] array){
        this.array = array;
    }

    @Override
    protected Integer compute() {
        if (array.length <= 30){
            return Arrays.stream(array).sum();
        }
        ArraySum firstHalf = new ArraySum(Arrays.copyOfRange(array, 0, array.length/2));
        ArraySum secondHalf = new ArraySum(Arrays.copyOfRange(array, array.length/2, array.length));
        firstHalf.fork();
        secondHalf.fork();
        return firstHalf.join() + secondHalf.join();
    }
}
