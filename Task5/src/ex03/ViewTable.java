package ex03;

import java.util.Formatter;
import ex01.Item2d;
import ex02.ViewResult;

/**
 * ConcreteProduct
 * (шаблон проєктування Factory Method)
 * <br>
 * Виведення результатів у вигляді таблиці
 *
 * @author ivan
 * @version 1.0
 * @see ViewResult
 */
public class ViewTable extends ViewResult {

    /** Визначає ширину таблиці за замовчуванням */
    private static final int DEFAULT_WIDTH = 20;

    /** Поточна ширина таблиці */
    private int width;

    /**
     * Встановлює {@linkplain ViewTable#width width}
     * значенням {@linkplain ViewTable#DEFAULT_WIDTH DEFAULT_WIDTH}
     * <br>
     * Викликається конструктор суперкласу {@linkplain ViewResult#ViewResult()}
     */
    public ViewTable() {
        width = DEFAULT_WIDTH;
    }

    /**
     * Встановлює {@linkplain ViewTable#width} значенням <b>width</b>
     * <br>
     * Викликається конструктор суперкласу {@linkplain ViewResult#ViewResult()}
     *
     * @param width визначає ширину таблиці
     */
    public ViewTable(int width) {
        this.width = width;
    }

    /**
     * Встановлює {@linkplain ViewTable#width} значенням <b>width</b>
     * <br>
     * Викликається конструктор суперкласу
     * {@linkplain ViewResult#ViewResult(int n)}
     *
     * @param width визначає ширину таблиці
     * @param n кількість елементів колекції; передається суперкласу
     */
    public ViewTable(int width, int n) {
        super(n);
        this.width = width;
    }

    /**
     * Встановлює поле {@linkplain ViewTable#width} значенням <b>width</b>
     *
     * @param width нова ширина таблиці
     * @return задана параметром <b>width</b> ширина таблиці
     */
    public int setWidth(int width) {
        return this.width = width;
    }

    /**
     * Повертає значення поля {@linkplain ViewTable#width}
     *
     * @return поточна ширина таблиці
     */
    public int getWidth() {
        return width;
    }

    /** Виводить горизонтальний роздільник шириною {@linkplain ViewTable#width} символів */
    private void outLine() {
        for (int i = width; i > 0; i--) {
            System.out.print('-');
        }
    }

    /** Викликає {@linkplain ViewTable#outLine()} та завершує рядок */
    private void outLineLn() {
        outLine();
        System.out.println();
    }

    /** Виводить заголовок таблиці шириною {@linkplain ViewTable#width} символів */
    private void outHeader() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width - 3) / 2, "s | %", "s\n");
        System.out.printf(fmt.toString(), "x ", "y ");
    }

    /** Виводить тіло таблиці шириною {@linkplain ViewTable#width} символів */
    private void outBody() {
        Formatter fmt = new Formatter();
        fmt.format("%s%d%s%2$d%s", "%", (width - 3) / 2, ".0f | %", ".3f\n");

        for (Item2d item : getItems()) {
            System.out.printf(fmt.toString(), item.getX(), item.getY());
        }
    }

    /**
     * Перевантаження (overloading) методу суперкласу;
     * встановлює поле {@linkplain ViewTable#width} значенням <b>width</b>
     * <br>
     * Викликає метод {@linkplain ViewResult#viewInit()}
     *
     * @param width нова ширина таблиці
     */
    public final void init(int width) {
        this.width = width;
        viewInit();
    }

    /**
     * Перевантаження методу суперкласу;
     * встановлює поле {@linkplain ViewTable#width} значенням <b>width</b>
     *
     * @param width нова ширина таблиці
     * @param stepX передається методу <b>init(double)</b>
     */
    public final void init(int width, double stepX) {
        this.width = width;
        init(stepX);
    }

    /**
     * Перевизначення (overriding) методу суперкласу;
     * виводить інформаційне повідомлення та викликає метод суперкласу
     * {@linkplain ViewResult#init(double)}
     *
     * @param stepX крок зміни X
     */
    @Override
    public void init(double stepX) {
        System.out.print("Initialization... ");
        super.init(stepX);
        System.out.println("done.");
    }

    /** Виведення заголовка таблиці */
    @Override
    public void viewHeader() {
        outHeader();
        outLineLn();
    }

    /** Виведення тіла таблиці */
    @Override
    public void viewBody() {
        outBody();
    }

    /** Виведення нижньої частини таблиці */
    @Override
    public void viewFooter() {
        outLineLn();
    }
}