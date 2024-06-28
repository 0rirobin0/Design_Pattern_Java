package CreationalDP_SPFAB;

class Singleton {

    private static Singleton instance;

    private Singleton() {
        System.out.println("Instantiated");
    }

    public static synchronized Singleton get_Singleton_Obj() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}

class SingletonThreads implements Runnable {
    @Override
    public void run() {
        Singleton singleton = Singleton.get_Singleton_Obj();
        System.out.println(Thread.currentThread().getName() + ": " + singleton);
    }
}

class Main {
    public static void main(String[] args) {
        // Creating instances of SingletonRunnable
        SingletonThreads t1 = new SingletonThreads();
        SingletonThreads t2 = new SingletonThreads();

        // Creating two threads
        Thread thread1 = new Thread(t1, "Thread 1");
        Thread thread2 = new Thread(t2, "Thread 2");

        // Starting the threads
        thread1.start();
        thread2.start();

        // Wait for both threads to complete
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Checking Singleton instances
        Singleton s1 = Singleton.get_Singleton_Obj();
        Singleton s2 = Singleton.get_Singleton_Obj();

        System.out.println("s1 == s2: " + (s1 == s2)); // should print true
    }
}
