package problems.changedirectory;

import java.util.ArrayDeque;
import java.util.Deque;

public class ChangeDirectory {

    public static void main(String[] args) {
        new ChangeDirectory().cd("a/b/", "c/../../d/e/../f");
    }

    // 'a/b'
    // 'c/../d/e/../f'
    public void cd(String curPath, String paths){
        StringBuilder current = new StringBuilder(curPath);
        char[] pathChars = paths.toCharArray();
        Deque<Character> cStack = new ArrayDeque<>();
        for (int i = 0; i < pathChars.length; i++){
            char c = pathChars[i];
            if(c == '.' && i < pathChars.length - 2 && pathChars[i + 1] == '.') {
                i+=2;
                if(!cStack.isEmpty()) {
                    System.out.println("Popping"); // Need to pop the first backslash.
                    System.out.println(cStack.pop()); // Need to pop the first backslash.
                    while (!cStack.isEmpty() && cStack.peek() != '/') {
                        System.out.println("Popping");
                        Character pop = cStack.pop();
                        System.out.println(pop);
                    }
                }
            } else {
                System.out.println("Pushing");
                System.out.println(c);
                cStack.push(c);
            }
        }

        while(!cStack.isEmpty()){
            current.append(cStack.removeLast());
        }
        current.append("/");
        System.out.println(current);
    }
}
