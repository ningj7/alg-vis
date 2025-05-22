package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AlgorithmPojo;

import java.util.List;

public interface IMergeSortService {

    List<AlgorithmPojo.MergeSortResponse> mergeSort(AlgorithmPojo.SortRequest request);

}
