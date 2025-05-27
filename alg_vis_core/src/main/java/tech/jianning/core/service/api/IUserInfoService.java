package tech.jianning.core.service.api;

import com.github.pagehelper.PageInfo;
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
     * @return 实例对象
     */
    UserPojo.UserInfoResponse queryOne();

    /**
     * 修改数据
     *
     * @param request 实例对象
     * @return 是否成功
     */
    int update(UserPojo.UpdateRequest request);

    /**
     * 查询列表
     *
     * @param request 请求参数
     * @return 列表
     */
    PageInfo<UserPojo.ListResponse> queryList(int page, int size, UserPojo.ListRequest request);

}
