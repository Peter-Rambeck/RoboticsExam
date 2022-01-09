package org.abstractica.openbuildsystem.Nema17Controller;

public class NemaController {

    public void turn_clockwise(int position,int speed){
        Mqqt_Publisher.mqqtNemaPublisher("+",position,speed);
    }
    public void turn_counterclockwise(int position,int speed){
        Mqqt_Publisher.mqqtNemaPublisher("-",position,speed);
    }
    public void turn_1rund_clockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("+",800,200);
    }
    public void turn_05rund_clockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("+",400,200);
    }
    public void turn_025rund_clockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("+",200,200);
    }
    public void turn_1rund_counterclockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("-",800,200);
    }
    public void turn_05rund_counterclockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("-",400,200);
    }
    public void turn_025rund_counterclockwise(){
        Mqqt_Publisher.mqqtNemaPublisher("-",200,200);
    }
     public static void main(String[] args){
        NemaController nc=new NemaController();
        nc.turn_1rund_counterclockwise();
        nc.turn_clockwise(400,234);
    }

}