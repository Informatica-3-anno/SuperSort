public class Principale {

	static int[] VET;

	public Principale(int size) {
		VET = new int[size];
		for (int i = 0; i < VET.length; i++) {
			VET[i] = (int) (Math.random() * size) + 1;
		}
	}
   
	private static void scambia(int[] v, int i, int j) {
		int temp=v[i];
		v[i]=v[j];
		v[j]=temp;
	}
	
	////////////////////////////////////////////
	////  Algoritmo INGENUO
	////////////////////////////////////////////
	// L’ordinamento ingenuo o sequenziale è il più semplice negli algoritmi di ordinamento sono necessari due cicli annidati
	// Si effettua il confronto del primo, del secondo, del terzo... del n-esimo con tutti i valori che seguono eseguendo lo
	// scambio se non sono ordinati.
	// In tutto il numero dei confronti effettuati è: (n - 1) + (n - 2) + (n - 3) + …+ 2 + 1
    // cioè n * (n - 1) / 2.
	public void ingenuoSort(int[] v) {
		int c;

		for (int i = 0; i < v.length - 1; i++) {
			for (int j = i + 1; j < v.length; j++) {
				if (v[i] > v[j]) {
					scambia(v,i,j);
				}
			}
		}
	}

	////////////////////////////////////////////
	////  Algoritmo INSERTION
	////////////////////////////////////////////
	// L'Insertion sort, in italiano ordinamento a inserimento, 
	// è un algoritmo relativamente semplice per ordinare un array. 
	// Non è molto diverso dal modo in cui un essere umano, spesso, ordina un mazzo di carte. 
	// E' un algoritmo in place, cioè ordina l'array senza doverne creare una copia, risparmiando memoria. 
	// Pur essendo molto meno efficiente di algoritmi più avanzati, può avere alcuni vantaggi: 
	// ad esempio, è semplice da implementare ed è efficiente per insiemi di partenza che sono quasi ordinati.
	public void insertionSort(int v[]) {
		int n = v.length;
		for (int j = 1; j < n; j++) {
			int key = v[j];
			int i = j - 1;
			// Per ciascun j-esimo elemento l'algoritmo lo confronta con gli elementi precedenti 
			// tramite una struttura ciclica condizionata while più interna fa lo spazio
			// per inserire il nuovo elemento.
			while ((i > -1) && (v[i] > key)) {
				v[i + 1] = v[i];
				i--;
			}
			v[i + 1] = key;
		}
	}

	////////////////////////////////////////////
	////  Algoritmo SELECTION
	////////////////////////////////////////////
	// L'ordinamento per selezione (selection sort) è un algoritmo di ordinamento che opera in place ed in modo 
	// simile all'ordinamento per inserzione. 
	// L'algoritmo è di tipo non adattivo, ossia il suo tempo di esecuzione non dipende dall'input ma dalla 
	// dimensione dell'array.
	// L'algoritmo seleziona di volta in volta il numero minore nella sequenza di partenza e lo sposta nella 
	// sequenza ordinata; di fatto la sequenza viene suddivisa in due parti: la sottosequenza ordinata, che 
	// occupa le prime posizioni dell'array, e la sottosequenza da ordinare, che costituisce la parte restante dell'array.
	public void selectionSort(int[] vet) {
		// Loop che divide le due sottosequenze
		for (int j = 0; j < vet.length - 1; j++) { 
 			int temp;
			int pos_min = j;
			// Loop che cerca il valore minimo 
			for (int i = j + 1; i < vet.length; i++) {
				if (vet[pos_min] > vet[i]) {
					pos_min = i;
				}
			}
			// Se il minimo non è il primo, scambia.
			if (pos_min != j) {
				scambia(vet,pos_min,j);
			}
		} // chiude il for
	}

	////////////////////////////////////////////
	////  Algoritmo BUBBLE
	////////////////////////////////////////////
    // In informatica il Bubble sort o ordinamento a bolla è un semplice algoritmo di ordinamento di liste di dati. 
	// In esso l'insieme di dati viene scansionato, ogni coppia di elementi adiacenti viene comparata ed i due 
	// elementi vengono invertiti di posizione se sono nell'ordine sbagliato. 
	// L'algoritmo continua nuovamente a ri-eseguire questi passaggi su tutta la lista fino a quando non vengono 
	// più eseguiti scambi, situazione che indica che la lista è ordinata.
	// Il Bubble sort è più efficiente rispetto al più semplice algoritmo di Ordinamento Ingenuo perché, 
	// invece di continuare ad eseguire sempre fino alla fine i due cicli annidati, si interrompe appena si accorge
	// di non effettuare più scambi quando l'ordinamento è già completo. 
	// Si tratta comunque di un algoritmo non particolarmente efficiente e il suo utilizzo si limita a scopi 
	// didattici in virtù della sua semplicità e per introdurre i futuri programmatori al ragionamento algoritmico 
	// e alle misure di complessità.
	public void bubbleSort(int[] v) {
		boolean scambio;
		int j = v.length - 1;
		do {
			scambio = false;
			for (int i = 0; i < j; i++) {
				int temp;
				if (v[i] > v[i + 1]) {
					scambia(v,i,i+1);
					scambio = true;
				}
			} // chiude il for
			j = j - 1;
		} while (scambio == true);
	}

	////////////////////////////////////////////
	////  Algoritmo QUICK
	////////////////////////////////////////////
	// Quicksort è un algoritmo di ordinamento ricorsivo in place non stabile. 
	// Tale procedura ricorsiva viene comunemente detta partition: preso un elemento chiamato "pivot" 
	// dall'array e si pongono gli elementi minori a sinistra rispetto al pivot e gli elementi maggiori a destra. 
	// L'operazione viene quindi reiterata sui due insiemi risultanti fino al completo ordinamento della struttura.
    // Il Quicksort, termine che tradotto letteralmente in italiano indica ordinamento rapido, è l'algoritmo di 
	// ordinamento che ha, nel caso medio, prestazioni migliori tra quelli basati su confronto. 
	// È stato ideato da Charles Antony Richard Hoare nel 1961.
	private int partition(int arr[], int low, int high) {
		int pivot = arr[high]; // Pivot l'ultimo elemento
		int i = low - 1; // indice dell'elemento piu' piccolo. -1 all'inizio
		for (int j = low; j < high; j++) {
			// se elemento corrente minore di pivot
			if (arr[j] <= pivot) {
				i++;
				// scambia arr[index] and arr[j]
                scambia(arr,i,j);
			}
		}
		// scambia arr[index+1] e arr[high] (o pivot)
		scambia(arr,i+1,high);
		return i + 1;
	}

	private int hoarepartition(int arr[], int low, int high) {
		int pivot = arr[low]; // Pivot primo elemento
		int i = low - 1; // indice dell'elemento piu' piccolo. -1 all'inizio
		int j = high + 1; // indice dell'elemento piu' grande. 
		while(true) {
			do {
				i++;
			} while (arr[i] < pivot); //elementi minori a sx
			
			do {
				j--;
			} while (arr[j] > pivot); //elementi maggiori a dx
			
			if (i>=j) { // gli indici si sono scambiati tutti gli elementi sono ok
				return j;
			}
			scambia(arr,i,j);
		}
	}

	/*
	 * La funzione principale che implementa QuickSort() arr[] --> array da
	 * ordinare, low --> indice iniziale, high --> indice finale
	 */
	public void quick(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi � l'indice di partizionamento, arr[pi] � ora al posto giusto
			 */
			int pi = partition(arr, low, high);
			// Ordina ricorsivamente gli elementi prima di
			// partition e dopo partition
			quick(arr, low, pi - 1);
			quick(arr, pi + 1, high);
		}
	}

	public void hoarequick(int arr[], int low, int high) {
		if (low < high) {
			/*
			 * pi � l'indice di partizionamento, arr[pi] � ora al posto giusto
			 */
			int pi = hoarepartition(arr, low, high);
			// Ordina ricorsivamente gli elementi prima di
			// partition e dopo partition
			quick(arr, low, pi - 1);
			quick(arr, pi + 1, high);
		}
	}
	public void quickSort(int v[]) {
		quick(v, 0, v.length - 1);
	}

	public void hoareQuickSort(int v[]) {
		quick(v, 0, v.length - 1);
	}
	
	////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////////////////////////////////////////////////
	
	public void stampa(int[] v) {
		if (v.length <= 20) {
			for (int e : v) {
				System.out.print(e);
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	///////////////////////////////////////////////////////////////////////////////
	// Utilizza metodi "reflection" di Java
	///////////////////////////////////////////////////////////////////////////////
	public void getTimeOF(String mName, int[] v) {
		Class[] parameterTypes = new Class[1];
		parameterTypes[0] = int[].class;
		long startTime, endTime;
		startTime = System.nanoTime();
		try {
			Principale.class.getMethod(mName, parameterTypes[0]).invoke(this, v);
			endTime = System.nanoTime();
			System.out.printf("+ Algoritmo %.15s tempo di esecuzione in nanosecondi: \t%,15d\n", mName,
					(endTime - startTime));
		} catch (Exception e) {
			e.setStackTrace(null);
		}
	}

	////////////////////////////////////////////////////////////////////////////////
	// Resetta il contenuto del vettore
	////////////////////////////////////////////////////////////////////////////////
	public void carica(int[] v) {
		for (int i = 0; i < v.length; i++) {
			v[i] = VET[i];
		}
	}

	public static void main(String[] args) {
		Principale p;
		String[] sort = { "bubbleSort", "ingenuoSort", "selectionSort", "insertionSort", "quickSort", "hoareQuickSort" };

		for (int size = 10; size <= 100000; size *= 10) {
			p = new Principale(size);
			int[] vet = new int[VET.length];
			p.carica(vet);
			p.stampa(vet);

			System.out.println("--- RUN con " + size + " elementi ---");
			for (int i = 0; i < sort.length; i++) {
				p.carica(vet);
				p.getTimeOF(sort[i], vet);
				p.stampa(vet);
			}
		}
	}
}
