package Model.Explosions.Directions;

import Model.Element;
import Tools.Events.EventBus;
import Tools.Position.Position;

public class HorizontalRightMiddleExplosion extends HorizontalMiddleExplosion {

    public HorizontalRightMiddleExplosion(EventBus<Element>eventBus, int intensity, Position position) {
        super(eventBus, intensity, position);
    }

    public void propagateExplosion(int intensity) {
        propagateRight(intensity);
    }

}
