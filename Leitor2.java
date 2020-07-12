import javax.swing.JOptionPane;

public class Leitor2 {
    public static String leStringDoTeclado(String mensagem) {
        return JOptionPane.showInputDialog(null, mensagem);
    }

    public static int leInteiroDoTeclado(String mensagem) {
        return Integer.parseInt(JOptionPane.showInputDialog(null, mensagem));
    }
    
    public static float leFloatDoTeclado(String mensagem) {
        return Float.parseFloat(JOptionPane.showInputDialog(null, mensagem));
    }
}