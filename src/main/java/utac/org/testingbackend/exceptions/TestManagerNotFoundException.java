package utac.org.testingbackend.exceptions;

public class TestManagerNotFoundException extends Throwable {

    public TestManagerNotFoundException(String idNotFound) {
    super(idNotFound);
    }
}
