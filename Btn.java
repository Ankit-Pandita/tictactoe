import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import java.awt.Graphics;
import java.awt.Color;

public class Btn extends JButton implements ActionListener{
    ImageIcon X,O;
    private boolean touch=true;
    private static boolean game_over=false;
    private static int turn=0;
    private static int [][] mat={{-1, -1, -1}, {-1, -1, -1}, {-1, -1, -1}};
    private int posx,posy;
    private Graphics paintContour;
	/*
	0:nothing
	1:X
	2:O
	*/

    public Btn(int x,int y){
        X=new ImageIcon(this.getClass().getResource("letter-x.png"));
        O=new ImageIcon(this.getClass().getResource("letter-o.png"));
        this.addActionListener(this);
        posx=x;
        posy=y;
        this.setOpaque(false);
        this.setVisible(true);
        switch(x){
            case 0:
                switch(y){
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(0, 2, 2, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
                        break;
                }
                break;
            case 2:
                switch(y){
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(2, 2, 0, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(2, 0, 0, 0, Color.BLACK));
                        break;
                }
                break;
            case 1:
                switch(y){
                    case 1:
                        this.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));
                        break;
                    default:
                        this.setBorder(BorderFactory.createMatteBorder(2, 0, 2, 0, Color.BLACK));
                        break;
                }
                break;
        }
        this.setContentAreaFilled(false);
        this.setOpaque(false);
    }

    private void jeu(int choix){
        mat[posx][posy]=choix;
    }
    private void check(){


        // Checking Rows
        for(int i=0;i<3;i++){
            if(mat[i][0]==1 && mat[i][1]==1 && mat[i][2]==1 || mat[0][i]==1 && mat[1][i]==1 && mat[2][i]==1 ){

                new Fin('O');
                TwoPlayer.over=0;
                game_over=true;
                break;
            }else if(mat[i][0]==2 && mat[i][1]==2 && mat[i][2]==2 || mat[0][i]==2 && mat[1][i]==2 && mat[2][i]==2 ){
                new Fin('X');
                TwoPlayer.over=1;
                game_over=true;
                break;
            }
        }

        //Checking Diagonals
        if(mat[0][0]==2 && mat[2][2]==2 && mat[1][1]==2 || mat[0][2]==2 && mat[1][1]==2 && mat[2][0]==2 ){

           new Fin('X');
            TwoPlayer.over=1;
            game_over=true;
        }else if(mat[0][0]==1 && mat[2][2]==1 && mat[1][1]==1 || mat[0][2]==1 && mat[1][1]==1 && mat[2][0]==1 ){
            //new Fin('O');
            TwoPlayer.over=0;
            game_over=true;
        }
        if(turn==9 && !game_over){
            new Fin("Match Draw");
            game_over=true;
            TwoPlayer.over=2;
        }
    }

    public void recyle(){
        touch=true;
        game_over=false;
        turn=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                mat[i][j]=-1;
            }
        }
        this.setOpaque(false);
        this.setVisible(true);
        this.setIcon(null);

    }

  public void actionPerformed(ActionEvent e){


      if(touch==true && game_over==false){
       int c=turn%2;
          switch(c){
          case 0:
              setIcon(X);
              jeu(2);
              break;
          case 1:
              setIcon(O);
              jeu(1);
              break;
      }
      turn+=1;
      touch=false;
      check();
  }


    }


}
