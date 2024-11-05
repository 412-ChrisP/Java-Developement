package YearUp.pluralsight;

import java.util.*;

public class FixedList<T>
{
    private List<T> items;
    private int maxSize;

    public FixedList(int maxSize)
    {
        this.maxSize = maxSize;
        this.items = new ArrayList<>();
    }

    public void add(T item)
    {
        if (items.size() < maxSize)
        {
            items.add(item);
        } else
        {
            throw new IllegalStateException("Cannot add more items.");
        }
    }

    public List<T> getItems()
    {
        return items;
    }
}