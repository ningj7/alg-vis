package tech.jianning.core.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tech.jianning.core.entity.UserInfo;
import tech.jianning.common.pojo.UserPojo;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.List;

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    List<UserPojo.ListResponse> queryList(@Param("filter") UserInfo filter);

    UserInfo queryOneByAccountAndPassword(@Param("request") UserPojo.LoginRequest request);
}
