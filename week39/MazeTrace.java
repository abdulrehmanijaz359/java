import java.util.ArrayDeque;
import java.util.Deque;

public class MazeTrace {
    private static final String RESET = "\u001B[0m";
    private static final String GREEN_BG = "\u001B[42m";   // current position
    private static final String YELLOW_BG = "\u001B[43m";  // on the stack (current path)
    private static final String RED_BG = "\u001B[41m";     // dead end (popped)

    static char[][] maze = {
        "##########".toCharArray(),
        "#S   #   #".toCharArray(),
        "# ## # # #".toCharArray(),
        "# #    # #".toCharArray(),
        "# # ####E#".toCharArray(),
        "#   #    #".toCharArray(),
        "##########".toCharArray()
    };

    static boolean[][] visited;
    static boolean[][] deadEnd;
    static int step = 0;

    record Pos(int r, int c) {
        public String toString() { return "(" + r + "," + c + ")"; }
    }

    public static void main(String[] args) {
        visited = new boolean[maze.length][maze[0].length];
        deadEnd = new boolean[maze.length][maze[0].length];

        Pos start = find('S');
        Pos end = find('E');
        System.out.println("PHASE 1: Start = " + start + ", Exit = " + end);

        Deque<Pos> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start.r()][start.c()] = true;
        System.out.println("PUSH " + start + "   (start position)");

        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // up, right, down, left
        String[] names = {"up", "right", "down", "left"};

        System.out.println("PHASE 2: Searching");
        while (!stack.isEmpty()) {
            Pos cur = stack.peek();
            step++;
            System.out.println("\nStep " + step + ": current = " + cur + ", stack size = " + stack.size());

            if (cur.equals(end)) {
                System.out.println("PHASE 3: Exit reached!");
                printMaze(stack, cur);
                System.out.println("Path length: " + stack.size() + " positions");
                printPath(stack);
                return;
            }

            boolean moved = false;
            for (int i = 0; i < 4; i++) {
                Pos next = new Pos(cur.r() + dirs[i][0], cur.c() + dirs[i][1]);
                char ch = maze[next.r()][next.c()];
                if (ch == '#') {
                    System.out.println("  try " + names[i] + " " + next + " -> wall");
                } else if (visited[next.r()][next.c()]) {
                    System.out.println("  try " + names[i] + " " + next + " -> already visited");
                } else {
                    System.out.println("  try " + names[i] + " " + next + " -> free, PUSH");
                    visited[next.r()][next.c()] = true;
                    stack.push(next);
                    moved = true;
                    break;
                }
            }

            if (!moved) {
                deadEnd[cur.r()][cur.c()] = true;
                stack.pop();
                System.out.println("  no moves left -> DEAD END, POP " + cur + " (backtrack)");
            }
            printMaze(stack, stack.isEmpty() ? cur : stack.peek());
        }
        System.out.println("No path exists.");
    }

    static Pos find(char target) {
        for (int r = 0; r < maze.length; r++)
            for (int c = 0; c < maze[r].length; c++)
                if (maze[r][c] == target) return new Pos(r, c);
        throw new IllegalStateException("Missing " + target);
    }

    static void printMaze(Deque<Pos> stack, Pos current) {
        for (int r = 0; r < maze.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < maze[r].length; c++) {
                Pos p = new Pos(r, c);
                String cell = " " + maze[r][c] + " ";
                if (p.equals(current)) sb.append(GREEN_BG).append(cell).append(RESET);
                else if (stack.contains(p)) sb.append(YELLOW_BG).append(cell).append(RESET);
                else if (deadEnd[r][c]) sb.append(RED_BG).append(cell).append(RESET);
                else sb.append(cell);
            }
            System.out.println(sb);
        }
    }

    static void printPath(Deque<Pos> stack) {
        StringBuilder sb = new StringBuilder("Path: ");
        var it = stack.descendingIterator(); // bottom of stack = start
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(" -> ");
        }
        System.out.println(sb);
    }
}

