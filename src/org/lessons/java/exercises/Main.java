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

    public static int[] pop(int[] array) {
        int[] res = new int[array.length - 1];

        for (int i=0; i<array.length-1; i++) {
            res[i] = array[i];
        }

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
        
            for (int[] array : arrays) {
                for (int i = 0; i < array.length; i++) {
                    res = addElement(res, array[i]);
                }
            }
        
        return res;
    }

    public static int sum(int[] values) {
        int res = 0;
        for (int value : values) {
            res += value;
        }

        return res;
    }
    
    //N.B.: creates infinite loop with duplicates!
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

    public static int[] sortPlus(int[] array) {
        int[] res = new int[0];
        int[] usedInd = new int[0];

        while (res.length < array.length) {
            for (int i=0; i<array.length; i++) {
                if (contains(usedInd, i)) {
                    continue;
                }

                boolean isLeast = true;
                for (int j=0; j<array.length; j++) {
                    if (i != j && !contains(usedInd, j)) {
                        if (array[i] > array[j]) {
                            isLeast = false;
                        }
                    }
                }
    
                if (isLeast) {
                    res = addElement(res, array[i]);
                    usedInd = addElement(usedInd, i);
                }
            }
        }
    
        return res;
    }

    public static int[] bestSorting(int[] array) {
        int[] res = array.clone();

        for (int i=0; i<array.length; i++) {
            int minIdx = i;

            for (int j=i+1; j< array.length; j++) {
                if (res[j] < res[i]) {
                    minIdx = j;
                }
            }

            int subval = res[i];
            res[i] = res[minIdx];
            res[minIdx] = subval;
            
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



        //Exercise 3
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



        //Exercise 4
    public static int[] cleanQueue(int[] queue) {
        int[] result = new int[0];

        for (int e : queue) {
            if (!contains(result, e) && e < 10000) {
                System.out.println("result contains: " + e);
                result = addElement(result, e);
            }
        }
        return result;
    };



        //Exercise 5
    public static int absDiff(int[] array1, int[] array2) {
        int sum1 = 0;
        for (int x : array1) {
            sum1 += x;
        }
        
        int sum2 = 0;
        for (int y : array2) {
            sum2 += y;
        }

        int res = sum1 - sum2;
        if (sum1 - sum2 < 0) {
          res = sum2 - sum1;
        }
        return res;
    }
    
    public static int[] swapEl(int[] array, int index, int value) {
        int[] result = array;

        if (index >= array.length || index < 0 || array[index]==value) {
            return array;
        }

        result[index] = value;
        return result;
    }
    
    public static int[] findBestSwap(int[] team1, int[] team2) {
        int[] bestSwap = new int[] {-1,-1, absDiff(team2, team1)};

        if (absDiff(team2, team1) == 0) {
            return bestSwap;
        }
        
        for (int i=0; i<team1.length; i++) {
            int x = team1[i];
            for (int j=0; j<team2.length; j++) {
                int y = team2[j];
                int[] swap1 = swapEl(team1, i, y);
                int[] swap2 = swapEl(team2, j, x);
                int absDiff = absDiff(swap1, swap2);

                if (absDiff < bestSwap[2]) {
                    bestSwap[0] = i;
                    bestSwap[1] = j;
                    bestSwap[2] = absDiff;

                    if (absDiff == 0) {
                        return bestSwap;
                    }
                }
            }
        }
        return bestSwap;
    }
    


        //Exercise 6
    public static int avg(int[] values) {
        int sum = 0;

        for (int i =0; i<values.length;i++) {
            sum += values[i];
        }

        return sum / values.length;
    }
    
    public static int[] detectViralSpikes(int[] hourlyViews) {
        int[] result = new int[0];

        for (int i=3; i<hourlyViews.length; i++) {
            int[] lastThree = new int[] {hourlyViews[i-1], hourlyViews[i-2], hourlyViews[i-3]};

            if (avg(lastThree) * 2 <= hourlyViews[i]) {
                result = addElement(result, i);
            }
        }
        
        return result;
    }



        //Exercise 7
    public static int[] mergeServersV1(int[] server1, int[] server2) {
        return sortPlus(concat(new int[][] {server1, server2}));
    }

    public static int[] mergeServers(int[] server1, int[] server2) {
        int [] res = new int[0];

        //Check for empty arguments
        if (server1.length == 0) {
            return server2;
        } else if (server2.length == 0) {
            return server2;
        }

        //Construct sorted merge
        int idx1 = 0;
        int idx2 = 0;

        for (int z=0; z < server1.length + server2.length; z++) {
            if (server1[idx1] <= server2[idx2]) {
                res = addElement(res, server1[idx1]);

                if (idx1 < server1.length - 1) {
                    idx1 += 1;
                }
            } else {
                res = addElement(res, server2[idx2]);
                if (idx2 < server2.length - 1) {
                    idx2 += 1;
                }
            }
        }

        return res;    
    }
    

        //Exercise 8
    public static int[] bingeOptimizer(int[] episodes, int maxTime) {
        int[] bestPath = new int[0];
        int[] solution = new int[2];

        boolean noSol = true;
        
        for (int i=0; i < episodes.length; i++) {
            if (bestPath.length >= episodes.length - i) {
                break;
            } 

            int[] currentPath = new int[] {episodes[i]};

            if (sum(currentPath) > maxTime) {
                noSol = noSol && true;
                break;
            } 
        
            noSol = noSol && false;
            if (currentPath.length >= bestPath.length) {
                bestPath = currentPath;
                solution = new int[] {bestPath.length, i};
            }

            for (int j=i+1; j<episodes.length; j++) {
                currentPath = addElement(currentPath, episodes[j]);

                if (sum(currentPath) > maxTime) {
                    currentPath = pop(currentPath);
                } else if (sum(currentPath) == maxTime) {
                    break;
                }
            }

            if (currentPath.length > bestPath.length) {
                bestPath = currentPath;
                solution = new int[] {bestPath.length, i};
            }

            if (bestPath.length == episodes.length) {
                break;
            }
        }

        if (noSol) {
            return new int[] {0,-1};
        }
        return solution;
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

        // char[] streak = new char[] {'W', 'W', 'L', 'W', 'W', 'W', 'L', 'W'};
        // char[] streak2 = new char[] {'L', 'L', 'L', 'L'};
        // char[] streak3 = new char[] {'W', 'W', 'L', 'W', 'W'};
        // char[] streak4 = new char[] {};

        //System.out.println(toString(longestWinStreak(streak)));
        // System.out.println(toString(longestWinStreak(streak2)));
        // System.out.println(toString(longestWinStreak(streak3)));
        // System.out.println(toString(longestWinStreak(streak4)));
        
        
        // System.out.println(toString(cleanQueue(new int[] {7, 3, 7, 3, 3, 7, 5, 3, 5})));
        // System.out.println(toString(cleanQueue(new int[] {1, 2, 3, 4, 5})));
        // System.out.println(toString(cleanQueue(new int[] {42, 42, 42})));

        // System.out.println(toString(findBestSwap(new int[] {10, 20, 30}, new int[] {5, 15, 25})));
        // System.out.println(toString(findBestSwap(new int[] {1,1,1}, new int[] {1,1,1})));
        // System.out.println(toString(findBestSwap(new int[] {100}, new int[] {1})));

        // System.out.println(avg(new int[] {2,1,5}));
        // System.out.println(toString(detectViralSpikes(new int[] {100, 120, 110, 400, 150, 140, 600})));
        // System.out.println(toString(detectViralSpikes(new int[] {10, 20, 30, 40, 50})));
        // System.out.println(toString(detectViralSpikes(new int[] {10, 20, 30})));

        // System.out.println(toString(mergeServersV1(new int[] {10, 20, 30}, new int[] {10, 30, 40})));
        // System.out.println(toString(mergeServersV1(new int[] {1, 3, 5, 7}, new int[] {2, 3, 6, 8})));
        // System.out.println(toString(mergeServersV1(new int[] {1, 1, 1}, new int[] {1, 1, 1})));
        // System.out.println(toString(mergeServersV1(new int[] {}, new int[] {5, 10, 15, 3})));

        // System.out.println(toString(mergeServers(new int[] {10, 20, 30}, new int[] {10, 30, 40})));
        // System.out.println(toString(mergeServers(new int[] {1, 3, 5, 7}, new int[] {2, 3, 6, 8})));
        // System.out.println(toString(mergeServers(new int[] {1, 1, 1}, new int[] {1, 1, 1})));
        // System.out.println(toString(mergeServers(new int[] {}, new int[] {5, 10, 15})));

        System.out.println(toString(bingeOptimizer(new int[] {45, 42, 50, 48, 45, 52, 44}, 180)));
        System.out.println(toString(bingeOptimizer(new int[] {60, 60, 60}, 120)));
        System.out.println(toString(bingeOptimizer(new int[] {200, 200, 200}, 100)));
        System.out.println(toString(bingeOptimizer(new int[] {}, 1000)));
    } 

}
