/**
 * Name: Woojun Seo
 * ID: 249
 * Description: This program contains a SimpleList class that involves arrays and its manipulation
 * It contains methods that add, remove, search, and toString elements in an array. It also keeps 
 * track of the number of elements in the array as well.
 */

package cse360assign2;
import java.io.*;
/**
 * This SimpleList class contains very simple methods that 
 * manipulate elements within an array
 */

public class SimpleList 
{
	private int[] list;
	private int count;
	
	/**
	 * This constructor creates a new array named list with a 
	 * size of 10 elements and sets the count of the array to 
	 * zero.
	 */
	public SimpleList()
	{
		list = new int[10];
		count = 0;	
	}
	
	/**
	 * This method adds an element to the array using an integer 
	 * @param x. It shifts all the other elements in the array over
	 * to make room for the new element. If the list is full, it increases
	 * the size of the array by 50%. The count is then incremented
	 */
	public void add(int input)
	{
		if(count == 0)
		{
			list[0] = input;
			count++;
		}
		else 
		{
			if (count == list.length)
			{
				int[] newList = new int[list.length * 3/2];
				for (int index = 0; index < count; index++)
				{
					newList[index] = list[index];
				}
				list = newList;
			}
			for(int start = count; start > 0; start--)
			{
				list[start] = list[start-1];
			}
			list[0] = input;
			count++;
		}
	}
	
	/**
	 * This method removes an element from the array given by the 
	 * @param x. It finds the specified element and removes it. If there
	 * are more than 25% empty spaces, then the size of the list is decreased. 
	 * The other values in the array are shifted to fill in the gap
	 */
	public void remove(int input)
	{
		for(int start=0; start < count; start++)
		{
			if (input == list[start])
			{
				for(int start2 = start; start2 < count-1; start2++)
				{
					list[start2] = list[start2+1];
				}
				count--;
				start = count;
			}
		}
		if (count < (list.length * 3/4) && list.length > 0)
		{
			System.out.println("i");
			int[] newList = new int[list.length-1];
			for (int index = 0; index < count; index++)
			{
				newList[index] = list[index];
			}
			list = newList;
		}
	}
	
	/**
	 * @return simply returns the number of elements in the array.
	 */
	public int count()
	{
		return count;
	}
	
	/**
	 * This method @returns the contents of the array as a string.
	 * There is a space between each element except for the last one
	 */
	public String toString()
	{
		String output = "";
		for (int start = 0; start < count; start++)
		{
			if(start == count-1)
				output = output + Integer.toString(list[start]);
			else
				output = output + Integer.toString(list[start]) + " ";
		}
		return output;
	}
	
	/**
	 * This method takes a @param input that is the element that is being searched
	 * for. It returns the index that the element is at if it is in the
	 * array and returns a negative number if the element
	 * does not exist.
	 */
	public int search(int input)
	{
		int found = -1;
		for(int start = 0; start < count; start++)
		{
			if (list[start] == input)
			{
				found = start;
				start = count;
			}
		}
		return found;
	}
	/**
	 * This method that a @param input and appends it to the end of the list.
	 * If the list is already full, it expands the size of the list by 50%.
	 * Then appends the new element. After this the count is incremented.
	 */
	public void append(int input)
	{
		if (count == list.length)
		{
			int[] newList = new int[list.length * 3/2];
			for (int index = 0; index < count; index++)
			{
				newList[index] = list[index];
			}
			list = newList;
		}
		list[count] = input;
		count++;
	}
	/**
	 * This method @return the first element of the list. If there are no elements
	 * in the list, it returns -1
	 */
	public int first()
	{
		int element = -1;
		if(count == 0)
			return element;
		else
			element = list[0];
		return element;		
	}
	
	/**
	 * This method @return the last element in the list. If there are no elements
	 * in the list, it returns -1.
	 */
	public int last()
	{
		int element = -1;
		if(count == 0)
			return element;
		else 
			element = list[count-1];
		return element;
	}
	
	/**
	 * This method @return the number of empty spaces in the list. It finds the difference
	 * between the length of the list and the current number of elements in it.
	 */
	public int size()
	{
		return list.length-count;
	}
}
