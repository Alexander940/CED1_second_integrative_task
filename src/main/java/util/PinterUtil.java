package util;

import java.awt.*;

public class PinterUtil {

    public static void printNodeInGraph(final Graphics graphics, final int positionX, final int positionY, final String nameNode) {

        final int width = 20;
        final int height = 20;

        if (positionX != 0 && positionY != 0) {
            Graphics2D graphics2D = (Graphics2D) graphics;

            // Draw Node
            graphics2D.setColor(Color.BLUE);
            graphics2D.fillOval(positionX, positionY, width, height);
            graphics2D.drawOval(positionX, positionY, width, height);

            //Text Node
            graphics2D.setColor(Color.BLACK);
            Font font = new Font(null, Font.BOLD, 10);
            graphics.setFont(font);
            graphics.drawString(nameNode, positionX, positionY);
        }
    }

    public static void printEdge(Graphics graphics, int initialPositionX, int initialPositionY, int finalPositionX, int finalPositionY, int size) {

        int xAux, yAux;
        Graphics2D graphics2D = (Graphics2D) graphics;
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        BasicStroke stroke = new BasicStroke(2);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(Color.ORANGE);
        graphics2D.drawLine(initialPositionX+10, initialPositionY+10, finalPositionX+10, finalPositionY+10);

        if (initialPositionX <= finalPositionX) {
            xAux = ((finalPositionX -  initialPositionX) / 2) + initialPositionX;
        } else {
            xAux = ((initialPositionX - finalPositionX) / 2) + finalPositionX;
        }

        if (initialPositionY <= finalPositionY) {
            yAux = ((finalPositionY - initialPositionY) / 2) + initialPositionY;
        } else {
            yAux = ((initialPositionY - finalPositionY) / 2) + finalPositionY;
        }

        Font font = new Font(null, Font.PLAIN, 12);
        graphics2D.setFont(font);
        graphics2D.drawString(String.valueOf(size), xAux, yAux);
    }

    public static void highlightLine(Graphics graphics, int initialPositionX, int initialPositionY, int finalPositionX, int finalPositionY, Color color) {
        Graphics2D graphics2D = (Graphics2D) graphics;
        BasicStroke stroke = new BasicStroke(3);
        graphics2D.setStroke(stroke);
        graphics2D.setColor(color);
        graphics2D.drawLine(initialPositionX+10, initialPositionY+10, finalPositionX+10, finalPositionY+10);
    }

}
