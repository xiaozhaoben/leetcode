import java.util.ArrayList;
import java.util.List;

/*
 * 1656. 设计有序流
 * */
public class leetcode1656 {

    class OrderedStream {

        String[] stream;
        int ptr;

        public OrderedStream(int n) {
            stream = new String[n + 1];
            ptr = 1;
        }

        public List<String> insert(int idKey, String value) {
            stream[idKey] = value;
            List<String> res = new ArrayList<>();
            if (ptr == idKey) {
                for (; ptr < stream.length; ptr++) {
                    if (stream[ptr] == null) break;
                    res.add(stream[ptr]);
                }
            }
            return res;
        }
    }

}
