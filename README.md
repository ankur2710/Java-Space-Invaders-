
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
