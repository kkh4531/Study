package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node {
    int data;
    Node lt, rt;

    public Node(int data) {
        this.data = data;
    }
}

public class Main {

    public static void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node current = q.poll();
                if (current.lt != null) {
                    q.add(current.lt);
                }
                if (current.rt != null) {
                    q.add(current.rt);
                }
            }
        }
    }

    static List<Integer> check = new ArrayList<>();

    public static int solution(int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(s);
        int L = 0;
        boolean flag = true;
        check.add(s);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                if (q.peek() == e) {
                    flag = false;
                    break;
                } else {
                    int tmp = q.poll();
                    if (!check.contains(tmp + 1)) {
                        check.add(tmp + 1);
                        q.offer(tmp + 1);
                    }
                    if (!check.contains(tmp - 1)) {
                        check.add(tmp - 1);
                        q.offer(tmp - 1);
                    }
                    if (!check.contains(tmp + 5)) {
                        check.add(tmp + 5);
                        q.offer(tmp + 5);
                    }
                }
            }
            if (!flag) {
                break;
            }
            L++;
        }
        return L;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        System.out.println(solution(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }
}