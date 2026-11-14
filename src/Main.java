public class Main {
    static void main(){

        int[] val = {3, 5, 8};
        SortedList list = new SortedList();
        for(int i = 0; i < val.length; i++){
            list.insert(val[i]);
        }
        IO.println(list.toStringReversed());

        SortedList list2 = new SortedList();
        IO.println(list2.toStringReversed());

        SortedList list3 = new SortedList();
        list3.insert(3);
        list3.insert(2);
        list3.insert(1);
        list3.insert(3);
        list3.insert(4);
        list3.insert(7);
        list3.insert(4);
        list3.insert(7);
        IO.println(list3.toStringReversed());

        list3.insert(0);
        IO.println(list3.toStringReversed());

        list3.insert(-1);
        IO.println(list3.toStringReversed());

        list3.insert(12);
        IO.println(list3.toStringReversed());
    }
}
