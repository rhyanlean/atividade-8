
public class InsertionSort1 {

	import java.util.ArrayList;
	import java.util.List;

	// Modelo (Model)
	class NumerosModel {
	    private List<Integer> numeros;

	    public NumerosModel() {
	        numeros = new ArrayList<>();
	    }

	    public void adicionarNumero(int numero) {
	        numeros.add(numero);
	    }

	    public List<Integer> getNumeros() {
	        return numeros;
	    }
	}

	// Visualização (View)
	class NumerosView {
	    public void mostrarNumeros(List<Integer> numeros) {
	        System.out.println("Números armazenados: " + numeros);
	    }

	    public void mostrarOrdenados(List<Integer> numerosOrdenados, String metodo) {
	        System.out.println("Números ordenados com " + metodo + ": " + numerosOrdenados);
	    }
	}

	// Controlador (Controller)
	class NumerosController {
	    private NumerosModel model;
	    private NumerosView view;

	    public NumerosController(NumerosModel model, NumerosView view) {
	        this.model = model;
	        this.view = view;
	    }

	    public void adicionarNumeros(int[] numeros) {
	        for (int numero : numeros) {
	            model.adicionarNumero(numero);
	        }
	    }

	    public void ordenarNumeros(String metodo) {
	        List<Integer> numeros = model.getNumeros();
	        if (metodo.equalsIgnoreCase("insertion")) {
	            insertionSort(numeros);
	            view.mostrarOrdenados(numeros, "Insertion Sort");
	        } else if (metodo.equalsIgnoreCase("bubble")) {
	            bubbleSort(numeros);
	            view.mostrarOrdenados(numeros, "Bubble Sort");
	        } else {
	            System.out.println("Método de ordenação inválido.");
	        }
	    }

	    private void insertionSort(List<Integer> arr) {
	        int n = arr.size();
	        for (int i = 1; i < n; ++i) {
	            int key = arr.get(i);
	            int j = i - 1;

	            while (j >= 0 && arr.get(j) > key) {
	                arr.set(j + 1, arr.get(j));
	                j = j - 1;
	            }
	            arr.set(j + 1, key);
	        }
	    }

	    private void bubbleSort(List<Integer> arr) {
	        int n = arr.size();
	        for (int i = 0; i < n - 1; i++) {
	            for (int j = 0; j < n - i - 1; j++) {
	                if (arr.get(j) > arr.get(j + 1)) {
	                    int temp = arr.get(j);
	                    arr.set(j, arr.get(j + 1));
	                    arr.set(j + 1, temp);
	                }
	            }
	        }
	    }
	}

	// Classe Principal (Main)
	public class Main {
	    public static void main(String[] args) {
	        NumerosModel model = new NumerosModel();
	        NumerosView view = new NumerosView();
	        NumerosController controller = new NumerosController(model, view);

	        int[] numeros = {10, 7, 15, 3, 9, 22, 5, 12, 18, 1};

	        controller.adicionarNumeros(numeros);
	        view.mostrarNumeros(model.getNumeros());
	        controller.ordenarNumeros("insertion");
	    }
	}




	
