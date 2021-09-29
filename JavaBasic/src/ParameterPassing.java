public class ParameterPassing {

    private int item;


    public ParameterPassing(int item){
        this.item = item;
    }

    public int getItem(){
        return item;
    }

    public void setItem(int item){
        this.item = item;
    }

    public static void main(String [] args){

        // Pass By Value For variable
        int count = 0;
        helper(count);
        System.out.println(count); //0

        //Pass by Value For method
        ParameterPassing counter = new ParameterPassing(0);
        helper1(counter);
        System.out.println(counter.getItem()); //0

        //Pass by Reference For Variables
        int count1 = 0;
        count1 = helper2(count1);
        System.out.println(count1); //1

        //Pass by Reference For objects
        ParameterPassing counter1 = new ParameterPassing(0);
        helper3(counter1);
        System.out.println(counter1); //1



    }

    public static void helper(int x){
        x = x+1;
    }

    public static void helper1(ParameterPassing x){
        x = new ParameterPassing(x.getItem()+1);
    }

    public static int helper2(int x){
        x = x+1;
        return x;
    }

    public static void helper3(ParameterPassing x){
        x.setItem(x.getItem()+1);
    }


}
