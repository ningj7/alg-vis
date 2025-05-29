package tech.jianning.core.service.impl;

import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import tech.jianning.common.context.BaseContext;
import tech.jianning.common.pojo.UserPojo;
import tech.jianning.common.utils.EncryptUtil;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.core.mapper.UserInfoMapper;
import tech.jianning.core.service.api.IUserInfoService;


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
    public UserPojo.UserInfoResponse queryOne() {
        UserPojo.UserInfoResponse userInfoResponse = new UserPojo.UserInfoResponse();
        BeanUtils.copyProperties(userInfoMapper.selectByPrimaryKey(BaseContext.current.get().getId()), userInfoResponse);
        return userInfoResponse;
    }


    @SneakyThrows
    @Override
    public int update(UserPojo.UpdateRequest request) {
        UserInfo userInfo = new UserInfo();
        BeanUtils.copyProperties(request, userInfo);
        if(userInfo.getPassword()!= null && !userInfo.getPassword().isEmpty()) {
            userInfo.setPassword(EncryptUtil.md5(userInfo.getPassword()));
        }
        if (userInfo.getId() == -1) {
            userInfo.setId(BaseContext.current.get().getId());
        }
        if (request.getResetPassword() != null && request.getResetPassword()) {
            userInfo.setPassword(EncryptUtil.md5("123456")); // 默认密码
        }
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }

    @Override
    public PageInfo<UserPojo.ListResponse> queryList(int page, int size, UserPojo.ListRequest request) {
        UserInfo filter = new UserInfo();
        BeanUtils.copyProperties(request, filter);
        return PageMethod.startPage(page, size).doSelectPageInfo(() -> userInfoMapper.queryList(filter));
    }
}
