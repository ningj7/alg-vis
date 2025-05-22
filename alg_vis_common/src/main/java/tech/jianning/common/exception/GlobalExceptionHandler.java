package tech.jianning.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.jianning.common.pojo.ResultResponse;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 处理自定义异常
     *
     * @param e 异常
     * @return 统一返回结果
     */
    @ExceptionHandler(AlgVisException.class)
    public ResultResponse<Void> exceptionHandler(AlgVisException e) {
        return ResultResponse.error(e.getErrorCode());
    }

    /**
     * 处理所有未知异常
     */
    @ExceptionHandler(Exception.class)
    public ResultResponse<Void> handleGeneralException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return ResultResponse.error(AlgVisErrorCode.INTERNAL_ERROR);
    }
}
