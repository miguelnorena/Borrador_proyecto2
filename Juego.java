import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
public class Juego extends JPanel{
public static boolean haChocado=false;
Piedra roca= new Piedra(this);
Araña bicho= new Araña();

public Juego(){
    addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }
        @Override
        public void keyPressed(KeyEvent e) {
             bicho.keyPressed(e);
        }
        @Override
        public void keyReleased(KeyEvent e){
            
        }
    });

    setFocusable(true);
}
@Override
public void paint(Graphics g){

    super.paint(g);
    ImageIcon tela = new ImageIcon(getClass().getResource("C:/Users/norena/Documents/Juego_proyecto2/imagenes/tela.png"));
    g.drawImage(tela.getImage(),0,0,getWidth(),getHeight(),this);

    Font score =new Font("Arial",Font.BOLD,25);
    g.setFont(score);
g.setColor(Color.blue);
g.drawString("Puntaje:"+roca.obtenerPuntos(),520,50);

bicho.paint(g);

roca.paint(g);
roca.mover();

g.dispose();

}


    public static void main(String[] args) {
    JFrame miVentana = new JFrame("Arañita camina a casa");
    Juego game = new Juego();
    miVentana.add(game);
    miVentana.setSize(700,700);
    miVentana.setVisible(true);
    miVentana.setResizable(false);
    miVentana.setLocationRelativeTo(null);
    miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    while (true) {
        if(haChocado | Piedra.nivel==5){
            if(Piedra.nivel==5){JOptionPane.showMessageDialog(null,"Ganasteee, felicidadess!!!");}
            int reiniciaJuego=JOptionPane.showConfirmDialog(null,"Haz perdido, " + "¿Quieres reiniciar el juego","Perdiste!!!",JOptionPane.YES_NO_OPTION);
            if(reiniciaJuego==0){
                reiniciaValores();
            }else if(reiniciaJuego==1){
                System.exit(0);
            }
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
            System.out.println(ex.toString());
        }
        game.repaint();
    }
    }
public static void reiniciaValores(){
    Piedra.xRoca1=600;
    Piedra.yRoca1=700;
    Piedra.xRoca2=700;
    Piedra.yRoca2=100;
    Piedra.xRoca3=-20;
    Piedra.yRoca3=600;
    Piedra.xRoca4=300;
    Piedra.yRoca4=-20;
    Araña.x=10;
    Araña.y=10;
    Piedra.nivel=1;
    haChocado=false;
    Piedra.puntos=0;
}

}




