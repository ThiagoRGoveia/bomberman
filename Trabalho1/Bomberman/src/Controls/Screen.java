package Controls;

import Model.Element;
import Model.Hero;
import Tools.*;
import Tools.Events.CreateElementsEvent;
import Tools.Events.EventBus;
import Tools.Events.RemoveElementsEvent;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;

import Controls.KeyStrokes.Movements;

public class Screen extends javax.swing.JFrame implements MouseListener, KeyListener {
    public Drawer drawer;
    private Hero hero;
    private ArrayList<Element> elements;
    private Controller controller = new Controller(this);
    private Graphics graphics;
    private Movements movements;
    private EventBus eventBus;

    public Screen(Drawer drawer) {
        this.drawer = drawer;
        drawer.setScreen(this);

        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);  /*teclado*/

        this.setSize(
            (
                (Consts.RES * Consts.CELL_SIDE) +
                (getInsets().left + getInsets().right)
            ),
            (
                (Consts.RES * Consts.CELL_SIDE) +
                (getInsets().top +  getInsets().bottom)
            )
        );

        eventBus = new EventBus(this);
        eventBus.on("create-element", new CreateElementsEvent());
        eventBus.on("remove-element", new RemoveElementsEvent());

        elements = new ArrayList<Element>(100);

        hero = new Hero(eventBus);
        hero.setPosition(0, 0);
        this.addElement(hero);

        movements = new Movements();
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void removeElement(Element element) {
        elements.remove(element);
    }

    public Graphics getGraphicsBuffer(){
        return graphics;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics oldGraphics) {
        Graphics newGraphics = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        graphics = newGraphics.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                try {
                    /*Linha para alterar o background*/
                    Image newImage = Toolkit.getDefaultToolkit().getImage(
                        new java.io.File(".").getCanonicalPath() + Consts.PATH + "ground_1.png"
                    );
                    graphics.drawImage(
                        newImage,
                        j * Consts.CELL_SIDE,
                        i * Consts.CELL_SIDE,
                        Consts.CELL_SIDE,
                        Consts.CELL_SIDE,
                        null
                    );

                } catch (IOException ex) {
                    Logger.getLogger(Screen.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.elements.isEmpty()) {
            this.controller.draw(elements);
            this.controller.process(elements);
        }

        newGraphics.dispose();
        graphics.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        movements.makeMovement(e, hero);

        if (!controller.isPositionValid(this.elements, hero)) {
            hero.resetToLastPosition();
        }
    }

    public void mousePressed(MouseEvent e) {
   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initElements
    private void initElements() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initElements
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

}
