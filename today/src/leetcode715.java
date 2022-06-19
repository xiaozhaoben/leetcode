import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
* 715. Range 模块
* */
public class leetcode715 {

    class RangeModule {

        class Range{
            private int left;
            private int right;

            public int getLeft() {
                return left;
            }

            public int getRight() {
                return right;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public void setRight(int right) {
                this.right = right;
            }

            public Range(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }
        List<Range> list;

        public RangeModule() {
            list = new ArrayList<>();
        }

        public void addRange(int left, int right) {
            list.add(new Range(left, right));
            list.sort((r1, r2) -> {
                return r1.getLeft() - r2.getLeft();
            });
            List<Range> merge = new ArrayList<>();
            for (Range range : list) {
                int L = range.getLeft(), R = range.getRight();
                if (merge.size() == 0 || merge.get(merge.size() - 1).getRight() < L) {
                    merge.add(new Range(L, R));
                } else {
                    merge.get(merge.size() - 1).setRight(Math.max(R, merge.get(merge.size() - 1).getRight()));
                }
            }
            list = merge;
        }

        public boolean queryRange(int left, int right) {
            for(int i = 0; i < list.size(); i++){
                System.out.println(list.get(i).left + " " + list.get(i).right);
                if (left >= list.get(i).getLeft() && right <= list.get(i).getRight()) {
                    return true;
                }
                if(list.get(i).getLeft() > right){
                    break;
                }
            }
            return false;
        }

        public void removeRange(int left, int right) {
            for(int i = 0; i < list.size(); i++){
                if (list.get(i).getLeft() > right){
                    break;
                }
                if(list.get(i).getRight() <= right && list.get(i).getLeft() < left && list.get(i).getRight() > left){
                    list.get(i).setRight(left);
                }else if(list.get(i).getRight() > right && list.get(i).getLeft() < right && list.get(i).getLeft() >= left){
                    list.get(i).setLeft(right);
                } else if(list.get(i).getRight() <= right && list.get(i).getLeft() >= left){
                    list.remove(i--);
                }else if(list.get(i).getLeft() < left && list.get(i).getRight() > right) {
                    int r = list.get(i).getRight();
                    list.get(i).setRight(left);
                    list.add(new Range(right, r));
                    list.sort((r1, r2) -> {
                        return r1.getLeft() - r2.getLeft();
                    });
                }
            }
        }

    }


}
