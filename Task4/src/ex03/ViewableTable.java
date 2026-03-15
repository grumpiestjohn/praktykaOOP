package ex03;

import ex02.ViewableResult;
import ex02.View;

/**
 * ConcreteCreator
 * (шаблон проєктування Factory Method)
 * <br>
 * Оголошує метод,
 * що "створює" об’єкти
 *
 * @author ivan
 * @version 1.0
 * @see ViewableResult
 * @see ViewableTable#getView()
 */
public class ViewableTable extends ViewableResult {

    /** Створює об’єкт відображення {@linkplain ViewTable} */
    @Override
    public View getView() {
        return new ViewTable();
    }
}