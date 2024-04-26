import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaximumMeetingOneRoom {
    public static void main(String[] args) {
        List<Integer> value = List.of(1, 3, 0, 5, 8, 5);
        List<Integer> weight = List.of(2, 4, 6, 7, 9, 9);
        List<Meeting> itemList = new ArrayList<>();
        for (int i = 0; i < value.size(); i++) {
            Meeting item = new Meeting();
            item.startTime = value.get(i);
            item.finishTime = weight.get(i);
            item.meetingNumber = i + 1;
            itemList.add(item);
        }

        itemList.sort(new MeetingComparator());
        System.out.println(itemList);

        List<Integer> result = new ArrayList<>();
        result.add(itemList.get(0).meetingNumber);
        Meeting previouMeeting = itemList.get(0);
        for (int i = 1; i < itemList.size(); i++) {
            Meeting currentMeeting = itemList.get(i);
            if (currentMeeting.startTime > previouMeeting.finishTime) {
                result.add(currentMeeting.meetingNumber);
                previouMeeting = currentMeeting;
            }
        }
        System.out.println(result);
    }

    private static class Meeting {
        Integer startTime;
        Integer finishTime;
        Integer meetingNumber;

        public String toString() {
            return startTime + " " + finishTime;
        }
    }

    private static class MeetingComparator implements Comparator<Meeting> {
        public int compare(Meeting i1, Meeting i2) {
            if (i1.finishTime > i2.finishTime) return 1;
            else if (i1.finishTime < i2.finishTime) return -1;
            else return 0;
        }
    }
}
