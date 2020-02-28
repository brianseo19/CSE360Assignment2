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
		list = new int[4];
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
				break;
			}
		}
	}
	
	/**
	 * @return simply returns the number of elements in the array.
	 */
	public int count()
	{
		//remove print line
		System.out.println(count);
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
		//remove print line
		System.out.println(output);
		return output;
	}
	
	/**
	 * This method takes a @param x that is the element that is being searched
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
	
	public static void main(String[] args)
	{
		SimpleList test = new SimpleList();
		test.add(1);
		test.add(2);
		test.add(3);
		test.add(4);
		test.add(7);
		test.count();
		test.toString();
	}
}
