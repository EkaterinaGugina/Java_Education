package HomeWork_27_12_22;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pathgraph {
    private final List<Cell> PointList;
    private final boolean[][] adjMatrix;

    public Pathgraph(int maxPointCount) {
        this.PointList = new ArrayList<>(maxPointCount);
        this.adjMatrix = new boolean[maxPointCount][maxPointCount];
    }

    public void addPoint(String label) {
        PointList.add(new Cell(label));
    }

    public boolean addEdge(String startLabel, String secondLabel) {
        int startIndex = indexOf(startLabel);
        int endIndex = indexOf(secondLabel);

        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        adjMatrix[startIndex][endIndex] = true;
        return false;
    }

    private int indexOf(String label) {
        for (int i = 0; i < PointList.size(); i++) {
            if (PointList.get(i).getLabel().equals(label)) {
                return i;
            }
        }
        return -1;
    }

    public boolean addEdge(String startLabel, String secondLabel, String... others) {
        boolean result = addEdge(startLabel, secondLabel);

        for (String other : others) {
            result &= addEdge(startLabel, other);
        }

        return result;
    }

    public int getSize() {
        return PointList.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < getSize(); i++) {
            sb.append(PointList.get(i));
            for (int j = 0; j < getSize(); j++) {
                if (adjMatrix[i][j]) {
                    sb.append(" -> ").append(PointList.get(j));
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private Cell getNearUnvisitedPoint(Cell Point) {
        int currentIndex = PointList.indexOf(Point);
        for (int i = 0; i < getSize(); i++) {
            if (adjMatrix[currentIndex][i] && !PointList.get(i).isVisited()) {
                return PointList.get(i);
            }
        }
        return null;
    }

    private void visitPoint(Queue<Cell> queue, Cell Point) {
        System.out.print(Point.getLabel() + " ");
        queue.add(Point);
        Point.setVisited(true);
    }

    private void resetPointVisited() {
        for (Cell Point : PointList) {
            Point.setVisited(false);
        }
    }

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        Queue<Cell> queue = new LinkedList<>();
        resetPointVisited();
        Cell Point = PointList.get(startIndex);

        visitPoint(queue, Point);
        while (!queue.isEmpty()) {
            Point = getNearUnvisitedPoint(queue.peek());
            if (Point != null) {
                visitPoint(queue, Point);
            } else {
                queue.remove();
            }
        }
        System.out.println();
    }
}
