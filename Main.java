public class Main {
    public static void main(String[] args) {
        
        Leitor leitor = new Leitor();
        int menu;
        
        do {
            System.out.println("Escolha uma opção:");
            System.out.println("[1] Cadastrar um Filme");
            System.out.println("[2] Cadastrar um Anime");
            System.out.println("[3] Sair");

            menu = leitor.leInteiro();
        
            switch (menu) {
                case 1:
                    
                    break;
            
                case 2:


                    break;

                default:
                    break;
            }
        
        
        } while (menu != 5);
        






    }
    
}