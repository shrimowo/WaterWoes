//import
import java.util.Random;
/**
 * this class manages transfering water between objects
*/
public class GridWorkings
{
    //Instance variables
    
    //Initialize grid to hold water
    final int GRIDSIZE = 10;
    int randomNumber;
    int[][] Grid;
    public int[][] gridWater = new int[GRIDSIZE][GRIDSIZE];
    
    //Waterwoes object to allow communication
    WaterWoes waterWoes;
    
    
    public GridWorkings(WaterWoes waterWoes)
    {
        //Update grids to share info
        this.waterWoes = waterWoes;
        Grid=waterWoes.Grid;
        gridTech(); //Simualate water
    }
    public void update(){
        Grid=waterWoes.Grid; //Updates grud when required
    }
    public void gridTech(){
        for (int x=0;x<GRIDSIZE;x++) {
                for (int y=0;y<GRIDSIZE;y++) {
                random();
                if (Grid[x][y] == 1) {
                    //Water Source
                    gridWater[x][y]++; //refils the source
                    //Updates water location based of water source locations.
                    if (x==0 && y==0) { 
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        }
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            }
                    } else if (y==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left 
                        }
                    } else if (x==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (y==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                    } else {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2 || Grid[x+1][y] == 3 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2 || Grid[x][y-1] == 3 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2 || Grid[x][y+1] == 3 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2 || Grid[x-1][y] == 3 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                    }
                }
                
                //Updates water location based of pipe locations.
                if (Grid[x][y] == 2) {
                    if (x==0 && y==0) { 
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ){gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        }
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            }
                    } else if (y==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left 
                        }
                    } else if (x==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (y==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                    } else {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 3 || Grid[x+1][y] == 4 ) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 3 || Grid[x][y-1] == 4 ) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 3 || Grid[x][y+1] == 4 ) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 3 || Grid[x-1][y] == 4 ) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                    }
                }
                
                if (Grid[x][y] == 3) {
                    //Sink
                    if (gridWater[x][y] >= 1) gridWater[x][y]--; //empties the sink
                }
                
                //Updates water location based of junction locations.
                if (Grid[x][y] == 4) {
                    if (x==0 && y==0) { 
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                        }
                    } else if (x==GRIDSIZE-1 && y==GRIDSIZE-1) {
                        if (randomNumber == 0) {
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==GRIDSIZE-1 && y==0) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }  
                    } else if (x==0 && y==GRIDSIZE-1) { 
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right  
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (x==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            }
                    } else if (y==0) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right 
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left 
                        }
                    } else if (x==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                        }
                    } else if (y==GRIDSIZE-1) {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                    } else {
                        if (randomNumber == 0){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                        }
                        else if (randomNumber == 1){
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x+1][y] == 2) {gridWater[x+1][y]++; gridWater[x][y]--;} //Right
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y-1] == 2) {gridWater[x][y-1]++; gridWater[x][y]--;}  //Top
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x][y+1] == 2) {gridWater[x][y+1]++; gridWater[x][y]--;}//Bottom
                            if (gridWater[x][y] <= 1) break;
                                else if (Grid[x-1][y] == 2) {gridWater[x-1][y]++; gridWater[x][y]--;}  //Left
                        }
                    }
                }
            }
        }
        waterWoes.repaint(); //paint
    }
    public void random(){ //generates random number to reduce pipe clogging
        Random rand = new Random();
        randomNumber = rand.nextInt(2);
    }
}