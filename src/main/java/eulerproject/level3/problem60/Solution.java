package eulerproject.level3.problem60;

import eulerproject.tools.primes.PrimesSet;
import eulerproject.tools.subsets.FixedSubSetImpl4;
import eulerproject.tools.subsets.FixedSubSetImpl5;
import eulerproject.tools.subsets.ParralellFixedSubSet;

import java.time.DateTimeException;
import java.time.LocalTime;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Lukasz on 2016-09-25.
 */
public class Solution {

    private static PrimesSet primes;
    private static int MAX_PRIME = 1000000;
    private static int MAX = 400;
    private static int NUM_THREADS = 100;

    static {
        primes = new PrimesSet(MAX_PRIME);
        System.out.println("Primes initiated. " + primes.getSet().size() + " " + primes.getMax());
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);
        int chunkSize = MAX/NUM_THREADS;

        for(int i =0;i<NUM_THREADS;i++)    {
//            System.out.println("Starting " + i + " thread with min= "+chunkSize*i+" max=" +chunkSize*(i+1) );
            new Thread(new MyTask(chunkSize*i,chunkSize*(i+1),MAX)).start();
        }
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
            ParralellFixedSubSet<Integer> fixedSubSet = new FixedSubSetImpl4<>();
            fixedSubSet.generate(primes.getSet(),new Problem60Listener(primes), min,max, size);

        }
    }

}
