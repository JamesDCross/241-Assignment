package week09;

import java.util.*;

/**
 * ExamPile interface.
 * 
 * @author James Cross, Callum Tanner
 */

public interface ExamPile {

    /**
     * The ExamPile list we are working with.
     * 
     * @param items the list of items to be loaded in.
     */
    public void load(List<Integer> items);

    /**
     * Returns the value at the top of the pile.
     *
     * @return the value at the top of the pile.
     */
    public int peek();
    
    /**
     * Returns the number of exams remaining in the pile.
     *
     * @return the number of exams left in the pile.
     */
    public int size();

    /**
     * Returns the given value from the top 
     * section of the pile, as specified by depth
     *  and removes it from the pile. Returns
     * -1 if the value is not found.
     * 
     * @return the value if it is within the depth. Otherwise, -1.
     *
     * @param depth the number of exams to search through from the top.
     * @param value the number of the exam that the method is looking for.
     */
    public int mark(int depth, int value);

    /**
     * Moves count values from the top of the pile to the bottom of the pile.
     *
     * @param count the number of exams to move to the bottom of the pile.
     */
    
    public void delay(int count);
}
