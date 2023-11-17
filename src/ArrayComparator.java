public class ArrayComparator {

    private ArrayExtensions arrayExtensions;

    public ArrayComparator(ArrayExtensions arrayExtensions){
        this.arrayExtensions=arrayExtensions;
    }
    public int compareArray(double[] arr1,double[] arr2){
        double avarage1=arrayExtensions.arrayAverage(arr1);
        double avarage2=arrayExtensions.arrayAverage(arr2);
        int res=Double.compare(avarage1, avarage2);
        switch (res){
            case -1:
                System.out.println("Второй список имеет большее среднее значение");
                break;
            case 0:
                System.out.println("Средние значения равны");
                break;
            case 1:
                System.out.println("Первый список имеет большее среднее значение");
        }
        return res;
    }
}
