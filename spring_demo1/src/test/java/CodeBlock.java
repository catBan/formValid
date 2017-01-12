import com.sun.corba.se.spi.activation.InitialNameServicePackage.NameAlreadyBound;
import com.sun.org.apache.bcel.internal.classfile.Code;

import javax.swing.tree.TreeNode;
import java.util.*;

/**
 * Created by catban on 16-12-5.
 */
public class CodeBlock {

    public static void main(String[] args) {
       /* System.out.println(new Date());
        Properties properties = System.getProperties();
        properties.list(System.out);
        System.out.println("---Memory Usage---");
        Runtime rt = Runtime.getRuntime();
        System.out.println("---Total Memory---");
        System.out.println("total:"+rt.totalMemory()+" free:"+rt.freeMemory());*/
        try {
        sda();

        }catch (Exception e){
            System.out.println("dddd????");
        }
    }
    static void sda() throws NameAlreadyBound{
        int d;
        Integer[] f =new Integer[10];
        int[] s = new int[3];
        System.out.println(s[0]+" "+s[1]);
        if(s != null)
            throw new NoSuchElementException();
        f[1] = 3;
        System.out.println(f[1]);
    }
    public CodeBlock(){
        System.out.println("constractor");
    }
    static {
        String s ="static";
        System.out.println(s);
    }
    {

        String s ="code";
        System.out.println(s);
    }

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        ArrayList<Integer>list=new ArrayList<Integer>();
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
        }
    }
    public void add(){
        TreeNode node;
        int result = 0;
        for(int i = 1;i<=100;i++){
            for(int j=2;j<i/2;j++){
                if(i%j==0)
                    break;
                else {
                    System.out.println(i);
                    result =result+i;
                    break;
                }
            }
        }
        System.out.println("result = "+result);
    }
}
