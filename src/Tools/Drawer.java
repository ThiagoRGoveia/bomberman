package Tools;

import java.awt.Graphics;
import java.io.Serializable;

import Model.Element;
import Tools.Position.Position;
import Controls.Screen;
// Contém lógica para desenhar os elementos na tela. Aqui são definidas as dimensões desses elementos
public class Drawer implements Serializable {
    private Screen screen;

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public void draw(Element element) {
        Position position = element.getPosition();
        element.getImage().paintIcon(
            screen,
            getScreenGraphics(),
            position.getColumn().getScreenPosition().value * Consts.CELL_SIDE / Consts.CELL_SIZE_FACTOR,
            position.getRow().getScreenPosition().value * Consts.CELL_SIDE / Consts.CELL_SIZE_FACTOR
        );
    }

    private Graphics getScreenGraphics() {
        return screen.getGraphicsBuffer();
    }
}
