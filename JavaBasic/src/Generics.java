public class Generics {


    private Object object;

    public Object getObject(){
        return object;
    }

    public void setObject(Object object){
        this.object = object;
    }

    public static void main(String [] args){
        Generics g1 = new Generics();
        g1.setObject("hello");
        String str = (String) g1.getObject();
    }

}

