public class ThreadOne implements Runnable {
    String name;
    Thread t;
    Boolean flag;

    ThreadOne(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("New thread: " + t);
        t.start();
    }

    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println("Thread " + name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + name + "Interrupted");
        }
        System.out.println("Thread " + name + " exiting.");
    }
}


class MultiThread {
    public static void main(String args[]) {
        Experiment("One", 10000);   // highest sleep time
        Experiment("Two", 5000);    // middle sleep time
        Experiment("Three", 500);   // shortest sleep time
    }

    // 3 experiments run, each experiment sleeps for a different amount of time
    // each experiment creates 3 similar threads
    // each thread counts down from 5 to 1 and then exits
    // they run concurrently and sometimes count at different paces

    private static void Experiment(String name, Integer limit) {
        System.out.println("\n\nExperiment "+name);
        new ThreadOne("One");
        new ThreadOne("Two");
        new ThreadOne("Three");
        try {
            Thread.sleep(limit);
        } catch (InterruptedException e) {
            System.out.println("Main thread Interrupted");
        }
        System.out.println("Main thread exiting.");
    }
}
