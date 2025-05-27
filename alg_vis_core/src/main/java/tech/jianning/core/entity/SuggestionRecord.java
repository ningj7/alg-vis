package tech.jianning.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "suggestion_record")
@AllArgsConstructor
@NoArgsConstructor
public class SuggestionRecord extends BaseDomain {

    /**
     * 主题
     */
    private String topic;
    /**
     * 内容
     */
    private String content;
    /**
     * 创建人ID
     */
    private Long creatorId;
    /**
     * 创建人姓名
     */
    private String creatorName;

}
