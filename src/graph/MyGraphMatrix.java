package graph;

public class MyGraphMatrix {
   private int v;
   private int[][]adjMatrix;

    public MyGraphMatrix(int v) {
        this.v = v;
        adjMatrix = new int[v][v];
    }

    void addEdge(int i, int j){
        adjMatrix[i][j] = 1;
        adjMatrix[j][i] = 1;
    }

    void printMatrix(){
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
