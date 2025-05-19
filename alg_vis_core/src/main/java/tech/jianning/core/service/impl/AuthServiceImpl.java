package tech.jianning.core.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.UserPojo;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.core.mapper.UserInfoMapper;
import tech.jianning.core.service.api.IAuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

  private final UserInfoMapper userInfoMapper;

  @Override
  public UserPojo.LoginResponse login(UserPojo.LoginRequest request) {
    UserInfo user = userInfoMapper.queryOneByAccountAndPassword(request);
    if (user == null) return new UserPojo.LoginResponse("-1");
    return new UserPojo.LoginResponse(String.valueOf(user.getId()));
  }

  @Override
  public int register(UserPojo.RegisterInfo request) {
    UserInfo newUser = new UserInfo();
    BeanUtils.copyProperties(request, newUser);
    return userInfoMapper.insertSelective(newUser);
  }
}
