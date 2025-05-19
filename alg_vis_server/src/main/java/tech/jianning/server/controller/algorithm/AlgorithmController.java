package tech.jianning.server.controller.algorithm;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jianning.common.exception.AlgVisErrorCode;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.core.service.api.IBubbleSortService;
import tech.jianning.core.service.api.IMergeSortService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/algorithms")
@RequiredArgsConstructor
class AlgorithmController {

  private final IBubbleSortService bubbleSortService;
  private final IMergeSortService mergeSortService;

  /**
   * 冒泡排序
   *
   * @param request 请求参数
   * @return 排序结果
   */
  @PostMapping("/bubbleSort")
  public ResultResponse<List<AlgorithmPojo.BubbleSortResponse>> bubbleSort(@RequestBody AlgorithmPojo.SortRequest request) {

    List<AlgorithmPojo.BubbleSortResponse> result = bubbleSortService.bubbleSort(request);
    if (result.isEmpty()) {
      return ResultResponse.error(AlgVisErrorCode.RUNNING_ERROR);
    }
    return ResultResponse.success(result);
  }

  /**
   * 归并排序
   *
   * @param request 请求参数
   * @return 排序结果
   */
  @PostMapping("/mergeSort")
  public ResultResponse<List<AlgorithmPojo.MergeSortResponse>> mergeSort(@RequestBody AlgorithmPojo.SortRequest request) {
    List<AlgorithmPojo.MergeSortResponse> result = mergeSortService.mergeSort(request);
    if (result.isEmpty()) {
      return ResultResponse.error(AlgVisErrorCode.RUNNING_ERROR);
    }
    return ResultResponse.success(result);
  }
}