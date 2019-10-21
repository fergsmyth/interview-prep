package problems.linuxfs;

public class ChangeDirectory {

    public static void main(String[] args) {
        new ChangeDirectory().cd("a/b","c/../d/e/../f");
    }

    public void cd(String current, String pathString){
        String[] paths = pathString.split(" ");
        for(String path : paths){
            String[] parts = path.split("/");
            
        }
    }
}
