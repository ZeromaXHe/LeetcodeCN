//执行用时 :0 ms, 在所有Java提交中击败了100.00%的用户
//内存消耗 :34.6 MB, 在所有Java提交中击败了99.52%的用户
class Solution {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            rotateOuter(i, matrix);
        }
    }

    private void rotateOuter(int layer, int[][] matrix) {
        int len = matrix.length;
        int temp;
        for (int i = 0; i < matrix.length - 1 - 2*layer; i++) {
            temp = matrix[len - 1 - layer - i][layer];
            matrix[len - 1 - layer - i][layer] = matrix[len - 1 - layer][len - 1 - layer - i];
            matrix[len - 1 - layer][len - 1 - layer - i] = matrix[layer + i][len - 1 - layer];
            matrix[layer + i][len - 1 - layer] = matrix[layer][layer + i];
            matrix[layer][layer + i] = temp;
        }
    }
}