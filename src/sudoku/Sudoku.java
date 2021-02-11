package sudoku;

public class Sudoku {
    private Region[][] regions;

    public Sudoku() {
        reset();
    }

    public void reset() {
        regions = new Region[][]{
                {new Region(), new Region(), new Region()},
                {new Region(), new Region(), new Region()},
                {new Region(), new Region(), new Region()},
        };
    }

    public Region[][] getRegions() {
        return regions;
    }

    public Region getRegion(int x, int y) {
        return regions[x][y];
    }
}
