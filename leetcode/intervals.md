# Intervals


+ [Merge Intervals](#merge-intervals)
+ [Non-overlapping Intervals](#non-overlapping-intervals)
+ [Insert Interval](#insert-interval)

## Merge Intervals

https://leetcode.com/problems/merge-intervals/

```
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));
        ArrayList<int[]> answer = new ArrayList<>();

        int[] currentInterval = null;
        for (int[] nextInterval: intervals) {
            if (currentInterval == null || currentInterval[1] < nextInterval[0]) {
                answer.add(nextInterval);
                currentInterval = nextInterval;
            }
            else
                currentInterval[1] = Math.max(currentInterval[1], nextInterval[1]);
        }

        return answer.toArray(new int[0][]);
    }
}
```

## Non-overlapping Intervals

https://leetcode.com/problems/non-overlapping-intervals/

```
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1)
            return 0;

        Arrays.sort(intervals, Comparator.comparing(arr -> arr[1]));
        int answer = 1;

        int currentIntervalEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int currentIntervalStart = intervals[i][0];
            if (currentIntervalStart >= currentIntervalEnd) {
                answer++;
                currentIntervalEnd = intervals[i][1];
            }
        }
        return intervals.length - answer;
    }

}
```

## Insert Interval
https://leetcode.com/problems/insert-interval/

```
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> answer = new ArrayList<>();
        boolean newIntervalInserted = false;
        for (int[] currentInterval: intervals) {
            if (newIntervalInserted || currentInterval[1] < newInterval[0])
                answer.add(currentInterval);
            else if (newInterval[1] < currentInterval[0]) {
                newIntervalInserted = true;
                answer.add(newInterval);
                answer.add(currentInterval);
            }
            else {
                newInterval[0] = Math.min(currentInterval[0], newInterval[0]);
                newInterval[1] = Math.max(currentInterval[1], newInterval[1]);
            }
        }

        if (newIntervalInserted)
            return answer.toArray(new int[][]{});
        answer.add(newInterval);
        return answer.toArray(new int[][]{});
    }
}
```
