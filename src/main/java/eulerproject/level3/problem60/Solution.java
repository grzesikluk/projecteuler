package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {

    private static PrimesSet primes;
    private static ArrayList<Integer> primesArray;
    private static int MAX_PRIME = 300000000;
    private static int MAX = 300;
    private static int NUM_THREADS = 100;


    static {
        primes = new PrimesSet(MAX_PRIME);
        primesArray = new ArrayList<>(primes.getSet().stream().collect(Collectors.toList()));

        System.out.println("Primes initiated. " + primesArray.size() );
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        int chunkSize = MAX/NUM_THREADS;

        for(int i =0;i<NUM_THREADS;i++)
            new Thread(new MyTask(chunkSize*i,chunkSize*(i+1),MAX)).start();

        System.out.println("Threads started "+ LocalTime.now());

    }


    static class MyTask implements Runnable {
        int min, max, size;


        MyTask(int min, int max, int size) {
            this.min = min;
            this.max = max;
            this.size = size;
        }

        @Override
        public void run() {
            ParralellFixedSubSetProblem60<Integer> fixedSubSet = new BruteForceSubsetImpl<>();
            fixedSubSet.generate(primesArray ,new Problem60Listener(), min,max, size);

        }
    }

}
