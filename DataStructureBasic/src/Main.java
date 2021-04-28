
public class Main {

    public static void main(String[] args) {
        System.out.println("hello");
        ArrayList<Integer> arrList = new ArrayList<>();
        arrList.addToFront(3);
//            arrList.addToFront(8);
//            arrList.addToFront(5);
//            arrList.addToBack(1);
//            arrList.addToBack(14);

        for(int i=0; i<arrList.getBackingArray().length; i++){
            System.out.println(arrList.getBackingArray()[i]);
        }

    }

//    public static void main(String args []){
//        System.out.println("Hello");
//        ArrayList<Integer> arr1 = new ArrayList<>();
//        arr1.addToFront(1);
//        arr1.addToFront(2);
//        arr1.addToFront(3);
//
//        Integer[] backArray = arr1.getBackingArray();
//
//        System.out.println(backArray);
////        for(int i=0; i<backArray.length;i++){
////            System.out.println(backArray[i]);
////        }
//
//
//    }
}
