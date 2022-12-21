// 
//  Name:   Hung, Kayden 
//  Homework:  #5
//  Due:        12/9/2022
//  Course:  cs-2400-02-f22 
// 
//  Description: 
//    Data struture that implements DictionaryInterface 
// 

import java.util.*;

public class MapDictionary<K,V> implements DictionaryInterface<K,V>
{
	private int numberOfKeys;
	private Map<K,V> hashmap;


	/** Default Constructor */
	public MapDictionary()
	{
		numberOfKeys = 0;
		hashmap = new HashMap<>();
	}

	public V add(K key, V value)
	{
		if(hashmap.containsKey(key))
		{
			hashmap.put(key, value);
			return hashmap.get(key);
		}
		else{
			hashmap.put(key, value);
			numberOfKeys++;
			return null;
		}
	}

	public V remove(K key)
	{
		if(hashmap.containsKey(key))
		numberOfKeys--;
		
		return hashmap.remove(key);
	}

	public V getValue(K key)
	{
		return hashmap.get(key);
	}

	public boolean contains(K key)
	{
		return hashmap.containsKey(key);
	}

	public Iterator<K> getKeyIterator()
	{
		return hashmap.keySet().iterator();
	}

	public boolean isEmpty()
	{
		return numberOfKeys==0;
	}

	public int getSize()
	{
		return numberOfKeys;
	}

	public void clear()
	{
		numberOfKeys = 0;
		hashmap.clear();
	} 
}
