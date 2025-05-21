package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AlgorithmPojo;

import java.util.List;

public interface ISearchService {

  List<AlgorithmPojo.SearchResponse> search(AlgorithmPojo.SearchRequest request);

}
