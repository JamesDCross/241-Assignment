package week09;

/**
 * Special exception for the EP class.
 * Called when the EP class tries to call something on an empty list.
 * 
 * @author  James Cross, Callum Tanner
 */
public class EmptyPileException extends RuntimeException{
    
    /**
     * Standard error message to give.
     *
     * @param message the error message to be returned.
     */
    public EmptyPileException(String message){
        super(message);
    }

    /**
     * Error to give if no message is passed.
     */
    public EmptyPileException(){
        super();
    }

    /**
     * Serial UID for the exception. The 42L value is arbitrary.
     */
    private static final long serialVersionUID = 42L;
    
}
