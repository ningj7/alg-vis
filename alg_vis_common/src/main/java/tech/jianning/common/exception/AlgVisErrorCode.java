package tech.jianning.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlgVisErrorCode implements ErrorCode {
  INVALID_INPUT(400, "无效的输入"),
  NOT_FOUND(404, "资源未找到"),
  INTERNAL_ERROR(500, "服务器内部错误");

  private final int code;
  private final String description;
}
