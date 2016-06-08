package exceptii;

/**
 * Created by spacvalentin on 19.03.2016.
 */
public class TrainerNecalificat extends Exception {

    public TrainerNecalificat(String message) {
        super(message);
    }

    public TrainerNecalificat(String message, Throwable cause) {
        super(message, cause);
    }
}
