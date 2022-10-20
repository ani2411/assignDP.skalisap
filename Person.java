import javax.swing.*;

public abstract class Person extends JFrame{
    private String name;
    private String password;
    protected Facade facade;
    protected ProductMenu productMenu;
    private ClassProductList lis;

    public Person(String name, String password, Facade facade) {
        this.name = name;
        this.password = password;
        this.facade = facade;
        lis = new ClassProductList();
    }

    public void showAddButton(){}

    public void showViewButton(){}

    public void showRadioButton() {productMenu.showRadioButton();}

    public void showLabel(){}

    public void addProductList(Product pro){
        lis.add(pro);
    }

    public abstract ProductMenu createProductMenu();
    public abstract void showMenu();
}
