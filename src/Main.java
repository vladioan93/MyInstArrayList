public class Main {
    public static void main(String[] args) {
        MyIntArrayList arr = new MyIntArrayList();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.printArray();

        System.out.println("\n" + arr.indexOf(2) + "\n");


        MyIntArrayList arr2 = new MyIntArrayList();
        arr2.add(5);
        arr2.add(6);
        arr2.add(7);

        System.out.println();
        arr2.printArray();

        arr.addAll(2,arr2);

        System.out.println();
        arr.printArray();

        int[] newArr = arr.toArray();

        System.out.println();

        for(int i=0;i<newArr.length;i++){
            System.out.print(newArr[i] + " ");
        }

        System.out.println("\ncapacitate minima 10 elemente");
        arr.ensureCapacity(10);
        arr.printArray();

        System.out.println("\nDupa trim: ");
        arr.trimToSize();
        arr.printArray();
    }
}
