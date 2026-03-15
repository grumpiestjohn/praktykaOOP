package ex02;

/**
 * ConcreteCreator
 * (шаблон проєктування Factory Method)
 *
 * Оголошує метод,
 * який "фабрикує" об'єкти.
 *
 * @author ivan
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */
public class ViewableResult implements Viewable {

    /** Створює об'єкт відображення {@linkplain ViewResult} */
    @Override
    public View getView() {
        return new ViewResult();
    }
}