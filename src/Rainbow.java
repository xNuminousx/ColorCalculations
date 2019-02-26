import org.bukkit.Color;
import org.bukkit.Particle.DustOptions;

public class Rainbow {
	/*
	 * For pastel colors alter the min to be 100-150 and the max to be 255.
	 */
	int speed = 17;
	int min = 0;
	int max = 255;
	
	int r = max;
	int g = min;
	int b = min;
	boolean riseRed = true, riseGreen = false, riseBlue = false;
	boolean red = true, green = false, blue = false;
	
	public DustOptions rainbow() {
		
		if (red) {
			if (riseRed) {
				r+= speed;
				if (r >= max) {
					r = max;
					riseBlue = false;
					green = true;
				}
			} else {
				r-= speed;
				if (r <= min) {
					r = min;
					riseRed = true;
					blue = true;
				}
			}
		}
		if (green) {
			if (riseGreen) {
				g+= speed;
				if (g >= max) {
					g = max;
					riseRed = false;
				}
			} else {
				g-= speed;
				if (g <= min) {
					g = min;
					riseGreen = true;
					riseRed =true;
				}
			}
		}
		if (blue) {
			if (riseBlue) {
				b+= speed;
				if (b >= max) {
					b = max;
					riseGreen = false;
				}
			} else {
				b-= speed;
				if (b <= min) {
					b = min;
					riseBlue = true;
				}
			}
		}
		Color color = Color.fromRGB(r, g, b);
		return new DustOptions(color, 1);
	}
}
