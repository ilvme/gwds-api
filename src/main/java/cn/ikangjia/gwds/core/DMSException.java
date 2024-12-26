package cn.ikangjia.gwds.core;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 09:36
 */
public class DMSException extends RuntimeException{

    public DMSException(String message) {
        super(message);
    }

    public DMSException(String message, Throwable cause) {
        super(message, cause);
    }
}
