import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.nio.charset.StandardCharsets;
public class Login extends JFrame {

    private final JRadioButton byr;
    private final JRadioButton slr;
    private volatile int cnt;
    private boolean login;
    private HashMap<String, String> buyers;
    private HashMap<String, String> sellers;
    private int userType;
    private Person p;
    private Facade facade;

    public Login(Facade facade) {
        this.facade = facade;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("Login");
        cnt = 0;

        getbyr();
        getsellers();

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel panel2 = new JPanel(new FlowLayout());
        JTextField username = new JTextField();
        username.setPreferredSize(new Dimension(150, 30));
        JLabel label = new JLabel("User name   ");
        panel2.add(label);
        panel2.add(username);
        contentPane.add(panel2);

        JPanel panel3 = new JPanel(new FlowLayout());
        JPasswordField password = new JPasswordField();
        password.setPreferredSize(new Dimension(150, 30));
        JLabel label1 = new JLabel("Password    ");
        panel3.add(label1);
        panel3.add(password);
        contentPane.add(panel3);

        byr = new JRadioButton("Buyer    ");
        slr = new JRadioButton("Seller");
        byr.setSelected(true);
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(byr);
        panel.add(slr);
        contentPane.add(panel);

        JButton button = new JButton("Login");
        JPanel panel1 = new JPanel(new FlowLayout());
        panel1.add(button);
        contentPane.add(panel1);

        byr.addActionListener(e -> slr.setSelected(false));
        slr.addActionListener(e -> byr.setSelected(false));

        button.addActionListener(e->{
            if(byr.isSelected() && buyers.containsKey(username.getText())){
                String value = buyers.get(username.getText());
                if(value.equals(password.getText())){
                    userType = 0;
                    p = new Buyer(username.getText(), password.getText(), facade);
                    login = true;
                    cnt = 1;
                }
            }else if(slr.isSelected() && sellers.containsKey(username.getText())){
                String value = sellers.get(username.getText());
                if(value.equals(password.getText())){
                    userType = 1;
                    p = new Seller(username.getText(), password.getText(), facade);
                    login = true;
                    cnt = 1;
                }
            }
        });
        setContentPane(contentPane);
        requestFocus();
        setFocusable(true);
        pack();
    }

    private void getbyr() {
        buyers = new HashMap<>();
        try {
        	File currFile = new File("src\\BuyerDatabase.txt");
        	Scanner scnr = new Scanner(currFile,StandardCharsets.UTF_8);
            while(scnr.hasNextLine()){
                String reader = scnr.nextLine();
                reader = reader.replace("\n", "");
                String[] reader1 = reader.split(":");
                buyers.put(reader1[0], reader1[1]);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void getsellers() {
        sellers = new HashMap<>();
        try {
            Scanner scnr = new Scanner(new File("src\\SellerDatabase.txt"));
            while(scnr.hasNextLine()){
                String reader = scnr.nextLine();
                reader = reader.replace("\n", "");
                String[] reader1 = reader.split(":");
                sellers.put(reader1[0], reader1[1]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean getResult() {
        while (cnt == 0) Thread.onSpinWait();
        return login;
    }

    public int getUserType() {
        return userType;
    }

    public Person getPerson() {
        return p;
    }
}
