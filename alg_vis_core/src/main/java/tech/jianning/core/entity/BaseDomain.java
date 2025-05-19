package tech.jianning.core.entity;

import lombok.Data;

import javax.persistence.Id;
import java.time.Instant;

@Data
public class BaseDomain {
  /**
   * 主键
   */
  @Id
  private Long id;
  /**
   * 创建时间
   */
  private Instant createTime;
  /**
   * 更新时间
   */
  private Instant updateTime;
}
