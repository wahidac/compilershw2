class Test{
    public static void main(String[] a){
	int b;
	int c;
	boolean f;
	int []g;
	
	while(1 < 3) {
		b = 4;
		if(f) 
			c = 3;
		else
			c = 3;
	}
    }
}

class Froyo {
	int a;
	public int hasbro() {
		return 2;
	}
	public int moko(int a) {
		return a;
	}
	
}


class NoNo extends Froyo {
	boolean a;
	
	public int randomFunc() {
		int b;
		return b;
	}
	
}

class Fubu extends NoNo {
	int a;
	public int yoko() {
		int a;
		a = this.moko(2);
		return a;
	}
	
	
	public Toopie mko(Froyo foopie, int a) {
		int b;
		int t;
		NoNo s;
		
		return s;
	}
}

class Toopie extends NoNo {
	Fubu f;
	
	public int yoo() {
		Froyo g;
		int t;
		int[] a;
		t = a[t];
		g = new Toopie();
		//g = f.mko(f.mko(f.mko(g,2),4),this.yoo());
		return 3;
	}
}


// This class contains the array of integers and
// methods to initialize, print and sort the array
// using Bublesort
class Yolo{
    
    int[] number ;
    int size ;
    Froyo f;
    
    public int jojo() {
    	int a;
    	a = f.hasbro();
    	return a;
    }
    
 

    // Invoke the Initialization, Sort and Printing
    // Methods
    public int Start(int sz, int koko, int momo, boolean broyo){
	int aux01 ;
	aux01 = this.Init(sz);
	aux01 = this.Print();
	System.out.println(99999);
	aux01 = this.Sort();
	aux01 = this.Print();
	return 0 ;
    }

 
    // Sort array of integers using Bublesort method
    public int Sort(){
	int nt ;
	int i ;
	int aux02 ;
	int aux04 ;
	int aux05 ;
	int aux06 ;
	int aux07 ;
	int j ;
	int t ;
	Froyo myFroyo;

	myFroyo  = new Froyo();
	i = size - 1 ;
	aux02 = 0 - 1 ;
	aux02 = this.Start(2, myFroyo.moko(3), j, false);
	
	while (aux02 < i) {
	    j = 1 ;
	    //aux03 = i+1 ;
	    while (j < (i+1)){
		aux07 = j - 1 ;
		aux04 = number[aux07] ;
		aux05 = number[j] ;
		if (aux05 < aux04) {
		    aux06 = j - 1 ;
		    t = number[aux06] ;
		    number[aux06] = number[j] ;
		    number[j] = t;
		}
		else nt = 0 ;
		j = j + 1 ;
	    }
	    i = i - 1 ;
	}
	return 0 ;
    }

    // Printing method
    public int Print(){
	int j ;
	Yolo k;
	
	j = 0 ;
	
	k = new Yolo();
	while (j < (size)) {
	    System.out.println(number[j]);
	    j = j + 1 ;
	}
	return 0 ;
    }
    
    // Initialize array of integers
    public int Init(int sz){
	size = sz ;
	number = new int[sz] ;
	
	number[0] = 20 ;
	number[1] = 7  ; 
	number[2] = 12 ;
	number[3] = 18 ;
	number[4] = 2  ; 
	number[5] = 11 ;
	number[6] = 6  ; 
	number[7] = 9  ; 
	number[8] = 19 ; 
	number[9] = 5  ;
	
	return 0 ;	
    }

}

