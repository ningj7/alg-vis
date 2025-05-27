package tech.jianning.server.controller.announce;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tech.jianning.common.pojo.AnnouncePojo;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.core.service.api.IAnnounceService;

import java.util.List;

@RestController
@RequestMapping("/announce")
@RequiredArgsConstructor
public class AnnounceController {

    private final IAnnounceService announceService;

    @GetMapping("list")
    public ResultResponse<List<AnnouncePojo.ListResponse>> queryList() {
        return ResultResponse.success(announceService.queryList());
    }

    @PostMapping("/insert")
    public ResultResponse<Integer> insert(@RequestBody AnnouncePojo.AddRequest request) {
        return ResultResponse.success(announceService.insert(request));
    }

    @DeleteMapping("/delete/{id}")
    public ResultResponse<Integer> deleteById(@PathVariable("id") Long id) {
        return ResultResponse.success(announceService.deleteById(id));
    }

    @PostMapping("/update")
    public ResultResponse<Integer> update(@RequestBody AnnouncePojo.UpdateRequest request) {
        return ResultResponse.success(announceService.update(request));
    }
}
