import javax.swing.*;
import java.util.Arrays;

public class Mainmenu {

    // ================================
    // 🔹 Componentes creados en el .form
    // ================================
    private JPanel panelMain;
    private JTabbedPane tabbedPane1;

    // Este panel es el que marcaste como Custom Create en el .form
    private JPanel panel1;

    // --- ARREGLOS ---
    private JTextField txtInputArreglo;
    private JTextArea txtAreaResultado;
    private JButton btnCrearArreglo;
    private JButton btnSumarElementos;
    private JButton btnOrdenar;
    private JButton btnInvertir;

    // ================================
    // 🔹 Variable global para guardar el arreglo
    // ================================
    private int[] arreglo;

    // ================================
    // 🔹 Constructor
    // ================================
    public Mainmenu() {
        // Conectar botones con métodos
        btnCrearArreglo.addActionListener(e -> crearArreglo());
        btnSumarElementos.addActionListener(e -> sumarArreglo());
        btnOrdenar.addActionListener(e -> ordenarArreglo());
        btnInvertir.addActionListener(e -> invertirArreglo());
    }

    // =======================================================
    // 🔹 Este método es OBLIGATORIO si activaste Custom Create
    // =======================================================
    private void createUIComponents() {
        // Crear a mano el panel marcado como Custom Create
        panel1 = new JPanel();
    }

    // ================================
    // 🔹 Métodos de la pestaña "Arreglos"
    // ================================

    private void crearArreglo() {
        try {
            arreglo = Arrays.stream(txtInputArreglo.getText().split(","))
                    .map(String::trim)
                    .mapToInt(Integer::parseInt)
                    .toArray();

            txtAreaResultado.setText("Arreglo creado:\n" + Arrays.toString(arreglo));

        } catch (Exception ex) {
            txtAreaResultado.setText("❌ Error: Entrada inválida.\nUse formato: 1,2,3,4");
        }
    }

    private void sumarArreglo() {
        if (arregloNulo()) return;

        int suma = 0;
        for (int n : arreglo) suma += n;

        txtAreaResultado.setText("Suma de elementos:\n" + suma);
    }

    private void ordenarArreglo() {
        if (arregloNulo()) return;

        int[] copia = arreglo.clone();
        Arrays.sort(copia);

        txtAreaResultado.setText("Arreglo ordenado:\n" + Arrays.toString(copia));
    }

    private void invertirArreglo() {
        if (arregloNulo()) return;

        int[] copia = arreglo.clone();
        for (int i = 0, j = copia.length - 1; i < j; i++, j--) {
            int temp = copia[i];
            copia[i] = copia[j];
            copia[j] = temp;
        }

        txtAreaResultado.setText("Arreglo invertido:\n" + Arrays.toString(copia));
    }

    // ================================
    // 🔹 Método auxiliar
    // ================================
    private boolean arregloNulo() {
        if (arreglo == null) {
            txtAreaResultado.setText("⚠️ Primero debe crear un arreglo.");
            return true;
        }
        return false;
    }

    // ================================
    // 🔹 Método main para iniciar la app
    // ================================
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mainmenu");
        frame.setContentPane(new Mainmenu().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}





