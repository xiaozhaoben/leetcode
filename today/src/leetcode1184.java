/*
 * 1184. 公交站间的距离
 * */
public class leetcode1184 {

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if (start > destination) {
            int temp = start;
            start = destination;
            destination = temp;
        }
        int sum = 0, count = 0;
        for (int i = 0; i < distance.length; i++) {
            sum += distance[i];
            if (i >= start && i < destination) {
                count += distance[i];
            }
        }
        return count > sum / 2 ? sum - count : count;
    }


}
