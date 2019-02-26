import org.bukkit.Color;
import org.bukkit.Particle.DustOptions;

public class NorthernLights {
	
	/*
	 * To make colors closer together, try making speed = 85;
	 */
	int speed = 18;
	int min = 0;
	int max = 255;
	
	int r = min;
	int g = max;
	int b = max;
	boolean riseRed = true, riseGreen = false, riseBlue = false;
	boolean red = true, green = false, blue = false;
	
	public DustOptions northernLights() {
		
		if (red) {
			if (riseRed) {
				r+= speed;
				if (r >= max) {
					r = max;
					riseGreen = true;
					riseRed = false;
				}
			} else {
				r-= speed;
				if (r <= min) {
					r = min;
					riseRed = true;
					riseGreen = false;
				}
			}
		}
		if (green) {
			if (riseGreen) {
				g+= speed;
				if (g >= max) {
					g = max;
				}
			} else {
				g-= speed;
				if (g <= min) {
					g = min;
				}
			}
		}
		Color color = Color.fromRGB(r, g, b);
		return new DustOptions(color, 1);
	}
}
