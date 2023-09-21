package utac.org.testingbackend.exceptions;

public class EvaluationNotFoundException extends Exception {
    public EvaluationNotFoundException(String id) {
        super(id);
    }
}
