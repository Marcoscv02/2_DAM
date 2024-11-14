package org.example.Teoria.counterExample;

public class CounterRunnable implements Runnable{
    public static final int NUM_OP=500;
    private Counter counter;
    public CounterRunnable(Counter counter){
        this.counter=counter;
    }

    @Override
    public void run() {
        for (int i = 0; i < NUM_OP; i++) {
            counter.increase();
            System.out.println(Thread.currentThread().getName()+" "+counter.getCount());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

