package tech.jianning.common.context;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class BaseContext {

    public static final ThreadLocal<User> current = new ThreadLocal<>();

    public static void setUserInfo(Long id, String username) {
            current.set(new User(id, username));
    }

    @Data
    @AllArgsConstructor
    public static class User {
        private Long id;
        private String username;
    }
}
