import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Head extends JPanel implements MouseListener {

    private boolean mouseInside;


    public Head() {


        // Head
        setPreferredSize(new Dimension(500,500));


        // Border
        Border raisedBorder = BorderFactory.createRaisedBevelBorder();
        setBorder(raisedBorder);


        // Mouse Listener
        addMouseListener(this);
    }

    @Override public void paintComponent(Graphics g){


        Graphics2D g2D = (Graphics2D) g;

        // head
        g2D.setPaint(Color.yellow);
        g2D.drawOval(150,150,200,200);
        g2D.fillOval(150,150,200,200);

        // eyes
        g2D.setStroke(new BasicStroke(5));
        g2D.setPaint(Color.pink);
        g2D.drawOval(200,200,40,40);
        g2D.drawOval(250,200,40,40);
        g2D.setPaint(Color.green);
        g2D.drawOval(215,220,10,10);
        g2D.fillOval(215,220,10,10);
        g2D.drawOval(265,220,10,10);
        g2D.fillOval(265,220,10,10);


        // nose
        g2D.setPaint(Color.pink);
        g2D.setStroke(new BasicStroke(12));
        g2D.drawLine(245,250,245,260);




        // mouth
        if (!mouseInside){
        g2D.drawArc(200,220,100,100,180,180);}

        else {
            g2D.drawArc(200,280,100,70,360,180);
            g2D.setPaint(Color.black);
            g2D.drawLine(220,180,240,200);
            g2D.drawLine(260,200,280,180);
            g2D.setPaint(Color.red);
            g2D.fillOval(265,220,10,10);
            g2D.fillOval(215,220,10,10);

        }
    }







    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        mouseInside = true;
        this.repaint();
       // System.out.println("entered");

    }

    @Override
    public void mouseExited(MouseEvent e) {
        mouseInside = false;
        this.repaint();
        //System.out.println("exit");

    }
}