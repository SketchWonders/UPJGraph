/*
* Ashley Wonders
*/
import java.util.*; //should import queue

public class MyGraph{
	private int numVertices;
	private int numEdges;
	private int adjMatrix [][]; //fix
	private int val []; //val is order visited
	private int count;
	private ArrayList articulationPoints;
	private int numNeihborsRoot;
	
	public MyGraph(int v, int e){
		numVertices = v;
		numEdges = e;
		adjMatrix = new int [v][v];
		val = new int [v];
		count =0;
		articulationPoints = new ArrayList();
		//don't worry about val or count
	}
	
	public void setCount(int c){
		count = c;
	}
	
	public void setNumVertice(int v){
		numVertices = v;
		//need to change adj matrix?
	}
	
	public void setnumEdges(int e){
		numEdges = e;
	}
	
	public void setVal(int i, int x){
		//sets entry i in val to x
		val[i] = x;
	}
	
	public void setAdjMatrix(int i, int j, int x){
		adjMatrix[i][j] = x;
	}
	
	public int getNumVertices(){
		return numVertices;
	}
	
	public int getNumEdges(){
		return numEdges;
	}
	
	public int getCount(){
		return count;
	}
	
	public int getVal(int i){
		return val[i];
	}
	
	public int getAdjmatrix(int i, int j){
		return adjMatrix[i][j];
	}
	
	public void printGraph(){
		//print adjMatrix
		for (int i = 0; i< numVertices; i++){
			for(int j = 0; j< numVertices; j++){
				System.out.print(adjMatrix[i][j] +"  ");
			}
			System.out.print("\n");
		}
	}
	
	public void secondNodeNeighbors(){
		for(int i = 0; i< numVertices; i++){
			if(adjMatrix[1][i] ==1){
				System.out.print(i + " ");
			}
		}
	}
	public void BFS (){
		//carries out BFS on whole graph by invoking visitBFS for each unseen vertex
		for(int i = 0; i< numVertices; i++){
			val[i] = 0; //none visited
		}
		count = 0;
		for(int k = 0; k< numVertices; k++){
			if (val[k] == 0){
				System.out.print("Connected Component: ");
				visitBFS(k);
			}
		}
	}
	
	//not done?
	public void visitBFS(int k){
		//start at vertex k. Use Queue data structure. Carry out BFS.
		count = count+1;
		val[k] = count;
		ArrayDeque queueA = new ArrayDeque (); //lookup
		queueA.add(k);
		int m;
		while(!queueA.isEmpty()){
			m = (int)queueA.removeFirst(); //look up - probably just remove() not pop
			//add unvisited neighbors of m to the queue
			for(int w = 0; w< numVertices; w++){
				if(adjMatrix[m][w] == 1){
					if(val[w] ==0){
						count++;
						val[w] = count;
						queueA.add(w);
						System.out.print("<" + m + ", " + w +"> ");
					}
				}
			}	
		}
	}
	
	public void DFS(){
		//invoke visitDFS on whole graph
		//set all vertices to unvisited at start
		for (int i = 0; i< numVertices; i++){
			val[i] = 0;
		}
		count = 0;
		for (int j = 0; j < numVertices; j++){
			if(val[j] ==0){
				System.out.print("Connected Component: ");
				visitDFS(j);
			}
		}
	}
	
	//not done?
	public void visitDFS(int k){
		//recursive DFS starting at vertex k
		count = count +1;
		val [k] = count;
		//visit first unvisited neighbor of k
		//should go through row of array for k -- see neighbor
		// look up
		for(int w = 0; w< numVertices; w++){
			if(adjMatrix[k][w] == 1 && val[w] ==0){
				System.out.print("<" + k + ", " + w +"> ");
				visitDFS(w);
			}
		}
	}
	
	public void ArtPts(){
	//search for art pts on whole graph by invoking visitDFSArtPts for each unseen vertex
		for (int i = 0; i< numVertices; i++){
			val[i] = 0;
		}
		count = 0;
		//check if root is articulation point
		for (int k = 0; k< numVertices; k++){
			if (val[k] ==0){
				numNeihborsRoot = 0;
				//initialCount = 0; //marks start of a component -- will test root separately
				/*
				for(int w = 0; w< numVertices; w++){
					if(adjMatrix[k][w] ==1){
						numNeihborsRoot++;
					}
				}
				*/
				visitDFSArtPts(k);
				if(!articulationPoints.isEmpty()&&(int)articulationPoints.get(articulationPoints.size()-1) ==k&& numNeihborsRoot<2){
					articulationPoints.remove(articulationPoints.size()-1);
				}
			}
		}
		
		if(articulationPoints.size()>0){
			while(!articulationPoints.isEmpty()){
				System.out.print(articulationPoints.remove(0)+ " ");
			}
		}else{
			System.out.print("No articulation points found");
		}
		System.out.print("\n");
	}
	
	//not done 
	public int visitDFSArtPts(int k){
		//search start at k
		//System.out.println("1. visitDFSArtPts. K:" + k+ " count "+ count + " val[k] "+ val[k]);
		count = count +1;
		val[k] = count;
		int min = count;
		int m = 0;
		//System.out.println("2. visitDFSArtPts. K:" + k+ " count "+ count + " val[k] " + val[k] + " min " + min);
		for(int w = 0; w< numVertices; w++){
			numNeihborsRoot = 0;
			if(adjMatrix[k][w] ==1){
				if(val[w] == 0){ //unvisited
					numNeihborsRoot++;
					//System.out.println("w: " + w+ " k = " + k +" m = "+ m+ " min = " +min+ " val[k] = " +val[k]);
					m = visitDFSArtPts(w);
					//System.out.println("k = " + k +" m = "+ m+ " min = " +min+ " val[k] = " +val[k]);
					if(m< min){
						//System.out.println("Reset min");
						min = m;
					}
					if(m >= val[k]){
						if(!articulationPoints.contains(k)){
							articulationPoints.add(k);
							//System.out.println("w = " + w +" m = "+ m+ " min = " +min+ " val[k] = " +val[k]);
							//System.out.println("Art pt: " +k);
						}
					}
				}
				if (val[w] < min){
					//System.out.println("3. visitDFSArtPts. K:" + k+ " count "+ count + " val[k] " + val[k] + " min " + min);
					min = val[w];
					//System.out.println("k = " + k +" m = "+ m+ " min = " +min+ " val[k] = " +val[k]);
				}
			}
		}
		//for each articulation point in the arraylist - print it.
		//if size is 0 -- not articulation points found
		//else System.out.print("Articulation Points: ") -- then print all.
		
		return min;
	}
}