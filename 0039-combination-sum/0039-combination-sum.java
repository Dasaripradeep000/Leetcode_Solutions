class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve( 0, candidates , target , new ArrayList<>() , ans);
        return ans;
    }
    private void solve(int index , int[] nums ,int target , List<Integer> current , List<List<Integer>> ans){
       if(target == 0){
        ans.add(new ArrayList<>(current));
        return;
       }
       if(target <0){
        return ;
       }
       for(int i=index ; i<nums.length; i++){
        current.add(nums[i]);
        solve(i , nums , target - nums[i] , current , ans);
        current.remove(current.size() -1);
       }

    }
}