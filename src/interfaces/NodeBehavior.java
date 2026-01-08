package interfaces;

public interface NodeBehavior<ElementType> {
    public ElementType element();
    public void setElement(ElementType value);
    public NodeBehavior<ElementType> left();
    public NodeBehavior<ElementType> right();
    public boolean isLeaf();

}
