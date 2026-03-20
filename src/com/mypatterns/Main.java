/**
 *  Java program with realization Decorator pattern with implementation interface List.
 */

package com.mypatterns;

import java.util.*;

/**
 *  Main class.
 */
public class Main {

    // Entry point for JVM.
    public static void main(String[] args) {

        // Creating an LinkedList with numbers.
        LinkedList<Integer> lk = new LinkedList<>();

        // Adding elements to lk.
        lk.add(3);
        lk.add(6);
        lk.add(1);
        lk.add(9);
        lk.add(7);
        lk.add(2);

        // Creating object of MyList type.
        MyList myList = new MyList(lk);

        // Printing size of myList.
        System.out.println(myList.size()); // Output: 6

        // Printing elements of myList to console.
        Iterator it = myList.iterator();

        while (it.hasNext()) {

            System.out. print(it.next() + " "); // Output: 3 6 1 9 7 2

        }

        // Moving pointer to next line.
        System.out.println();

        // Adding element to myList.
        myList.add(6);

        // Printing elements of myList to console.
        Iterator it1 = myList.iterator();

        while (it1.hasNext()) {

            System.out. print(it1.next() + " "); // Output: 3 6 1 9 7 2 6

        }

        // Removing element with value 1.
        myList.remove(1);

        // Moving pointer to next line.
        System.out.println();

        // Printing elements of myList to console.
        Iterator it2 = myList.iterator();

        while (it2.hasNext()) {

            System.out. print(it2.next() + " "); // Output: 3 1 9 7 2 6

        }

        // Deleting all elements from myList.
        myList.clear();

        // Checking that myList is empty.
        System.out.println("\nList size is: " + myList.size()); // Output: 0

    }
}

/**
 *  Class MyList.
 */

class MyList implements List {

    private List component;

    // Constructor of the class.
    public MyList(List component) {
        this.component = component;
    }

    // Method to return size os the list.
    @Override
    public int size() {
        return component.size();
    }

    // Method infor if list is empty.
    @Override
    public boolean isEmpty() {

        // Flag to hold empty or not value.
        boolean isEmpty = false;

        // Condition.
        if (component.size() != 0) {

            isEmpty = true;

        }

        return isEmpty;
    }

    // Method to check if there is an element.
    @Override
    public boolean contains(Object o) {

        // Flag to hold is here present element.
        boolean isPresent = false;

        // Condition
        if (component.contains(o)) {
            isPresent = true;
        }
        return isPresent;
    }

    // Method to create Mylist iterator.
    @Override
    public Iterator iterator() {

        // Creating iterator.
        Iterator it = component.iterator();

        return  it;
    }


    // Method to craete an array from given list.
    @Override
    public Object[] toArray() {

        // Craeting an array.
        Object[] arr = new Object[component.size()];

        // Filling the array with elelents.
        for (int index = 0; index < component.size(); index++) {

            arr[index] = component.get(index);
        }

        return arr;
    }

    // Method to add element.
    @Override
    public boolean add(Object o) {

        // Flag to inform if element is added.
        boolean idAdded = false;

        // Size of a list before adding an element.
        int oldSize = component.size();

        // Adding element;
        component.add(o);

        // Condition
        if (oldSize < component.size()) {

            idAdded = true;

        }

        return idAdded;
    }


    // Method to remove element.
    @Override
    public boolean remove(Object o) {

        // Flag if element id deleted.
        boolean isRemoved = false;

        // Condition.
        if (component.contains(o)) {

            component.remove(o);
            isRemoved = true;

        }

        return isRemoved;
    }


    // Method to add a collection.
    @Override
    public boolean addAll(Collection c) {

        // Flag to inform if elements were added.
        boolean isAdded = false;

        // Size of list before adding new elements.
        int oldSize = component.size();

        // Addin elements.
        component.addAll(c);

        // Condition.
        if (component.size() > oldSize) {

            isAdded = true;

        }

        return isAdded;
    }

    // Method to add elements starting from some index.
    @Override
    public boolean addAll(int index, Collection c) {

        // Flag to show that elements were added.
        boolean isAdded = false;

        // Size of list before adding new elements.
        int oldSize = component.size();

        // Holding elements of component from given index.
        Object[] arr = new Object[component.size() - index];

        // Storing elements.
        for (int i = 0; i < arr.length; i++) {

            arr[i] = component.get(i);
        }

        // Adding elements to component.
        component.addAll(c);

        // Adding old elements to component.
        for (int i = 0; i < arr.length; i++) {

            component.add(arr[i]);

        }

        // Condition.
        if (oldSize < component.size()) {

            isAdded = true;
        }

        return isAdded;
    }

    // Method to remove all elements.
    @Override
    public void clear() {

        component.clear();

    }

    // Method to get element by index.
    @Override
    public Object get(int index) {
        return component.get(index);
    }

    // Method to set and return element by index.
    @Override
    public Object set(int index, Object element) {

        // Storing value of ewlement.
        Object el = element;

        // Adding element.
        component.add(index, element);

        return el;
    }

    // Method to add element in specific index.
    @Override
    public void add(int index, Object element) {

        // Adding element.
        component.add(index, element);

    }

    // Method to remove element by index.
    @Override
    public Object remove(int index) {

        // Storing elemnts to remove.
        Object el = component.get(index);

        // Removing element.
        component.remove(el);

        return el;
    }

    // Method to find index of element.
    @Override
    public int indexOf(Object o) {
        return component.indexOf(o);
    }

    // Method to return the last index of element.
    @Override
    public int lastIndexOf(Object o) {

        // Index -1 if no such element.
        int index = -1;

        // Creating an array to iterate through it.
        Object[] arr = new Object[component.size()];

        // Filling the array with elements.
        for (int i = 0; i < arr.length; i++) {

            arr[i] = component.get(i);

        }

        // Iterating from the end of array to find index.
        for (int i = arr.length - 1; i > -1 ; i--) {

            // Condition.
            if (arr[i].equals(o)) {

                // Assigning value to index.
                index = i;

            }
        }

        return index;
    }


    // Method to creat ListIterator.
    @Override
    public ListIterator listIterator() {

        // Creating iterator.
        ListIterator lit = component.listIterator();

        return lit;
    }

    // Method to create ListIterator fom given index.
    @Override
    public ListIterator listIterator(int index) {

        // Creating iterator..
        ListIterator lit = component.listIterator();

        return lit;

    }

    // Method to returm part of the list.
    @Override
    public List subList(int fromIndex, int toIndex) {
        return component.subList(fromIndex, toIndex);
    }

    // Method to remove different elements.
    @Override
    public boolean retainAll(Collection c) {
        return component.retainAll(c);
    }

    // Method to remove collection of elements from the MyList.
    @Override
    public boolean removeAll(Collection c) {
        return component.removeAll(c);
    }

    // Method to check if MyList has elements.
    @Override
    public boolean containsAll(Collection c) {
        return component.containsAll(c);
    }

    // Method to create an array from given collection.
    @Override
    public Object[] toArray(Object[] a) {

        // Creating new array.
        Object[] newArr = new Object[component.size() + a.length];

        // Adding elements to newArray.
        for (int i = 0; i < component.size(); i++) {

            newArr[i] = component.get(i);

        }

        // Variable to iterate through array a.
        int var = 0;

        // Adding elements to newArray.
        for (int i = component.size(); i < newArr.length ; i++) {

            // Addind new elements to nreArr.
            newArr[i] = a[var];

            // Increasing var by 1.
            var++;
        }

        // Returning new array.
        return new Object[0];
    }
}
