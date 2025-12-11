package org.lessons.java.exercises;

public class Main {

    //Utilities
    public static boolean contains(int[] array, int element) {
        boolean res = false;
            for (int z=0; z< array.length; z++) {
                if (array[z] == element) {
                    res = true;
                }
            }
        return res;
    }

    public static int[] concat(int[][] arrays) {
        int[] res = new int[0];
        int[] prev = res;
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    res = new int[res.length + 1];

                    for (int j=0; j<prev.length;j++) {
                        res[j] = prev[j];                    
                    }

                    res[prev.length] = array[i];
                    prev = res;
                }
            }
    
        return res;
    }

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

    
    public static int[] findStalkers(int[] day1, int[] day2, int[] day3, int[] day4, int[] day5, int[] day6, int[] day7) {
        int[] result = new int[0];
        int[] prev = result;
        
        int[][] days = new int[][] {day1, day2, day3, day4, day5, day6, day7};
        int[] concatDays = concat(days);

        for (int suspect : concatDays) {
            if (!contains(result, suspect)) {
                
                    boolean isStalker = true;
                    for (int[] day : days) {
                
                        if (day.length > 0) {

                            if (contains(day, suspect)) {
                                isStalker = isStalker && true;
                            } else {
                                isStalker = isStalker && false;
                            }

                        } else {
                            isStalker = false;
                        }
                }

                if (isStalker) {
                    
                    result = new int[result.length + 1];
                    for (int j=0;j<prev.length; j++) {
                        result[j] = prev[j];
                    }
                    result[prev.length] = suspect;
                    prev = result;
                    System.out.println("suspect added: " + suspect);
                }
            
                
            
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

        // System.out.println(toString(filterKillFeed(events, invT)));
        // System.out.println(toString(filterKillFeed(events2, invT2)));
        // System.out.println(toString(filterKillFeed(events3, invT3)));
        
        System.out.println(toString(concat(new int[][] {events, events2})));
        System.out.println(toString(findStalkers(
                new int[] {1, 5, 2, 6, 1, 3},
                new int[] {1, 2, 3, 5},
                new int[] {1, 5, 2, 6, 7, 3, 5},
                new int[] {1, 2, 6, 1, 3},
                new int[] {1, 5, 2, 6, 1, 3, 5},
                new int[] {1, 5, 2, 6, 1, 3, 5},
                new int[] {1, 5, 2, 6, 1, 3, 5})));


        

    }
}
