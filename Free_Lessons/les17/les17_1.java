package Free_Lessons.les17;
//Вложения и анонимные классы
public class les17_1 {
    public static void main(String[] args) {
//        Car bmw = new Car(250.5f, 2500, "White", new byte[] {0, 0, 0});
//        bmw.engine.setValues(false, 2000);
//        bmw.engine.info();
//
//        Truck truck = new Truck(5600, new byte[] {110, 0, 110}, false);
//        truck.engine.setValues(true, 500);
//        truck.engine.info();
//        truck.setValues(250.5f, 2500, "White", new byte[] {0, 0, 0}, true);
//        System.out.println(truck.getValues());

        Car flyCar = new Car(250.5f, 2500, "White", new byte[] {0, 0, 0}) {
            @Override
            public void moveObject(float speed) {
                super.moveObject(speed);
                this.engine.isReady(true);
                System.out.println("Машина летит");
            }
        };
        flyCar.moveObject(450);
     }
}
