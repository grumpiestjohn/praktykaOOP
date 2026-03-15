package ex01;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/** Зберігає реалізацію методів для обчислення и відображення результатів.
* @author ivan
* @version 1.0
*/
public class Calc {
	/** Ім'я файлу, що використовується при серіализації. */
	private static final String FNAME = "Item2d.bin";
	/** Зберігає результат обчислень. Об'єкт класу {@linkplain Item2d} */
	private Item2d result;
	/** Ініціалізує {@linkplain Calc#result} */
	public Calc() {
		result = new Item2d();
	}
	/** Змінити значення {@linkplain Calc#result}
	* @param result - нове значення посилання на об'єкт {@linkplain Item2d}
	*/
	public void setResult(Item2d result) {
		this.result = result;
	}
	/** Отримати значення {@linkplain Calc#result}
	* @return теперішнє значення посилання на об'єкт {@linkplain Item2d}
	*/
	public Item2d getResult() {
		return result;
	}
	/** Обчислює значення функції.
	* @param x - аргумент обчислювальної функції.
	* @return результат обчислення функції.
	*/
	private double calc(double x) {
		return Math.sin(x * Math.PI / 180);
	}
	/** Обчислює значення функції і зберігає
	* результат у об'єкті {@linkplain Calc#result}
	* @param x - аргумент обчислювальної функції.
	*/
	public double init(double x ) {
		result.setX(x);
		return result.setY(calc(x));
	}
	/** Виволить результат обчислень. */
	public void show() {
	System.out.println(result);
	}
	/** Зберігає {@linkplain Calc#result} у файлі {@linkplain Calc#FNAME}
	* @throws IOException
	*/
	public void save() throws IOException {
		ObjectOutputStream os = new ObjectOutputStream(new
		FileOutputStream(FNAME));
		os.writeObject(result);
		os.flush();
		os.close();
	}
	/** Відновнює {@linkplain Calc#result} з файлу {@linkplain Calc#FNAME}
	* @throws Exception
	*/
	public void restore() throws Exception {
	ObjectInputStream is = new ObjectInputStream(new FileInputStream(FNAME));
	result = (Item2d)is.readObject();
	is.close();
	}
}