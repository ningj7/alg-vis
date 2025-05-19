package tech.jianning.core.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.core.mapper.UserInfoMapper;
import tech.jianning.core.service.api.IUserInfoService;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.common.pojo.UserPojo;


/**
 * 用户信息表(UserInfo)表服务实现类
 *
 * @author makejava
 * @since 2025-03-27 15:11:29
 */
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements IUserInfoService {

  private final UserInfoMapper userInfoMapper;

  @Override
  public ResultResponse<UserPojo.UserInfoResponse> queryById(Long id) {
    UserPojo.UserInfoResponse userInfoResponse = new UserPojo.UserInfoResponse();
    BeanUtils.copyProperties(userInfoMapper.selectByPrimaryKey(id), userInfoResponse);
    return ResultResponse.success(userInfoResponse);
  }

  @Override
  public boolean insert(UserInfo userInfo) {
    return userInfoMapper.insertSelective(userInfo) > 0;
  }

  @Override
  public boolean update(UserInfo userInfo) {
    return userInfoMapper.updateByPrimaryKey(userInfo) > 0;
  }

  @Override
  public boolean deleteById(Long id) {
    return userInfoMapper.deleteByPrimaryKey(id) > 0;
  }

  @Override
  public PageInfo<UserPojo.ListResponse> queryList(int page, int size, UserPojo.ListRequest request) {
    UserInfo filter = new UserInfo();
    BeanUtils.copyProperties(request, filter);
    return PageMethod.startPage(page, size).doSelectPageInfo(() -> userInfoMapper.queryList(filter));
  }
}
