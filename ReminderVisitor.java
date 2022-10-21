// Reminder pattern is used in that class to send the reminder to user

public class ReminderVisitor extends  NodeVisitor{
    private Reminder reminder;

    public ReminderVisitor(Reminder reminder, Facade facade, ClassProductList cls, Trading trade) {
        this.reminder = reminder;
    }

    @Override
    public void visitProduct(Product product) {
        product.accept(this);
    }

    @Override
    public void visitTrading(Trading trade) {
        trade.accept(this);
    }

    @Override
    public void visitFacade(Facade facade) {
        facade.accept(this);
    }
}
