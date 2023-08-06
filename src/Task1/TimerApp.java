package Task1;

public class TimerApp {
    public static void main(String[] args) {
        Thread timeThread = new Thread(() -> {
            int seconds = 0;
            while (true) {
                System.out.println("Time elapsed: " + seconds + " seconds");
                seconds++;
                try {
                    Thread.sleep(1000); // Почекати 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread messageThread = new Thread(() -> {
            int counter = 0;
            while (true) {
                if (counter % 5 == 0) {
                    System.out.println("Минуло 5 секунд");
                }
                counter++;
                try {
                    Thread.sleep(1000); // Почекати 1 секунду
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        timeThread.start();
        messageThread.start();
    }
}
