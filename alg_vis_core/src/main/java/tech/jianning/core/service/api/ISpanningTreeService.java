package tech.jianning.core.service.api;

import tech.jianning.common.pojo.AlgorithmPojo;

import java.util.List;

public interface ISpanningTreeService {

    List<AlgorithmPojo.SpanningTreeResponse> spanningTree(AlgorithmPojo.SpanningTreeRequest request);

}
