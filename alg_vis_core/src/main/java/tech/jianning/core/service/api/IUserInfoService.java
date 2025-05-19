package tech.jianning.core.service.api;

import com.github.pagehelper.PageInfo;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.common.pojo.UserPojo;

/**
 * 用户信息表(UserInfo)表服务接口
 *
 * @author makejava
 * @since 2025-03-27 15:11:29
 */
public interface IUserInfoService {

  /**
   * 通过ID查询单条数据
   *
   * @param id 主键
   * @return 实例对象
   */
  ResultResponse<UserPojo.UserInfoResponse> queryById(Long id);

  /**
   * 新增数据
   *
   * @param userInfo 实例对象
   * @return 是否成功
   */
  boolean insert(UserInfo userInfo);

  /**
   * 修改数据
   *
   * @param userInfo 实例对象
   * @return 是否成功
   */
  boolean update(UserInfo userInfo);

  /**
   * 通过主键删除数据
   *
   * @param id 主键
   * @return 是否成功
   */
  boolean deleteById(Long id);

  /**
   * 查询列表
   *
   * @param request 请求参数
   * @return 列表
   */
  PageInfo<UserPojo.ListResponse> queryList(int page, int size, UserPojo.ListRequest request);

}
