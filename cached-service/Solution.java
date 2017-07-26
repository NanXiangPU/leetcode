import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class Solution<T> {
    private Map<T, Long> timeMap = new ConcurrentHashMap<T, Long>();
    private long expireTimeInMillis = 1000;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss  yyyy.MM.dd");
    private Thread cleanerThread;

    public int getCacheSize() {
        return this.timeMap.size();
    }

    public void stop() {
        this.cleanerThread.stop();
    }
    
    private class CleanerThread extends Thread {
        @Override
        public void run() {
            System.out.println("Initializing cleaner thread");
            while(true) {
                cleanMap();
                try {
                    Thread.sleep(expireTimeInMillis / 2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        
        private void cleanMap() {
            long currentTime = new Date().getTime();
            for (T key : timeMap.keySet()) {
                if (currentTime > timeMap.get(key) + expireTimeInMillis) {
                    timeMap.remove(key);
                    System.out.println("Removing : " + sdf.format(new Date()) + " :\n" + key );
                }
            }
        }
    }

    
    public Solution() {
        initialize();
    }
    
    public Solution(long expireTimeInMillis) {
        this.expireTimeInMillis = expireTimeInMillis;
        initialize();
    }
    
    public void initialize() {
        this.cleanerThread = new CleanerThread();
        cleanerThread.start();
    }
    
    public void put(T key) {
        Date date = new Date();
        timeMap.put(key, date.getTime());
        System.out.println("Inserting key : " + sdf.format(date) + "\n" + key);
    }
    
    public T get(T key) {
        if (!timeMap.containsKey(key)) {
            System.out.println("Key:" + key + " Not found in cache:");
            put(key);
        }
        timeMap.put(key, new Date().getTime());
        return key;
    }
    
    
    
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Solution<String> s = new Solution<>();
        s.put("1");
        s.put("2");
        s.put("3");
        System.out.println("\ncurrentCacheSize: " + s.getCacheSize() + "\n");
        TimeUnit.SECONDS.sleep(2);
        System.out.println("\ncurrentCacheSize: " + s.getCacheSize() + "\n");
        s.get("1");
        System.out.println("\ncurrentCacheSize: " + s.getCacheSize() + "\n");

        s.stop();
    }

}