package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static StringBuilder solution(int s, int n, int arr[]) {
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int tmp = arr[i];
            if (!queue.contains(tmp)) { // 큐에 현재 작업하려는 숫자가 없을 경우 = 캐시 미스
                if (queue.size() >= s) { // 사이즈가 다 찼을 경우
                    queue.poll();
                    queue.offer(tmp);
                } else {
                    queue.offer(tmp);
                }
            } else { // 캐시 히츠
                int idx = 0;
                for (int j = 0; j < queue.size(); j++) {
                    if (queue.get(j) == tmp) {
                        queue.offer(queue.remove(idx));
                        break;
                    }
                    idx++;
                }
            }
        }
        for (int i = queue.size() - 1; i >= 0; i--) {
            sb.append(queue.get(i)).append(" ");
        }
        return sb;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int s = Integer.parseInt(st.nextToken()); // 캐시 사이즈
        int n = Integer.parseInt(st.nextToken()); // 작업 갯수
        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(s, n, arr));
    }
}
