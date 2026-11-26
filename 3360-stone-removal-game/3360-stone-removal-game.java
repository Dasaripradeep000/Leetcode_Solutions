class Solution {
    public boolean canAliceWin(int n) {
        int a = 10;
        boolean game = true;

        while (n >= a) {
            n -= a;
            a--;
            game = !game;
        }
        return !game;
    }
}