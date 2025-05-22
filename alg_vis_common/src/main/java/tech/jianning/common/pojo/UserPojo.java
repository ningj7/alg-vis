package tech.jianning.common.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * 用户相关pojo
 */
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class UserPojo {

    @Data
    public static class LoginRequest {
        /**
         * 账号
         */
        private String account;
        /**
         * 密码
         */
        private String password;
    }

    @Data
    @AllArgsConstructor
    public static class LoginResponse {
        private String jwt;
    }

    @Data
    public static class UserInfoResponse {
        /**
         * 头像url
         */
        private String avatarUrl;
        /**
         * 昵称
         */
        private String nickName;
        /**
         * 状态
         */
        private int status;
        /**
         * 角色
         */
        private int role;
    }

    @Data
    public static class ListRequest {
        /**
         * 主键
         */
        private Long id;
        /**
         * 昵称
         */
        private String nickName;
        /**
         * 账号
         */
        private String account;
        /**
         * 状态
         */
        private Integer status;
    }

    @Data
    public static class ListResponse {
        /**
         * 主键
         */
        private Long id;
        /**
         * 头像url
         */
        private String avatarUrl;
        /**
         * 昵称
         */
        private String nickName;
        /**
         * 性别
         */
        private int gender;
        /**
         * 账号
         */
        private String account;
        /**
         * 状态
         */
        private int status;
        /**
         * 角色
         */
        private int role;
        /**
         * 创建时间
         */
        private LocalDateTime createTime;
    }

    @Data
    public static class RegisterInfo {
        /**
         * 头像url
         */
        private String avatarUrl;
        /**
         * 昵称
         */
        private String nickName;
        /**
         * 性别
         */
        private Integer gender;
        /**
         * 账号
         */
        private String account;
        /**
         * 密码
         */
        private String password;
    }
}
