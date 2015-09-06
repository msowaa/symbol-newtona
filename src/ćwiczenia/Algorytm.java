package �wiczenia;
public class Algorytm {
	
	/** sta�a N s�u��ca do wyznaczenia warto�ci n! */
	private static final int N = 6;
	
	/** licznik mno�e� / dodawa� */
	private static long licznik = 0;
	
    /**
     * Funkcja SILNIA obliczaj�ca warto�� funkcji n!
     * @param n
     * @param iteracyjnie flaga definiuj�ca algorytm, kt�ry zostanie u�yty do wyznaczenia warto�ci SN
     * @return warto�� funkcji n!
     */
	private static long SILNIA(int n, boolean iteracyjnie) {
		// je�li wyliczamy warto�� funkcji n! iteracyjnie
		if (iteracyjnie) {
			// implementacja wersji iteracyjnej
			long a = 1;
			while (n > 0) {
				a *= n; // 1 mno�enie
				licznik++; // inkrementacja licznika mno�e�
				n--;
			}
			return a;
		}
		// je�li wyliczamy warto�� funkcji n! rekurencyjnie
		else {
			// implementacja wersji rekurencyjnej
	        if (n < 1) {
	            return 1;
	        }
	        else {
	            licznik++; // inkrementacja licznika mno�e�
	            return n * SILNIA(n - 1, false); // mno�enie
	        }
		}
	}
	
	/**
	 * Funkcja NEWTON1 obliczaj�ca warto�� SN � wersja 1
	 * @param n
	 * @param m
	 */
	private static void NEWTON1(int n, int m) {
		// resetujemy stan licznika
		licznik = 0;
		
		long wynik = SILNIA(n, true) / ( SILNIA(m, true) * SILNIA(n - m, true) );
		licznik++; // wykonane mno�enie pomi�dzy m! * (n - m)!
		System.out.println("Funkcja NEWTON1 obliczaj�ca warto�� SN � wersja 1");
		System.out.println("n = " + n + " | m = " + m);
		System.out.println("Wynik = " + wynik);
		System.out.println("Licznik mno�e� = " + licznik);
		System.out.println("---");
	}
	
	/**
	 * Funkcja NEWTON2 obliczaj�ca warto�� SN � wersja 2
	 * @param n
	 * @param m
	 */
	private static void NEWTON2(int n, int m) {
		// resetujemy stan licznika
		licznik = 0;
		
		long wynik = 1;
		
		for (int i = 1; i <= m; i++) {
			wynik = wynik * ( n - i + 1 ) / i; // wz�r iteracyjny
			licznik++; // wykonane jedno mno�enie
		}
		
		System.out.println("Funkcja NEWTON2 obliczaj�ca warto�� SN � wersja 2");
		System.out.println("n = " + n + " | m = " + m);
		System.out.println("Wynik = " + wynik);
		System.out.println("Licznik mno�e� = " + licznik);
		System.out.println("---");
	}
	
	/**
	 * Funkcja PASCAL liczy symbol Newtona (SN) z tr�jk�ta Pascala rekurencyjnie
	 * @param n
	 * @param m
	 * @return wyznaczona warto�� SN
	 */
	private static long PASCAL(int n, int m) {
		if (n == m || n == 0)
			return 1;
		if (m == 1 || m == n - 1)
		      return n;
		licznik++; // operacja ni�ej wykonuje 1 dodawanie
		return PASCAL(n - 1, m - 1) + PASCAL(n - 1, m);
	}
	
	/**
	 * Funkcja NEWTON3 obliczaj�ca warto�� SN � wersja 3
	 * @param n
	 * @param m
	 */
	private static void NEWTON3(int n, int m) {
		// resetujemy stan licznika
		licznik = 0;
		
		System.out.println("Funkcja NEWTON3 obliczaj�ca warto�� SN � wersja 3");
		System.out.println("n = " + n + " | m = " + m);
		System.out.println("Wynik = " + PASCAL(n, m));
		System.out.println("Licznik dodawa� = " + licznik);
		System.out.println("---");
	}
	
	/**
	 * Funkcja NEWTON4 obliczaj�ca warto�� SN � wersja 4 z tr�jk�ta Pascala z pomoc� tablicy jednowymiarowej
	 * @param n
	 * @param m
	 */
	private static void NEWTON4(int n, int m) {
		// resetujemy stan licznika
		licznik = 0;
		
		// tablica jednowymiarowa
		int[] tablica = new int[n+1];
		
		for (int i = 0; i < n + 1; i++) {
			// inicjalizacja tablicy
			tablica[i] = 1;
			for (int j = i - 1; j > 0; j--) {
				tablica[j] += tablica[j - 1];
				licznik++; // inkrementujemy licznik dodawa�
			}
		}
		
		long wynik = tablica[m];
		
		System.out.println("Funkcja NEWTON4 obliczaj�ca warto�� SN � wersja 4");
		System.out.println("n = " + n + " | m = " + m);
		System.out.println("Wynik = " + wynik);
		System.out.println("Licznik dodawa� = " + licznik);
		System.out.println("---");
	}
	
	/**
	 * Funkcja NEWTON5 obliczaj�ca warto�� SN � wersja 5 z tr�jk�ta Pascala z pomoc� tablicy dwuwymiarowej
	 * @param n
	 * @param m
	 */
	private static void NEWTON5(int n, int m) {
		// resetujemy stan licznika
		licznik = 0;
		
		// tablica dwuwymiarowa
		int[][] tablica = new int[n+1][];
		
		// inicjalizacja tr�jk�ta Pascala
		for (int i = 0; i < tablica.length; i++) {
			tablica[i] = new int[i+1];
			tablica[i][0] = 1;
			tablica[i][i] = 1;
			for (int j = 1; j < i; j++) {
				tablica[i][j] = tablica[i-1][j] + tablica[i-1][j-1];
				licznik++; // inkrementujemy licznik dodawa�
				if (i == n && j == m) break;
			}
		}
		
		long wynik = tablica[n][m];
		
		System.out.println("Funkcja NEWTON5 obliczaj�ca warto�� SN � wersja 5");
		System.out.println("n = " + n + " | m = " + m);
		System.out.println("Wynik = " + wynik);
		System.out.println("Licznik dodawa� = " + licznik);
		System.out.println("---");
	}
	
	public static void main(String args[]) {
		// wyznaczanie warto�ci n! iteracyjnie
		System.out.println("Funkcja SILNIA obliczaj�c� warto�� funkcji n! wersja iteracyjna");
		System.out.println("Warto�� " + N + "! = " + SILNIA(N, true));
		System.out.println("Licznik mno�e� = " + licznik);
		System.out.println("---");
		
		// resetujemy stan licznika
		licznik = 0;
		
		// wyznaczanie warto�ci n! rekurencyjnie
		System.out.println("Funkcja SILNIA obliczaj�c� warto�� funkcji n! wersja rekurencyjna");
		System.out.println("Warto�� " + N + "! = " + SILNIA(N, false));
		System.out.println("Licznik mno�e� = " + licznik);
		System.out.println("---");
		
		// wywo�ywanie funkcji NEWTON1 dla r�nych parametr�w n i m
		NEWTON1(4, 2);
		NEWTON1(8, 5);
		NEWTON1(15, 9);
		NEWTON1(18, 4);
		
		// wywo�ywanie funkcji NEWTON2 dla r�nych parametr�w n i m
		NEWTON2(4, 2);
		NEWTON2(8, 5);
		NEWTON2(15, 9);
		NEWTON2(18, 4);
		
		// wywo�ywanie funkcji NEWTON3 dla r�nych parametr�w n i m
		NEWTON3(4, 2);
		NEWTON3(8, 5);
		NEWTON3(15, 9);
		NEWTON3(18, 4);
		// NEWTON3(100, 50);
		
		// wywo�ywanie funkcji NEWTON4 dla r�nych parametr�w n i m
		NEWTON4(4, 2);
		NEWTON4(8, 5);
		NEWTON4(15, 9);
		NEWTON4(18, 4);
		
		// wywo�ywanie funkcji NEWTON5 dla r�nych parametr�w n i m
		NEWTON5(4, 2);
		NEWTON5(8, 5);
		NEWTON5(15, 9);
		NEWTON5(18, 4);
	}

}
