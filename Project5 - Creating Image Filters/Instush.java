import java.awt.Color;

/**
 * A library of image processing functions.
 */
public class Instush {
	
	public static void main(String[] args) {
		String s1 = "cake.ppm";
		Color[][] cake = read(s1);
		String s2 = "thor.ppm";
		Color[][] thor = read(s2);
		String s3 = "ironman.ppm";
		Color[][] ironman = read(s3);
		String s4 = "eyes.ppm";
		Color[][] eyes = read(s4);


		//show(thor);	
		//show(flippedHorizontally(image1));
		//show(flippedVertically(image1));	
		//morph(image, greyscaled(image), 5);
		//show(greyscaled(cake));
		//show(cake);
		//show(scaled(cake, 500, 300));
		//show(flippedVertically(cake));
		//morph(cake, eyes, 50);

		//morph(cake, thor, 5);
	}

	/**
	 * Returns an image created from a given PPM file.
	 * SIDE EFFECT: Sets standard input to the given file.
	 * @return the image, as a 2D array of Color values
	 */
	public static Color[][] read(String filename) {
		StdIn.setInput(filename);
		// Reads the PPM file header (ignoring some items)
		StdIn.readString();
		int numRows = StdIn.readInt();
		int numCols = StdIn.readInt();
		StdIn.readInt();
		// Creates the image
		Color[][] image = new Color[numCols][numRows];
		// Reads the RGB values from the file, into the image. 
		// For each pixel (i,j), reads 3 values from the file,
		// creates from the 3 colors a new Color object, and 
		// makes pixel (i,j) refer to that object.		
		// Replace the following statement with your code
		for (int i = 0; i < image.length ;i++ ) {
			for (int j = 0; j < image[0].length ;j++ ) {
				int red = StdIn.readInt();
				int green = StdIn.readInt();
				int blue = StdIn.readInt();	
				image[i][j]	= new Color(red, green, blue);
			}
		}
		return image;
	}

	/**
	 * Prints the pixels of a given image.
	 * Each pixel is printed as a triplet of (r,g,b) values.
	 * For debugging purposes.
	 * @param image - the image to be printed
	 */
	public static void println(Color[][] image) {
	    for (int i = 0; i < image.length ;i++ ) {
			for (int j = 0; j < image[i].length ;j++ ) {
				System.out.print("(");
				System.out.printf("%3s", image[i][j].getRed());    // Prints the red component
				System.out.printf("%4s", image[i][j].getGreen());  // Prints the green component
		        System.out.printf("%4s", image[i][j].getBlue());   // Prints the blue component
		        System.out.print(") ");
			    System.out.println();
			}
		}
	}
	
	/**
	 * Returns an image which is the horizontally flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the horizontally flipped image
	 */
	public static Color[][] flippedHorizontally(Color[][] image) {
		Color[][] image2 = new Color[image.length][image[0].length];
		for (int i = 0; i < image.length ;i++ ) {
			for (int j = 0; j < image[i].length ;j++ ) {
				image2[i][j] = image[i][image[0].length - j - 1];
			}
		}
		return image2;
	}
	
	/**
	 * Returns an image which is the vertically flipped version of the given image. 
	 * @param image - the image to flip
	 * @return the vertically flipped image
	 */
	public static Color[][] flippedVertically(Color[][] image){
		Color[][] image2 = new Color[image.length][image[0].length];
		for (int i = 0; i < image[0].length ;i++ ) {
			for (int j = 0; j < image.length ;j++ ) {
				image2[j][i] = image[image.length - j - 1][i];
			}
		}

		return image2;
	}
	
	/**
	 * Returns the average of the RGB values of all the pixels in a given image.
	 * @param image - the image
	 * @return the average of all the RGB values of the image
	 */
	public static double average(Color[][] image) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < image.length ;i++ ) {
			for (int j = 0; j < image[0].length ;j++ ) {
				sum += image[i][j].getRed();
				sum += image[i][j].getGreen();
				sum += image[i][j].getBlue();
				count++;
			}
		}
		double average = sum / count;
		return average;
	}

	/**
	 * Returns the luminance value of a given pixel. Luminance is a weighted average
	 * of the RGB values of the pixel, given by 0.299 * r + 0.587 * g + 0.114 * b.
	 * Used as a shade of grey, as part of the greyscaling process.
	 * @param pixel - the pixel
	 * @return the greyscale value of the pixel, as a Color object
	 *         (r = g = b = the greyscale value)
	 */
	public static Color luminance(Color pixel) { // lum(r,g,b) = (int) (0.299 ⋅ r + 0.587 ⋅ g + 0.114 ⋅ b)
		int lum = (int)(0.299 * pixel.getRed() + 0.587 * pixel.getGreen() + 0.114 * pixel.getBlue());
		Color coLum = new Color(lum,lum,lum);
		return coLum;
	}
	
	/**
	 * Returns an image which is the greyscaled version of the given image.
	 * @param image - the image
	 * @return rhe greyscaled version of the image
	 */
	public static Color[][] greyscaled(Color[][] image) {
		Color [][] grey = new Color[image.length][image[1].length];
		for (int i = 0; i < image.length ;i++ ) {
			for (int j = 0; j < image[1].length ;j++ ) {
				grey[i][j] = luminance(image[i][j]);
			}
		}
		return grey;
	}	
	
	/**
	 * Returns an umage which is the scaled version of the given image. 
	 * The image is scaled (resized) to be of the given width and height.
	 * @param image - the image
	 * @param width - the width of the scaled image
	 * @param height - the height of the scaled image
	 * @return - the scaled image
	 */
	public static Color[][] scaled(Color[][] image, int width, int height) {
		Color [][] scaled = new Color [height][width];
		int rows = scaled.length;
		int cols = scaled[0].length;
		for (int i = 0; i < rows ;i++ ) {
			for (int j = 0; j < cols ;j++ ) {
				scaled[i][j] = image[i * image.length / height][j * image[0].length / width];			
			}
			
		}
		return scaled;
	}
	
	/**
	 * Returns a blended color which is the linear combination of two colors.
	 * Each r, g, b, value v is calculated using v = (1 - alpha) * v1 + alpha * v2.
	 * 
	 * @param pixel1 - the first color
	 * @param pixel2 - the second color
	 * @param alpha - the linear combination parameter
	 * @return the blended color
	 */
	public static Color blend(Color c1, Color c2, double alpha) {
		int red = (int)(alpha * c1.getRed() + (1 - alpha) * c2.getRed());
		int green = (int)(alpha * c1.getGreen() + (1 - alpha) * c2.getGreen());
		int blue = (int)(alpha * c1.getBlue() + (1 - alpha) * c2.getBlue());
		Color blend = new Color(red, green, blue);
		return blend;
	}
	
	/**
	 * Returns an image which is the blending of the two given images.
	 * The blending is the linear combination of (1 - alpha) parts the
	 * first image and (alpha) parts the second image.
	 * The two images must have the same dimensions. 
	 * @param image1 - the first image
	 * @param image2 - the second image
	 * @param alpha - the linear combination parameter
	 * @return - the blended image
	 */
	public static Color[][] blend(Color[][] image1, Color[][] image2, double alpha) {
		Color[][] blendArr = new Color[image1.length][image1[0].length];
		for (int i = 0; i < image1.length ;i++ ) {
			for (int j = 0; j < image1[i].length ;j++ ) {
				blendArr[i][j] = blend(image1[i][j], image2[i][j], alpha);
			}
		}
		return blendArr;
	}
	
	/**
	 * Morphs the source image into the target image, gradually, in n steps.
	 * Animates the morphing process by displaying the morphed image in each step.
	 * The target image is an image which is scaled to be a version of the target
	 * image, scaled to have the width and height of the source image.
	 * @param source - source image
	 * @param target - target image
	 * @param n - number of morphing steps
	 */
	public static void morph(Color[][] source, Color[][] target, int n) {
		target = scaled(target, source[0].length, source.length);
		for (int i = 0; i < n + 1 ;i++) {
			show(blend(source, target, (double)(n - i) / n));
		}
	}
	
     /**
	 * Renders (displays) an image on the screen, using StdDraw. 
	 * 
	 * @param image - the image to show
	 */
	public static void show(Color[][] image) {
		StdDraw.setCanvasSize(image[0].length, image.length);
		int width = image[0].length;
		int height = image.length;
		StdDraw.setXscale(0, width);
		StdDraw.setYscale(0, height);
		StdDraw.show(25); 
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				// Sets the pen color to the color of the pixel
				StdDraw.setPenColor( image[i][j].getRed(),
					                 image[i][j].getGreen(),
					                 image[i][j].getBlue() );
				// Draws the pixel as a tiny filled square of size 1
				StdDraw.filledSquare(j + 0.5, height - i - 0.5, 0.5);
			}
		}
		StdDraw.show();
	}
}

