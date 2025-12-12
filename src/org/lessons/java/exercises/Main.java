package org.lessons.java.exercises;

public class Main {

    //Utilities
    public static int[] addElement(int[] array, int element) {
        int[] res = new int[array.length + 1];

        for (int i=0; i<array.length; i++) {
            res[i] = array[i];
        }
        res[array.length] = element;

        return res;
    }

    //Note: array's elements and element variable should have equal length
    public static int[][] addElement2D(int[][] array, int[] element) {
        int[][] res = new int[array.length + 1][element.length];

        for (int i=0; i<array.length; i++) {
            res[i] = array[i];
        }
        res[array.length] = element;

        return res;
    }

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

    public static int[] sort(int[] array) {
        int[] res = new int[0];

        while (res.length < array.length) {

            for (int x : array) { 
                boolean isLeast = true;

                for (int y : array) {
                    if (y!=x && !contains(res, y)) {

                        if (y<x) {
                            isLeast = false;
                            break;
                        }

                    } else if (contains(res, x)) {
                        isLeast = false;
                    }
                }

                if (isLeast) {
                    res = addElement(res, x);
                }
                if (!(res.length < array.length)) {
                    break;
                }
            }
        }
        
        return res;
    }



    // Assignments
        //Exercise 1
    public static int[] filterKillFeed(int[] killFeed, int[] invalidTypes) {
        int[] result = new int[0];

        for (int i=0; i < killFeed.length; i++) {

            //We chack if the current event is of invalid type;
            boolean isInvalid = false;
            for (int z=0; z< invalidTypes.length; z++) {
                if (invalidTypes[z] == killFeed[i]) {
                    isInvalid = true;
                }
            }

            //Updating the "result"
            if (!isInvalid) {
                result = addElement(result, killFeed[i]);
            }
        }
        return result;
    }

        //Exercise 2
    public static int[] findStalkers(int[] day1, int[] day2, int[] day3, int[] day4, int[] day5, int[] day6, int[] day7) {
        int[] result = new int[0];
        
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
                    result = addElement(result, suspect);
                }
            }
        }

        return sort(result);
    }


    public static int[] longestWinStreak(char[] matches) {
        int[][] streaks = new int[0][2]; 
        int[] currentStreak = new int[2];

        //Construct win-streaks array
        for (int i=0; i<matches.length; i++) {
            char c = matches[i];
            if (c == 'W') {
                currentStreak[0] = currentStreak[0] + 1;
                if (i>0 && matches[i-1]=='L') {
                    currentStreak[1] = i;
                }
            } else if (c == 'L' && currentStreak[0] > 0) {
                //add currentStreak to streaks
                streaks = addElement2D(streaks, currentStreak);
                currentStreak = new int[2];
            }
        }

        //find longest streak
        if (streaks.length == 0) {
            return new int[] {0,-1};
        }

        int[] result = streaks[0];
        
        for (int[] streak : streaks) {
            if (streak[0] > result[0]) {
                result = streak;
            } else if (streak[0] == result[0] && result[1] < streak[1]) {
                result = streak;
            }
        }
        return result;
    }

    //Debug Utilities
    public static String toString(int[] array) {
        String result = "{";

        for (int i=0; i< array.length; i++) {
            result += " " + array[i] + " ";
        }
        result += "}";
        return result;
    }
    
    //MAIN METHOD
    public static void main(String[] args) {
        //filterKillFeed Test
        // int[] events = new int[] {1, 5, 2, 6, 1, 3, 5};
        // int[] invT = new int[] {5,6};

        // int[] events2 = new int[]{3, 3, 3, 4};
        // int[] invT2 = new int[] {1,2};

        // int[] events3 = new int[]{};
        // int[] invT3 = new int[] {5,6};

        // System.out.println(toString(filterKillFeed(events, invT)));
        // System.out.println(toString(filterKillFeed(events2, invT2)));
        // System.out.println(toString(filterKillFeed(events3, invT3)));
        
        // System.out.println(toString(concat(new int[][] {events, events2})));
        

        // System.out.println(toString(findStalkers(
        //     new int[] {1, 2, 3},
        //     new int[] {1, 2, 3, 5},
        //     new int[] {1,2,3,7,8},
        //     new int[] {9,1,2,3},
        //     new int[] {10,1,2,3},
        //     new int[] {11,1,2,3,12},
        //     new int[] {1,2,3})));

        // System.out.println(toString(findStalkers(
        //         new int[] {3, 2, 1},
        //         new int[] {2, 1, 3, 5},
        //         new int[] {3,2,1,7,8},
        //         new int[] {9,12,3, 2, 1},
        //         new int[] {10,1,2,3},
        //         new int[] {11,1,2,3,12},
        //         new int[] {1,2,3})));

        //System.out.println(toString(addElement2D(new int[][] {{3,5}, {4,7}}, new int[] {1, 2})[2]));

        char[] streak = new char[] {'W', 'W', 'L', 'W', 'W', 'W', 'L', 'W'};
        char[] streak2 = new char[] {'L', 'L', 'L', 'L'};
        char[] streak3 = new char[] {'W', 'W', 'L', 'W', 'W'};
        char[] streak4 = new char[] {};

        System.out.println(toString(longestWinStreak(streak)));
        System.out.println(toString(longestWinStreak(streak2)));
        System.out.println(toString(longestWinStreak(streak3)));
        System.out.println(toString(longestWinStreak(streak4)));
        
        


    

    }

}
