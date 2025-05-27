package tech.jianning.server.controller.suggestion;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.common.pojo.SuggestionPojo;
import tech.jianning.core.service.api.ISuggestionService;

import java.util.List;

@RestController
@RequestMapping("/suggestion")
@RequiredArgsConstructor
public class SuggestionController {

    private final ISuggestionService suggestionService;

    /**
     * 查询列表
     *
     * @return 列表
     */
    @GetMapping("/list")
    public ResultResponse<List<SuggestionPojo.ListResponse>> queryList() {
        return ResultResponse.success(suggestionService.queryList());
    }

    /**
     * 插入
     *
     * @param request request
     * @return 插入结果
     */
    @PostMapping("/insert")
    public ResultResponse<SuggestionPojo.AddResponse> insert(@RequestBody SuggestionPojo.AddRequest request) {
        return ResultResponse.success(suggestionService.insert(request));
    }
}
