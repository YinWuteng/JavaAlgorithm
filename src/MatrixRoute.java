/**
 * 矩阵中的路径是否存在，不能走已经走过的点
 * a,v,b,f,
 * h,r,w,q,
 * q,r,t,y
 * 回溯法
 */
public class MatrixRoute {

    public static void main(String[] args) {

        char[] data={'a','b','c','e','s','f','c','s','a','d','e','e'};
        char[] str={'a','b','c','b'};
        System.out.println(hasPaths(data,3,4,str));
    }

    /**
     * @param data 目标字符串
     * @param rows 总行数
     * @param cols 总列数
     * @param str  带查询路径
     * @return
     */
    public static boolean hasPaths(char[] data, int rows, int cols, char[] str) {
        //校验合法性
        if (data == null || !(data.length == rows * cols) && str.length < 1) return false;
        //初始化一个数组，用于记录该点是否已经走过
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        int pathLength = 0;
        //开始查询
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(data, rows, cols, i, j, visited, str, pathLength)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * @param data       带查询数组
     * @param rows       总行数
     * @param cols       总列数
     * @param row        行
     * @param col        列
     * @param visited    是否被走过
     * @param str        查询字符串
     * @param pathLength 已经查询长度
     * @return
     */
    public static boolean hasPath(char[] data, int rows, int cols, int row, int col, boolean[] visited, char[] str, int pathLength) {

        //校验合法性
        if (pathLength == str.length) return true;
        boolean hasPath = false;
        //当前点符合条件，则查找周围的四个点
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[row * cols+col]
                && data[row*cols+col] == str[pathLength]) {
            pathLength++;
            visited[row * col] = true;
            //按左上右下进行回调
            hasPath = hasPath(data, rows, cols, row , col-1, visited, str, pathLength)
                    || hasPath(data, rows, cols, row-1 , col, visited, str, pathLength)
                    || hasPath(data, rows, cols, row, col + 1, visited, str, pathLength)
                    || hasPath(data, rows, cols, row+1, col , visited, str, pathLength);
            if (!hasPath) {
                pathLength--;
                visited[row * col] = false;
            }
        }
        return hasPath;
    }
}
