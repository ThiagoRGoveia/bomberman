package Controls;

import Tools.Image.ImageFactory;
import Tools.Image.Boundaries.BoundariesFactoryLevel1;

public class Level1 extends GameLevel {

    public Level1(Screen screen) {
        super(screen);
    }

    public void begin() {
        this.setImageFactory(
            new ImageFactory(
                new BoundariesFactoryLevel1()
            )
        );
        super.begin();
    }

    protected int[][] getWallPositions() {
        return new int[][]{
            {0, 0},{0, 1},{0, 2},{0, 3},{0, 4},{0, 5},{0, 6},{0, 7},{0, 8},{0, 9},{0, 10},{0, 11},{0, 12},{0, 13},{0, 14},{0, 15},{0, 16},{0, 17},{0, 18},{0, 19},{1, 19},{2, 19},{3, 19},{4, 19},{5, 19},{6, 19},{7, 19},{8, 19},{9, 19},{10, 19},{11, 19},{12, 19},{13, 19},{14, 19},{15, 19},{16, 19},{17, 19},{18, 19},{19, 19},{1, 0},{2, 0},{3, 0},{4, 0},{5, 0},{6, 0},{7, 0},{8, 0},{9, 0},{10, 0},{11, 0},{12, 0},{13, 0},{14, 0},{15, 0},{16, 0},{17, 0},{18, 0},{19, 0},{19, 1},{19, 2},{19, 3},{19, 4},{19, 5},{19, 6},{19, 7},{19, 8},{19, 9},{19, 10},{19, 11},{19, 12},{19, 13},{19, 14},{19, 15},{19, 16},{19, 17},{19, 18},{2, 2},{1, 4},{2, 4},{2, 6},{2, 8},{2, 10},{1, 12},{2, 12},{2, 14},{1, 16},{2, 16},{2, 18},{3, 8},{4, 2},{4, 4},{4, 6},{4, 8},{4, 10},{4, 12},{4, 14},{4, 16},{4, 18},{6, 2},{6, 4},{6, 6},{6, 8},{6, 10},{6, 12},{6, 14},{6, 16},{6, 18},{8, 2},{8, 4},{8, 6},{8, 8},{8, 10},{8, 12},{8, 14},{8, 16},{8, 18},{10, 2},{10, 4},{10, 6},{10, 8},{10, 10},{10, 12},{10, 14},{10, 16},{10, 18},{12, 2},{12, 4},{12, 6},{12, 8},{12, 10},{12, 12},{12, 14},{12, 16},{12, 18},{14, 2},{14, 4},{14, 6},{14, 8},{14, 10},{14, 12},{14, 14},{14, 16},{14, 18},{16, 2},{16, 4},{16, 6},{16, 8},{16, 10},{16, 12},{16, 14},{16, 16},{16, 18},{18, 2},{18, 4},{18, 6},{18, 8},{18, 10},{18, 12},{18, 14},{18, 16},{18, 18},
        };
    }

    protected int[][] getRegularBlockPositions() {
        return new int[][]{
            {3, 1}, {4, 1}, {5, 1}, {10, 1}, {11, 1}, {12, 1}, {13, 1}, {18, 1}, {5, 2}, {7, 2}, {9, 2}, {11, 2}, {13, 2}, {15, 2}, {17, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, {8, 3}, {9, 3}, {10, 3}, {11, 3}, {12, 3}, {13, 3}, {5, 4}, {9, 4}, {2, 5}, {3, 5}, {4, 5}, {5, 5}, {6, 5}, {7, 5}, {8, 5}, {9, 5}, {10, 5}, {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5}, {16, 5}, {18, 5}, {3, 6}, {5, 6}, {9, 6}, {11, 6}, {13, 6}, {15, 6}, {2, 7}, {3, 7}, {8, 7}, {9, 7}, {16, 7}, {18, 7}, {5, 8}, {9, 8}, {11, 8}, {13, 8}, {2, 9}, {3, 9}, {4, 9}, {5, 9}, {6, 9}, {8, 9}, {9, 9}, {10, 9}, {11, 9}, {12, 9}, {13, 9}, {14, 9}, {16, 9}, {18, 9}, {3, 10}, {5, 10}, {9, 10}, {11, 10}, {13, 10}, {2, 11}, {3, 11}, {4, 11}, {5, 11}, {6, 11}, {8, 11}, {9, 11}, {10, 11}, {11, 11}, {12, 11}, {13, 11}, {14, 11}, {16, 11}, {18, 11}, {3, 12}, {5, 12}, {9, 12}, {11, 12}, {13, 12}, {1, 13}, {2, 13}, {3, 13}, {4, 13}, {5, 13}, {6, 13}, {7, 13}, {8, 13}, {9, 13}, {10, 13}, {11, 13}, {12, 13}, {13, 13}, {16, 13}, {18, 13}, {1, 14}, {3, 14}, {5, 14}, {7, 14}, {9, 14}, {11, 14}, {13, 14}, {1, 15}, {2, 15}, {3, 15}, {4, 15}, {5, 15}, {6, 15}, {7, 15}, {8, 15}, {9, 15}, {10, 15}, {11, 15}, {12, 15}, {13, 15}, {14, 15}, {16, 15}, {18, 15}, {3, 16}, {5, 16}, {7, 16}, {9, 16}, {11, 16}, {13, 16}, {15, 16}, {17, 16}, {5, 17}, {11, 17}, {18, 17}, {1, 18}, {3, 18}, {5, 18}, {7, 18}, {9, 18}, {11, 18}, {13, 18}, {15, 18}, {17, 18}
        };
    }

    protected int[][] getEnemyPositions() {
        return new int[][]{
            {17, 1}, {18, 3}, {7, 6}, {1, 7}, {12, 7}, {17, 7}, {15, 10}, {17, 12}, {7, 1}, {3, 17}, {8, 17}, {13, 17}, {16, 17}
        };
    }


}
