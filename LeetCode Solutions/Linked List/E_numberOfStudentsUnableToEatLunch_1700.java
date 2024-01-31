import java.util.Queue;
import java.util.Stack;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int lenStudents = students.length;
        Queue<Integer> studentsQueue = new LinkedList<>();
        Stack<Integer> foodStack = new Stack<>();

        for (int i = 0; i < lenStudents; i++){
            studentsQueue.offer(students[i]);
            foodStack.push(sandwiches[lenStudents - 1 - i]);
        }

        int counter = 0;

        while (counter < foodStack.size()){
            if (studentsQueue.peek() == foodStack.peek()){
                studentsQueue.poll();
                foodStack.pop();
                counter = 0;
            }
            else{
                int val = studentsQueue.poll();
                studentsQueue.offer(val);
                counter++;
            }
        }

        return counter;
    }
}
