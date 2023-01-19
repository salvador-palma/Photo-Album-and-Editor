class ImageEdit {
    
    
    
    //LAYER COM TRANSPARENCIA
    static void layer(ColorImage original, ColorImage lay, int x, int y){
        int l = lay.getWidth() > original.getWidth() -x ? original.getWidth() -x : lay.getWidth();
        int r = lay.getHeight() > original.getHeight() -y ?original.getHeight() -y :  lay.getHeight() ;
        for (int i = 0 ; i != l  ; i++){
            for (int j = 0 ; j != r; j++){
                if(lay.getColor(i,j).getR() != 255 || lay.getColor(i,j).getG() != 255 || lay.getColor(i,j).getB() != 255){
                    
                    original.setColor(i+x,j+y, lay.getColor(i,j));
                }
                
            }
        }
        
    }
    
    //FILL PATTERN
    static void fill(ColorImage page, ColorImage pattern){
    	if(pattern == null){
    		for (int i = 0; i!= page.getWidth()  ; i++){
                for (int j = 0; j!= page.getHeight()  ; j++){
                	
                	page.setColor(i,j,Color.black);
                }
                
                
    		}
    		
    	}else{
    		for (int i = 0; i!= page.getWidth()/ pattern.getWidth()  +1; i++){
                for (int j = 0; j!= page.getHeight()/ pattern.getHeight()  +1 ; j++){
                    for (int c = 0; c!= pattern.getWidth(); c++){
                        for (int l = 0; l!=  pattern.getHeight(); l++){
                            if((i*pattern.getWidth())+c < page.getWidth() && (j*pattern.getHeight())+l < page.getHeight()){                        
                                page.setColor((i*pattern.getWidth())+c,(j*pattern.getHeight())+l, pattern.getColor(c,l));    
                            }
                            
                        }            
                    }
                }            
            }
    		
    	}
        
        
    }
    
    
    //SCALE
    static ColorImage scaled(ColorImage img, double factor){
        ColorImage n = new ColorImage((int)( img.getWidth() * factor),(int)( img.getHeight() * factor) );
        for (int i = 0; i!= n.getWidth() ; i++){
            for (int j = 0; j!= n.getHeight() ; j++){
                n.setColor(i,j,img.getColor((int)(i * (1/factor)),(int)(j * (1/factor))));
            }            
        }
        return n;
    }
    
    //PRETO E BRANCO
    static ColorImage pb(ColorImage img){
        ColorImage n = new ColorImage(img.getWidth(),img.getHeight());
        int c;
        for (int i = 0; i!= n.getWidth() ; i++){
            for (int j = 0; j!= n.getHeight() ; j++){
                c = tone(img.getColor(i,j));
                n.setColor(i,j, new Color(c,c,c));
            }            
        }
        return n;
    }
    static int tone(Color c){
        return (int)(c.getR()*0.3 + c.getG() * 0.55 + c.getB() * 0.11);
    }
    //VINHETA
    //Para o efeito mais normal escolher um valor 
    //proximo de metade das dimensoes da imagem como limit
    static ColorImage vignette(ColorImage img, int limit){
        ColorImage n = new ColorImage(img.getWidth(),img.getHeight());
        int cx = (int)(img.getWidth()/2);
        int cy = (int)(img.getHeight()/2);
        for (int i = 0; i!= n.getWidth() ; i++){
            for (int j = 0; j!= n.getHeight() ; j++){
                n.setColor(i,j,  img.getColor(i,j).brighter(Math.min(limit-distance(cx,cy, i,j),0)));    
            }            
        }
        return n;
    }
    static int distance(int cx, int cy, int x, int y){
        return (int)Math.sqrt((cx-x)*(cx-x) + (cy-y)*(cy-y));
        
    }
    
    

	
  
    
}