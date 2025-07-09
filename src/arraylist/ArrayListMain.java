package arraylist;

public class ArrayListMain {


    public static void main(String[] args) {
        MyArrayList list = new MyArrayList(2);
        list.add(10);
        list.add(20);
        list.add(30);

        System.out.println(list);
        System.out.println(list.set(2, -10));
        System.out.println(list);
    }

}
