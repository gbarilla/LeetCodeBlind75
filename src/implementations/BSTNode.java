package implementations;

import interfaces.NodeBehavior;

public class BSTNode<Key,ElementType> implements NodeBehavior<ElementType> {

    private Key key;
    private ElementType element;
    private BSTNode<Key,ElementType> left;
    private BSTNode<Key,ElementType> right;

    public BSTNode()
    {
        left=right=null;
    }

    public BSTNode(Key key, ElementType value,BSTNode<Key,ElementType> left,BSTNode<Key,ElementType> right)
    {
        this.left = left;
        this.right=right;
        this.key = key;
        element = value;
    }

    @Override
    public ElementType element() {
        return null;
    }

    @Override
    public void setElement(ElementType value) {

    }

    @Override
    public NodeBehavior left() {
        return null;
    }

    @Override
    public NodeBehavior right() {
        return null;
    }

    @Override
    public boolean isLeaf() {
        return false;
    }
}
