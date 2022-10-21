public class App {
    public static Facade facade = new Facade();
    public static void main(String[] args) {

        if(facade.login()){
            facade.getThePerson().createProductMenu();
            facade.getThePerson().showMenu();
        }
    }
}
