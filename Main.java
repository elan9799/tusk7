import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("введи номер машины");
        Car car = new Car(sc.next());
        System.out.println(car.numder);

        parkingLot pk = new parkingLot();


        pk.showFreePlaces();
        pk.parkMyCar(car.numder + "\n");
        pk.showFreePlaces();
        pk.returnMyCar(car.numder + "\n");
        pk.showFreePlaces();

    }

    public static class Car{
        String numder;

        public Car(String num){
            numder = num;
        }

    }
    public static class parkingLot{
        String places[][] = new String[5][50];
        public parkingLot(){
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 50; j++) {
                    places[i][j] = Integer.toString((int) (Math.random() * 2));
                }
            }
        }
        public void showFreePlaces (){
            int counter =0;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 50; j++) {
                    if (places[i][j].equals("0")){
                        counter++;
                    }
                }
            }
            System.out.println(Arrays.toString(places[0]));
            System.out.println(Arrays.toString(places[1]));
            System.out.println(Arrays.toString(places[2]));
            System.out.println(Arrays.toString(places[3]));
            System.out.println(Arrays.toString(places[4]) + "\n");
            System.out.println("кол во свободных мест = " + counter);
        }

        public void parkMyCar(String Car){
            loop:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 50; j++) {
                    if (places[i][j].equals("0")){
                        places[i][j] = Car;
                        break loop;
                    }
                }
            }
        }
        public void returnMyCar (String Car){
            loop:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 50; j++) {
                    if (places[i][j].equals(Car)){
                        places[i][j] = "0";
                        break loop;
                    }
                }
            }
        }
    }
}
