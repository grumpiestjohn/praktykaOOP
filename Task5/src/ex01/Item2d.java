package ex01;
import java.io.Serializable;
/** Зберігає вхідні дані й результат обчислень.
* @author ivan
* @version 1.0
*/
public class Item2d implements Serializable {
	/** Аргумент обчислювальної функції. */
	// transient
	private double x;
	/** Результат обчислення функції. */
	private double y;
	/** Автоматично згенегрована константа */
	private static final long serialVersionUID = 1L;
	/** Ініціалізує поля {@linkplain Item2d#x}, {@linkplain Item2d#y} */
	public Item2d() {
		x = .0;
		y = .0;
	}
	/** Ставить значення полей: аргументу
	* і результату обчислення функції.
	* @param x - значення для ініціализації поля {@linkplain Item2d#x}
	* @param y - значення для ініціализації поля {@linkplain Item2d#y}
	*/
	public Item2d(double x, double y) {
		this.x = x;
		this.y = y;
	}
	/** Встановлення значення поля {@linkplain Item2d#x}
	* @param x - значення для {@linkplain Item2d#x}
	* @return значення {@linkplain Item2d#x}
	*/
	public double setX(double x) {
		return this.x = x;
	}
	/** Отримання значення поля {@linkplain Item2d#x}
	* @return значення {@linkplain Item2d#x}
	*/
	public double getX() {
		return x;
	}
	/** Встановлення значення поля {@linkplain Item2d#y}
	* @param y - значення для {@linkplain Item2d#y}
	* @return значення для {@linkplain Item2d#y}
	*/
	public double setY(double y) {
		return this.y = y;
	}
	/** Отримання значення поля {@linkplain Item2d#y}
	* @return значення {@linkplain Item2d#y}
	*/
	public double getY() {
		return y;
	}
	/** Встановлення значення {@linkplain Item2d#x} и {@linkplain Item2d#y}
	* @param x - значення для {@linkplain Item2d#x}
	* @param y - значення для {@linkplain Item2d#y}
	* @return this
	*/
	public Item2d setXY(double x, double y) {
		this.x = x;
		this.y = y;
		return this;
	}
	/** Представляє результат обчислень у вигляді рядку.<br>{@inheritDoc} */
	@Override
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	/** Автоматично згенегрований метод.<br>{@inheritDoc} */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
		return true;
		if (obj == null)
		return false;
		if (getClass() != obj.getClass())
		return false;
		Item2d other = (Item2d) obj;
		if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
		return false;
		// змінено порівняння результату обчислення функції
		if (Math.abs(Math.abs(y) - Math.abs(other.y)) > .1e-10)
		return false;
		return true;
	}
}