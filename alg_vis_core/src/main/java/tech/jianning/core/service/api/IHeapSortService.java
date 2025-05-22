package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AlgorithmPojo;

import java.util.List;

public interface IHeapSortService {

    List<AlgorithmPojo.HeapSortResponse> heapSort(AlgorithmPojo.SortRequest request);

}
