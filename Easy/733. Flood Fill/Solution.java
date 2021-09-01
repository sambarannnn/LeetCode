class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if(newColor != color) {
            dfs(image, sr, sc, color, newColor);
        }
        return image;
    }
    private void dfs(int[][] image, int i, int j, int color, int newColor) {
        if(image[i][j] == color) {
            image[i][j] = newColor;
            
            if(i >= 1)
                dfs(image, i-1, j, color, newColor);
            if(j >= 1)
                dfs(image, i, j-1, color, newColor);
            if(i+1 < image.length)
                dfs(image, i+1, j, color, newColor);
            if(j+1 < image[i].length)
                dfs(image, i, j+1, color, newColor);
        }
    }
}
