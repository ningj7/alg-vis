package tech.jianning.core.service.api;

import tech.jianning.common.pojo.UserPojo;

public interface IAuthService {

    UserPojo.LoginResponse login(UserPojo.LoginRequest request);

    int register(UserPojo.RegisterInfo request);
}
