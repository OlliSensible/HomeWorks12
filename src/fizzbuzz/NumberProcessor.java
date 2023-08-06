package fizzbuzz;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcesor extends Thread{
    private Consumer<Integer> processor;
    private int n;
    private AtomicBoolean isNProcessed;

    public NumberProcesor(Consumer<Integer> processor){
        this.processor = processor;
    }

    public void process(int n){
        this.n = n;
        isNProcessed.set(false);
    }

    @Override
    public void run() {
       while (true){
           try {
               Thread.sleep(100);
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
           if (isNProcessed.get()) {
               continue;
           }
           processor.accept(n);
           isNProcessed.set(true);
       }
    }
}
