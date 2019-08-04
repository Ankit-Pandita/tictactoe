import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TwoPlayer {
    JFrame frame;
    static byte restart=-1,over=-1;
    Btn[][] button;

    //

    TwoPlayer(){
        frame=new JFrame("Tic Tac Toe");
        button= new Btn[3][3];
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(3,3));

        /*for(Btn i : button){
           i=new Btn();
           //i.addActionListener(this);

           frame.add(i);
        }*/

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                frame.add(button[i][j]=new Btn(i,j));
            }
        }


        frame.pack();
        frame.setSize(400,400);
        frame.setVisible(true);
    }

    public void hide_two_player(){
        frame.setVisible(false);
    }

    public void recycle_all_buttons(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
               button[i][j].recyle();
            }
        }
    }


}

