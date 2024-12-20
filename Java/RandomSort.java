import java.util.ArrayList;

public class RandomSort {
    private static int getRandomPosition(int boundary){
        return (int) Math.random() % boundary;
    }

    private static boolean isSorted(ArrayList<Integer> input){
        for(int i=0; i<input.size()-1; i++){
            if(input.get(i)>input.get(i+1)) return false;
        }
        return true;
    }

    public static ArrayList<Integer> randomSort(ArrayList<Integer> input, int interations){
        for(int i=0; i<interations; i++){
            var cpy = new ArrayList<Integer>();
            for(int j=0; j<input.size(); j++){
                cpy.add(getRandomPosition(j), input.get(j));
            }
            if(isSorted(input)) return cpy;
            try{
                Thread.sleep(100);
            } catch(InterruptedException e){ 
                e.printStackTrace(); 
            }
        }
        return null;
    }
}
