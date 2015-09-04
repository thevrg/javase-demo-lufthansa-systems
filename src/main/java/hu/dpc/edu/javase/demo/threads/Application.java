package hu.dpc.edu.javase.demo.threads;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author U122951
 */
public enum Application {
    INSTANCE;
    
    private List<Thread> appThreads = new ArrayList<>();
    
    private boolean timeToQuit;

    public boolean isTimeToQuit() {
        return timeToQuit;
    }
    
    public void registerThread(Thread t) {
        appThreads.add(t);
    }
    
    public void shutdown() {
        timeToQuit = true;
        for (Thread appThread : appThreads) {
            appThread.interrupt();
        }
    }
}
