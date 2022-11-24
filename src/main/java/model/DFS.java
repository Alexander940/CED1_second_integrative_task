package model;

public class DFS {

    private Graph graph;
    private int sourceNode;
    private int endNode;

    public DFS(Graph graph, int sourceNode, int endNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.endNode = endNode;
    }

    public boolean dfs(){
        boolean [] visited = new boolean[graph.getNodes().length];
        Stack<Node> actual = new Stack<>();
        actual.push(graph.getNodes()[graph.returnPosition(String.valueOf(sourceNode))]);
        return dfs(graph.returnPosition(String.valueOf(sourceNode)), graph.returnPosition(String.valueOf(endNode)), visited, actual, graph);
    }

    private boolean dfs(int a, int f, boolean [] visited, Stack<Node> actual, Graph graph){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(a, i) == 1 && i == f){
                return true;
            } else if(graph.getMatrixAdjacency(a, i) == 1 && !visited[i]) {
                actual.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfs(i, f, visited, actual, graph);
            }
        }
        actual.pop();
        if(actual.top() != null){
            return dfs(graph.returnPosition(actual.top().getName()), f, visited, actual, graph);
        }
        return false;
    }
}
