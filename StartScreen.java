import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartScreen implements ActionListener{
    JFrame sframe;
    JButton start;
    StartScreen(){
        sframe=new JFrame("TIC TAC TOE");
        sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sframe.setLayout(new GridLayout(3,1));
        start=new JButton("START");
        start.addActionListener(this);
        sframe.add(start);
        sframe.pack();
        sframe.setSize(250,400);
        sframe.setVisible(true);

    }

    public void hide_start_screen(){
        sframe.setVisible(false);
    }

    public void actionPerformed(ActionEvent ae){
        JButton btn=(JButton)ae.getSource();
        if(btn.getText()=="START"){
            sframe.setVisible(false);
            TwoPlayer frame1=new TwoPlayer();

        }
    }
}
