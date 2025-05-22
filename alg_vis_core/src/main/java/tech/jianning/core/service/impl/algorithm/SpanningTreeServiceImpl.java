package tech.jianning.core.service.impl.algorithm;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.ISpanningTreeService;

import java.util.*;

@Service
public class SpanningTreeServiceImpl implements ISpanningTreeService {

    private int[] visited;
    private int[][] edgeStatus;
    private int totalWeight;
    private Map<Integer, List<int[]>> edges;
    private int[] father;

    @Override
    public List<AlgorithmPojo.SpanningTreeResponse> spanningTree(AlgorithmPojo.SpanningTreeRequest request) {
        int num = request.getNum();
        visited = new int[num];
        edgeStatus = new int[num][num];
        totalWeight = 0;
        edges = request.getEdges();
        List<AlgorithmPojo.SpanningTreeResponse> result = new ArrayList<>();
        result.add(new AlgorithmPojo.SpanningTreeResponse(edges, DataHandleUtils.copyArray(visited), DataHandleUtils.copyArray(edgeStatus), totalWeight));
        if (request.getType() == 1) {
            prim(edges, result);
        } else {
            kruskal(edges, result);
        }
        return result;
    }

    private void prim(Map<Integer, List<int[]>> edges, List<AlgorithmPojo.SpanningTreeResponse> result) {
        int[] dis = new int[visited.length];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] v1 = queue.poll();
            if (visited[v1[0]] == 1) {
                continue;
            }
            if (v1.length == 3) edgeStatus[v1[2]][v1[0]] = edgeStatus[v1[0]][v1[2]] = 1;
            result.add(new AlgorithmPojo.SpanningTreeResponse(edges, DataHandleUtils.copyArray(visited), DataHandleUtils.copyArray(edgeStatus), totalWeight));
            visited[v1[0]] = 1;
            if (v1.length == 3) edgeStatus[v1[2]][v1[0]] = edgeStatus[v1[0]][v1[2]] = 2;
            totalWeight += v1[1];
            result.add(new AlgorithmPojo.SpanningTreeResponse(edges, DataHandleUtils.copyArray(visited), DataHandleUtils.copyArray(edgeStatus), totalWeight));
            edges.getOrDefault(v1[0], Collections.emptyList()).forEach(v2 -> {
                if (v2[1] < dis[v2[0]]) {
                    queue.offer(new int[]{v2[0], v2[1], v1[0]});
                    dis[v2[0]] = v2[1];
                }
            });
        }
    }

    private void kruskal(Map<Integer, List<int[]>> edges, List<AlgorithmPojo.SpanningTreeResponse> result) {
        father = new int[visited.length];
        for (int i = 0; i < visited.length; i++) father[i] = i;
        List<Edge> edgeList = new ArrayList<>();
        edges.forEach((k, v) -> v.forEach(item -> {
            if (k < item[0]) {
                edgeList.add(new Edge(k, item[0], item[1]));
            }
        }));
        edgeList.sort(Comparator.comparingInt(a -> a.weight));
        int cnt = 0;
        for (Edge item : edgeList) {
            if (cnt == visited.length - 1) break;
            int fx = find(item.v1);
            int fy = find(item.v2);
            edgeStatus[item.v1][item.v2] = edgeStatus[item.v2][item.v1] = 1;
            result.add(new AlgorithmPojo.SpanningTreeResponse(edges, DataHandleUtils.copyArray(visited), DataHandleUtils.copyArray(edgeStatus), totalWeight));
            if (fx != fy) {
                cnt++;
                father[fx] = fy;
                edgeStatus[item.v1][item.v2] = edgeStatus[item.v2][item.v1] = 2;
                visited[item.v1] = 1;
                visited[item.v2] = 1;
                totalWeight += item.weight;
                result.add(new AlgorithmPojo.SpanningTreeResponse(edges, DataHandleUtils.copyArray(visited), DataHandleUtils.copyArray(edgeStatus), totalWeight));
            } else {
                edgeStatus[item.v1][item.v2] = edgeStatus[item.v2][item.v1] = 0;
            }
        }
    }

    private int find(int x) {
        return x == father[x] ? x : (father[x] = find(father[x]));
    }

    @Data
    @AllArgsConstructor
    private static class Edge {
        private int v1;
        private int v2;
        private int weight;
    }
}
