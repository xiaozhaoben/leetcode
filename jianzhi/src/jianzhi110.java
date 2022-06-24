import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
* 剑指 Offer II 110. 所有路径
* */
public class jianzhi110 {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path);
        return ans;
    }

    public void dfs(int[][] graph, int index, List<Integer> path){
        if(index == graph.length - 1){
            ans.add(new ArrayList<>(path));
        }
        for(int i = 0; i < graph[index].length; i++){
            path.add(graph[index][i]);
            dfs(graph, graph[index][i], path);
            path.remove(path.size() - 1);
        }
    }
}
