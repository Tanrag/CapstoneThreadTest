import java.util.concurrent.*;

public class main
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newFixedThreadPool(100);

        long startTime = System.nanoTime();

        Callable<Integer> task = () -> {
            int count = 0;
            for (int x = 1; x <= 1_000_000_000; x++) 
            {
                count++;
            }
            return count;
        };

        Future<Integer> future = executor.submit(task);

        int total = 0;
        try
        {
            total = future.get();
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }
        
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Duration: " + duration + " ns");
        System.out.println("Total: " + total);
        executor.shutdown();
    }

    
}