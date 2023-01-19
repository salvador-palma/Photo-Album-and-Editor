class Page {
	
	
	ColorImage background;
	Photo[] collection;
	ColorImage bgPat;
	
	Page(Photo ph, int x, int y){
		if(ph == null){
			 throw new NullPointerException("Argument must not be null!"); 
		}
		if(x < 0 || y<0 ){
			
			throw new IllegalArgumentException("Sizes must be positive!");
		}
		this.background = new ColorImage(x,y);
		this.collection = new Photo[1];
		this.collection[0] = ph;
	}
	
	Page(ColorImage[] coll, int x, int y){
		if(coll == null){
			 throw new NullPointerException("Argument must not be null!"); 
		}
		if(x < 0 || y<0 ){
			
			throw new IllegalArgumentException("Sizes must be positive!");
		}
		this.background = new ColorImage(x,y);
		this.collection = new Photo[coll.length];
		for (int i = 0; i!= coll.length; i++){
			this.collection[i] = new Photo(coll[i], "", "");
			
		}
	}
	
	void changeBg(ColorImage pattern){
		bgPat= pattern;
		ImageEdit.fill(background, pattern);
		
	}
	
	void addPhoto(Photo ph){
		if(ph == null){
			 throw new NullPointerException("Argument must not be null!"); 
		}
		
		Photo[] nc = new Photo[collection.length + 1];
		for (int i = 0; i!= collection.length; i++){
			nc[i] = collection[i];
		} 
		nc[nc.length-1] = ph;
		//collection = new Photo[collection.length + 1];
		collection = nc;
	}
	
	void removePhoto(int index){
		//EMENDAR: demasiados for loops
		
		if(index<0 || index >= collection.length ){
			
			throw new IllegalArgumentException("Indexes must be in bounds!");
		}
		for (int i = index; i!= collection.length-1; i++){
			collection[i] = collection[i+1];
		} 
		Photo[] nc = new Photo[collection.length-1];
		for (int i = 0; i!= nc.length; i++){
			nc[i] = collection[i];
		} 
		
		//collection = new Photo[collection.length - 1];
		collection = nc;
	}
	
	void swapPhoto(int x, int y){
		if(x < 0 || y<0 ){
			
			throw new IllegalArgumentException("Indexes must be positive!");
		}
		if(x >= collection.length || y >= collection.length ){
			
			throw new NullPointerException("No page was found at position " + Math.max(x,y));
		}
		Photo ph = collection[x];
		collection[x] = collection[y];
		collection[y] = ph;
	}
	
	void sort(){
		int max = 0;
		int nx=5;
		int ny=5;
		for(int i = 0; i != collection.length; i++){
			if(nx==5 && collection[i].img.getWidth() + nx > background.getWidth()){
				
				collection[i].x = nx;
				collection[i].y = ny;
				max = 0;
				nx = 5;
				ny = ny +collection[i].img.getHeight()+5;
				
			}else{
				if(collection[i].img.getWidth() + nx + 5 < background.getWidth()){
					collection[i].x = nx;
					collection[i].y = ny;
					max = Math.max(max, collection[i].img.getHeight());
					nx = nx + collection[i].img.getWidth() +5;
					//ny = ny;
				}else{
					ny = ny +max+5;
					max = 0;
					nx = 5;
					i --;
				}
			}
			
		}
		
	}
	
	
	ColorImage draw(){
		ImageEdit.fill(background, bgPat);
		ColorImage n = background;
		
		for(int i = 0; i != collection.length; i++){
			if(collection[i].x < background.getWidth() && collection[i].y < background.getHeight()){
				ImageEdit.layer(n, collection[i].img, collection[i].x, collection[i].y);
			}
		}
		return n;
		//ImageUtil.writeImage(background.data,"D:/Downloads/Final.png", "png" );
	}
	
	
}