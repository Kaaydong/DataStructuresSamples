// 
//  Name:   Hung, Kayden 
//  Project:  #2 
//  Due:        10/7/2022 
//  Course:  cs-2400-02
// 
//  Description: 
//    Interface for set abstract data type
//     

public interface SetInterface<T>
{
    /** Returns the number of items in the set
     @return integer value of number of items in the set */
    int getCurrentSize();
    
    /** Returns whether the set has zero items in it or not
     @return boolean, true if the set is empty, false if not */
    boolean isEmpty();
    
    /** Adds a new item to the set
     @param newItem, the object being added as a new item
     @return boolean, true if object is added successfully,
     false if not */
    boolean add(T newItem);
    
    /** Removes an item in the set
     @return the object of the item if it was successfully removed,
     null if unsuccessful */
    T remove();
    
    /** Removes a specified item in the set 
     @param anItem, the item that needs to be removed
     @return boolean, true if removal was successful, 
     false if unsuccessful */
    boolean remove(T anItem);
    
    /** Clears all items from the set */
    void clear();
    
    /** Returns number of instances of a specific item is in the set
     @param anItem, item to be scanned for frequency in set
     @return integer value of number of times anItem appears
     in the set */
    int getFrequencyOf(T anItem);
    
    /** Tells whether an item is in the set
     @param anItem, the item to be search for in the set
     @return boolean, true if anItem is found in the set,
     false if not */
    boolean contains(T anItem);
    
    /** Creates an array using all items in the set
     @return array filled with all set items, or an empty array
     if set is empty */
    T[] toArray();

    /** Tells whether the object  set is a subset of the parameter set 
     @param rhs, the set to which the object set will be comparing with
     @return boolean, true if the object set is a subset of the parameter set,
     false if not */
    boolean subset(SetInterface rhs);

    /** Tells whether the object set is equal to the parameter set 
     @param rhs, the set to which the object set will be comparing with
     @return boolean, true if the object set's contents are identical to that of the parameter set,
     false if not */
    boolean equals(SetInterface rhs);

    // /** Returns the union of the object set and parameter set 
    //  @param rhs, the set being compared to with the object set
    //  @return SetInterface, a set of all the contents to which the object set
    //  and parameter set share */
    // SetInterface union(SetInterface rhs);

    /** Returns a formatted String of all of the set's contents 
     @return String, a formatted output of all of the set's content,
    a empty String if the set has no items */
    String toString(); 

}