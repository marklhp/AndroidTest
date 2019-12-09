package design_pattern;

public class test {

    public static void main(String[] args){
        String str="0118610086";
        str=str.substring(3,str.length()-1);
        str="+"+str;
        System.out.println(str);
    }
}
