// 
//  Name:   Hung, Kayden 
//  Homework: #1 
//  Due:      9/26/2022 
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    BagInterface for ArrayBag ADT
// 

public interface BagInterface<T>
{
    /** Returns the number of items in the bag
     @return integer value of number of items in the bag */
    int getCurrentSize();
    
    /** Returns whether the bag has zero items in it or not
     @return boolean, true if the bag is empty, false if not empty */
    boolean isEmpty();
    
    /** Adds a new item to the bag
     @param newItem, the object being added as a new item
     @return boolean, true if object is added successfully,
     false if not */
    boolean add(T newItem);
    
    /** Removes the last item in the bag
     @return the object of the item if it was successfully removed,
     null if unsuccessful */
    T remove();
    
    /** Removes a specified item in the bag 
     @param anItem, the item that needs to be removed
     @return boolean, true if removal was successful, 
     false if unsuccessful */
    boolean remove(T anItem);
    
    /** Clears all items from the bag*/
    void clear();
    
    /** Returns number of instances of a specific item is in the bag
     @param anItem, item to be scanned for frequency in bag
     @return integer value of number of times anItem appears
     in the bag */
    int getFrequencyOf(T anItem);
    
    /** Tells whether an item is in the bag
     @param anItem, the item to be search for in the bag
     @return boolean, true if anItem is found in the bag,
     false if not */
    boolean contains(T anItem);
    
    /** Creates an array using all items in the bag
     @return array filled with all bag items, or an empty array
     if bag is empty */
    T[] toArray();
}
