package design_pattern.BuilderPattern.BuilderPattern2;

import java.util.ArrayList;

import design_pattern.BuilderPattern.BuilderPattern1.BMWModel;
import design_pattern.BuilderPattern.BuilderPattern1.CarModel;

public class BMWBuilder extends CarBuilder {
    private BMWModel bmw = new BMWModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.bmw.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.bmw;
    }
}
