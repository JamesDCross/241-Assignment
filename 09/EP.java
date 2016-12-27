package week09;

import java.util.*;
import java.io.*;

/**
 * EP class for the first assignment.
 * 
 * @author James Cross, Callum Tanner
 */
public class EP implements ExamPile{
  
    /** The arraylist that is used to represent the examPile. */
    private ArrayList<Integer> examPile;
  
    /**
     * Constructor for the EP class. 
     */
    public EP(){
        this.examPile = new ArrayList<Integer>();
    }
  
    /**
     * This function loads the examPile with exams (integers).
     * 
     * @param items a list of exams to load into the examPile.
     */
    public void load(List<Integer> items){
        examPile.addAll(items);
    }
  
    /**
     * Returns the exam at the top of the examPile.
     * 
     * @return the number of the exam at the top of the pile.
     *
     * @throws EmptyPileException if the examPile is empty.
     */
    public int peek() throws EmptyPileException{
        if (isEmpty()) {
            throw new EmptyPileException("Stack is empty");
        }
        return this.examPile.get(0);
    }
  
    /**
     * Marks the next exam in the pile if it is within
     * a certain number of items from the top (specified
     * by the depth).
     * 
     * @param depth number of items to scan through to find
     * the next exam
     * 
     * @param value the exam number to be found.
     * 
     * @return the exam number if it is found. Else, -1.
     *
     * @throws EmptyPileException if the examPile is empty.
     */
    public int mark(int depth, int value) throws EmptyPileException{
        if (isEmpty()) {
            throw new EmptyPileException("Stack is empty");
        }
        Integer index = -1; 
        for(int i = 0; i < depth && i < examPile.size(); i++){
            if(examPile.get(i) == value){
                index = examPile.get(i);
                examPile.remove(i);
            }
        }
        return index; 
    }
  
    /**
     * Moves a number of exams from the top of the pile to the bottom.
     * 
     * @param count number of exams to move.
     *
     * @throws EmptyPileException if the examPile is empty.
     */
    public void delay(int count) throws EmptyPileException{
        if (isEmpty()) {
            throw new EmptyPileException("Stack is empty");
        }
        for(int i = 0; i < count; i++){
            examPile.add(examPile.get(0));
            examPile.remove(0);
        }
    }
  
    /**
     * Gives the current number of exams in the pile.
     * 
     * @return number of exams left in the pile.
     *
     * @throws EmptyPileException if the examPile is empty.
     */
    public int size() throws EmptyPileException{
        if (this.isEmpty()) {
            throw new EmptyPileException("Stack is empty");
        }
        return examPile.size();
    }
  
    /**
     * Determines whether the pile is empty or not.
     * 
     * @return true if the pile is empty. Else, false.
     */
    public boolean isEmpty() {
        return examPile.isEmpty();
    }
  
    /**
     * Runs through multiple mark and delay functions until all exams
     * have been marked. Each step is recorded in a string ("M" for 
     * mark and "D" for delay), which is then returned.
     * 
     * @param depth the depth to be used for each mark and delay step. 
     * 
     * @return the steps involved in the sorting process.
     */
    public String sortingSteps(int depth){
        String result = "";
        int currentVal = 0;
        while (!isEmpty()){
            if(depth > this.examPile.size()){
                depth = this.examPile.size();
            }
            int a = mark(depth, currentVal);
            if(a == -1){
                delay(depth);
                result = result.concat("D");
            } else {
                result = result.concat("M");
                currentVal++;
            }
        }
        return result;
    }

    /**
     * Entry point of the program. Reads numbers from stdin and then
     * returns the result of using sortingSteps() on them to stdout.
     *
     * @param args command line arguments are not used.
     */
    public static void main(String[] args){
        Scanner scanIn = new Scanner(System.in);
        Integer firstArg = null;
        EP e = new EP();
        if (args.length > 0) {
            try {
                firstArg = Integer.parseInt(args[0]);
            } catch (NumberFormatException notInteger) {
                System.err.println(args[0] + " not an integer.");
                System.exit(1);
            }
        }
        while(scanIn.hasNextLine()){
            String inLine = scanIn.nextLine();
            ArrayList<Integer> incoming = new ArrayList<Integer>();
            Scanner lineScan = new Scanner(inLine);
            while(lineScan.hasNextInt()){
                incoming.add(lineScan.nextInt());
            }
            e.load(incoming);
            if(firstArg==null){
                System.out.println(e.sortingSteps(1));
            } else {
                System.out.println(e.sortingSteps(firstArg));
            }
        }
    }
}
