package Lessons_2.Modules.Module_3.les2.les2_2;

public class Proccess extends Thread {
    private volatile boolean isRun = true; //volatile - Обязательный атрибут переменной которая используется в нескольких потоках, т.к. она не кэшируется
    public void run() {
        while (isRun) {
            System.out.println("Привет");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void exit() {
        isRun = false;
    }
}
