package exception;

/**
 * 非法的年龄异常
 *
 * 自定义异常，通常是用来声明满足语法但是不满足业务时的错误情况，java没有现成的异常来说明
 * 这种情况
 *
 * 自定义异常需要完成一下工作:
 * 1：定义类名，要做到见名知意
 * 2：需要继承自Exception(直接或间接继承)
 * 3:提供Exception中定义的所有种类构造器
 */
public class IllegalAgeException extends Exception{
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
