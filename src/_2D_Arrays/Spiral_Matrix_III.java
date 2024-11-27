package _2D_Arrays;

public class Spiral_Matrix_III {
    public static void main(String[] args) {
        int rows = 5 ,cols = 6;
        int rStart = 1 ,cStart = 4;

        int total = rows * cols;

        int[][] arr = new int[total][2];
        int x = rStart;
        int y = cStart;

        int steps = 1;
        arr[0][0] = x;
        arr[0][1] = y;
        int idx = 1;

        while (idx < total) {
            // going towards Right
            for (int j = 1; j <= steps && idx < total; j++) {
                if (validIdx(x, y+j, rows, cols)) {
                    arr[idx][0] = x;
                    arr[idx++][1] = y+j;
                }
            }
            y += steps;

            // going towards Bottom
            for (int i = 1; i <= steps && idx < total; i++) {
                if (validIdx(x+i, y, rows, cols)) {
                    arr[idx][0] = x+i;
                    arr[idx++][1] = y;
                }
            }
            x += steps;
            steps++;

            // going towards Left
            for (int j = 1; j <= steps && idx < total; j++) {
                if (validIdx(x, y-j, rows, cols)) {
                    arr[idx][0] = x;
                    arr[idx++][1] = y-j;
                }
            }
            y -= steps;

            // going towards Top
            for (int i = 1; i <= steps && idx < total; i++) {
                if (validIdx(x-i, y, rows, cols)) {
                    arr[idx][0] = x-i;
                    arr[idx++][1] = y;
                }
            }
            x -= steps;
            steps++;
        }

        for (int i = 0; i < total; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean validIdx(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y <cols;
    }
}
