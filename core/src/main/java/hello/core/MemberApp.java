package hello.core;

import java.util.*;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        class Solution {
            public int solution(int[] picks, String[] minerals) {
                int answer = 0;

                int mList[] = new int[5];
                int sum = 0;
                
                for (int i = 0; i < minerals.length; i++) {

                    if (minerals.equals("diamond")) sum += 25;
                    else if (minerals.equals("iron")) sum += 5;
                    else sum += 1;

                    if ((i + 1) % 5 == 0) {
                        int idx = (i + 1) / 5 - 1;
                        mList[idx] = sum;
                        sum = 0;
                    }

                    Arrays.sort(mList);
                    for (int cost : mList) {
                        int t = 0;
                        for (int j = 0; j < picks.length; j++) {
                            if (picks[j] > 0) {
                                picks[j] -= 1;
                                t = j;
                                break;
                            }
                        }
                        double cCost = Math.ceil(cost / t);
                        if(cCost > 5) answer += cCost;
                        else answer += 5;
                    }

                }
                return answer;
            }
        }
    }
}
