public class Rat_In_Maze {
    public static void main(String[] args) {

    }

    public static void ratInMaze(char[][] maze, int cr, int cc, int[][] ans) {
        if (cr == maze.length - 1 && cc == maze[0].length - 1 && maze[cr][cc] != 'X') {
            ans[cr][cc] = 1;
            display(ans);
            return;
        }

        if (cr < 0 || cr >= maze.length || cc < 0 || cc >= maze[0].length || maze[cr][cc] == 'X') return;

        maze[cr][cc] = 'X';
        ans[cr][cc] = 1;

        ratInMaze(maze, cr, cc - 1, ans);// left
        ratInMaze(maze, cr, cc + 1, ans);// right
        ratInMaze(maze, cr - 1, cc, ans);// up
        ratInMaze(maze, cr + 1, cc, ans);// down

        maze[cr][cc] = '0';
        ans[cr][cc] = 0;
    }

    public static void display(int[][] ans) {
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[0].length; j++) {
                System.out.println(ans[i][j]);
            }
        }
    }
}
