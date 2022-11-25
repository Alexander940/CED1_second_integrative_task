package model;

public class DFS {

    private Graph graph;
    private String sourceNode;
    private String endNode;

    public DFS(Graph graph, String sourceNode, String endNode) {
        this.graph = graph;
        this.sourceNode = sourceNode;
        this.endNode = endNode;
    }

    public DFS(Graph graph) {
        this.graph = graph;
    }

    public boolean dfsNodeToNode(){
        boolean [] visited = new boolean[graph.getNodes().length];
        visited[graph.returnPosition(sourceNode)] = true;
        Stack<Node> actual = new Stack<>();
        actual.push(graph.getNodes()[graph.returnPosition(sourceNode)]);
        return dfsNodeToNode(graph.returnPosition(sourceNode), graph.returnPosition(endNode), visited, actual, graph);
    }

    private boolean dfsNodeToNode(int a, int f, boolean [] visited, Stack<Node> actual, Graph graph){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(a, i) == 1 && i == f){
                return true;
            } else if(graph.getMatrixAdjacency(a, i) == 1 && !visited[i]) {
                actual.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfsNodeToNode(i, f, visited, actual, graph);
            }
        }
        actual.pop();
        if(actual.top() != null){
            return dfsNodeToNode(graph.returnPosition(actual.top().getName()), f, visited, actual, graph);
        }
        return false;
    }

    public boolean dfsAllRelated(){
        boolean [] visited = new boolean[graph.getNodes().length];
        visited[0] = true;
        Stack<Node> actual = new Stack<>();
        actual.push(graph.getNodes()[0]);
        visited = dfsAllRelated(0, visited, actual, graph);

        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                return false;
            }
        }

        return true;
    }

    private boolean [] dfsAllRelated(int source, boolean [] visited, Stack<Node> actual, Graph graph){
        for (int i = 0; i < visited.length; i++) {
            if(graph.getMatrixAdjacency(source, i) == 1 && !visited[i]) {
                actual.push(graph.getNodes()[i]);
                visited[i] = true;
                return dfsAllRelated(i, visited, actual, graph);
            }
        }
        actual.pop();
        if(actual.top() != null){
            return dfsAllRelated(graph.returnPosition(actual.top().getName()), visited, actual, graph);
        }
        return visited;
    }
}
