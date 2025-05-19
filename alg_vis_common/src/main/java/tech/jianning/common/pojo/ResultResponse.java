package tech.jianning.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一返回结果格式
 */
@Data
@AllArgsConstructor
public class ResultResponse<T> {
  private int code;
  private String message;
  private T data;


  public static <T> ResultResponse<T> success(T data) {
    return new ResultResponse<>(200, "成功", data);
  }

  public static <T> ResultResponse<T> error(int code, String message) {
    return new ResultResponse<>(code, message, null);
  }
}
