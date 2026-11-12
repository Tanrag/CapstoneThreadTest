public class main
{
    public static void main(String[] args) 
    {
        long startTime = System.nanoTime();
 
        Thread[] threads = new Thread[1];
        long[] threadTotals = new long[1];
 
        for (int x = 0; x < threads.length; x++)
        {
            int threadIndex = x;
            threads[x] = new Thread(() -> {
                long sum = 0;
                //Sum
                for (int y = 1; y <= 1_000_000_000; y++)
                {
                    sum++;
                }
                threadTotals[threadIndex] = sum;
            });
            threads[x].start();
        }


        for (int x = 0; x < threads.length; x++)
        {
            try 
            {
                threads[x].join(); 
            } catch (InterruptedException e) 
            {
                e.printStackTrace();
            }
        }

        long total = 0;
        for (int x = 0; x < threadTotals.length; x++)
        {
            total += threadTotals[x];
        }

        long endTime = System.nanoTime();
        long duration = (endTime - startTime);
        System.out.println("Total: " + total);
        System.out.println("Duration: " + duration + " ns");
    }
}