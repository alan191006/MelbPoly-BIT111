import java.awt.Color;

public class test {

    public static void main(String[] args) {
        // Initialize here because Java doesn't like it when n is declared in try-catch :(
        int n = 1;

        try {
            n = Integer.parseInt(args[0]); // Grid Size :D
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            // Default to 50 :D
            n = 50;
        }

        // Create an instance of the class to call non-static methods
        test mp = new test();
        mp.Tiles1557984(n);
    }

    // Non-static method
    void Tiles1557984(int n) {
        // Board dimensions
        int x = 500;
        int y = 500;

        StdDraw.setCanvasSize(x, y);

        // Call the checkerboard generation function
        generateCheckerboard(n);
    }

    // New method to generate checkerboard
    void generateCheckerboard(int n) {
        float h = 1.0f / (2 * n); // Half of a shape size

        // Loop through every cell of the n*n "checker-board"
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                // StdDraw draws from the center. The center starts at 1 half-shape length
                // and shapes are 2 half-shape lengths apart.
                float pos_x = (i * 2 * h + h);
                float pos_y = (j * 2 * h + h);

                // Checker-board pattern draw
                if ((i + j) % 2 == 0) {
                    drawSquare(pos_x, pos_y, h);
                } else {
                    drawCircle(pos_x, pos_y, h);
                }
            }
        }
    }

    // Draws a square
    void drawSquare(float pos_x, float pos_y, float h) {
        StdDraw.setPenColor(Color.red);
        StdDraw.filledSquare(pos_x, pos_y, h);
    }

    // Draws a circle
    void drawCircle(float pos_x, float pos_y, float h) {
        StdDraw.setPenColor(Color.black);
        StdDraw.circle(pos_x, pos_y, h);
    }
}
