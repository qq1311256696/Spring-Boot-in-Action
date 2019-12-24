package hys.mongodb.exeception;

public class MgdbException extends RuntimeException {


    //无参构造方法
    public MgdbException() {
        super();
    }

    //有参的构造方法
    public MgdbException(String message) {
        super(message);
    }

    // 用指定的详细信息和原因构造一个新的异常
    public MgdbException(String message, Throwable cause) {
        super(message, cause);
    }

    //用指定原因构造一个新的异常
    public MgdbException(Throwable cause) {
        super(cause);
    }
}
