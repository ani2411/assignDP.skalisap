import javax.swing.*;
import java.awt.*;

public class MeatProductMenu extends JFrame implements ProductMenu{
    private Person person;

    public MeatProductMenu(Person person) throws HeadlessException {
        this.person = person;
    }

    @Override
    public void showMenu()
    {
       ProductMenuFrame frame=new ProductMenuFrame(person.facade);
       frame.setVisible(true);
    }

    @Override
    public void showAddButton() {}

    @Override
    public void showViewButton() {

    }

    @Override
    public void showRadioButton() {}

    @Override
    public void showLabels() {}

    @Override
    public void showComboxes() {}
}
