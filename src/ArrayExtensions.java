import java.util.NoSuchElementException;

public class ArrayExtensions {

    public double arrayAverage(double[] array){
        if(array==null)
            throw new NullPointerException();
        if(array.length==0)
            throw  new EmptyListException();
        double sum=0;
        for(int i=0;i<array.length;i++){
            sum+=array[i];
        }
        return sum/array.length;
    }
}
