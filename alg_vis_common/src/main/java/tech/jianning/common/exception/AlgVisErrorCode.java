package tech.jianning.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum AlgVisErrorCode implements ErrorCode {
    INVALID_INPUT(400, "无效的输入"),
    NOT_FOUND(404, "资源未找到"),
    RUNNING_ERROR(501, "算法运行错误，请检查输入"),
    LOGIN_ERROR(401, "登录失败，请检查账号或密码"),
    INTERNAL_ERROR(500, "服务器内部错误");

    private final int code;
    private final String description;
}
