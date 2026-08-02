Java Space Invaders

In this part of the  Java 2D  games tutorial we will create a simple Space Invaders  game clone in Java. Source code and images can be found at the author's Github Java-Space-Invaders repository. 
Space Invaders is an arcade video game designed by Tomohiro Nishikado. It was first released in 1978.

In Space Invaders game, the player controls a cannon. He is about to save the Earth from invasion of evil space invaders.


Development of Space Invaders in Java
In our Java clone we have 24 invaders. These aliens heavily shell the ground. When the player shoots a missile, he can shoot another one only when it hits an alien or the top of the Board. The player shoots with the Space key. Aliens launch randomly their bombs. Each alien shoots a bomb only after the previous one hits the bottom.


This is the Alien sprite. Each alien has an inner Bomb class. 


public void act(int direction) {

    this.x += direction;
}


The act() method is called from the Board class. It is used to position an alien in horizontal direction.


public Bomb getBomb() {

    return bomb;
}


These are the initial coordinates of the player sprite.

public void keyPressed(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {

        dx = -2;
    }
If we press the left cursor key, the dx variable is set to -2. Next time the act() method is called, the player moves to the left.

public void keyReleased(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {

        dx = 0;
    }

    if (key == KeyEvent.VK_RIGHT) {

        dx = 0;
    }
}

The main logic of the  game is located in the Board class.


private void gameInit() {

    aliens = new ArrayList<>();

    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 6; j++) {

            var alien = new Alien(Commons.ALIEN_INIT_X + 18 * j,
                    Commons.ALIEN_INIT_Y + 18 * i);
            aliens.add(alien);
        }
    }

    player = new Player();
    shot = new Shot();
}


In the gameInit() method we create 24 aliens. The alien image size is 12x12px. We put 6px space among the aliens. We also create the player and the shot objects. VisualArt & Design



private void drawBombing(Graphics g) {

    for (Alien a : aliens) {

        Alien.Bomb b = a.getBomb();

        if (!b.isDestroyed()) {

            g.drawImage(b.getImage(), b.getX(), b.getY(), this);
        }
    }
}


The drawBombing() method draws bombs launched by the aliens. 


if (inGame) {

    g.drawLine(0, Commons.GROUND,
            Commons.BOARD_WIDTH, Commons.GROUND);

    drawAliens(g);
    drawPlayer(g);
    drawShot(g);
    drawBombing(g);

} 

Inside the doDrawing() method, we draw the ground, the aliens, the player, the shot, and the bombs.


private void update() {

    if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY) {

        inGame = false;
        timer.stop();
        message = "Game won!";
    }
...
Inside the update() method we check the number of destroyed aliens. If we destroy all aliens, we win the game. 
