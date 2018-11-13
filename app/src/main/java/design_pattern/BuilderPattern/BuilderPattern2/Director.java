package design_pattern.BuilderPattern.BuilderPattern2;

import java.util.ArrayList;

import design_pattern.BuilderPattern.BuilderPattern1.BMWModel;
import design_pattern.BuilderPattern.BuilderPattern1.BenzModel;
import design_pattern.BuilderPattern.BuilderPattern1.CarModel;

public class Director {
    private ArrayList<String> sequence = new ArrayList();
    private BenzBuilder benzBuilder = new BenzBuilder();
    private BMWBuilder bmwBuilder = new BMWBuilder();

    public BenzModel getABenzModel() {
        this.sequence.clear();
        //这只ABenzModel的执行顺序
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return (BenzModel) this.benzBuilder.getCarModel();
    }

    public CarModel getBBenzModel() {
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.benzBuilder.setSequence(this.sequence);
        return this.benzBuilder.getCarModel();
    }

    /*
     * C型号的宝马车是先按下喇叭(炫耀嘛)，然后启动，然后停止
     */
    public BMWModel getCBMWModel() {
        this.sequence.clear();
        this.sequence.add("alarm");
        this.sequence.add("start");
        this.sequence.add("stop");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.bmwBuilder.getCarModel();
    }

    /*
     * D类型的宝马车只有一个功能，就是跑，启动起来就跑，永远不停止，牛叉
     */
    public BMWModel getDBMWModel() {
        this.sequence.clear();
        this.sequence.add("start");
        this.bmwBuilder.setSequence(this.sequence);
        return (BMWModel) this.benzBuilder.getCarModel();
    }
}
