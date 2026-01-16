import java.util.*;

public class GraphCycle {
    static boolean dfs(int node,int parent,boolean[] vis,List<List<Integer>> g){
        vis[node]=true;
        for(int nei:g.get(node)){
            if(!vis[nei]){
                if(dfs(nei,node,vis,g)) return true;
            }
            else if(nei!=parent) return true;
        }
        return false;
    }

    public static void main(String[] args){
        int V=4;
        List<List<Integer>> g=new ArrayList<>();
        for(int i=0;i<V;i++) g.add(new ArrayList<>());

        g.get(0).add(1); g.get(1).add(0);
        g.get(1).add(2); g.get(2).add(1);
        g.get(2).add(3); g.get(3).add(2);
        g.get(3).add(0); g.get(0).add(3); // cycle

        boolean[] vis=new boolean[V];
        System.out.println(dfs(0,-1,vis,g));
    }
}
