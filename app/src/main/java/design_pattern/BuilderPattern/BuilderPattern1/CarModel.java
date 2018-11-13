package design_pattern.BuilderPattern.BuilderPattern1;

import java.util.ArrayList;

public abstract class CarModel {
    private ArrayList<String> sequence=new ArrayList<>();
    protected abstract void start();
    protected abstract void stop();
    protected abstract void alarm();
    protected abstract void engineBoom();
    final public void run(){
        for (int i=0;i<this.sequence.size();i++){
            String actionName = this.sequence.get(i);
            switch (actionName){
                case "start":
                    this.start();
                    break;
                case "stop":
                    this.stop();
                    break;
                case "alarm":
                    this.alarm();
                    break;
                case "engine boom":
                    this.engineBoom();
                    break;
            }
        }
    }

    public void setSequence(ArrayList<String> sequence) {
        this.sequence = sequence;
    }
}
