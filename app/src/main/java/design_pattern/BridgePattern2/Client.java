package design_pattern.BridgePattern2;

public class Client {

    public static void main(String[] args) {
        House house=new House();
        HouseCorp houseCorp=new HouseCorp(house);
        houseCorp.makeMoney();

        ShanZhaiCorp shanZhaiCorp=new ShanZhaiCorp(new Clothes());
        shanZhaiCorp.makeMoney();
    }
}
