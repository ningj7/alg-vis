package tech.jianning.server.controller.algorithm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.jianning.common.exception.AlgVisErrorCode;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.pojo.ResultResponse;
import tech.jianning.core.service.api.*;

import java.util.List;

@RestController
@RequestMapping("/algorithms")
@RequiredArgsConstructor
class AlgorithmController {

  private final IBubbleSortService bubbleSortService;
  private final IMergeSortService mergeSortService;
  private final IHeapSortService heapSortService;
  private final ISearchService searchService;
  private final IDijkstraService dijkstraService;

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

  /**
   * 堆排序
   *
   * @param request 请求参数
   * @return 排序结果
   */
  @PostMapping("/heapSort")
  public ResultResponse<List<AlgorithmPojo.HeapSortResponse>> heapSort(@RequestBody AlgorithmPojo.SortRequest request) {
    List<AlgorithmPojo.HeapSortResponse> result = heapSortService.heapSort(request);
    if (result.isEmpty()) {
      return ResultResponse.error(AlgVisErrorCode.RUNNING_ERROR);
    }
    return ResultResponse.success(result);
  }

  /**
   * 搜索
   *
   * @param request 请求参数
   * @return 搜索结果
   */
  @PostMapping("/search")
  public ResultResponse<List<AlgorithmPojo.SearchResponse>> search(@RequestBody AlgorithmPojo.SearchRequest request) {
    List<AlgorithmPojo.SearchResponse> result = searchService.search(request);
    if (result.isEmpty()) {
      return ResultResponse.error(AlgVisErrorCode.RUNNING_ERROR);
    }
    return ResultResponse.success(result);
  }

  /**
   * Dijkstra
   *
   * @param request 请求参数
   * @return 最短路径结果
   */
  @PostMapping("/dijkstra")
  public ResultResponse<List<AlgorithmPojo.ShortestPathResponse>> dijkstra(@RequestBody AlgorithmPojo.ShortestPathRequest request) {
    List<AlgorithmPojo.ShortestPathResponse> result = dijkstraService.dijkstra(request);
    if (result.isEmpty()) {
      return ResultResponse.error(AlgVisErrorCode.RUNNING_ERROR);
    }
    return ResultResponse.success(result);
  }
}