package org.example;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
6. 최대 길이 연속부분수열
설명

0과 1로 구성된 길이가 N인 수열이 주어집니다. 여러분은 이 수열에서 최대 k번을 0을 1로 변경할 수 있습니다. 여러분이 최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하세요.

만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면

1 1 0 0 1 1 0 1 1 0 1 1 0 1

여러분이 만들 수 있는 1이 연속된 연속부분수열은

Image1.jpg

이며 그 길이는 8입니다.


입력

첫 번째 줄에 수열의 길이인 자연수 N(5<=N<100,000)이 주어집니다.

두 번째 줄에 N길이의 0과 1로 구성된 수열이 주어집니다.


출력

첫 줄에 최대 길이를 출력하세요.


예시 입력 1

14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
예시 출력 1

8
 */
public class Main {
    public static int solution(int n, int k, int arr[]) {
        int max = Integer.MIN_VALUE;
        int cnt = 0;
        int zeroCnt = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] != 1) { // arr[rt]가 1일 때는 그냥 cnt++만 하면 된다.
                if (zeroCnt + 1 > k) { // zeroCntr가 k를 넘어가게 되면
                    while (true) { // arr[lt]가 0인 곳을 찾기까지 계속 cnt를 1씩 감소시킨다. 찾으면 break
                        if (arr[lt] == 1) {
                            cnt--;
                            lt++;
                            continue;
                        }
                        cnt--;
                        lt++;
                        break;
                    }
                }
                zeroCnt++; // arr[rt]가 0이면 zeroCnt++
            }
            cnt++;
            if (cnt > max) { // 최댓값 갱신
                max = cnt;
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(n, k, arr));
    }

}
