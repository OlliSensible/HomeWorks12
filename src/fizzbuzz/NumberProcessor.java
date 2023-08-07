package fizzbuzz;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public class NumberProcessor extends Thread{
    private Consumer<Integer> processor;
    private int n;
    private AtomicBoolean isNProcessed = new AtomicBoolean(true);

    public NumberProcessor(Consumer<Integer> processor){
        this.processor = processor;
    }

    public void process(int n){
        this.n = n;
        isNProcessed.set(false);
    }

    public boolean isNProcessed(){
        return isNProcessed.get();
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
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