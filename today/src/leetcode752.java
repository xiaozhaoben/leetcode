import java.util.*;

public class leetcode752 {
    public static int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        Set<String> deadendSet = new HashSet<>(Arrays.asList(deadends));
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int index = 0; index < size; index++) {
                String current = queue.poll();
                if (deadendSet.contains(current)) {
                    continue;
                }
                if (current.equals(target)) {
                    return step - 1;
                }

                for (int i = 0; i < 4; i++) {
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    for (int j = 0; j < 4; j++) {
                        if (i == j) {
                            sb.append(((current.charAt(j) - '0') + 1) % 10);
                            sb2.append(((current.charAt(j) - '0') + 9) % 10);
                        } else {
                            sb.append(current.charAt(j));
                            sb2.append(current.charAt(j));
                        }
                    }
                    if (!set.contains(sb.toString())) {
                        queue.offer(sb.toString());
                        set.add(sb.toString());
                    }
                    if (!set.contains(sb2.toString())) {
                        queue.offer(sb2.toString());
                        set.add(sb2.toString());
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(openLock(new String[] {"0201","0101","0102","1212","2002"}, "0009"));
    }

}
