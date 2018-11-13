package design_pattern.BridgePattern1;

public abstract class Corp {
    protected  abstract void produce();
    protected abstract void sell();
    public void makeMoney(){
        this.produce();
        this.sell();
    }

}
