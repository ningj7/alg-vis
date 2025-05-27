package tech.jianning.common.pojo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.Instant;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class SuggestionPojo {

    @Data
    public static class ListResponse {
        /**
         * 主键
         */
        private Long id;
        /**
         * 主题
         */
        private String topic;
        /**
         * 内容
         */
        private String content;
        /**
         * 创建人姓名
         */
        private String creatorName;
        /**
         * 创建时间
         */
        private Instant createTime;
    }

    @Data
    public static class AddRequest {

        private String topic;

        private String content;

    }

    @Data
    @AllArgsConstructor
    public static class AddResponse {

        /**
         * 主键
         */
        private Long id;
        /**
         * 创建人姓名
         */
        private String creatorName;
        /**
         * 创建时间
         */
        private Instant createTime;

    }
}
