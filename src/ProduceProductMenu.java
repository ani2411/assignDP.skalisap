import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ProduceProductMenu extends JFrame implements ProductMenu {
    private JButton add;
    private JButton view;
    private Person person;
    private ArrayList<JLabel> lab;

    public ProduceProductMenu(Person buyer) {
        this.person = buyer;

    }

    @Override
    public void showMenu()
    {
        ProductMenuFrame fr=new ProductMenuFrame(person.facade);
        fr.setVisible(true);
    }

    @Override
    public void showAddButton() {
        add.setVisible(true);
    }

    @Override
    public void showViewButton() {
        view.setVisible(true);
    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {
        for(JLabel j:lab){
            j.setVisible(true);
        }
    }

    @Override
    public void showComboxes() {}
}
