package sudoku;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

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

    public void setCells(int[][] cells) {
        this.cells = cells;
    }

    public int[] getPossibleValues() {
        return possibleValues;
    }

    public int get(int x, int y) {
        return this.cells[x][y];
    }
    public void set(int x, int y, int val) {
        /*if () {
            this.cells[x][y]
        }*/
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

    @Override
    public Iterator iterator() {
        return null;
    }
}
