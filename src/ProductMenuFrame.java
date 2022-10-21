import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ProductMenuFrame extends JFrame {

    public ProductMenuFrame(Facade facade) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Product Menu");

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel panel1 = new JPanel(new FlowLayout());
        JButton trading = new JButton("Add trading");
        panel1.add(trading);

        JPanel panel2 = new JPanel(new FlowLayout());
        JButton view = new JButton("View trading");
        panel2.add(view);

        JPanel panel3 = new JPanel(new FlowLayout());
        JButton markOffering = new JButton("Mark Offering");
        panel3.add(markOffering);

        JPanel panel4 = new JPanel(new FlowLayout());
        JButton submitOffering = new JButton("Submit Offering");
        panel4.add(submitOffering);

        JPanel panel5 = new JPanel(new FlowLayout());
        JButton remind = new JButton("Remind");
        panel5.add(remind);

        JPanel panel6 = new JPanel(new FlowLayout());
        JButton product_list = new JButton("Create Product List");
        panel6.add(product_list);

        JPanel panel7 = new JPanel(new FlowLayout());
        JButton attach = new JButton("Attach Product to user");
        panel7.add(attach);

        JPanel panel8 = new JPanel(new FlowLayout());
        JButton select = new JButton("Select Product");
        panel8.add(select);

        contentPane.add(panel1);
        contentPane.add(panel2);
        contentPane.add(panel3);
        contentPane.add(panel4);
        contentPane.add(panel5);
        contentPane.add(panel6);
        contentPane.add(panel7);
        contentPane.add(panel8);

        if(facade.getUserType() == 1) {
            panel4.setVisible(false);
            panel5.setVisible(false);
        }

        setContentPane(contentPane);
        pack();

        trading.addActionListener(e->facade.addTrading());
        view.addActionListener(e->facade.viewTrading());
        markOffering.addActionListener(e->facade.markOffering());
        submitOffering.addActionListener(e->facade.submitOffering());
        product_list.addActionListener(e->facade.createProductList());
        remind.addActionListener(e->facade.remind());
        attach.addActionListener(e->facade.attachProductToUser());
        select.addActionListener(e->facade.selectProduct());
    }
}
