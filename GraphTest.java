/*
* Ashley Wonders
*/
import java.util.*; //should import queue

public class GraphTest{
	public static void main (String [] args){
		Scanner sc = new Scanner(System.in);
		int graphNum;
		int continueChoice = 0;
		//Graph 1
		MyGraph G1 = new MyGraph(4,3);  
		G1.setAdjMatrix(0,1,1); 
		G1.setAdjMatrix(1,0,1); 
		G1.setAdjMatrix(1,2,1); 
		G1.setAdjMatrix(2,1,1); 
		G1.setAdjMatrix(1,3,1); 
		G1.setAdjMatrix(3,1,1); 
		 
		//Graph 2	 
		MyGraph G2 = new MyGraph(6,10);  
		G2.setAdjMatrix(0,1,1); 
		G2.setAdjMatrix(1,0,1); 
		G2.setAdjMatrix(0,2,1); 
		G2.setAdjMatrix(2,0,1); 
		G2.setAdjMatrix(0,3,1); 
		G2.setAdjMatrix(3,0,1); 
		G2.setAdjMatrix(0,4,1); 
		G2.setAdjMatrix(4,0,1); 
		G2.setAdjMatrix(1,2,1); 
		G2.setAdjMatrix(2,1,1); 
		G2.setAdjMatrix(2,4,1); 
		G2.setAdjMatrix(4,2,1); 
		G2.setAdjMatrix(2,5,1); 
		G2.setAdjMatrix(5,2,1); 
		G2.setAdjMatrix(3,4,1); 
		G2.setAdjMatrix(4,3,1); 
		G2.setAdjMatrix(3,5,1); 
		G2.setAdjMatrix(5,3,1); 
		G2.setAdjMatrix(4,5,1); 
		G2.setAdjMatrix(5,4,1); 
		
		//Graph 3
		MyGraph G3 = new MyGraph(13,17);  
		G3.setAdjMatrix(0,1,1); 
		G3.setAdjMatrix(1,0,1); 
		G3.setAdjMatrix(0,5,1); 
		G3.setAdjMatrix(5,0,1); 
		G3.setAdjMatrix(0,6,1); 
		G3.setAdjMatrix(6,0,1); 
		G3.setAdjMatrix(0,2,1); 
		G3.setAdjMatrix(2,0,1); 
		G3.setAdjMatrix(2,6,1); 
		G3.setAdjMatrix(6,2,1); 
		G3.setAdjMatrix(4,3,1); 
		G3.setAdjMatrix(3,4,1); 
		G3.setAdjMatrix(3,5,1);
		G3.setAdjMatrix(5,3,1); 
		G3.setAdjMatrix(4,5,1); 
		G3.setAdjMatrix(5,4,1); 
		G3.setAdjMatrix(4,6,1); 
		G3.setAdjMatrix(6,4,1); 
		G3.setAdjMatrix(6,7,1); 
		G3.setAdjMatrix(7,6,1); 
		G3.setAdjMatrix(6,11,1); 
		G3.setAdjMatrix(11,6,1); 
		G3.setAdjMatrix(6,9,1); 
		G3.setAdjMatrix(9,6,1); 
		G3.setAdjMatrix(7,8,1); 
		G3.setAdjMatrix(8,7,1); 
		G3.setAdjMatrix(9,10,1); 
		G3.setAdjMatrix(10,9,1); 
		G3.setAdjMatrix(9,11,1); 
		G3.setAdjMatrix(11,9,1); 
		G3.setAdjMatrix(9,12,1); 
		G3.setAdjMatrix(12,9,1); 
		G3.setAdjMatrix(11,12,1); 
		G3.setAdjMatrix(12,11,1); 
		  
		//Graph 4
		MyGraph G4 = new MyGraph(5,4);   
		G4.setAdjMatrix(0,1,1); 
		G4.setAdjMatrix(1,0,1); 
		G4.setAdjMatrix(0,2,1); 
		G4.setAdjMatrix(2,0,1); 
		G4.setAdjMatrix(1,2,1); 
		G4.setAdjMatrix(2,1,1); 
		G4.setAdjMatrix(3,4,1); 
		G4.setAdjMatrix(4,3,1); 
		 
		//Graph 5
		MyGraph G5 = new MyGraph(10,14);  
		G5.setAdjMatrix(0,3,1); 
		G5.setAdjMatrix(3,0,1); 
		G5.setAdjMatrix(2,2,1); 
		G5.setAdjMatrix(3,5,1); 
		G5.setAdjMatrix(5,3,1); 
		G5.setAdjMatrix(8,9,1); 
		G5.setAdjMatrix(9,8,1); 
		G5.setAdjMatrix(0,5,1); 
		G5.setAdjMatrix(5,0,1); 
		G5.setAdjMatrix(8,3,1); 
		G5.setAdjMatrix(3,8,1); 
		G5.setAdjMatrix(5,9,1); 
		G5.setAdjMatrix(9,5,1); 
		G5.setAdjMatrix(3,9,1); 
		G5.setAdjMatrix(9,3,1); 
		G5.setAdjMatrix(8,3,1); 
		G5.setAdjMatrix(3,8,1); 
		G5.setAdjMatrix(1,7,1); 
		G5.setAdjMatrix(7,1,1); 
		G5.setAdjMatrix(4,6,1); 
		G5.setAdjMatrix(6,4,1); 
		G5.setAdjMatrix(6,7,1); 
		G5.setAdjMatrix(7,6,1); 
		G5.setAdjMatrix(1,4,1); 
		G5.setAdjMatrix(4,1,1); 
		G5.setAdjMatrix(1,6,1); 
		G5.setAdjMatrix(6,1,1); 
		G5.setAdjMatrix(4,7,1); 
		G5.setAdjMatrix(7,4,1); 
		
		//Methods Want to print each
		while (continueChoice ==0){
			System.out.println("Enter 1-5 for the graph you want to view");
			graphNum = sc.nextInt();
			switch(graphNum){
				case 1: graphOutputs(G1); break;
				case 2: graphOutputs(G2); break;
				case 3: graphOutputs(G3); break;
				case 4: graphOutputs(G4); break;
				case 5: graphOutputs(G5); break;
				default: System.out.println("Incorrect input.");
			}
			System.out.println("To continue, enter 0. To quit, enter 6.");
			continueChoice = sc.nextInt();
			while(continueChoice!=0 && continueChoice!=6){
				System.out.println("Incorrect input. To continue, enter 0. To quit, enter 6.");
				continueChoice = sc.nextInt();
			}
		}
	}
	
	public static void graphOutputs(MyGraph mg){
		System.out.println("\n=============================");
		System.out.println("Adjacency matrix is...");
		mg.printGraph();
		System.out.print("Neighbors of 2nd node are: ");
		mg.secondNodeNeighbors();
		System.out.println("\nCarrying out BFS...");
		mg.BFS();
		System.out.println("\nCarrying out DFS...");
		mg.DFS();
		System.out.println("\nSearching for articulation points...");
		mg.ArtPts();
		System.out.println("=============================\n");
	}
}