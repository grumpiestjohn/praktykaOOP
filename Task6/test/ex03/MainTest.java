package ex03;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/**
 * Виконує тестування розроблених класів.
 *
 * @author ivan
 * @version 3.0
 */
public class MainTest {

    /** Перевірка основної функціональності класу {@linkplain ViewTable} */
    @Test
    public void testCalc() {

        ViewTable tbl = new ViewTable(10, 5);

        assertEquals(10, tbl.getWidth());
        assertEquals(5, tbl.getItems().size());

        tbl.init(40, 90.0);

        Item2d item = new Item2d();
        int ctr = 0;

        item.setXY(0.0, 0.0);
        assertTrue(
                "expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(90.0, 1.0);
        assertTrue(
                "expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(180.0, 0.0);
        assertTrue(
                "expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(270.0, -1.0);
        assertTrue(
                "expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(360.0, 0.0);
        assertTrue(
                "expected:<" + item + "> but was:<" + tbl.getItems().get(ctr) + ">",
                tbl.getItems().get(ctr).equals(item)
        );
    }

    /** Перевірка серіалізації. Коректність відновлення даних. */
    @Test
    public void testRestore() {

        ViewTable tbl1 = new ViewTable(10, 1000);
        ViewTable tbl2 = new ViewTable();

        // Обчислимо значення функції з випадковим кроком зміни аргументу
        tbl1.init(30, Math.random() * 100.0);

        // Збережемо колекцію tbl1.items
        try {
            tbl1.viewSave();
        } catch (IOException e) {
            Assert.fail(e.getMessage());
        }

        // Завантажимо колекцію tbl2.items
        try {
            tbl2.viewRestore();
        } catch (Exception e) {
            Assert.fail(e.getMessage());
        }

        // Повинні завантажити стільки ж елементів, скільки зберегли
        assertEquals(tbl1.getItems().size(), tbl2.getItems().size());

        // Причому ці елементи повинні бути рівними.
        // Для цього потрібно перевизначити метод equals
        assertTrue("containsAll()", tbl1.getItems().containsAll(tbl2.getItems()));
    }
}