//Functionality of GUI is handled by using Bridge pattern and Facade Pattern.

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Facade {
    private int userType;
    private Product theSelectedProduct;
    private int nProductCategory;
    private ClassProductList theProductList=new ClassProductList();
    private Person thePerson;

    public boolean login() {
        Login login = new Login(this);
        login.setVisible(true);
        boolean x = login.getResult();
        userType = login.getUserType();
        thePerson = login.getPerson();
        login.dispose();
        return x;
    }

    public void addTrading()
    {
        JOptionPane.showMessageDialog(null, "Display Menu for Add Trading");
    }

    public void viewTrading(){
        JOptionPane.showMessageDialog(null, "trading not offered");
    }

    public void viewOffering(){
        JOptionPane.showMessageDialog(null, "No current offers to display");
    }

    public void markOffering(){
        JOptionPane.showMessageDialog(null, "No current mark offerings ");
    }

    public void submitOffering(){
        JOptionPane.showMessageDialog(null, "No current offers to submit");
    }

    public void remind(){
        JOptionPane.showMessageDialog(null, "Nothing is present");
    }

    public void createUser(){}

    public void createProductList(){
        try {
            Scanner scnr = new Scanner(new File("ProductInfo.txt"));
            while (scnr.hasNextLine()){
                String reader = scnr.nextLine();
                reader = reader.replace("\n", ":");
                String[] reader1= reader.split(":");
                Product product = new Product(reader1[1], reader1[0]);
                theProductList.add(product);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        JOptionPane.showMessageDialog(null, "Product List generated");
    }

    public void attachProductToUser(){
        try {
            Scanner scnr = new Scanner(new File("UserProduct.txt"));
            while (scnr.hasNextLine()){
                String reader = scnr.nextLine();
                reader = reader.replace("\n", ":");
                String[] reader1= reader.split(":");
                if(reader1[0].equals(thePerson.getName())) {
                    Product product=null;
                    for(Product p:theProductList){
                        if(p.getName().equals(reader1[1])) {
                            product = p;
                            break;
                        }
                    }
                    if(product != null)
                        thePerson.addProductList(product);
                }

            }
            JOptionPane.showMessageDialog(null, "Given Product List is attached");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void selectProduct(){
        String strng = "Select one: \n";
        int j = 0;
        while(j++ < theProductList.size()) {
        	strng += j + theProductList.get(j).toString() +"\n";
        }
        	
        
        int option = Integer.parseInt(JOptionPane.showInputDialog(strng));
        if(option > 0) { 
        	if (option < theProductList.size()) {
        		theSelectedProduct = theProductList.get(option);
        	}
        }
            
    }

    public void productOperation(){
        thePerson.showMenu();
    }

    public void accept(ReminderVisitor reminderVisitor) {
    }

    public Person getThePerson() {
        return thePerson;
    }

    public int getUserType() {
        return userType;
    }
}
