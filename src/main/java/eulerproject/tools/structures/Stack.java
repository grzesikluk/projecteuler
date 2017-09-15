package eulerproject.tools.structures;

import java.util.LinkedList;
import java.util.List;

public class Stack<V>
{
    private List<V> vector;
    private int pointer;

    public Stack()
    {
        vector = new LinkedList<V>();
        pointer = -1;
    }

    public boolean isEmpty()
    {
        return vector.isEmpty();
    }

    public void push(V item)
    {
        vector.add(item);
        pointer++;
    }

    public V pop()
    {
        if (!vector.isEmpty()) {
            V result = vector.get(pointer);
            vector.remove(pointer);
            pointer--;

            return result;
        }

        return null;
    }

    public V peek()
    {
        if(!vector.isEmpty())
            return vector.get(pointer);
        else
            return null;
    }

    public int size()
    {
        return vector.size();
    }

    @Override
    public String toString()
    {
        return vector.toString();
    }
}
