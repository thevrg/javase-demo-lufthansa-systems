package hu.dpc.edu.javase.demo.exception;

/**
 *
 * @author u122951
 */
public class ContentReadException extends Exception {

    private final String contentId;

    public ContentReadException(String contentId) {
        this.contentId = contentId;
    }

    public ContentReadException(String contentId, String message) {
        super(message);
        this.contentId = contentId;
    }

    public ContentReadException(String contentId, String message, Throwable cause) {
        super(message, cause);
        this.contentId = contentId;
    }

    public ContentReadException(String contentId, Throwable cause) {
        super(cause);
        this.contentId = contentId;
    }

    public ContentReadException(String contentId, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.contentId = contentId;
    }
    
    
    
    public String getContentId() {
        return contentId;
    }
    
    
    
}
