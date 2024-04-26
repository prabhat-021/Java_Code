import java.util.Comparator;
import java.util.List;

public class NonOverlappingInterval {
    public static void main(String[] args) {

    }

    private static class Interval {
        int startTime;
        int endTime;

        public Interval(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public String toString() {
            return startTime + "-" + endTime;
        }
    }

    private static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval i1, Interval i2) {
            if (i1.startTime > i2.startTime) return 1;
            else if (i1.startTime < i2.startTime) return -1;
            else return 0;
        }
    }

    public static int interval(List<Interval> intervalList) {
        intervalList.sort(new IntervalComparator());

        int result = 0;
        int previousEndTime = intervalList.get(0).endTime;

        for (int i = 1; i < intervalList.size(); i++) {
            Interval current = intervalList.get(i);

            if (current.startTime < previousEndTime) {
//                chote wale ko previous bana do
                previousEndTime = Math.min(previousEndTime, current.endTime);
                result++;
            } else {
                previousEndTime = current.endTime;
            }
        }
        return result;
    }
}
