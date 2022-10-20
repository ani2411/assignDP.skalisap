import javax.swing.*;

public class Seller extends Person{
    public Seller(String name, String password, Facade facade) {
        super(name, password, facade);
    }

    @Override
    public ProductMenu createProductMenu()
    {
        // use factory pattern to decide which menu to display
        int i = Integer.parseInt(JOptionPane.showInputDialog("1. MenuforMeatProduct \n2. MenuforProduceProduct"));
        switch(i) {
        case 1:
        	super.productMenu = new MeatProductMenu(this);
        	break;
        case 2:
        	super.productMenu = new ProduceProductMenu(this);
        	break;
        default:
        	break;
        	
        }
        return super.productMenu;
        }
       
    @Override
    public void showMenu() {
        super.productMenu.showMenu();
    }
}
