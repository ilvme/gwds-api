package cn.ikangjia.gwds.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/24 09:38
 */
@Data
@Accessors(chain = true)
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public static final Integer SUCCESS_CODE = 0;
    public static final Integer ERROR_CODE = -1;

    public static <T> ResultVO<T> success(){
        return new ResultVO<T>()
                .setCode(SUCCESS_CODE);
    }

    public static <T> ResultVO<T> success(T data){
        return new ResultVO<T>()
                .setCode(SUCCESS_CODE)
                .setData(data);
    }

    public static <T> ResultVO<T> success(String msg, T data){
        return new ResultVO<T>()
                .setCode(SUCCESS_CODE)
                .setMsg(msg)
                .setData(data);
    }

    public static <T> ResultVO<T> error(String msg){
        return new ResultVO<T>()
                .setCode(ERROR_CODE)
                .setMsg(msg);
    }
}
