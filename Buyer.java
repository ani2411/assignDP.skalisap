import javax.swing.*;

public class Buyer extends Person{
    public Buyer(String name, String password,Facade facade) {
        super(name, password, facade);
    }

    @Override
    public ProductMenu createProductMenu()
    {
        // factory pattern is used to display ProductMenu
    	// getting inputs from the user
        int i = Integer.parseInt(JOptionPane.showInputDialog("1. MenuforMeatProduct \n2. MenuforProduceProduct"));
        switch (i) {
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
