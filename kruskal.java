import java.util.ArrayList;
import java.util.Collections;
import java.lang.Comparable;

// Comparable 인터페이스를 이용하여 간선들을 정렬
class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    public Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight; // 오름차순으로 정렬
    }
}

public class kruskal {
    public static int[] parent;
    public static ArrayList<Edge> edgeList;

    // find() 함수로 부모 노드 찾기
    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    // isSameParent() 함수로 부모 노드가 같은지 검사
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return true;
        else return false;
    }

    // union() 함수로 두 정점 합치기
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y)
            parent[y] = x;
    }

    public static void main(String args[]) {
        edgeList = new ArrayList<Edge>();
        edgeList.add(new Edge(0, 1, 29));
        edgeList.add(new Edge(1, 2, 16));
        edgeList.add(new Edge(2, 3, 12));
        edgeList.add(new Edge(3, 4, 22));
        edgeList.add(new Edge(4, 5, 27));
        edgeList.add(new Edge(5, 0, 10));
        edgeList.add(new Edge(6, 1, 15));
        edgeList.add(new Edge(6, 3, 18));
        edgeList.add(new Edge(6, 4, 25));

        parent = new int[7];
        for (int i = 1; i <= 7; i++) {
            parent[i] = i;
        }

        Collections.sort(edgeList);

        int sum = 0; // 가중치 합
        for (int i = 0; i < edgeList.size(); i++) {
            Edge edge = edgeList.get(i);
            if (!isSameParent(edge.v1, edge.v2)) {
                sum += edge.weight; // sum = sum + edge.weight
                union(edge.v1, edge.v2);
            }
        }

        System.out.println(sum);
    }
}
