package greedycoloring;

import java.util.Arrays;
import java.util.Iterator;

public class GreedyColoringGraf {
        //Main class dari program
	public static void main(String[] args) {
            final long START = System.nanoTime();
		System.out.println("PEWARNAAN GRAF DENGAN STRATEGI GREEDY");
		pewarnaanGraf g1 = new pewarnaanGraf(16);

		System.out.println("Graf:");
		//Membuat graf dengan memasukkan vertex dengan ketatanggaannya
		g1.buatEdge(0, 1);
		g1.buatEdge(0, 8);
		g1.buatEdge(1, 4);
		g1.buatEdge(1, 6);
		g1.buatEdge(1, 8);
		g1.buatEdge(2, 3);
                g1.buatEdge(2, 4);
		g1.buatEdge(4, 5);
                g1.buatEdge(4, 6);
		g1.buatEdge(5, 6);
		g1.buatEdge(6, 7);
		g1.buatEdge(6, 8);
		g1.buatEdge(6, 9);
                g1.buatEdge(7, 8);
                g1.buatEdge(7, 9);
		g1.buatEdge(7, 10);
		g1.buatEdge(7, 13);
                g1.buatEdge(7, 14);
		g1.buatEdge(8, 10);
		g1.buatEdge(9, 13);
		g1.buatEdge(10, 11);
                g1.buatEdge(10, 12);
		g1.buatEdge(10, 14);
		g1.buatEdge(10, 15);
		g1.buatEdge(11, 12);
		g1.buatEdge(12, 15);
		g1.buatEdge(13, 14);
                g1.buatEdge(14, 15);
		
		// mencetak graf yang telah dibuat
		g1.printGraf();
                //memanggil fungsi pewarnaan graf strategi greedy
		perwanaanGreedy(g1);
            final long END = System.nanoTime();
            System.out.println((END - START)/1e+9);
	}
	
	// Fungsi pewarnaan graf strategi greddy
	public static void perwanaanGreedy(pewarnaanGraf g) {
		int V = g.buatVertex();

		// array warna untuk menyimpan warna vertex
		int warna[] = new int[V];

		// mengisi semua vertex dengan nilai 1 yang berarti vertex tidak berarah
		Arrays.fill(warna, -1);

		// Melakukan pewarnaan kepada vertex pertama dengan kode warna 0
		warna[0] = 0;

                // Array bolean untuk menunjukkan warna yang masih tersedia.
                // Memeriksa warna yang telah dipakai oleh tetangganya
		boolean tersedia[] = new boolean[V];

		// Menset semua warna tersedia
		Arrays.fill(tersedia, true);

		// assign colors to the remaining V-1 vertices
                // Memasukkan warna ke vertex v-1 
		for (int u = 1; u < V; u++) {
			// memproses simpul dan adjacency yang berdekatan
			// warna yang digunakan tidak bisa dipakai, not available
			Iterator<Integer> it = g.ketetanggaan(u).iterator();
			while (it.hasNext()) {
				int i = it.next();
				if (warna[i] != -1) {
					tersedia[warna[i]] = false;
				}
			}

			// mencari warna pertama yang tersedia
			int cr;
			for (cr = 0; cr < V; cr++) {
				if (tersedia[cr])
					break;
			}

			// Memasukkan warna yang tersedia
			warna[u] = cr;

			// reset nilai kembali ke true untuk iterasi berikutnya
			Arrays.fill(tersedia, true);
		}

		printWarna(warna);
	}

	// Fungsi untuk mencetak hasil pewarnaan vertex
	public static void printWarna(int[] warna) {
            System.out.println("\nHASIL PEWARNAAN DENGAN STRATEGI GREEDY");
		for (int i = 0; i < warna.length; i++)
			System.out.println("Vertex " + i + " berkode warna " + warna[i]);
	}
}