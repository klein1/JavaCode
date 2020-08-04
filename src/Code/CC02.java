package Code;

public class CC02 {

    public static void main(String[] args) {

        int[] c = new int[]{0,6,1,5,2,1};
        int[] w = new int[]{0,48,7,40,12,8};
        int V = 9;

        int n = c.length;
        int[][] f = new int[n][V];

        for (int i = 1; i < n; i++) {
            for (int v = 1; v < V; v++) {
                f[i][v] = f[i-1][v];
                if(v >= c[i])
                    f[i][v] = Math.max(f[i][v], f[i-1][v-c[i]] + w[i]);
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<V;j++) {
                System.out.printf("%-5d",f[i][j]);
            }
            System.out.println();
        }

        int max = 0;
        for (int i = 0; i < V; i++) {
            max = Math.max(max, f[n-1][i]);
        }

        System.out.println(max);

        int[][] g = new int[V][n];

        for (int v = 1; v < V; v++) {
            for (int i = 1; i < n; i++){
                g[v][i] = g[v][i-1];
                if(v >= c[i])
                    g[v][i] = Math.max(g[v][i], g[v-c[i]][i-1] + w[i]);
            }
        }

        for(int j=1;j<V;j++){
             for(int i=1;i<n;i++) {
                System.out.printf("%-5d",g[j][i]);
            }
            System.out.println();
        }

        int max2 = 0;
        for (int i = 0; i < V; i++) {
            max2 = Math.max(max2, g[i][n-1]);
        }

        System.out.println(max2);

    }
}
