package tech.jianning.core.service.impl.algorithm;

import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.ISearchService;

import java.util.*;

@Service
public class SearchServiceImpl implements ISearchService {

    @Override
    public List<AlgorithmPojo.SearchResponse> search(AlgorithmPojo.SearchRequest request) {
        int num = request.getNum();
        Map<Integer, List<Integer>> edges = request.getEdges();
        int[] visited = new int[num];
        List<AlgorithmPojo.SearchResponse> result = new ArrayList<>();
        result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, null));
        if (request.getType() == 1) {
            dfs(edges, visited, 0, result);
        } else {
            bfs(edges, visited, result);
        }
        return result;
    }

    private void dfs(Map<Integer, List<Integer>> edges, int[] visited, int cur, List<AlgorithmPojo.SearchResponse> result) {
        visited[cur] = 1;
        result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, null));
        edges.getOrDefault(cur, Collections.emptyList()).forEach(node -> {
            if (visited[node] == 0) {
                result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, new int[]{cur, node}));
                dfs(edges, visited, node, result);
            }
        });
    }

    private void bfs(Map<Integer, List<Integer>> edges, int[] visited, List<AlgorithmPojo.SearchResponse> result) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = 1;
        result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, null));
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            edges.getOrDefault(v, Collections.emptyList()).forEach(item -> {
                if (visited[item] == 0) {
                    result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, new int[]{v, item}));
                    visited[item] = 1;
                    result.add(new AlgorithmPojo.SearchResponse(DataHandleUtils.copyArray(visited), edges, null));
                    queue.offer(item);
                }
            });
        }
    }
}

