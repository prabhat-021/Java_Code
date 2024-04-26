import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> list = new ArrayList<>();

    public void add(int item) {
        list.add(item);
        upHeapyfy(list.size() - 1);
    }

    private void upHeapyfy(int ci) {
        int pi = (ci - 1) / 2;
        if (list.get(pi) > list.get(ci)) {
            Swap(pi, ci);

            upHeapyfy(pi);
        }
    }

    public void Swap(int ith, int jth) {
        int ithe = list.get(ith);
        int jthe = list.get(jth);
        list.set(ith, jthe);
        list.set(jth, ithe);
    }

    public int size() {
        return list.size();
    }

    public int remove() {
        Swap(0, list.size() - 1);
        int rv = list.remove(list.size() - 1);
        downHeapify(0);
        return rv;
    }

    public void downHeapify(int pi) {
        int lci = 2 * pi + 1;
        int rci = 2 * pi + 2;
        int mini = pi;

        if (lci < list.size() && list.get(lci) < list.get(mini)) mini = lci;
        if (rci < list.size() && list.get(rci) < list.get(mini)) mini = rci;

        if (mini != pi) {
            Swap(mini, pi);
            downHeapify(mini);
        }
    }

    public void Display() {
        System.out.println(list);
    }
}
