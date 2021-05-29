package com.github.antezovko23.sortdetective.service;

import java.math.BigInteger;
import java.util.HashMap;

import com.github.antezovko23.sortdetective.model.listTypes.AllLists;
import com.github.antezovko23.sortdetective.model.listTypes.IList;
import com.github.antezovko23.sortdetective.model.sorts.ISorter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





@Service
public class MetricsData {

    // private SortingExperiment sortingExperiment;
    private int[] list;
    private HashMap<String, String> map;
    private HashMap<String, HashMap<String, BigInteger>> outerMap;
    
    


    @Autowired
    public MetricsData(int[] list, AllLists allLists, 
    HashMap<String, String> map, HashMap<String, HashMap<String, BigInteger>> outerMap) {

        this.list = list;
        this.map = map;
        this.outerMap = outerMap;

    }


    public HashMap<String, String> getSortData(String algName, ISorter buttonAlgorithm, int listSize, IList listType)
            throws Exception {
        SortingExperiment sortingExperiment = new SortingExperiment(new Metrics());

        sortingExperiment.setAlgorithm(buttonAlgorithm);
        

    
            String key = listType.getClass().getSimpleName();
            map = new HashMap<>();


            list = listType.createList(listSize);
        
    
    
            sortingExperiment.getExperimentData(list);
            map.put("Comparisons:", String.valueOf(sortingExperiment.getComparisons()));
            map.put("Movements:", String.valueOf(sortingExperiment.getMovements()));
            map.put("Time:", String.valueOf(sortingExperiment.getTime()));
            
            switch (algName) {
                case "BubbleSort":
                    map.put("AvgCase", "f(n) = n * n");
                    map.put("WorstCase", "f(n) = n * n");
                    map.put("BestCase", "f(n) = n");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Bubble sort is an algorithm that compares the adjacent elements and swaps their positions if they are not in the intended order. The order can be ascending or descending. </td> </tr> <tr><td><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n^2)</p> <p>It occurs when the elements of the array are in jumbled order (neither ascending nor descending).</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n^2)</p> <p>If we want to sort in ascending order and the array is in descending order then, the worst case occurs.</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n)</p> <p>If the array is already sorted, then there is no need for sorting.</p> </td></tr> <tr><td> <h3>Applications</h3> <p>When the complexity of the code does not matter.</p> <p>When short code is preferred.</p> </td></tr>");
                    break;
                case "InsertionSort":
                    map.put("AvgCase", "f(n) = n * n");
                    map.put("WorstCase", "f(n) = n * n");
                    map.put("BestCase", "f(n) = n");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Insertion sort works similarly as we sort cards in our hand in a card game. We assume that the first card is already sorted then, we select an unsorted card. If the unsorted card is greater than the card in hand, it is placed on the right otherwise, to the left. In the same way, other unsorted cards are taken and put at their right place. A similar approach is used by insertion sort. Insertion sort is a sorting algorithm that places an unsorted element at its suitable place in each iteration. </td> </tr> <tr><td> <br></br><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n^2)</p> <p>It occurs when the elements of an array are in jumbled order (neither ascending nor descending).</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n^2)</p> <p>Suppose, an array is in ascending order, and you want to sort it in descending order. In this case, worst case complexity occurs. Each element has to be compared with each of the other elements so, for every nth element, (n-1) number of comparisons are made. Thus, the total number of comparisons = n*(n-1) ~ n^2</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n)</p> <p>When the array is already sorted, the outer loop runs for n number of times whereas the inner loop does not run at all. So, there are only n number of comparisons. Thus, complexity is linear.</p> </td></tr> <tr><td> <br></br><h3>Applications</h3> <p>When the array is has a small number of elements</p> <p>When there are only a few elements left to be sorted</p> </td></tr>");
                    break;
                case "SelectionSort":
                    map.put("AvgCase", "f(n) = n * n");
                    map.put("WorstCase", "f(n) = n * n");
                    map.put("BestCase", "f(n) = n * n");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Selection sort is an algorithm that selects the smallest element from an unsorted list in each iteration and places that element at the beginning of the unsorted list. </td> </tr> <tr><td> <br></br><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n^2)</p> <p>It occurs when the elements of an array are in jumbled order (neither ascending nor descending).</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n^2)</p> <p>If we want to sort in ascending order and the array is in descending order then, the worst case occurs.</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n^2)</p> <p>It occurs when the array is already sorted</p> </td></tr> <tr><td> <br></br><h3>Applications</h3> <p>When a small list is to be sorted</p> <p>When cost of swapping does not matter</p> <p>When checking of all the elements is compulsory</p> </td></tr>");
                    break;
                case "QuickSort":
                    map.put("AvgCase", "f(n) = n * log(n)");
                    map.put("WorstCase", "f(n) = n * n");
                    map.put("BestCase", "f(n) = n * log(n)");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Quicksort is an algorithm based on divide and conquer approach in which the array is split into subarrays and these sub-arrays are recursively called to sort the elements. </tr> <tr><td> <br></br><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n * log n)</p> <p>It occurs when the pivot element is not the greatest, smallest or middle element</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n^2)</p> <p>It occurs when the pivot element picked is either the greatest or the smallest element. This condition leads to the case in which the pivot element lies in an extreme end of the sorted array. One sub-array is always empty and another sub-array contains n - 1 elements. Thus, quicksort is called only on this sub-array. However, the quick sort algorithm has better performance for scattered pivots.</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n * log n)</p> <p>It occurs when the pivot element is always the middle element or near to the middle element.</p> </td></tr> <tr><td> <br></br><h3>Applications</h3> <p>When the programming language is good for recursion</p> <p>When time complexity matters</p> <p>When space complexity matters</p> </td></tr>");
                    break;
                case "MergeSort":
                    map.put("AvgCase", "f(n) = n * log(n)");
                    map.put("WorstCase", "f(n) = n * log(n)");
                    map.put("BestCase", "f(n) = n * log(n)");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Merge Sort is a kind of Divide and Conquer algorithm in computer programming. It is one of the most popular sorting algorithms and a great way to develop confidence in building recursive algorithms. </tr> <tr><td> <br></br><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n * log n)</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n * log n)</p> <p>The worst case scenario for Merge Sort is when, during every merge step, exactly one value remains in the opposing list; in other words, no comparisons were skipped. This situation occurs when the two largest values in a merge step are contained in opposing lists. </p> <br></br> <h4>Best Case Complexity</h4> <p>O(n * log n)</p> </td></tr> <tr><td> <br></br><h3>Applications</h3> <p>Inversion count problem</p> <p>External sorting</p> <p>E-commerce applications</p> </td></tr>");
                    break;
                case "ShellSort":
                    map.put("AvgCase", "f(n) = n * log(n)");
                    map.put("WorstCase", "f(n) = n * n");
                    map.put("BestCase", "f(n) = n * log(n)");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Shell sort is an algorithm that first sorts the elements far apart from each other and successively reduces the interval between the elements to be sorted. It is a generalized version of insertion sort. In shell sort, elements at a specific interval are sorted. The interval between the elements is gradually decreased based on the sequence used. The performance of the shell sort depends on the type of sequence used for a given input array. Shell sort is an unstable sorting algorithm because this algorithm does not examine the elements lying in between the intervals. </td> </tr> <tr><td> <h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n*log n)</p> <p>The complexity depends on the interval chosen. Best increment sequence is unknown.</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n^2)</p> <p>Worst case complexity for shell sort is always less than or equal to O(n^2).</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n*log n)</p> <p>When the array is already sorted, the total number of comparisons for each interval (or increment) is equal to the size of the array.</p> <br></br> <br></br> <p>The complexity depends on the interval chosen. The above complexities differ for different increment sequences chosen. Best increment sequence is unknown.</p> </td></tr> <tr><td> <h3>Applications</h3> <p>Calling a stack is overhead. uClibc library uses this sort.</p> <p>Recursion exceeds a limit. bzip2 compressor uses it.</p> <p>Insertion sort does not perform well when the close elements are far apart. Shell sort helps in reducing the distance between the close elements. Thus, there will be less number of swappings to be performed.</p> </td></tr>");
                    break;
                case "HeapSort":
                    map.put("AvgCase", "f(n) = n * log(n)");
                    map.put("WorstCase", "f(n) = n * log(n)");
                    map.put("BestCase", "f(n) = n * log(n)");
                    map.put("SortInfo", "<tr> <td> <h3>About</h3> Heap Sort is a popular and efficient sorting algorithm in computer programming. Learning how to write the heap sort algorithm requires knowledge of two types of data structures - arrays and trees. Heap sort works by visualizing the elements of the array as a special kind of complete binary tree called a heap. </tr> <tr><td> <br></br><h3>Time Complexity</h3> <h4>Average Case Complexity</h4> <p>O(n * log n)</p> <br></br> <h4>Worst Case Complexity</h4> <p>O(n * log n)</p> <br></br> <h4>Best Case Complexity</h4> <p>O(n * log n)</p> <br></br> <h3>Explanation</h3> <p>The height of a complete binary tree containing n elements is log n <p>To fully heapify an element whose subtrees are already max-heaps, we need to keep comparing the element with its left and right children and pushing it downwards until it reaches a point where both its children are smaller than it.</p> <p>In the worst case scenario, we will need to move an element from the root to the leaf node making a multiple of log(n) comparisons and swaps.</p> <p>During the build_max_heap stage, we do that for n/2 elements so the worst case complexity of the build_heap step is n/2*log n ~ nlog n. </p> <p>During the sorting step, we exchange the root element with the last element and heapify the root element. For each element, this again takes log n worst time because we might have to bring the element all the way from the root to the leaf. Since we repeat this n times, the heap_sort step is also nlog n. Also since the build_max_heap and heap_sort steps are executed one after another, the algorithmic complexity is not multiplied and it remains in the order of nlog n.</.p> </td></tr> <tr><td> <br></br><h3>Applications</h3> <p>Systems concerned with security</p> <p>Embedded systems such as the Linux Kernel</p></td></tr>");
                    break;
            
                
            }
      
       


        return map;

           


        



    }



 

    
}