class Album {
	
	Page[] pages;
	int curr;
	
	Album(int x, int y, int n){
		if(x < 0 || y<0 || n<0){
			
			throw new IllegalArgumentException("The size and number of pages must be positive!");
		}
		
		pages = new Page[n];
		for(int i = 0; i != pages.length; i++){
			pages[i] = new Page(new ColorImage[0], x,y);
			
		}
		curr =0;
	}
	
	void next(){
		if(curr == pages.length -1){
			
			throw new IllegalStateException("Album doesn't have more pages");
			
		}else{
			curr++;
			
		}
		
	}
	void prev(){
		if(curr == 0){
			
			throw new IllegalStateException("Album doesn't have negative pages");
			
		}else{
			curr--;
			
		}
	}
	
	void swap(int f, int d){
		if(f < 0 || d<0 ){
			
			throw new IllegalArgumentException("Indexes must be positive!");
		}
		if(f >= pages.length || d >= pages.length ){
			
			throw new IllegalArgumentException("Indexes must be in bounds!");
		}
		Page temp = pages[f];
		pages[f] = pages[d];
		pages[d] = temp;
	}
	
	ColorImage show(){
		return pages[curr].draw();
		
	}
}