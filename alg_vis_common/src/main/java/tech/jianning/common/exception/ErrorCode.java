package tech.jianning.common.exception;

public interface ErrorCode {
    /**
     * 获取错误码
     *
     * @return 错误码
     */
    int getCode();

    /**
     * 获取错误描述
     *
     * @return 错误描述
     */
    String getDescription();
}
