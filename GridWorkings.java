public class GridWorkings
{
    int GRIDSIZE = 10;
    boolean GridGenerating;
    int Timer;
    public GridWorkings()
    {
        int[][] Grid = new int[GRIDSIZE][GRIDSIZE]; 
        System.out.print('\u000C');
        for (int x=0;x<GRIDSIZE;x++) //Sets the grid as off by default
            for (int y=0;y<GRIDSIZE;y++) {
                Grid[x][y] = 0;
            }
        System.out.print('\u000C');
        while (GridGenerating) { //Generates (prints) the grid
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    if (Grid[x][y] == 1) System.out.print("o ");
                    else if (Grid[x][y] == 2) System.out.print("x ");
                }
                System.out.println("");
            }
        }
        int[][][] GridGen = new int[Timer+1][GRIDSIZE][GRIDSIZE]; 
        int livecells = 0;
        for (int x=0;x<GRIDSIZE;x++) { // This is for the users planning
            for (int y=0;y<GRIDSIZE;y++) {
                if (Grid[x][y] == 1) GridGen[0][x][y] = 1 ;
                else if (Grid[x][y] == 2) GridGen[0][x][y] = 2;
            }
        }
        for (int t=0;t<Timer;t++) {
            System.out.println("Generation "+(t+1)); //Displays what generation we are on
            for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                    livecells = 0;
                    if (x==0 && y==0) { 
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[t][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[t][x+1][y] == 2) livecells++; //Right
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[t][x-1][y] == 2) livecells++; //Left
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[t][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[t][x-1][y] == 2) livecells++; //Left
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x+1][y-1] == 2) livecells++; //Top Right
                        if (GridGen[t][x+1][y] == 2) livecells++; //Right                        
                    } else if (x==0) {
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[t][x+1][y] == 2) livecells++; //Right
                        if (GridGen[t][x+1][y-1] == 2) livecells++; //Top Right
                    } else if (y==0) {
                        if (GridGen[t][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[t][x-1][y] == 2) livecells++; //Left
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[t][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[t][x+1][y] == 2) livecells++; //Right 
                    } else if (x==GRIDSIZE-1) {
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        if (GridGen[t][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[t][x-1][y] == 2) livecells++; //Left
                        if (GridGen[t][x-1][y+1] == 2) livecells++; //Bottom Left
                    } else if (y==GRIDSIZE-1) {
                        if (GridGen[t][x-1][y] == 2) livecells++; //Top Right
                        if (GridGen[t][x-1][y-1] == 2) livecells++; //Right
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x+1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[t][x+1][y] == 2) livecells++; //Left
                    } else {
                        if (GridGen[t][x-1][y+1] == 2) livecells++; //Bottom Left
                        if (GridGen[t][x-1][y] == 2) livecells++; //Left
                        if (GridGen[t][x-1][y-1] == 2) livecells++; //Top Left
                        if (GridGen[t][x][y+1] == 2) livecells++; //Bottom
                        //if (GridGen[t][x][y] == 2) livecells++; This is the cell being checked
                        if (GridGen[t][x][y-1] == 2) livecells++; //Top
                        if (GridGen[t][x+1][y+1] == 2) livecells++; //Bottom Right
                        if (GridGen[t][x+1][y] == 2) livecells++; //Right
                        if (GridGen[t][x+1][y-1] == 2) livecells++; //Top Right
                    } 
                    // Setup next generation
                    if (GridGen[t][x][y] == 2 && livecells < 2) GridGen[t+1][x][y] = 1;
                    else if (GridGen[t][x][y] == 2 && livecells == 2) GridGen[t+1][x][y] = 2;
                    else if (GridGen[t][x][y] == 2 && livecells == 3) GridGen[t+1][x][y] = 2;
                    else if (GridGen[t][x][y] == 2 && livecells > 3) GridGen[t+1][x][y] = 1;
                    else if (GridGen[t][x][y] == 1 && livecells == 3) GridGen[t+1][x][y] = 2;
                    else GridGen[t+1][x][y] = 1;
                    // Display grid
                    if (GridGen[t][x][y] == 1) System.out.print("o ");
                    else if (GridGen[t][x][y] == 2) System.out.print("x ");
                    else System.out.print("e "); //Error Diagnosis
                }
                System.out.println("");
            }
            //This adds distance between the grids
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }
}
