package com.goat.calvin.service.provider.domain.leetcode.swordtooffer;

/**
 * @author xiefei
 * @date 2022/5/25 8:35
 */
public class Demo12 {

    /**
     * dfs + 剪枝
     */
    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 每一个字符都有可能是开头
                if (check(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }


    public boolean check(char[][] board, char[] words, int r, int c, int index) {
        // 剪枝
        if (r < 0 || r > board.length || c < 0 || c > board[0].length || board[r][c] != words[index]) return false;
        if (index == words.length - 1) return true;
        board[r][c] = ' ';
        // dfs
        boolean res = check(board, words, r, c - 1, index + 1) || check(board, words, r, c + 1, index + 1)
                || check(board, words, r - 1, c, index + 1) || check(board, words, r + 1, c, index + 1);
        // 还原的目的为了不影响下一次的校验
        board[r][c] = words[index];
        return res;
    }
}
