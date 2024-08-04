public class GridWorkings
{
    final int GRIDSIZE = 10;
    int[][] Grid;
    public int[][] gridWater = new int[GRIDSIZE][GRIDSIZE];
    instance2.myNewInt = instance.myNum;
    public GridWorkings()
    {
        for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                if (Grid[x][y] == 1) {
                    //Water Source
                    gridWater[x][y]++;
                    if (x==0 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                        else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right                        
                    } else if (x==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (y==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                    } else if (x==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    }
                }
                //Pipes
                if (Grid[x][y] == 2) {
                    if (x==0 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                        else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right                        
                    } else if (x==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (y==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                    } else if (x==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    }
                }
                if (Grid[x][y] == 3) {
                    //Sink
                    gridWater[x][y]--;
                }
                if (Grid[x][y] == 4) {
                                        if (x==0 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                        else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right                        
                    } else if (x==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    } else if (y==0) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                    } else if (x==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else if (y==GRIDSIZE-1) {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                    } else {
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        if (gridWater[x][y] <= 1) break;
                            else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                    }
                }
            }
        }
    }
}
