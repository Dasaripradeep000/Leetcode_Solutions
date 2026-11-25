import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        solve(0, candidates, target, new ArrayList<>(), ans);
        return ans;
    }

    private void solve(int index, int[] nums, int target, List<Integer> current, List<List<Integer>> ans) {
        if (target == 0) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates at the same level of recursion
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }

            // 1. Choose the number
            current.add(nums[i]);
            
            // 2. Explore further (pass i + 1 because each number can be used only once)
            solve(i + 1, nums, target - nums[i], current, ans);
            
            // 3. Backtrack (undo the choice)
            current.remove(current.size() - 1);
        }
    }
}