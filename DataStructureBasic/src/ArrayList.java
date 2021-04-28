public class ArrayList<T> {

    /*
      The starting capacity of the ArrayList should be the constant INITIAL_CAPACITY defined in the file
      If, while adding an element, the ArrayList does not have enough space, you should regrow the backing array to twice its old capacity.
      Do not resize the backing array when removing elements.

      3 Operations
      Adding
       * addToFront() - When adding to the front subsequent elements should be shifted at back to make room for new element
       * addToBack() - Adds element to the back of the array
      Removing - returns the deleted number
       * removeFromFront() - The element should be removed and all subsequent elements should be shifted forward by one position
       * removeFromBack() - When removing from the back, the last element should be set to null in the array. All unused positions in the backing array must be set to null
      Resizing - will be called whenever backing array is full
       * Resize() - In order to resize your backing array, you will need to create new array of size (2 * old length) and copy all the elements from the old backing array into the new backing array.
                    Don't forget to reassign the backingArray variable to the new backing array!
                    Note that since the capacity doubles with each resize, the need of another resize operation decreases as more and more elements are added.

     ErrorHandling and notes
       * In add() methods, if the passed in data is null, an exception should be thrown (see details in javadocs) and your ArrayList should not be modified in any way.
         Where is the most optimal location in the method to check for this situation?
         Should this check be performed at the beginning or at the end?

       * The size variable is used to keep track of the number of elements in the ArrayList.
         Whenever data is successfully added/removed from the backing array, the size variable should be incremented/decremented appropriately.
         How can this variable be leveraged to check if your backing array needs to be resized?

       * Do not include any package declarations in your classes.

       * Do not change any existing class headers, constructors, instance/global variables, or method signatures.
         For example, do not add throws to the method headers since they are not necessary.
         Instead, exceptions should be thrown as follows: throw new InsertExceptionHere("Error: some exception was thrown");

       * All helper methods you choose to write should be made private.

       * Always be very conscious of efficiency. Even if your method is to be  O(n) , traversing the structure multiple times is considered inefficient unless that is absolutely required (and that case is extremely rare).

       * If applicable, use the generic type of the class; do not use the raw type of the class. For example, use new LinkedList<Integer>() instead of new LinkedList().

       */

    /*
     * The initial capacity of the ArrayList.
     *
     * DO NOT MODIFY THIS VARIABLE!
     */
    public static final int INITIAL_CAPACITY = 9;

    /*
     * Do not add new instance variables or modify existing ones.
     */
    private T[] backingArray;
    private int size;

    /**
     * This is the constructor that constructs a new ArrayList.
     *
     * Recall that Java does not allow for regular generic array creation,
     * so instead we cast an Object[] to a T[] to get the generic typing.
     */
    public ArrayList() {
        //DO NOT MODIFY THIS METHOD!
        backingArray = (T[]) new Object[INITIAL_CAPACITY];
    }

    /**
     * Adds the data to the front of the list.
     *
     * This add may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @param data the data to add to the front of the list
     * @throws IllegalArgumentException if data is null
     */
    public void addToFront(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null){
            throw new IllegalArgumentException("Error: Null data was passed");
        }else{
            if(backingArray.length == 0){
                //First time inserting record in the array
                size = 1;
                backingArray[size() - 1] = data;
            }else{
                if(size()+1 > backingArray.length){
                    T[] tempArray = resize();
                    backingArray = tempArray;
                }
                T initialElement = (T) new Object[1];
                T newElement = (T) new Object[1];

                for(int i=0; i<= size(); i++){
                    if(i == 0){
                        initialElement = backingArray[i];
                        backingArray[i] = data;
                    }else{
                        if(i == size()){
                            backingArray[i] =initialElement;

                        }else{
                            newElement = backingArray[i];
                            backingArray[i] = initialElement;
                            initialElement = newElement;
                        }
                    }
                }
                size = size() + 1;

            }
        }
    }

    /**
     * Adds the data to the back of the list.
     *
     * Method should run in amortized O(1) time.
     *
     * @param data the data to add to the back of the list
     * @throws IllegalArgumentException if data is null
     */
    public void addToBack(T data) {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        if(data == null){
            throw new IllegalArgumentException("Error: Null data was passed");
        }else{
            if(size() + 1 > backingArray.length){
                T[] tempArray = resize();
                backingArray = tempArray;
            }
            backingArray[size()] = data;
            size = size() + 1;

        }
    }

    /**
     * Defining resize() function to resize the backing array
     */

    private T[] resize(){
        T[] newArray = (T[]) new Object[backingArray.length*2];
        for(int i=0; i<backingArray.length; i++){
            newArray[i] = backingArray[i];
        }
//        backingArray = newArray;
        return newArray;
    }

    /**
     * Removes and returns the first data of the list.
     *
     * Do not shrink the backing array.
     *
     * This remove may require elements to be shifted.
     *
     * Method should run in O(n) time.
     *
     * @return the data formerly located at the front of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromFront() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
//        Integer removedElement;
        T removedElement;
        if(size() == 0){
            throw new java.util.NoSuchElementException("Error: Can't remove from empty array");
        }else{
            removedElement = backingArray[0];
            for(int i =1; i<size(); i++){

                backingArray[i-1] = backingArray[i];

            }
            backingArray[size()-1] = null;
            size = size() - 1;
        }
        return removedElement;
    }

    /**
     * Removes and returns the last data of the list.
     *
     * Do not shrink the backing array.
     *
     * Method should run in O(1) time.
     *
     * @return the data formerly located at the back of the list
     * @throws java.util.NoSuchElementException if the list is empty
     */
    public T removeFromBack() {
        // WRITE YOUR CODE HERE (DO NOT MODIFY METHOD HEADER)!
        T removedElement;
        if(size() == 0){
            throw new java.util.NoSuchElementException("Error: Can't remove from empty array");
        }else{
            removedElement = backingArray[size()-1];
            backingArray[size()-1] = null;
            size = size() - 1;
        }
        return (T) removedElement;
    }

    /**
     * Returns the backing array of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the backing array of the list
     */
    public T[] getBackingArray() {
        // DO NOT MODIFY THIS METHOD!
        return backingArray;
    }

    /**
     * Returns the size of the list.
     *
     * For grading purposes only. You shouldn't need to use this method since
     * you have direct access to the variable.
     *
     * @return the size of the list
     */
    public int size() {
        // DO NOT MODIFY THIS METHOD!
        return size;
    }

}


