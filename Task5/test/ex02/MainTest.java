package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Item2d;

/**
 * Виконує тестування
 * розроблених класів.
 *
 * @author ivan
 * @version 2.0
 */
public class MainTest {

    /**
     * Перевірка основної функціональності класу {@linkplain ViewResult}
     */
    @Test
    public void testCalc() {

        ViewResult view = new ViewResult(5);
        view.init(90.0);

        Item2d item = new Item2d();
        int ctr = 0;

        item.setXY(0.0, 0.0);
        assertTrue(
            "expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
            view.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(90.0, 1.0);
        assertTrue(
            "expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
            view.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(180.0, 0.0);
        assertTrue(
            "expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
            view.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(270.0, -1.0);
        assertTrue(
            "expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
            view.getItems().get(ctr).equals(item)
        );

        ctr++;
        item.setXY(360.0, 0.0);
        assertTrue(
            "expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
            view.getItems().get(ctr).equals(item)
        );
    }

    /**
     * Перевірка серіалізації. Коректність відновлення даних.
     */
    @Test
    public void testRestore() {

        ViewResult view1 = new ViewResult(1000);
        ViewResult view2 = new ViewResult();

        // Обчислимо значення функції з випадковим кроком приросту аргументу
        view1.init(Math.random() * 100.0);

        // Збережемо колекцію view1.items
        try {
            view1.viewSave();
        } catch (IOException e) {
            fail(e.getMessage());
        }

        // Завантажимо колекцію view2.items
        try {
            view2.viewRestore();
        } catch (Exception e) {
            fail(e.getMessage());
        }

        // Повинні завантажити стільки ж елементів, скільки зберегли
        assertEquals(view1.getItems().size(), view2.getItems().size());

        // Причому ці елементи повинні бути рівними
        // Для цього потрібно перевизначити метод equals
        assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
    }
}