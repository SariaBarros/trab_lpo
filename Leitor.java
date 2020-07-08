import java.util.Scanner;

public class Leitor {
    private Scanner scanner;

    public Leitor () {
        scanner = new Scanner(System.in);
    }

    public int leInteiro() {
        int valorInteiro = scanner.nextInt();
        scanner.nextLine();
        return valorInteiro;
    }

    public String leString() {
        return scanner.nextLine();
    }
}
