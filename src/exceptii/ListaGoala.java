package exceptii;

/**
 * Created by spacvalentin on 19.03.2016.
 */
public class ListaGoala extends Exception {

    public ListaGoala(String message) {
        super(message);
    }

    public ListaGoala(String message, Throwable cause) {
        super(message, cause);
    }
}
