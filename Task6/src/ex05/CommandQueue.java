package ex05;

import java.util.Vector;
import ex04.Command;

/**
 * Створює обробник
 * потоку, що виконує
 * об’єкти з інтерфейсом
 * Command; шаблон
 * Worker Thread
 * 
 * @author ivan
 * @version 1.0
 * @see Command
 */
public class CommandQueue implements Queue {

    /** Черга задач */
    private Vector<Command> tasks;

    /** Флаг очікування */
    private boolean waiting;

    /** Флаг завершення */
    private boolean shutdown;

    /** Встановлює флаг завершення */
    public void shutdown() {
        shutdown = true;
    }

    /**
     * Ініціалізація {@linkplain CommandQueue#tasks},
     * {@linkplain CommandQueue#waiting};
     * створює потік для класу {@linkplain CommandQueue.Worker}
     */
    public CommandQueue() {
        tasks = new Vector<Command>();
        waiting = false;
        new Thread(new Worker()).start();
    }

    @Override
    public void put(Command r) {
        tasks.add(r);
        if (waiting) {
            synchronized (this) {
                notifyAll();
            }
        }
    }

    @Override
    public Command take() {
        if (tasks.isEmpty()) {
            synchronized (this) {
                waiting = true;
                try {
                    wait();
                } catch (InterruptedException ie) {
                    waiting = false;
                }
            }
        }
        return tasks.remove(0);
    }

    /**
     * Обслуговує чергу задач; шаблон
     * Worker Thread
     * 
     * @author xone
     * @version 1.0
     * @see Runnable
     */
    private class Worker implements Runnable {

        /**
         * Витягує з черги
         * готові до виконання
         * задачі; шаблон
         * Worker Thread
         */
        public void run() {
            while (!shutdown) {
                Command r = take();
                r.execute();
            }
        }
    }
}