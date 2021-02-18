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

    public boolean isOnLine (int line, int number)
    {
        for (int j=0; j < 3; j++)
            if (regions[line][j].isOnLine(line, number))
                return true;
        return false;
    }

    public boolean isOnColumn(int line, int number)
    {
        for (int i=0; i < 3; i++)
            if (regions[i][line].isOnColumn(line, number))
                return true;
        return false;
    }

    public boolean isOnBloc(int i, int j, int number)
    {
        return regions[i][j].isOnBloc(number);
    }
}
