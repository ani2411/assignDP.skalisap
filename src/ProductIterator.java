// using iterator pattern to iterate between product list
public class ProductIterator implements ListIterator {

    private final ClassProductList list;
    int index;

    public ProductIterator(ClassProductList list) {
        this.list = list;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public Object next() {
        return list.get(index);
    }

    @Override
    public void moveToHead() {
        index = 0;
    }

    @Override
    public void remove() {
        list.remove(index);
    }
}
