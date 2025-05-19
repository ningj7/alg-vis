package tech.jianning.server.controller.users;

import com.github.pagehelper.PageInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import tech.jianning.core.service.api.IUserInfoService;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.common.pojo.UserPojo;

/**
 * 用户信息
 */
@Slf4j
@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserInfoController {

  private final IUserInfoService userInfoService;

  /**
   * 根据id查询用户信息
   *
   * @param userId 用户id
   * @return 用户信息
   */
  @GetMapping("/query")
  public ResultResponse<UserPojo.UserInfoResponse> getUserInfo(@RequestParam("userId") String userId) {
    return userInfoService.queryById(Long.valueOf(userId));
  }

  /**
   * 分页查询
   *
   * @param pageNo   页码
   * @param pageSize 每页数量
   * @param request  查询条件
   * @return 列表
   */
  @GetMapping("/queryList")
  public ResultResponse<PageInfo<UserPojo.ListResponse>> queryList(
      @ModelAttribute UserPojo.ListRequest request,
      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
      @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
    return ResultResponse.success(userInfoService.queryList(pageNo, pageSize, request));
  }

}

