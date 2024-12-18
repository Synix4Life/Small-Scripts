import java.util.Arrays;

public class MergeSort{
    public static int[] sort(int[] A, int[] B){
        var res = new int[A.length + B.length];
        int aP = 0; int bP = 0; int resP = 0;
        while(aP < A.length && bP < B.length){
            if(A[aP] < B[bP]){
                res[resP] = A[aP];
                aP++;
            }
            else{
                res[resP] = B[bP];
                bP++;
            }
            resP++;
        }
        if(bP >= B.length){ System.arraycopy(A, aP, res, resP, A.length - aP); }
        else{ System.arraycopy(B, bP, res, resP, B.length - bP); }
        return res;
    }
    public static int[] mergeSort(int[] input){
        if(input.length > 1){
            var A = mergeSort(Arrays.copyOfRange(input, 0, (int)Math.floor(input.length/2)));
            var B = mergeSort(Arrays.copyOfRange(input, (int)Math.floor(input.length/2)+1, input.length));
            input = sort(A, B);
        }
        return input;
    }
}