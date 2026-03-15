package ex05;

import ex04.Command;

/**
 * Інтерфейс для додавання та отримання завдань
 * обробником потоку;
 * шаблон Worker Thread
 * 
 * @author ivan
 * @version 1.0
 * @see Command
 */
public interface Queue {

    /**
     * Додає нове завдання у чергу;
     * шаблон Worker Thread
     * 
     * @param cmd завдання
     */
    void put(Command cmd);

    /**
     * Видаляє завдання з черги;
     * шаблон Worker Thread
     * 
     * @return видалене завдання
     */
    Command take();
}