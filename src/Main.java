
public class Main {


    public static int equilibriumIndex(int array[]){
        int length = array.length;
        int prefixSumArray[] = new int[length];
        prefixSumArray[0] = array[0];
        for (int iterator = 1; iterator < length ; iterator++){
            prefixSumArray[iterator] = prefixSumArray[iterator-1] + array[iterator];
        }
        int equilibriumIndex = Integer.MAX_VALUE;
        for (int iterator = 0 ; iterator < length ; iterator++){
            if (iterator == 0 ){
                if(prefixSumArray[length - 1] - prefixSumArray[iterator] == 0){
                    equilibriumIndex = Math.min(equilibriumIndex , iterator);
                }
            }else {
                if (prefixSumArray[iterator - 1] == prefixSumArray[length -1] - prefixSumArray[iterator]){
                    equilibriumIndex = Math.min(equilibriumIndex , iterator);
                }
            }
        }
        return (equilibriumIndex == Integer.MAX_VALUE) ? -1 : equilibriumIndex;
    }

    public static void main(String[] args) {
        System.out.println(equilibriumIndex(new int[]{-3, 2, 4, 1}));
    }
}