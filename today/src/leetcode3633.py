# 给你两种类别的游乐园项目：陆地游乐设施 和 水上游乐设施。
#
#
#  陆地游乐设施
#
#
#
#  landStartTime[i] – 第 i 个陆地游乐设施最早可以开始的时间。
#  landDuration[i] – 第 i 个陆地游乐设施持续的时间。
#
#
#  水上游乐设施
#
#  waterStartTime[j] – 第 j 个水上游乐设施最早可以开始的时间。
#  waterDuration[j] – 第 j 个水上游乐设施持续的时间。
#
#
#
#
#  一位游客必须从 每个 类别中体验 恰好一个 游乐设施，顺序 不限 。
#
#
#  游乐设施可以在其开放时间开始，或 之后任意时间 开始。
#  如果一个游乐设施在时间 t 开始，它将在时间 t + duration 结束。
#  完成一个游乐设施后，游客可以立即乘坐另一个（如果它已经开放），或者等待它开放。
#
#
#  返回游客完成这两个游乐设施的 最早可能时间 。
#
#
#
#  示例 1:
#
#
#  输入：landStartTime = [2,8], landDuration = [4,1], waterStartTime = [6],
# waterDuration = [3]
#
#
#  输出：9
#
#  解释：
#
#
#  方案 A（陆地游乐设施 0 → 水上游乐设施 0）：
#
#  在时间 landStartTime[0] = 2 开始陆地游乐设施 0。在 2 + landDuration[0] = 6 结束。
#  水上游乐设施 0 在时间 waterStartTime[0] = 6 开放。立即在时间 6 开始，在 6 + waterDuration[0] = 9 结
# 束。
#
#  方案 B（水上游乐设施 0 → 陆地游乐设施 1）：
#
#  在时间 waterStartTime[0] = 6 开始水上游乐设施 0。在 6 + waterDuration[0] = 9 结束。
#  陆地游乐设施 1 在 landStartTime[1] = 8 开放。在时间 9 开始，在 9 + landDuration[1] = 10 结束。
#
#  方案 C（陆地游乐设施 1 → 水上游乐设施 0）：
#
#  在时间 landStartTime[1] = 8 开始陆地游乐设施 1。在 8 + landDuration[1] = 9 结束。
#  水上游乐设施 0 在 waterStartTime[0] = 6 开放。在时间 9 开始，在 9 + waterDuration[0] = 12 结束。
#
#
#  方案 D（水上游乐设施 0 → 陆地游乐设施 0）：
#
#  在时间 waterStartTime[0] = 6 开始水上游乐设施 0。在 6 + waterDuration[0] = 9 结束。
#  陆地游乐设施 0 在 landStartTime[0] = 2 开放。在时间 9 开始，在 9 + landDuration[0] = 13 结束。
#
#
#
#  方案 A 提供了最早的结束时间 9。
#
#  示例 2:
#
#
#  输入：landStartTime = [5], landDuration = [3], waterStartTime = [1],
# waterDuration = [10]
#
#
#  输出：14
#
#  解释：
#
#
#  方案 A（水上游乐设施 0 → 陆地游乐设施 0）：
#
#  在时间 waterStartTime[0] = 1 开始水上游乐设施 0。在 1 + waterDuration[0] = 11 结束。
#  陆地游乐设施 0 在 landStartTime[0] = 5 开放。立即在时间 11 开始，在 11 + landDuration[0] = 14 结束
# 。
#
#  方案 B（陆地游乐设施 0 → 水上游乐设施 0）：
#
#  在时间 landStartTime[0] = 5 开始陆地游乐设施 0。在 5 + landDuration[0] = 8 结束。
#  水上游乐设施 0 在 waterStartTime[0] = 1 开放。立即在时间 8 开始，在 8 + waterDuration[0] = 18 结束
# 。
#
#
#
#  方案 A 提供了最早的结束时间 14。
#
#
#
#  提示:
#
#
#  1 <= n, m <= 100
#  landStartTime.length == landDuration.length == n
#  waterStartTime.length == waterDuration.length == m
#  1 <= landStartTime[i], landDuration[i], waterStartTime[j], waterDuration[j] <
# = 1000
#
#
#  Related Topics 贪心 数组 双指针 二分查找 排序 👍 13 👎 0
from _bisect import bisect_right


# leetcode submit region begin(Prohibit modification and deletion)
class Solution(object):
    def earliestFinishTime(self, landStartTime, landDuration, waterStartTime, waterDuration):
        def solve(firstStart, firstDuration, secondStart, secondDuration):
            rides = sorted(zip(secondStart, secondDuration))
            starts = [s for s, d in rides]
            n = len(rides)

            prefix_min_duration = [10 ** 18] * n
            for i, (s, d) in enumerate(rides):
                if i == 0:
                    prefix_min_duration[i] = d
                else:
                    prefix_min_duration[i] = min(prefix_min_duration[i - 1], d)

            suffix_min_finish = [10 ** 18] * (n + 1)
            for i in range(n - 1, -1, -1):
                s, d = rides[i]
                suffix_min_finish[i] = min(s + d, suffix_min_finish[i + 1])

            ans = 10 ** 18

            for s, d in zip(firstStart, firstDuration):
                t = s + d
                idx = bisect_right(starts, t)

                if idx > 0:
                    ans = min(ans, t + prefix_min_duration[idx - 1])

                if idx < n:
                    ans = min(ans, suffix_min_finish[idx])

            return ans

        return min(
            solve(landStartTime, landDuration, waterStartTime, waterDuration),
            solve(waterStartTime, waterDuration, landStartTime, landDuration)
        )
# leetcode submit region end(Prohibit modification and deletion)
