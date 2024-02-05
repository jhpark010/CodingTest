package practice.programmers.level_2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Practice_lessons_178870 {
	public static void main(String[] args) {
		// Test Case
		int[] sequence = {1,2,3,4,5};
		int k = 7;
		
		// Answer
		Practice_lessons_178870 main = new Practice_lessons_178870();
		System.out.println(Arrays.toString(main.solution(sequence, k)));
	}
	
    public int[] solution(int[] sequence, int k) {
        int sum = 0;
        int sIdx = 0;
        int eIdx = 0;
        sum += sequence[sIdx];
        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
        	@Override
        	public int compare(Info a, Info b) {
        		return a.diff - b.diff;
        	}
        });
        
        while (eIdx != sequence.length || sIdx <= eIdx) {
            if (sum < k) {
                eIdx++;
                if (eIdx == sequence.length) break;
                sum += sequence[eIdx];
            } else if (sum > k) {
                sum -= sequence[sIdx++];
            } else if (sum == k) {
                pq.add(new Info(sIdx, eIdx, eIdx - sIdx));
                sum -= sequence[sIdx++];
            }
        }
        
        int[] answer = new int[2];
        Info info = pq.poll();
        answer[0] = info.sIdx;
        answer[1] = info.eIdx;
        
        return answer;
    }
    
    class Info {
        int sIdx;
        int eIdx;
        int diff;
        
        Info (int sIdx, int eIdx, int diff) {
            this.sIdx = sIdx;
            this.eIdx = eIdx;
            this.diff = diff;
        }
    }
}


















