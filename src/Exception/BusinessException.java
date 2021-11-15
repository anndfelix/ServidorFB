
package Exception;

public class BusinessException extends Exception {

    public BusinessException() {
    }

    public BusinessException(String string) {
        super(string);
    }

    public BusinessException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public BusinessException(Throwable thrwbl) {
        super(thrwbl);
    }

}
