
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

The getBomb() method is called when the alien is about to drop a bomb.

This is the Player sprite. We control the cannon with the cursor keys. 


           int START_X = 270;
           setX(START_X);

            int START_Y = 280;
            setY(START_Y);


These are the initial coordinates of the player sprite.



public void keyPressed(KeyEvent e) {

    int key = e.getKeyCode();

    if (key == KeyEvent.VK_LEFT) {

        dx = -2;
    }
...
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


If we release the left or the right cursor, the dx variable is set to zero. The player sprite stops moving. 


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

The drawBombing() method draws bombs launched by the aliens.

if (inGame) {

    g.drawLine(0, Commons.GROUND,
            Commons.BOARD_WIDTH, Commons.GROUND);

            drawAliens(g);
    drawPlayer(g);
    drawShot(g);
    drawBombing(g);

} ...


Inside the doDrawing() method, we draw the ground, the aliens, the player, the shot, and the bombs.

    private void update() {

    if (deaths == Commons.NUMBER_OF_ALIENS_TO_DESTROY) 
      inGame = false;
        timer.stop();
        message = "Game won!";
    }
...


Inside the update() method we check the number of destroyed aliens. If we destroy all aliens, we win the game.


      if (alien.isVisible() && shot.isVisible()) {
    if (shotX >= (alienX)
            && shotX <= (alienX + Commons.ALIEN_WIDTH)
            && shotY >= (alienY)
            && shotY <= (alienY + Commons.ALIEN_HEIGHT))   
            var ii = new ImageIcon(explImg);
        alien.setImage(ii.getImage());
        alien.setDying(true);
        deaths++;
        shot.die();
    }
}


If the shot triggered by the player collides with an alien, the alien ship is destroyed. More precisely, the dying flag is set.  We use it to display an explosion. The deaths variable increases and the shot sprite is destroyed.

    if (x >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction != -1) {

       direction = -1;

       Iterator<Alien> i1 = aliens.iterator();
