// 
//  Name:   Hung, Kayden 
//  Homework: #1 
//  Due:      9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    ArrayBag abstract data type for storing objects
// 

public class ArrayBag<T> implements BagInterface<T>{

    private T[] bag;
    private int numberOfEntries;
    private static final int DEFAULT_CAPACITY = 15;
    private static final int MAX_CAPACITY = 30000;

    /** Default Constructor: creates bag with default capacity: 15 */
    public ArrayBag()
    {
        this(DEFAULT_CAPACITY);
    }

    /** Constructor: allowing for custom bag starting capacity
     * @param size, integer representing starting capacity of bag.
     */
    public ArrayBag(int size)
    {
        if(size < MAX_CAPACITY)
        {
        @SuppressWarnings("unchecked")
        T[] initializingBag = (T[]) new Object[size];
        bag = initializingBag;

        numberOfEntries = 0;
        }
        else{
            throw new RuntimeException("Input size is over MAX_CAPACITY:" + MAX_CAPACITY);
        }
    }

    /** Returns the number of items in the bag
     @return integer value of number of items in the bag */
    public int getCurrentSize()
    {
        return numberOfEntries;
    }

    /** Returns whether the bag has zero items in it or not
     @return boolean, true if the bag is empty, false if not empty */
    public boolean isEmpty()
    {
        return (numberOfEntries == 0);
    }

    /** Adds a new item to the bag
     @param newItem, the object being added as a new item
     @return boolean, true if object is added successfully,
     false if bag is at or close to max capacity */
    public boolean add(T newItem)
    {
        if(isArrayFull())
        {
            if(bag.length + DEFAULT_CAPACITY >= MAX_CAPACITY)
            {
                return false;
            }

            extendBag();
        }
        bag[numberOfEntries] = newItem;
        numberOfEntries++;

        return true;
    }

    /** checks if bag is full
     * @return boolean, true if bag is full, false if not */
    public boolean isArrayFull()
    {
        return !(numberOfEntries < bag.length);
    }

    /** Extends the length of the bag by the default capacity */
    private void extendBag() //increases size of bag
    {
        @SuppressWarnings("unchecked")
        T[] newBag = (T[]) new Object[bag.length + DEFAULT_CAPACITY];
        for(int i = 0; i < numberOfEntries; i++)
        {
            newBag[i] = bag[i];
        }

        bag = newBag;
    }

    /** Removes the last item in the bag
     @return the object of the item if it was successfully removed,
     null if unsuccessful */
    public T remove()
    {
        if(numberOfEntries==0)
        {
            return null;
        }
        T item = bag[numberOfEntries-1];
        bag[numberOfEntries-1] = null;
        numberOfEntries--;
        return item;
    }

    /** Removes a specified item in the bag 
     @param anItem, the item that needs to be removed
     @return boolean, true if removal was successful, 
     false if unsuccessful */
    public boolean remove(T anItem)
    {
        boolean found = false;
        int i = 0;
        while(!found && i < numberOfEntries)
        {
            if(bag[i].equals(anItem))
            {
                numberOfEntries--;
                reorganizeBag(i);
                return true;
            }
            else
            {
                i++;
            }
        }
        numberOfEntries--;
        return false;
    }

    /** Reorganizes bag after a specific item is removed at a random location
     * @param index, the int value of the location in the bag where the item was removed */
    private void reorganizeBag(int index) //shifts contents of bag after item removal 
    {
        for(int i = index; i < numberOfEntries; i++)
        {
            bag[i] = bag[i+1];
        }
    }

    /** Clears all items from the bag*/
    public void clear()
    {
        for(int i = 0; i < numberOfEntries; i++)
        {
            bag[i] = null;
        }
        numberOfEntries = 0;
    }

    /** Returns number of instances of a specific item is in the bag
     @param anItem, item to be scanned for frequency in bag
     @return integer value of number of times anItem appears
     in the bag */
    public int getFrequencyOf(T anItem)
    {
        int counter = 0;
        for(int i = 0; i < numberOfEntries; i++)
        {
            if(bag[i].equals(anItem)){
                counter++;
            }
        }
        return counter;
    }

    /** Tells whether an item is in the bag
     @param anItem, the item to be search for in the bag
     @return boolean, true if anItem is found in the bag,
     false if not */
    public boolean contains(T anItem)
    {
        for(int i = 0; i < numberOfEntries; i++)
        {
            if(bag[i].equals(anItem)){
                return true;
            }
        }
        return false;
    }

    /** Creates an array using all items in the bag
     @return array filled with all bag items, or an empty array
     if bag is empty */
    public T[] toArray()
    {
        @SuppressWarnings("unchecked")
        T[] newBag = (T[]) new Object[numberOfEntries];
        for(int i = 0; i < numberOfEntries; i++)
        {
            newBag[i] = bag[i];
        }

        return newBag;
    }
}
