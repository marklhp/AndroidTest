package design_pattern.BuilderPattern.BuilderPattern2;

import java.util.ArrayList;

import design_pattern.BuilderPattern.BuilderPattern1.CarModel;

public abstract class CarBuilder {
    //建造一个模型，你要给我一个顺序要，就是组装顺序
    public abstract void setSequence(ArrayList<String> sequence);

    //设置完毕顺序后，就可以直接拿到这个车辆模型
    public abstract CarModel getCarModel();
}
