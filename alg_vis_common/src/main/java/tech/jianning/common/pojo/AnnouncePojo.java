package tech.jianning.common.pojo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class AnnouncePojo {

    @Data
    public static class ListResponse {
        /**
         * 主键
         */
        private Long id;
        /**
         * 主题
         */
        private String title;
        /**
         * 内容
         */
        private String content;
        /**
         * 创建时间
         */
        private Instant createTime;
        /**
         * 更新时间
         */
        private Instant updateTime;
    }

    @Data
    public static class AddRequest {
        /**
         * 标题
         */
        private String title;
        /**
         * 内容
         */
        private String content;
    }

    @Data
    public static class UpdateRequest {
        /**
         * 主键
         */
        private Long id;
        /**
         * 标题
         */
        private String title;
        /**
         * 内容
         */
        private String content;
    }
}
