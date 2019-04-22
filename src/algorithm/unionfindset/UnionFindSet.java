package algorithm.unionfindset;

// ���鼯ʵ��
public class UnionFindSet {

//    class Node {
//        int value;
//        public Node (int value) {
//            this.value = value;
//        }
//    }
    private int n; // Ԫ�ظ���
    private int[] roots = new int[n];
    private void init() {
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int p) {
        if (p < 0) {
            return -2;
        }
        int rt = p;
        while (roots[rt] != rt) {
            rt = roots[rt];
        }
        while (p != roots[p]) {
            int tmp = roots[p];
            roots[p] = rt;
            p = tmp;
        }
        return rt;
    }

    private boolean sameRoot(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        if (rootp != rootq)
            roots[rootp] = rootq;
    }
}
