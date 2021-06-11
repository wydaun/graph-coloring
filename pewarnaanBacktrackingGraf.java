package backtrackingcoloring;

import java.util.Arrays;
import java.util.Iterator;

public class pewarnaanBacktrackingGraf {

	public static void main(String[] args) {
		// Main class dari program
            final long START = System.nanoTime();
		System.out.println("PEWARNAAN GRAF DENGAN STRATEGI BACKTRACKING");
		pewarnaanGraf g1;
                g1 = new pewarnaanGraf (16);

		System.out.println("Ketatenggaan Graf:");
		// Membuat graf dengan memasukkan vertex dengan ketatanggaannya
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
		// print Graph
		g1.printGraf();

		pewarnaanBacktracking(g1, 3);
            final long END = System.nanoTime();
            System.out.println((END - START)/1e+9);
	}
        
	// Fungsi utilitas mewarnai backtracking
	public static boolean isSafe(int v, pewarnaanGraf g, int warna[], int cr) {
		for (int i = 0; i < g.buatVertex(); i++) {
			if (g.adaEdge(v, i) && cr == warna[i]) {
				return false;
			}
		}
		return true;

	}
        
	public static boolean cekWarnai(pewarnaanGraf g, int m, int warna[], int v) {
		// semua simpul memiliki warna maka hanya true
		if (v == g.buatVertex())
			return true;

		// coba warna yang berbeda untuk v
		for (int cr = 1; cr <= m; cr++) {
			// Periksa apakah penugasan warna cr ke v benar
			if (isSafe(v, g, warna, cr)) {
				warna[v] = cr;
				// berulang untuk menetapkan warna ke sisa simpul
				if (cekWarnai(g, m, warna, v + 1))
					return true;

				// Jika menetapkan warna cr tidak mengarah
                                // ke solusi lalu hapus
				warna[v] = 0;
			}
		}
		// jika tidak ada warna yang dapat diberikan maka kembalikan false
		return false;
	}
        
	// Fungsi utama backtracking
	public static void pewarnaanBacktracking(pewarnaanGraf g, int m) {
		int V = g.buatVertex();

		// array warna untuk menyimpan warna vertex
		int warna[] = new int[V];

		// mengisi semua vertex dengan nilai 0
		Arrays.fill(warna, 0);

		// memanggil cekWarnai untuk vertex 0
		if (!cekWarnai(g, m, warna, 0)) {
			System.out.println("Tidak ada solusi");
		}

		printWarna(warna);
	}

	// Print Warna
	public static void printWarna(int[] warna) {
            System.out.println("\nHASIL PEWARNAAN DENGAN STRATEGI BACKTRACKING");
		for (int i = 0; i < warna.length; i++)
			System.out.println("Vertex " + i + " berkode warna " + warna[i]);
	}
}