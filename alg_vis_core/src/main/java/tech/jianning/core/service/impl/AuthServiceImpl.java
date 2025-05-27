package tech.jianning.core.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.UserPojo;
import tech.jianning.common.utils.EncryptUtil;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.core.mapper.UserInfoMapper;
import tech.jianning.core.service.api.IAuthService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements IAuthService {

    private final UserInfoMapper userInfoMapper;

    @SneakyThrows
    @Override
    public UserPojo.LoginResponse login(UserPojo.LoginRequest request) {
        request.setPassword(EncryptUtil.md5(request.getPassword()));
        UserInfo user = userInfoMapper.queryOneByAccountAndPassword(request);
        if (user == null) return new UserPojo.LoginResponse("-1");
        if(user.getStatus()==1)return new UserPojo.LoginResponse("-2");
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", user.getId());
        claims.put("username", user.getNickName());
        String token = EncryptUtil.createJWT(
            1000 * 60 * 60,
            claims
        );
        return new UserPojo.LoginResponse(token);
    }

    @SneakyThrows
    @Override
    public int register(UserPojo.RegisterInfo request) {
        List<UserInfo> userInfos = userInfoMapper.queryByAccountAndNickName(request.getAccount(), request.getNickName());
        if (userInfos != null && !userInfos.isEmpty()) {
            return 0;
        }
        UserInfo newUser = new UserInfo();
        BeanUtils.copyProperties(request, newUser);
        newUser.setPassword(EncryptUtil.md5(request.getPassword()));
        return userInfoMapper.insertSelective(newUser);
    }
}
