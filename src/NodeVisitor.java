
// Reminder pattern is used in that class to send the reminder to user

public abstract class NodeVisitor {
    public abstract void visitProduct(Product product);
    public abstract void visitTrading(Trading product);
    public abstract void visitFacade(Facade product);
}
