// 733. Flood Fill

class Solution {
    private boolean isValid(int[][] image, int sr, int sc, int clr, int color) {
        if(sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == clr ) {
            return true;
        }
        return false;
    }

    private void floodFillRec(int[][] image, int sr, int sc, int clr, int color) {
        image[sr][sc] = color;

        if(isValid(image, sr+1, sc, clr, color)) {
            floodFillRec(image, sr+1, sc, clr, color);
        }
        if(isValid(image, sr-1, sc, clr, color)) {
            floodFillRec(image, sr-1, sc, clr, color);
        }
        if(isValid(image, sr, sc+1, clr, color)) {
            floodFillRec(image, sr, sc+1, clr, color);
        }
        if(isValid(image, sr, sc-1, clr, color)) {
            floodFillRec(image, sr, sc-1, clr, color);
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // int n = image.length;
        
        int clr = image[sr][sc];
        if(clr == color) {
            return image;
        }
        floodFillRec(image, sr, sc, clr, color);
        
        return image;
    }
}
