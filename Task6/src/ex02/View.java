package ex02;

import java.io.IOException;

/**
 * Product
 * (шаблон проєктування Factory Method)
 *
 * Інтерфейс "фабрикованих" об'єктів.
 * Оголошує методи відображення об'єктів.
 *
 * @author ivan
 * @version 1.0
 */
public interface View {

    /** Відображає заголовок */
    public void viewHeader();

    /** Відображає основну частину */
    public void viewBody();

    /** Відображає завершальну частину */
    public void viewFooter();

    /** Відображає об'єкт повністю */
    public void viewShow();

    /** Виконує ініціалізацію */
    public void viewInit();

    /** Зберігає дані для подальшого відновлення */
    public void viewSave() throws IOException;

    /** Відновлює раніше збережені дані */
    public void viewRestore() throws Exception;
}