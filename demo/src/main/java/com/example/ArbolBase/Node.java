package co.edu.uniquindio.poo.Unidad3.Arboles.ArbolBase;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    private T value;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
        if (value == null) {
            throw new IllegalArgumentException("El valor no puede ser nulo");
        }
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    @Override
    public int compareTo(Node<T> other) {
        if (other == null) {
            throw new IllegalArgumentException("No se puede comparar con un nodo nulo");
        }
        return this.value.compareTo(other.value);

        /*
         * resultados:
         * -1: this.value es menor que other.value
         * 0: this.value es igual a other.value
         * 1: this.value es mayor que other.value
         */
    }

    @Override
    public String toString() {
        return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
    }
}