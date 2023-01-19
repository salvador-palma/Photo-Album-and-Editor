/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
class ColorImage {

	 int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	
	void invert(){
		for (int i = 0 ; i != this.getWidth() ; i++){
			for (int j = 0 ; j != this.getHeight() ; j++){
				this.setColor(i,j, this.getColor(i,j).invert());
			}
		}
	}
	void brighter(int x){
		for (int i = 0 ; i != this.getWidth() ; i++){
			for (int j = 0 ; j != this.getHeight() ; j++){
				this.setColor(i,j, this.getColor(i,j).brighter(x));
			}
		}
	}
	
	void swap(int i1,int j1, int i2, int j2){
		int temp = data[i1][j1];
		data[i1][j1] = data[i2][j2];
		data[i2][j2] = temp;
	}
	void mirror(){
		for (int i = 0 ; i != this.getHeight() ; i++){
			for (int j = 0 ; j != this.getWidth()/2; j++){
				swap(i,j,i, this.getWidth() -1 -j);
			}
		}
	}
	
	void merge(ColorImage lay, int x, int y){
		int l = lay.getWidth() > this.getWidth() -x ? this.getWidth() -x : lay.getWidth();
		int r = lay.getHeight() > this.getHeight() -y ?this.getHeight() -y :  lay.getHeight() ;
		for (int i = 0 ; i != l  ; i++){
			for (int j = 0 ; j != r; j++){
				this.setColor(i+x,j+y, lay.getColor(i,j));
			}
		}
		
	}
	
	ColorImage pb(){
		ColorImage c = new ColorImage(this.getWidth(), this.getHeight());
		for (int i = 0 ; i != this.getWidth(); i++){
			for (int j = 0 ; j != this.getHeight(); j++){
				if(this.getColor(i,j).getLuminance() < 128){
					c.setColor(i,j,Color.black);
				}else{
					c.setColor(i,j,Color.white);
				}
			}
		}
		return c;
	}
	
	ColorImage copy(){
		ColorImage c = new ColorImage(this.getWidth(), this.getHeight());
		for (int i = 0 ; i != this.getWidth(); i++){
			for (int j = 0 ; j != this.getHeight(); j++){
					c.setColor(i,j,this.getColor(i,j));
			}
		}
		return c;
	}
	
	ColorImage cut(int xstr, int ystr, int xend, int yend){
		ColorImage c = new ColorImage(xend-xstr, yend-ystr);
		for (int i = xstr ; i != xend; i++){
			for (int j = ystr ; j != yend; j++){
					c.setColor(i-xstr,j-ystr,this.getColor(i,j));
			}
		}
		return c;
	}
	
	
}