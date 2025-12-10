package org.lessons.java.exercises;

public class Main {
    public static int[] filterKillFeed(int[] killFeed, int[] invalidTypes) {
        int[] result = new int[0];
        int length = 0;
        int[] prevRes = new int[0];

        for (int i=0; i< killFeed.length; i++) {

            //We chack if the current event is of invalid type;
            boolean isInvalid = false;
            for (int z=0; z< invalidTypes.length; z++) {
                if (invalidTypes[z] == killFeed[i]) {
                    isInvalid = true;
                }
            }

            //Updating the "result"
            if (!isInvalid) {
                length += 1;
                result = new int[length];
                
                for (int j=0; j < length; j++) {
                    if (j == length - 1) {
                        result[j] = killFeed[i];
                    } else {
                        result[j] = prevRes[j];             }
                }

                prevRes = result;
                
            }
        }
        return result;
    }

    public static String toString(int[] array) {
        String result = "{";

        for (int i=0; i< array.length; i++) {
            result += " " + array[i] + " ";
        }
        result += "}";
        return result;
    }
    public static void main(String[] args) {
        //filterKillFeed Test
        int[] events = new int[] {1, 5, 2, 6, 1, 3, 5};
        int[] invT = new int[] {5,6};

        int[] events2 = new int[]{3, 3, 3, 4};
        int[] invT2 = new int[] {1,2};

        int[] events3 = new int[]{};
        int[] invT3 = new int[] {5,6};

        System.out.println(toString(filterKillFeed(events, invT)));
        System.out.println(toString(filterKillFeed(events2, invT2)));
        System.out.println(toString(filterKillFeed(events3, invT3)));
        

        

    }
}
