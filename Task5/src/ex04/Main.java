package ex04;

/**
 * Обчислення та відображення результатів;
 * містить реалізацію статичного методу main()
 *
 * @author ivan
 * @version 4.0
 * @see Main#main
 */
public class Main {

    /**
     * Виконується під час запуску програми;
     * викликає метод {@linkplain Application#run()}
     *
     * @param args параметри запуску програми
     */
    public static void main(String[] args) {
        Application app = Application.getInstance();
        app.run();
    }
}