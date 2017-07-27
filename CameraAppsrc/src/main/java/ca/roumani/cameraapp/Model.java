package ca.roumani.cameraapp;


        import android.graphics.Bitmap;

/**
 * The model of the camera app.
 *
 * @author Franck van Breugel
 */
public class Model
{
    private Bitmap bitmap;

    /**
     * Initializes this model with the given bitmap.
     *
     * @param bitmap bitmap of this model.
     */
    public Model(Bitmap bitmap)
    {
        this.bitmap = bitmap;
    }

    /**
     * Returns the bitmap of this model.
     *
     * @return bitmap of this model.
     */
    public Bitmap getBitmap()
    {
        return this.bitmap;
    }

    /**
     * Reflects the bitmap of this model along the y-axis.
     */
    public void reflectY()
    {
        final int WIDTH = this.bitmap.getWidth();
        final int HEIGHT = this.bitmap.getHeight();

        Bitmap reflection = Bitmap.createBitmap(WIDTH, HEIGHT, this.bitmap.getConfig());

        for (int x = 0; x < WIDTH; x++)
        {
            for (int y = 0; y < HEIGHT; y++)
            {
                int color = this.bitmap.getPixel(x, y);
                reflection.setPixel(WIDTH - 1 -x, y, color);
            }
        }

        this.bitmap = reflection;
    }
    public void reflectX()
    {
        final int WIDTH = this.bitmap.getWidth();
        final int HEIGHT = this.bitmap.getHeight();

        Bitmap reflection = Bitmap.createBitmap(WIDTH, HEIGHT, this.bitmap.getConfig());

        for (int x = 0; x < WIDTH; x++)
        {
            for (int y = 0; y < HEIGHT; y++)
            {
                int color = this.bitmap.getPixel(x, y);
                reflection.setPixel(x, HEIGHT - 1 - y, color);
            }
        }

        this.bitmap = reflection;
    }
    public void rotate()
    {

        final int WIDTH = this.bitmap.getWidth();
        final int HEIGHT = this.bitmap.getHeight();
        final int x0 = WIDTH / 2;
        final int y0 = HEIGHT / 2;
        final double THETA = Math.toRadians(90);
        Bitmap reflection = Bitmap.createBitmap(WIDTH, HEIGHT, this.bitmap.getConfig());

        for (int x = 0; x < WIDTH; x++)
        {
            for (int y = 0; y < HEIGHT; y++)
            {
                int color = this.bitmap.getPixel(x, y);
                double x2 = Math.cos(THETA)*(x-x0) - Math.sin(THETA)*(y-y0) + x0;
                double y2 = Math.sin(THETA)*(x-x0) + Math.cos(THETA)*(y-y0) + y0;
                if(x2 >= 0 && x2 < WIDTH && y2 < HEIGHT && y2 >= 0)
                {
                    reflection.setPixel((int) x2, (int) y2, color);
                }
            }
        }

        this.bitmap = reflection;
    }
}

