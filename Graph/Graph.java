package Graph;

public class Graph {
    int V;
    int E;
    int[][] adjMatrix;

    Graph(int nodes){
        V=nodes;
        E=0;
        adjMatrix=new int[nodes][nodes];
    }

    public void addEdge(int u,int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;
        E++;
    }

    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append(V+" Vertices "+E+" Edges "+"\n");
        for(int i=0;i<V;i++){
            for(int j:adjMatrix[i]){
                sb.append(j+" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 0);
        System.out.println(g);
    }
}
