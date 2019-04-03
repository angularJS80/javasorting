import java.util.Arrays;

public class Main {
    static int meargSortCompareCount;
    static int quickSortCompareCount;
    static int bubbleSortCompareCount;


    public static void main(String[] args) {
        // 기본배열의 정렬 타입은 char
        char[] charArray ={ 'e', 'b', 'c', 'd', 'a' };

        // 정렬 의 높고 낮음을 비교 하기위해 Ascii숫자로 전환(
        int[] meargSortArray = charArrayToIntArry(charArray );

        //mearg sort 구현
        int[] meargTmp = new int[meargSortArray.length];
        meargSort(meargSortArray,meargTmp,0,meargSortArray.length-1);
        char[] meargSortCharArray = intArrayToCharArry(meargSortArray);
        printArray(meargSortCharArray);
        System.out.println("meargSortCompareCount"+meargSortCompareCount);

        //quick sort 구현
        int[] quickSortArray = charArrayToIntArry(charArray );
        quickSort(quickSortArray);
        char[] quickSortCharArray = intArrayToCharArry(quickSortArray);
        printArray(quickSortCharArray);
        System.out.println("quickSortCompareCount"+quickSortCompareCount);

        //exchange sort 구현
        int[] bubbleSortArray = charArrayToIntArry(charArray );
        bubbleSort(bubbleSortArray);
        char[] bubbleSortCharArray = intArrayToCharArry(bubbleSortArray);
        printArray(bubbleSortCharArray);
        System.out.println("bubbleSortCompareCount"+bubbleSortCompareCount);

        //quickSortV2 기본 quickSort시 재귀호출 임의의 중지점을 만들고 이후 exchange sort
        //meargSortV2 기본 meargSort시 재귀호출 임의의 중지점을 만들고 이후 exchange sort

    }

    private static void bubbleSort(int[] array) {
        bubbleSort(array,array.length-1);
    }

    private static void bubbleSort(int[] array, int last) {
        bubbleSortCompareCount++;
        if(last>0){
            for(int i=1; i<=last;i++){
                bubbleSortCompareCount++;
                if(array[i-1] > array[i]){
                    swap(array,i-1,i);
                }
            }
            bubbleSort(array,last - 1);

        }
    }

    //quick sort start
    private static void quickSort(int[] array) {
        quickSort(array,0,array.length-1);
    }

    private static void quickSort(int[] array, int start, int end) {
        int part2 = quickPartition(array,start,end);
                quickSortCompareCount++;
                if(start < part2-1){
                    quickSort(array,start,part2-1);
                }
                quickSortCompareCount++;
                if(part2 < end){
                    quickSort(array,part2,end);
                }
    }

    private static int quickPartition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end){
            quickSortCompareCount++;
            while (array[start] < pivot) start++;
            quickSortCompareCount++;
            while (array[end] > pivot) end--;
            quickSortCompareCount++;
            quickSortCompareCount++;
            if(start<=end){
                swap(array,start,end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
    //quick sort end

    // mearg start
    private static void meargSort(int[] array, int[] tmp, int start, int end) {
        meargSortCompareCount++;
        if(start<end){
            int mid = (start + end ) /2;
            meargSort(array,tmp,start,mid);
            meargSort(array,tmp,mid+1,end);
            mearg(array,tmp,start,mid,end);
        }

    }

    private static void mearg(int[] array, int[] tmp, int start, int mid, int end) {
        for(int i = start;i<=end; i++){
            tmp[i] = array[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        while (part1<= mid && part2 <= end){
            meargSortCompareCount++;
            if(tmp[part1] <= tmp[part2]){
                array[index] = tmp[part1];
                part1++;
            }else{
                array[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for(int i=0;i<= mid -part1;i++){
            array[index+i] = tmp[part1+i];
        }

    }
    // mearg end



    // common start
    private static char[] intArrayToCharArry(int[] intArray) {
        char[] rtnCharArry = new char[intArray.length];
        for(int i=0;i<rtnCharArry.length;i++){
            rtnCharArry[i] = (char)intArray[i];
        }
        return rtnCharArry;
    }

    private static int[] charArrayToIntArry(char[] charArray) {
        int[] rtnAsciiArry = new int[charArray.length];
        for(int i=0;i<rtnAsciiArry.length;i++){
            rtnAsciiArry[i] = (int)charArray[i];
        }
        return rtnAsciiArry;
    }

    private static void printArray(char[] array) {
        for(int i=0;i<array.length;i++){
            System.out.println(i+" :"+array[i]);
        }
    }
    // common end





}
