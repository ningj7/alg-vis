package tech.jianning.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

/**
 * 用户信息表(UserInfo)实体类
 *
 * @author makejava
 * @since 2025-03-27 15:11:26
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "user_info")
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo extends BaseDomain {

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
   * 状态:0,正常，1:禁用
   */
  private Integer status;
  /**
   * 账号
   */
  private String account;
  /**
   * 密码
   */
  private String password;
  /**
   * 角色:0,管理员，1:普通用户
   */
  private Integer role;

}

