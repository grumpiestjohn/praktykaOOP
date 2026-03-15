package ex04;

/**
 * Інтерфейс команди
 * або задачі;
 * шаблони: Command,
 * Worker Thread
 *
 * @author ivan
 * @version 1.0
 */
public interface Command {

    /**
     * Виконання команди; шаблони: Command, Worker Thread
     */
    public void execute();
}