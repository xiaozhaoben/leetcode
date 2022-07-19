import java.util.ArrayList;
import java.util.List;

/*
 * 729. 我的日程安排表 I
 * */
public class leetcode729 {

    class MyCalendar {

        List<int[]> list;

        public MyCalendar() {
            list = new ArrayList<int[]>();
        }

        public boolean book(int start, int end) {
            if (list.isEmpty()) {
                list.add(new int[]{start, end});
                return true;
            }
            if (list.get(0)[0] >= end) {
                if (list.get(0)[0] == end) {
                    list.get(0)[0] = start;
                } else {
                    list.add(0, new int[]{start, end});
                }
                return true;
            }
            for (int i = 0; i < list.size(); i++) {
                if (start >= list.get(i)[0] && start < list.get(i)[1]) {
                    return false;
                }
                if (end > list.get(i)[0] && end <= list.get(i)[1]) {
                    return false;
                }
                if (start >= list.get(i)[1] && (i == list.size() - 1 || end <= list.get(i + 1)[0])) {
                    if (start == list.get(i)[1] && (i == list.size() - 1 || end == list.get(i + 1)[0])) {
                        if (i + 1 < list.size()) {
                            list.get(i)[1] = list.get(i + 1)[1];
                            list.remove(i + 1);
                        } else {
                            list.get(i)[1] = end;
                        }
                    } else if (start == list.get(i)[1]) {
                        list.get(i)[1] = end;
                    } else if (i != list.size() - 1 && end == list.get(i + 1)[0]) {
                        list.get(i + 1)[0] = start;
                    } else {
                        list.add(i + 1, new int[]{start, end});
                    }
                    return true;
                }
            }
            return false;
        }
    }

    //TreeSet
//    class MyCalendar {
//        TreeSet<int[]> calendar;
//        public MyCalendar() {
//            calendar = new TreeSet<>((a, b) -> a[0] - b[0]);
//        }
//
//        public boolean book(int start, int end) {
//            int[] cur = new int[]{start, end};
//            int[] pre = calendar.floor(cur);
//            int[] after = calendar.ceiling(cur);
//            if (pre != null && start < pre[1]) return false;
//            if (after != null && end > after[0]) return false;
//            calendar.add(cur);
//            return true;
//        }
//    }
}
