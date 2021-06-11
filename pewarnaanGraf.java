package backtrackingcoloring;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//KELAS GRAF
//Kelas dalam pewarnaan graf 
public class pewarnaanGraf {
	private int vertex; 
	private List<Integer>[] adjacency;
	
        //hak akses dari kelas untuk membuat vertex
	public int buatVertex() {
		return vertex;
	}
        
        //Publik kelas pewarnaan graf
	public pewarnaanGraf(int vertex) {
		this.vertex = vertex;
		adjacency = (List<Integer>[]) new List[vertex];
		for (int i = 0; i < vertex; i++)
			adjacency[i] = new ArrayList<Integer>();
	}
        //Kelas publik membuat edge
	public void buatEdge(int i, int j) {
		adjacency[i].add(j);
		adjacency[j].add(i);
	}
	
	public boolean adaEdge(int i, int j) {
		return adjacency[i].contains(j);
	}
        
        //Kelas publik membuat list ketetanggaan
	public List<Integer> ketetanggaan(int vertex) {
		return adjacency[vertex];
	}
        //Kelas publik untuk mencetak graf dan ketetanggaannya
	public void printGraf() {
		for (int i = 0; i < vertex; i++) {
			List<Integer> edges = ketetanggaan(i);
			System.out.print("vertex " + i + " bertetangga dengan : ");
			for (int j = 0; j < edges.size(); j++) {
				System.out.print(edges.get(j) + " ");
			}
			System.out.println();
		}
	}
}
