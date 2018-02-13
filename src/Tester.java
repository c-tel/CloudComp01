import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        Scanner sc = null;
        try {
            sc = new Scanner(new File("input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String name;
        int year;
        int cash;
        Movie[] arr = new Movie[7];
        for(int i = 0; i<7;i++){
           name = sc.nextLine();
           year = Integer.parseInt(sc.nextLine());
           cash =  Integer.parseInt(sc.nextLine());
           arr[i] = new Movie(name, year, cash);
        }

        sort(arr, Movie.cash_order);
        for(Movie m : arr){
            System.out.println(m);
        }
        System.out.println();
        sort(arr, Movie.year_order);
        for(Movie m : arr){
            System.out.println(m);
        }
        System.out.println();
        sort(arr, Movie.name_order);
        for(Movie m : arr){
            System.out.println(m);
        }
    }

    public static void selectionSort(Movie[] arr, Comparator<Movie> c) {
        int i, j, minIndex;
        Movie tmp;
        int n = arr.length;
        for (i = 0; i < n - 1; i++) {
            minIndex = i;
            for (j = i + 1; j < n; j++)
                if (c.compare(arr[j], arr[minIndex]) > 0)
                    minIndex = j;
            if (minIndex != i) {
                tmp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = tmp;
            }
        }
    }

    public static void insertionSort(Movie[] input, Comparator<Movie> c){
        Movie temp;
        for (int i = 1; i < input.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(c.compare(input[j], input[j-1])>0){
                    temp = input[j];
                    input[j] = input[j-1];
                    input[j-1] = temp;
                }
            }
        }
    }

    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi, Comparator c){
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (c.compare(aux[j], aux[i])>0) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }



    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi, Comparator c){
        if (hi <= lo) return;
        else {int mid = lo + (hi - lo) / 2;
            sort(a, aux, lo, mid, c);
            sort(a, aux, mid+1, hi, c);
            if (c.compare(a[mid+1],a[mid])<1) return;
            merge(a, aux, lo, mid, hi, c);
        }
    }

    public static void sort(Comparable[] a, Comparator c)	{
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length - 1, c);
    }
}
