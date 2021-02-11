package sudoku;

import java.util.*;
import java.util.stream.IntStream;

public class Region implements Iterable{
    private int[][] cells;
    private final int[] possibleValues;

    public Region() {
        this.cells = new int[3][3];
        this.possibleValues = new int[]{
                0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        };
    }

    public List<Integer> getCellValues(){
        List<Integer> values = new ArrayList<>();
        for(int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; i++) {
                values.add(cells[i][j]);
            }
        }
        return values;
    }

    public int[][] getCells() {
        return cells;
    }

    public int[] getPossibleValues() {
        return possibleValues;
    }

    public int get(int x, int y) {
        return this.cells[x][y];
    }

    public void set(int x, int y, int val) throws IllegalArgumentException {
        if (IntStream.of(possibleValues).noneMatch(i -> i == x))
            throw new IllegalArgumentException("Value must be between 0-9, given : " + val);
        this.cells[x][y] = val;
    }

    public void fill() {
        for(int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; i++) {
                fill(i, j);
            }
        }
    }

    public void fill(int x, int y) {
        int rnd = possibleValues[new Random().nextInt(possibleValues.length)];
        cells[x][y] = rnd;
    }

    public boolean isOnLine (int line, int number) {
        for (int j = 0; j < 3; j++)
            if (cells[line][j] == number)
                return true;
        return false;
    }

    public boolean isOnColumn(int line, int number)
    {
        for (int i=0; i < 9; i++)
            if (cells[i][line] == number)
                return true;
        return false;
    }

    @Override
    public Iterator<int[]> iterator() {
        return Arrays.stream(cells).iterator();
    }
}
