package TOP_450.TREE.BST;

/*
    Problem- https://www.geeksforgeeks.org/given-n-appointments-find-conflicting-appointments/

    Input: appointments[] = { {1, 5} {3, 7}, {2, 6}, {10, 15}, {5, 6}, {4, 100}}
    Output: Following are conflicting intervals
        [[3,7] Conflicts with [1,5]
        [2,6] Conflicts with [1,5]
        [2,6] Conflicts with [3,7]
        [5,6] Conflicts with [3,7]
        [4,100] Conflicts with [1,5]
        [4,100] Conflicts with [3,7]
        [4,100] Conflicts with [10,15]
        [4,100] Conflicts with [5,6]

        1. Create an Interval Tree, initially with the first appointment.
        2. Do following for all other appointments starting from the second one.
            - Check if the current appointment conflicts with any of the existing  appointments in Interval Tree.
              If conflicts, then print the current appointment.  This step can be done O(Log(n)) time.
            - Insert the current appointment in Interval Tree. This step also can be done O(Log(n)) time.
 */
public class ConflictingAppointments {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class Node {
        Interval interval;
        Node left;
        Node right;

        Node(Interval i) {
            this.interval = i;
        }
    }

    void print(Node root) {
        if (null == root) return;
        print(root.left);
        System.out.println("{ " + root.interval.start + "," + root.interval.end + " }");
        print(root.right);
    }

    Node insert(Node root, Interval i) {
        if (null == root) {
            return new Node(i);
        }
        if (i.start < root.interval.start ||
                (i.start == root.interval.start && i.end <= root.interval.end)) {
            root.left = insert(root.left, i);
        } else {
            root.right = insert(root.right, i);
        }
        return root;
    }

    /*
          For overlapping, the best way to check between A and B is if the latest interval starts before the earliest interval end.
          A: 1...2......3
                   B 2.5.........6
                   Latest interval start= Math.max(i1.start, i2.start)
                   Earliest interval end= Math.min(i1.end, i2.end)
     */
    boolean isConflict(Interval i1, Interval i2) {
        return Math.max(i1.start, i2.start) < Math.min(i1.end, i2.end);
    }

    public void OverlapSearch(Node root, Interval i) {
        if (null == root) return;
        if (isConflict(root.interval, i)) {
            System.out.print("[" + i.start +
                    "," + i.end +
                    "] Conflicts with [" +
                    root.interval.start + "," +
                    root.interval.end + "]\n");
        }
        if (i.start < root.interval.start)
            OverlapSearch(root.left, i);
        else
            OverlapSearch(root.right, i);
    }


    public static void main(String[] args) {
        Interval[] intervals = {new Interval(1, 5),
                new Interval(3, 7),
                new Interval(2, 6),
                new Interval(10, 15),
                new Interval(5, 6),
                new Interval(4, 100)};

        ConflictingAppointments conflictingAppointments = new ConflictingAppointments();

        Node root = null;
        root = conflictingAppointments.insert(root, intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            conflictingAppointments.OverlapSearch(root, intervals[i]);
            root = conflictingAppointments.insert(root, intervals[i]);
        }

    }
}
