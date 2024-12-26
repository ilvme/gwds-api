package cn.ikangjia.gwds.infra.exception;

import cn.ikangjia.gwds.infra.rest.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author kangJia
 * @email ikangjia.cn@outlook.com
 * @since 2024/12/26 14:21
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResultVO<Void> exceptionHandler(Exception e) {
        log.error("GlobalExceptionHandler:{}", e.getMessage(), e);
        return ResultVO.error(e.getMessage());
    }
}
