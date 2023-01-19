class Main {
	
	public static void main(String[] args){
		Tests();
	}
	static void Tests(){
		ColorImage img = new ColorImage("D:/Downloads/tiagao.png");
		img.brighter(100);
		//ColorImage page = new ColorImage("D:/Downloads/page.png");
		//ColorImage pattern = new ColorImage("D:/Downloads/pattern.png");
		//ColorImage landscape = new ColorImage("D:/Downloads/landscape.jpg");
		//ColorImage bear = new ColorImage("D:/Downloads/bear.png");
		
//		ColorImage[] cn = new ColorImage[15];
//		
//		Page p = new Page(cn, 3000,3000);
		/*
		p.collection[2].img = ImageEdit.vignette(p.collection[2].img, 250);
		p.collection[0].img = ImageEdit.pb(p.collection[0].img);
		*/
		
		
		
		
		//p.changeBg(pattern);
		
		//System.out.println(p.collection[8].x + " " + p.collection[8].y);
		
//		p.sort();
//		p.draw();
		ImageUtil.writeImage(img.data,"D:/Final.png", "png" );
		//ImageEdit.layer(landscape,bear, 100,100);
		
		System.out.println("Done!");
		
		
	}
	
	
	static void test2(){
		ColorImage chika = new ColorImage("D:/Downloads/chika.jpg");
		ColorImage[] cn = new ColorImage[0];
		Page p = new Page(cn, 1000,1000);
		Photo ph = new Photo(chika, "","");
		p.addPhoto(ph);
		p.sort();
		p.draw();
			
		
				
		ImageUtil.writeImage(p.background.data,"D:/Downloads/ww.png", "png" );
	}
}