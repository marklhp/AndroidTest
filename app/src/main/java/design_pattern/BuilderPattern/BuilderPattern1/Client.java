package design_pattern.BuilderPattern.BuilderPattern1;

import java.util.ArrayList;

public class Client {
    public static void main(String[] args) {
        BenzModel benzModel=new BenzModel();
        ArrayList<String> sequence=new ArrayList<>();
        sequence.add("engine boom"); //客户要求，run的时候时候先发动引擎
        sequence.add("start"); //启动起来
        sequence.add("stop"); //开了一段就停下来
        //然后我们把这个顺序给奔驰车:
        benzModel.setSequence(sequence);
        benzModel.run();
    }
}
