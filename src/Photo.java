class Photo {
	
	ColorImage img;
	int x,y;
	String description, date;
	
	Photo(ColorImage img, String desc, String date){
		if(img == null){
			 throw new NullPointerException("Argument must not be null!"); 
		}
		
		this.img = img;
		this.description = desc;
		this.date = date;
		
	}
	
	Photo(ColorImage img, String desc, String date, int x , int y){
		if(img == null){
			 throw new NullPointerException("Argument must not be null!"); 
		}
		if(x < 0 || y<0 ){
			
			throw new IllegalArgumentException("Coordinates must be positive!");
		}
		this.img = img;
		this.description = desc;
		this.date = date;
		this.x = x;
		this.y = y;
		
	}
	
	
	void setDesc(String desc){
		description = desc;
	}
	void setDate(String date){
		this.date = date;
	}
	void setCoords(int x , int y){
		if(x < 0 || y<0 ){
			
			throw new IllegalArgumentException("Coordinates must be positive!");
		}
		
		this.x = x;
		this.y = y;
	}
}