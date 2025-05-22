package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AlgorithmPojo;

import java.util.List;

public interface IDijkstraService {

    List<AlgorithmPojo.ShortestPathResponse> dijkstra(AlgorithmPojo.ShortestPathRequest request);

}
