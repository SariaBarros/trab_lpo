import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;

public class BotaoMenu {
    private JMenu menu;
    private JMenuItem menuItems[];
    private int quantDeMenuItems;

    public BotaoMenu(String nome, int quantDeMenuItems) {
        setMenu(nome);
        setMenuItens(quantDeMenuItems);
        setQuantDeMenuItems(0);
    }

    public void adicionarMenuItem(String menuItem){
        menuItems[quantDeMenuItems] = new JMenuItem(menuItem);
        menu.add(menuItems[quantDeMenuItems]);
        setQuantDeMenuItems(getQuantDeMenuItems() + 1);
    }

    public void configurarEventoBotaoMenuItem(int idMenuItem, ActionListener ouvido){
        menuItems[idMenuItem].addActionListener(ouvido);
    }

    //get e set
    public JMenu getMenu() {
        return menu;
    }

    private void setMenu(String nome) {
        menu = new JMenu(nome);
    }

    public void setMenuItens(int quantDeMenuItems) {
        menuItems = new JMenuItem[quantDeMenuItems];
    }

    public int getQuantDeMenuItems() {
        return quantDeMenuItems;
    }

    private void setQuantDeMenuItems(int quantDeMenuItems) {
        this.quantDeMenuItems = quantDeMenuItems;
    }
}