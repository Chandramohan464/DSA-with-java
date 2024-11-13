package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class GraphListRepresentation {
    int V;
    int E;
    LinkedList<Integer>[] adj;

    public GraphListRepresentation(int nodes) {
        V=nodes;
        E=0;
        adj=new LinkedList[nodes];
        for (int i=0;i<V; i++) {
            adj[i]=new LinkedList<>();
        }
    }

    public void addEdge(int u,int v){
        adj[u].add(v);
        adj[v].add(u);
        E++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(V+" Vertices "+E+" Edges "+"\n");
        for (int i=0;i<V; i++) {
            sb.append(i+"->");
            for (int it:adj[i]) {
                sb.append(it+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void bfs(int s){
        boolean[] visited=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        visited[s]=true;
        q.offer(s);
        while(!q.isEmpty()){
            int u=q.poll();
            System.out.print(u+" ");
            for (int i:adj[u]){
                if (!visited[i]){
                    visited[i]=true;
                    q.offer(i);
                }
            }
        }
    }

    public void dfs(int s){
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        while (!stack.isEmpty()) {
            int u=stack.pop();
            if (!visited[u]) {
                visited[u]=true;
                System.out.print(u+" ");
                for (int i:adj[u]) {
                    if (!visited[i]) {
                        stack.push(i);
                    }
                }
            }
        }
    }
    
    public static void main(String[] args) {
       GraphListRepresentation g=new GraphListRepresentation(5);
       g.addEdge(0,1);
       g.addEdge(1,2);
       g.addEdge(2,3);
       g.addEdge(3,0);
       g.addEdge(2,4);
       System.out.println(g);
       System.out.println("---BFS Traversal---");
       g.bfs(0);
       System.out.println();
       System.out.println("---DFS Traversal---");
       g.dfs(0);
    }
}
