import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fin implements ActionListener{

    JFrame lframe;
    Fin(char a){
        lframe=new JFrame();
        lframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton restartt,exitt,mmenu;
        lframe.setLayout(new FlowLayout());
        JLabel l=new JLabel("PPLAYER "+a+" WON!",JLabel.CENTER);
        l.setPreferredSize(new Dimension(400,70));
        l.setFont(new Font("Serif", Font.PLAIN, 20));
        lframe.add(l);
        restartt=new JButton("RESTART");
        restartt.setPreferredSize(new Dimension(100, 50));
        restartt.addActionListener(this);
        exitt= new JButton("EXIT");
        exitt.setPreferredSize(new Dimension(100,50));
        exitt.addActionListener(this);
        mmenu=new JButton("MAIN MENU");
        mmenu.setPreferredSize(new Dimension(100,50));
        mmenu.addActionListener(this);
        lframe.add(restartt);
        lframe.add(exitt);
        lframe.add(mmenu);
        lframe.setSize(400,300);
        lframe.setVisible(true);
        //JOptionPane.showMessageDialog(new JFrame(),"Player "+a+" wins!");
    }

    public void actionPerformed(ActionEvent ae){
        JButton btn=(JButton)ae.getSource();
        if(btn.getText()=="RESTART"){
            lframe.setVisible(false);
            lframe.dispose();

            new TwoPlayer();

        }
        else if(btn.getText()=="MAIN MENU"){
            lframe.setVisible(false);
            lframe.dispose();

            //StartScreen.sframe.setVisible(true);
        }
        else{
            lframe.setVisible(false);
            System.exit(0);
        }
    }
    Fin(String a){
        new JFrame();
        //JOptionPane.showMessageDialog(new JFrame(),a);
    }



}
