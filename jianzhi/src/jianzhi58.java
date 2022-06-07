import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
* 剑指 Offer II 058. 日程表
* */
public class jianzhi58 {


    class MyCalendar {

        private TreeMap<Integer, Integer> map;

        public MyCalendar() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Map.Entry<Integer, Integer> entry1 = map.floorEntry(start);
            Map.Entry<Integer, Integer> entry2 = map.ceilingEntry(start);
            if(entry1 != null && entry1.getValue() > start){
                return false;
            }
            if(entry2 != null && entry2.getKey() < end){
                return false;
            }
            map.put(start, end);
            return true;
        }
    }


}
