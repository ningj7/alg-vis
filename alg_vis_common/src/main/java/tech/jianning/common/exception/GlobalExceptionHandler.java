package tech.jianning.common.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import tech.jianning.common.pojo.ResultResponse;

@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * 处理自定义异常
   *
   * @param e 异常
   * @return 统一返回结果
   */
  @ExceptionHandler(AlgVisException.class)
  public ResultResponse<Void> exceptionHandler(AlgVisException e) {
    return ResultResponse.error(e.getErrorCode().getCode(), e.getMessage());
  }

  /**
   * 处理所有未知异常
   */
  @ExceptionHandler(Exception.class)
  public ResultResponse<Void> handleGeneralException(Exception ex) {
    return ResultResponse.error(500, "服务器内部错误: " + ex.getMessage());
  }
}
