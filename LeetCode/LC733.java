class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        return helper(image, sr, sc, newColor, image[sr][sc]);
    }
    
    private int[][] helper(int[][] image, int sr, int sc, int newColor, int color) {
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length) {
            return image;
        }
        if (image[sr][sc] == color) {
            image[sr][sc] = newColor;
        }
        else {
            return image;
        }
        image = helper(image, sr-1, sc, newColor, color);
        image = helper(image, sr+1, sc, newColor, color);
        image = helper(image, sr, sc-1, newColor, color);
        image = helper(image, sr, sc+1, newColor, color);
        return image;
        
    }
}
