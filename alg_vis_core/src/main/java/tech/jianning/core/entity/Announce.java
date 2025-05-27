package tech.jianning.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "announce")
@AllArgsConstructor
@NoArgsConstructor
public class Announce extends BaseDomain {

    private String title;

    private String content;
}
