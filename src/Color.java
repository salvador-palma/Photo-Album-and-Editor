class Color {

	private final int[] rgb; // @color
	static final Color red = new Color(255,0,0);
	static final Color blue = new Color(0,0,255);
	static final Color green = new Color(0,255,0);
	static final Color cyan = new Color(0,255,255);
	static final Color magenta = new Color(255,0,255);
	static final Color yellow = new Color(255,255,0);
	static final Color black = new Color(0,0,0);
	static final Color white = new Color(255,255,255);
	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}

	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}
	
	Color invert(){
		return new Color(255 - this.rgb[0],255 - this.rgb[1],255 - this.rgb[2]);
	}

	Color brighter(int x){
		return new Color(this.rgb[0] + x < 0 ? 0: this.rgb[0] + x  > 255 ? 255 : this.rgb[0] + x, this.rgb[1] + x < 0 ? 0: this.rgb[1] + x  > 255 ? 255 : this.rgb[1] + x,this.rgb[2] + x < 0 ? 0: this.rgb[2] + x  > 255 ? 255 : this.rgb[2] + x);
	}
	
	boolean isEqual(Color c){
		return c.getR() == this.rgb[0] && c.getG() == this.rgb[1]  && c.getB() == this.rgb[2] ;
		
	}
}