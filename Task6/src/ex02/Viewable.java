package ex02;

/**
 * Creator
 * (шаблон проєктування Factory Method)
 *
 * Оголошує метод,
 * який "фабрикує" об'єкти.
 *
 * @author ivan
 * @version 1.0
 * @see Viewable#getView()
 */
public interface Viewable {

    /** Створює об'єкт, що реалізує {@linkplain View} */
    public View getView();
}