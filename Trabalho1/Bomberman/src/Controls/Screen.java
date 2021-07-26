package Controls;

import Tools.*;
import Tools.Image.AnimatorFactory;
import Tools.Position.Column;
import Tools.Position.Position;
import Tools.Position.Row;
import Tools.Position.ScreenPosition;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.SwingUtilities;

import Controls.KeyStrokes.Movements;
import Model.Element;
import Model.Enemies.Enemy;

// Esta classe centraliza o controle do jogo, ela é responsável por manter todos os objetos em uso
public class Screen extends javax.swing.JFrame implements MouseListener, KeyListener {
    public Drawer drawer;
    private Controller controller = new Controller(this);
    private Graphics graphics;
    private Movements movements;
    private AnimatorFactory animatorFactory;
    private SerializableTimer timer;
    private GameManager gameManager;

    public Screen(GameManager gameManager){
        timer = TimerSingleton.getInstance().getTimer(); // Instancia timer que contrlará redesenhos e movimentos
        drawer = new Drawer();
        this.gameManager = gameManager;
        drawer.setScreen(this);

        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);  /*teclado*/

        // Seta tamanho da janela
        // Por algum motivo a janela calculada era 30px menor do que deveria
        // tivemos que adicionar esse valor à conta pois não encontramos o motivo.
        this.setSize(
            (
                (Consts.RES * Consts.CELL_SIDE) +
                (getInsets().left + getInsets().right)
            ),
            (
                (Consts.RES * Consts.CELL_SIDE) +
                (getInsets().top +  getInsets().bottom) + 30
            )
        );
        movements = new Movements();
    }

    public Graphics getGraphicsBuffer(){
        return graphics;
    }

    public Timer getTimer() {
        return timer;
    }

    public GameManager getGameManager() {
        return gameManager;
    }

    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/
    public void paint(Graphics oldGraphics) {
        Graphics newGraphics = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        graphics = newGraphics.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);

        /*Desenha cenário*/
        for (int i = 0; i < Consts.RES; i++) {
            for (int j = 0; j < Consts.RES; j++) {
                    gameManager.getCurrentLevel().getImageFactory().getImageList("floor-static").get(0).paintIcon(
                    this,
                    this.getGraphicsBuffer(),
                    j * Consts.CELL_SIDE,
                    i * Consts.CELL_SIDE
                );
            }
        }

        /*Aqui podem ser inseridos novos processamentos de controle*/
        if (!this.gameManager.state.getElements().isEmpty()) {
            this.controller.draw(gameManager.state.getElements(), gameManager.state.getEnemies());
            this.controller.process(gameManager.state.getHero());
            boolean victory = this.controller.checkVitory(gameManager.state.getEnemies());
            if (victory) {
                this.gameManager.nextLevel();
            }
        }

        newGraphics.dispose();
        graphics.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        setVisible(true);
        createBufferStrategy(2);
        SerializableTimerTask redesenhar = new SerializableTimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };

        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void stop() {
        setVisible(false);
        getBufferStrategy().dispose();
        timer.cancel();
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
        if (SwingUtilities.isRightMouseButton(e)) {
            Element element = LoadElementFromFile.loadElement();

            int x = e.getX();
            int y = e.getY();
            System.out.println("X: " + x + " Y: " + y);

            Position pos = new Position(
                new Row(
                    new ScreenPosition(y - 57)
                ),
                new Column(
                    new ScreenPosition(x - 22)
                )
            );

            element.setPosition(
                pos.getRow().getCoordinate().value,
                pos.getColumn().getCoordinate().value
            );

            Element oldElement = gameManager.getInteractionMap().get(pos);
            if (oldElement != null) {
                gameManager.getInteractionMap().remove(pos);
                if (gameManager.getElements().indexOf(oldElement) > -1) {
                    gameManager.getElements().remove(oldElement);
                } else if (gameManager.getEnemies().indexOf(oldElement) > -1) {
                    gameManager.getEnemies().remove(oldElement);
                }
            }

            gameManager.getInteractionMap().insert(pos, element);
            if (element instanceof Enemy) {
                gameManager.getEnemies().add((Enemy) element);
            } else {
                gameManager.getElements().add(element);
            }
            element.start();
        }
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

    public void mousePressed(MouseEvent e) {
    }

    public void keyReleased(KeyEvent e) {
        gameManager.state.getHero().stop(e.getKeyCode());
    }

    public void keyPressed(KeyEvent e) {
        movements.makeMovement(e, this); // Procurar tecla no objeto de handlers
    }

}
