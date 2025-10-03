import java.util.*;

class ThreadSafeLockingSingleton {
    private static ThreadSafeLockingSingleton instance = null;

    private ThreadSafeLockingSingleton() {
        System.out.println("Singleton Constructor called");
    }

    public static ThreadSafeLockingSingleton getInstance() {
        synchronized (ThreadSafeLockingSingleton.class) {
            if (instance == null) {
                instance = new ThreadSafeLockingSingleton();
            }

            return instance;
        }
    }
}

class ThreadSafeDoubleLockingSingleton {
    private static ThreadSafeDoubleLockingSingleton instance = null;

    private ThreadSafeDoubleLockingSingleton() {
        System.out.println("double lock singleton constructor called");
    }

    public static ThreadSafeDoubleLockingSingleton getInstance() {
        if (instance == null) {
            synchronized (ThreadSafeDoubleLockingSingleton.class) {
                if (instance == null) {
                    instance = new ThreadSafeDoubleLockingSingleton();
                }
            }
        }

        return instance;
    }
}

class ThreadSafeEagerSingleton {
    private static ThreadSafeEagerSingleton instance = new ThreadSafeEagerSingleton();

    private ThreadSafeEagerSingleton() {
        System.out.println("Eager Singleton constructor called");
    }

    public static ThreadSafeEagerSingleton getInstance() {
        return instance;
    }
}

public class Thread_Safe_Singleton {
    public static void main(String[] args) {
        ThreadSafeLockingSingleton ts1 = ThreadSafeLockingSingleton.getInstance();
        ThreadSafeLockingSingleton ts2 = ThreadSafeLockingSingleton.getInstance();

        System.out.println(ts1 == ts2);

        ThreadSafeDoubleLockingSingleton tsd1 = ThreadSafeDoubleLockingSingleton.getInstance();
        ThreadSafeDoubleLockingSingleton tsd2 = ThreadSafeDoubleLockingSingleton.getInstance();

        System.out.println(tsd1 == tsd2);

        ThreadSafeEagerSingleton tse1 = ThreadSafeEagerSingleton.getInstance();
        ThreadSafeEagerSingleton tse2 = ThreadSafeEagerSingleton.getInstance();

        System.out.println(tse1 == tse2);
    }
}