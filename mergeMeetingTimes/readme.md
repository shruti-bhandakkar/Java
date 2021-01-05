Your company built an in-house calendar tool called HiCal.
You want to add a feature to see the times in a day when everyone is available.

To do this, you’ll need to know when any team is having a meeting.
In HiCal, a meeting is stored as an object of a Meeting class with integer variables startTime and endTime.
These integers represent the number of 30-minute blocks past 9:00am.

Write a method mergeRanges() that takes a list of multiple meeting time ranges and returns a list of condensed ranges.

For example, given:

  [Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12), Meeting(9, 10)]

your method would return:

  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]

 Do not assume the meetings are in order. The meeting times are coming from multiple teams.

 Write a solution that's efficient even when we can't put a nice upper bound on the numbers representing our time ranges. Here we've simplified our times down to the number of 30-minute slots past 9:00 am. But we want the method to work even for very large numbers, like Unix timestamps. In any case, the spirit of the challenge is to merge meetings where startTime and endTime don't have an upper bound.

 Gotchas
Look at this case:

  [Meeting(1, 2), Meeting(2, 3)]

These meetings should probably be merged, although they don't exactly "overlap"—they just "touch." Does your method do this?

Look at this case:

  [Meeting(1, 5), Meeting(2, 3)]

Notice that although the second meeting starts later, it ends before the first meeting ends. Does your method correctly handle the case where a later meeting is "subsumed by" an earlier meeting?

Look at this case:

  [Meeting(1, 10), Meeting(2, 6), Meeting(3, 5), Meeting(7, 9)]

Here all of our meetings should be merged together into just Meeting(1, 10). We need keep in mind that after we've merged the first two we're not done with the result—the result of that merge may itself need to be merged into other meetings as well.

Make sure that your method won't "leave out" the last meeting.

We can do this in O(n log n) time.
