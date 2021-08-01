package Controls;

import Tools.Image.ImageFactory;
import Tools.Image.Boundaries.BoundariesFactoryLevel3;


public class Level3 extends GameLevel {

    public Level3(Screen screen) {
        super(screen);
    }

    public void begin() {
        this.setImageFactory(
            new ImageFactory(
                new BoundariesFactoryLevel3()
            )
        );
        super.begin();
    }

    protected int[][] getWallPositions() {
        return new int[][]{
            {0, 0}, {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5}, {0, 6}, {0, 7}, {0, 8}, {0, 9}, {0, 10}, {0, 11}, {0, 12}, {0, 13}, {0, 14}, {0, 15}, {0, 16}, {0, 17}, {0, 18}, {0, 19}, {1, 19}, {2, 19}, {3, 19}, {4, 19}, {5, 19}, {6, 19}, {7, 19}, {8, 19}, {9, 19}, {10, 19}, {11, 19}, {12, 19}, {13, 19}, {14, 19}, {15, 19}, {16, 19}, {17, 19}, {18, 19}, {19, 19}, {1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}, {10, 0}, {11, 0}, {12, 0}, {13, 0}, {14, 0}, {15, 0}, {16, 0}, {17, 0}, {18, 0}, {19, 0}, {19, 1}, {19, 2}, {19, 3}, {19, 4}, {19, 5}, {19, 6}, {19, 7}, {19, 8}, {19, 9}, {19, 10}, {19, 11}, {19, 12}, {19, 13}, {19, 14}, {19, 15}, {19, 16}, {19, 17}, {19, 18}, {2, 2}, {2, 4}, {2, 6}, {2, 8}, {2, 11}, {2, 13}, {2, 15}, {2, 17}, {4, 2}, {4, 4}, {4, 7}, {4, 9}, {4, 10}, {4, 13}, {4, 15}, {4, 17}, {5, 2}, {6, 2}, {6, 4}, {6, 6}, {6, 8}, {6, 11}, {6, 13}, {6, 15}, {5, 17}, {6, 17}, {7, 17}, {7, 2}, {8, 4}, {8, 6}, {8, 9}, {8, 10}, {8, 13}, {9, 11}, {9, 15}, {10, 16}, {10, 8}, {10, 4}, {10, 3}, {11, 6}, {11, 9}, {11, 10}, {11, 13}, {12, 2}, {12, 8}, {13, 2}, {13, 4}, {13, 6}, {13, 8}, {13, 11}, {13, 13}, {13, 15}, {13, 17}, {12, 17}, {14, 17}, {14, 2}, {15, 2}, {15, 4}, {15, 6}, {15, 9}, {15, 10}, {15, 13}, {15, 15}, {15, 17}, {17, 2}, {17, 4}, {17, 6}, {17, 8}, {17, 11}, {17, 13}, {17, 15}, {17, 17}
        };
    }

    protected int[][] getRegularBlockPositions() {
        return new int[][]{
            {3, 1}, {8, 1}, {9, 1}, {10, 1}, {11, 1}, {12, 1}, {18, 1}, {3, 2}, {8, 2}, {9, 2}, {10, 2}, {11, 2}, {18, 2}, {1, 3}, {2, 3}, {3, 3}, {4, 3}, {5, 3}, {6, 3}, {7, 3}, {8, 3}, {11, 3}, {12, 3}, {13, 3}, {14, 3}, {15, 3}, {17, 3}, {18, 3}, {1, 4}, {3, 4}, {5, 4}, {7, 4}, {11, 4}, {12, 4}, {14, 4}, {18, 4}, {1, 5}, {2, 5}, {6, 5}, {7, 5}, {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5}, {17, 5}, {18, 5}, {1, 6}, {4, 6}, {7, 6}, {12, 6}, {14, 6}, {18, 6}, {2, 7}, {6, 7}, {7, 7}, {12, 7}, {16, 7}, {17, 7}, {18, 7}, {4, 8}, {7, 8}, {2, 9}, {3, 9}, {6, 9}, {7, 9}, {12, 9}, {13, 9}, {17, 9}, {2, 10}, {6, 10}, {7, 10}, {12, 10}, {13, 10}, {17, 10}, {4, 11}, {7, 11}, {12, 11}, {15, 11}, {2, 12}, {4, 12}, {6, 12}, {7, 12}, {12, 12}, {13, 12}, {15, 12}, {17, 12}, {7, 13}, {12, 13}, {2, 14}, {4, 14}, {6, 14}, {7, 14}, {12, 14}, {13, 14}, {15, 14}, {17, 14}, {7, 15}, {8, 15}, {10, 15}, {11, 15}, {12, 15}, {1, 16}, {2, 16}, {3, 16}, {6, 16}, {7, 16}, {8, 16}, {9, 16}, {11, 16}, {12, 16}, {13, 16}, {15, 16}, {16, 16}, {17, 16}, {1, 17}, {3, 17}, {8, 17}, {9, 17}, {10, 17}, {11, 17}, {16, 17}, {1, 18}, {2, 18}, {3, 18}, {4, 18}, {5, 18}, {6, 18}, {16, 18}, {17, 18}, {18, 18}
        };
    }

    protected int[][] getEnemyPositions() {
        return new int[][]{
            {5, 1}, {15, 1}, {16, 4}, {3, 5}, {1, 12}, {3, 13}, {5, 10}, {9, 8}, {10, 11}, {11, 18}, {14, 9}, {16, 11}, {18, 11},
        };
    }

}