package design_pattern.BuilderPattern.BuilderPattern2;

import java.util.ArrayList;

import design_pattern.BuilderPattern.BuilderPattern1.BenzModel;
import design_pattern.BuilderPattern.BuilderPattern1.CarModel;

public class BenzBuilder extends CarBuilder {
    private BenzModel benz = new BenzModel();
    @Override
    public void setSequence(ArrayList<String> sequence) {
        this.benz.setSequence(sequence);
    }

    @Override
    public CarModel getCarModel() {
        return this.benz;
    }
}
