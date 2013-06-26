import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;


public class model {
	public boolean[][] cat;
	
	public model(){
		cat= new boolean[50][50];
		fillModel();
	}
	public void fillModel(){
		Random r= new Random();
		for(int i=0;i<300; i++){
			int x=r.nextInt(49);
			int y=r.nextInt(49);
			cat[x][y]=true;
		}
		
	}
	
	public void play(){
		for(int i=0; i<50;i++){
			for(int j=0; j<50;j++){
				int num=surronding(i,j);
				if(cat[i][j]){
					 if(num-1<2 || 3<num-1){
						 cat[i][j]=false;
					 }
				}else{
					if(num==3) cat[i][j]=true;
				}
			}
		}
	}
	
	public int surronding(int x, int y){
		int num=0;
		for(int i= 0<x ? x-1 : 0; i<x+2; i++ ){
			for(int j= 0<y ? y-1 : 0; j<y+2;j++){
				if(i<50)
					if(j<50)
						num+= cat[i][j]? 1:0;
			}
		}
		return num;
	}
	
    public void paint(Graphics2D g) {
        // loop through all the cells in the world rendering them
        for (int i=0;i<50;i++) {
            for (int j=0;j<50;j++) {
                g.setColor(new Color(0,0,0));
                if (cat[i][j]){ 
                	g.setColor(new Color(68,89,110));}

                g.fillRect(i*10,j*10,10,10);
            }
        }
    }

}
