import java.util.ArrayList;

/**
 * Created by catban on 16-12-6.
 */
public class Bdsd {
    {
        int[] a ={1,2,4,5,5,3,3,1,4,6};
        int[] s= new int[1];
        int[] d= new int[1];

        FindNumsAppearOnce(a,s,d);
    }

    public static void main(String[] args) {
        Bdsd d = new Bdsd();
    }
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<array.length;i++)
        {
            if(!list.contains(array[i]))
                list.add(array[i]);
            else
                list.remove(new Integer(array[i]));
        }
        if(list.size()>1)
        {
            num1[0]=list.get(0);
            num2[0]=list.get(1);
            System.out.println(num1[0]);
            System.out.println(num2[0]);
        }
    }
}
