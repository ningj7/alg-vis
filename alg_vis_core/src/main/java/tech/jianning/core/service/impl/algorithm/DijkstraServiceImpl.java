package tech.jianning.core.service.impl.algorithm;

import org.springframework.stereotype.Service;
import tech.jianning.common.pojo.AlgorithmPojo;
import tech.jianning.common.utils.DataHandleUtils;
import tech.jianning.core.service.api.IDijkstraService;

import java.util.*;

@Service
public class DijkstraServiceImpl implements IDijkstraService {

    @Override
    public List<AlgorithmPojo.ShortestPathResponse> dijkstra(AlgorithmPojo.ShortestPathRequest request) {
        int num = request.getNum();
        Map<Integer, List<int[]>> edges = request.getEdges();
        int[] dis = new int[num];
        int[] visited = new int[num];
        Arrays.fill(dis, Integer.MAX_VALUE);
        List<AlgorithmPojo.ShortestPathResponse> result = new ArrayList<>();
        result.add(new AlgorithmPojo.ShortestPathResponse(edges, DataHandleUtils.copyArray(dis), DataHandleUtils.copyArray(visited), null));
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int st = request.getStart();
        dis[st] = 0;
        queue.offer(new int[]{st, 0});
        while (!queue.isEmpty()) {
            int[] v1 = queue.poll();
            if (visited[v1[0]] == 1) {
                continue;
            }
            visited[v1[0]] = 1;
            result.add(new AlgorithmPojo.ShortestPathResponse(edges, DataHandleUtils.copyArray(dis), DataHandleUtils.copyArray(visited), null));
            edges.getOrDefault(v1[0], Collections.emptyList()).forEach(v2 -> {
                if (visited[v2[0]] != 1) {
                    result.add(new AlgorithmPojo.ShortestPathResponse(edges, DataHandleUtils.copyArray(dis), DataHandleUtils.copyArray(visited), new int[]{v1[0], v2[0]}));
                    if (dis[v2[0]] > v1[1] + v2[1]) {
                        dis[v2[0]] = v1[1] + v2[1];
                        result.add(new AlgorithmPojo.ShortestPathResponse(edges, DataHandleUtils.copyArray(dis), DataHandleUtils.copyArray(visited), null));
                        queue.offer(new int[]{v2[0], dis[v2[0]]});
                    }
                }
            });
        }
        return result;
    }

}
