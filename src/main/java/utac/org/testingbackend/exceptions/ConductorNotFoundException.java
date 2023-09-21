package utac.org.testingbackend.exceptions;

public class ConductorNotFoundException extends Exception {
    public ConductorNotFoundException(Long id) {
        super(String.format("conductor  not found :"+id));
    }
}
