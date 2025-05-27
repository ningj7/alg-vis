package tech.jianning.server.controller.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jianning.common.exception.AlgVisErrorCode;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.core.service.api.IAuthService;
import tech.jianning.common.pojo.UserPojo;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final IAuthService authService;

    @PostMapping("/login")
    public ResultResponse<UserPojo.LoginResponse> login(@RequestBody UserPojo.LoginRequest request) {
        UserPojo.LoginResponse result = authService.login(request);
        if (result.getToken().equals("-1")) {
            return ResultResponse.error(AlgVisErrorCode.LOGIN_ERROR);
        } else if (result.getToken().equals("-2")) {
            return ResultResponse.error(AlgVisErrorCode.ACCOUNT_ABNORMAL);
        }
        return ResultResponse.success(result);
    }

    @PostMapping("/register")
    public ResultResponse<Integer> register(@RequestBody UserPojo.RegisterInfo request) {
        int result = authService.register(request);
        if (result == 0) {
            return ResultResponse.error(AlgVisErrorCode.REGISTER_ERROR);
        }
        return ResultResponse.success(result);
    }

}
