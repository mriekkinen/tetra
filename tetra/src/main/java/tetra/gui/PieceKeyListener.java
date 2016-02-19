package tetra.gui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import tetra.logic.Direction;
import tetra.logic.Piece;

/**
 * Listens and reacts to keyboard events during the game.
 *
 * For instance, moves the active piece when the user presses the arrow keys.
 */
public class PieceKeyListener implements KeyListener {

    private Component component;
    private Piece piece;

    public PieceKeyListener(Piece piece, Component component) {
        this.piece = piece;
        this.component = component;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                piece.move(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                piece.move(Direction.RIGHT);
                break;
            case KeyEvent.VK_DOWN:
                piece.move(Direction.DOWN);
                break;
            case KeyEvent.VK_UP:
                piece.move(Direction.UP);
                break;
            case KeyEvent.VK_Z:
                piece.rotate(false);
                break;
            case KeyEvent.VK_X:
                piece.rotate(true);
                break;
            case KeyEvent.VK_SPACE:
                piece.lockAndRespawn();
                break;
        }

        component.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}