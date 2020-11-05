package SortedList;

import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

public class SortedListDriver {

    public static void main(String[] args) {
      SortedAList<Integer> sil = new SortedAList<>();
        for (int i = 0; i < 30 ; i++) {
            sil.addEntry(i*i%100);
        }
        Object[] array2 = sil.toArray();
        int[] array1 = new int[sil.getLength()];
        for (int i = 0; i < sil.getLength(); i++) {
            array1[i]=(int) array2[i];
        }
        ArrayList<Integer> arrayList = new ArrayList<>(array1.length);
        for (int i = 0; i < array1.length ; i++) {
        arrayList.add(array1[i]);
        }
        ListIterator <Integer> lit = arrayList.listIterator();
        int a1,a2,sum=0;
        lit.next();
        while(lit.hasNext()){
            a1=lit.previous();
            lit.next();
            a2= lit.next();
            sum += (a2-a1);
        }

        System.out.println(sum);
    }





}
