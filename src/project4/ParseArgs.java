package project4;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class ParseArgs {

	
	HashTable hash;
	Edge[] edgeArray;
	int cityArrayCounter;
	String[] cities = null;
	

	/** Passes command line to parseArguments
	 * @param args - Arguments from command line */
	public ParseArgs(String[] args) {
		parseArguments(args);
	}
	

	/** Arguments from command line are passed, determines if it is input.txt file. 
	 * passes file to be parsed
	 * @param args - arguments from command line */
	public void parseArguments(String[] args) {
		
		for (int i = 0; i < args.length; i++) {
			
			if((args[i]).toLowerCase().contains("input")) {
				
				try {
					parseFile(args[i]);
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	/**
	 * Receives argument (file) as string. Inserts cities in city string array. Uses String array to 
	 * create Hash Table. Reads each line to get cities and distances between cities.
	 * Gets index value of cities in hash table. Uses cities and distances to create Graph 
	 * @param args
	 * @throws IOException
	 */
	public void parseFile(String args) throws IOException {
		

		Path file = Paths.get(args);
		
		
		try (BufferedReader in = Files.newBufferedReader(file, Charset.forName("UTF8"))) {	
			
			/** elements to get line, convert to string, string array and pass string array to convert to hash table */
			String stringToConvertToArray = null;
			cityArrayCounter = 0;
			
			/** elements to create Graph */
			String firstCity = null, cityNeighbor = null;
			int cityDistance = 0, firstCityIndex = 0, cityNeighborIndex = 0;
			
			
			String readLine = in.readLine(); 
			
			while(readLine != null && !readLine.contains(".")) {
				
				if(stringToConvertToArray == null) {
					stringToConvertToArray = readLine+" ";
						
				} else {
					stringToConvertToArray += readLine+" ";
				}
					
				cityArrayCounter++;
				readLine = in.readLine();
					
				if(readLine.contains(".")) {
					break;
				}
			}
			
			stringToConvertToArray = stringToConvertToArray.trim();
			cities = stringToConvertToArray.split(" ");
			
			int cityLength = cities.length;
			setCounter(cityArrayCounter);
			
			edgeArray = new Edge[cities.length];
			
			hash = new HashTable(cities.length);
			
			for(int i = 0; i < cityLength; i++) {
				hash.insert(i, cities[i]);
			}

			
			while((firstCity = in.readLine()) != null) {
				
				firstCityIndex = hash.find(firstCity);
				
				cityNeighbor = in.readLine();
				cityNeighborIndex = hash.find(cityNeighbor);
				
				cityDistance = Integer.parseInt(in.readLine());
						
				buildGraph(firstCityIndex, cityNeighborIndex, cityDistance);
						
			}
		}

	}

	/** Receives index of city, neighbor city, and distance between them and creates a new edge in graph
	 * at the first city's index */
	public void buildGraph(int index, int secondIndex, int miles) {
		
		Edge newEdge = new Edge(secondIndex, miles, edgeArray[index]);
		edgeArray[index] = newEdge;
		
	}
	
	
	/** Goes through List of all cities and prints the city's neighbor and distance from city */
	public void printGraph() {
		
		for(int i = 0; i < edgeArray.length; i++) {
			
			Edge temp = edgeArray[i];
			
			System.out.print(cities[i]+ " " +i+ ": "+cities[temp.getNeighbor()]+ " "+temp.getMiles()+ ", ");
			
			if(temp.getNext() != null) {
				
				while(temp.getNext() != null) {
					
					temp = temp.getNext();
					System.out.print(cities[temp.getNeighbor()]+ " "+temp.getMiles()+ ", ");
					
				}
				System.out.println();
				
			}
			
		}
		System.out.println("");
		
	}
	
	public Edge[] returnEdgeArray() {
		return edgeArray;
	}
	
	public String[] cities() {
		return cities;
	}
	
	public void setCounter(int counter) {
		this.cityArrayCounter = counter;
	}
	
	public int getCounter() {
		return cityArrayCounter;
	}
	
}

