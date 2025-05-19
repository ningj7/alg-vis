package tech.jianning.common.exception;


import lombok.Getter;

/**
 * @author jianning
 * 2025/03/27
 */
@Getter
public class AlgVisException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  private final ErrorCode errorCode;

  public AlgVisException(ErrorCode errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }

  public AlgVisException(ErrorCode errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public AlgVisException(ErrorCode errorCode, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
  }

  public AlgVisException(ErrorCode errorCode) {
    this(errorCode, errorCode.getDescription());
  }

}
