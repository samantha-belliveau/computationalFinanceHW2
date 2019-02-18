import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AmericanPutOp {
	static double r, p, u, d, S0, t, K;
	static int c = 0;
	
	public static void main(String[] args) {
		long startTime = System.nanoTime();

		String fileName = args[0];
	    File file = new File(fileName); 
	    Scanner sc;
	    double v, T;
	    int n;
	    try {
			sc = new Scanner(file);
			while (sc.hasNextLine()){
				String line = sc.nextLine();
				String[] arguments = line.split("\t");
				r = Double.parseDouble(arguments[0]);
				T = Double.parseDouble(arguments[1]);
				n = Integer.parseInt(arguments[2]);
				v = Double.parseDouble(arguments[3]);
				S0 = Double.parseDouble(arguments[4]);
				K = Double.parseDouble(arguments[5]);
				
				Vertex root = new Vertex();
				root.setTime(0);
				Vertex.setEndTime(n);

				t = T/n;
				u = Math.pow(Math.E, v*Math.pow(t, .5));
				d = Math.pow(Math.E, -1*v*Math.pow(t, .5));
				p = (Math.pow(Math.E, r*t) - d)/(u-d);
				
				root = calculatePrice(root, null, -1, true);
				System.out.println(root.getF());

				long endTime = System.nanoTime();
				//System.out.println("Took "+(endTime - startTime) + " ns");
			}

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public static Vertex calculatePrice(Vertex v, Vertex prev, double prevSk, boolean up){
		double Sk;
		if (prevSk > 0){
			if (up){
				Sk = prevSk * u;
			}else {
				Sk = prevSk * d;
			}
		}else{
			prevSk = S0;
			Sk = S0;
		}
		if (v.getTime() == Vertex.getEndTime()){
			// is leaf
			v.setF(Math.max(K-Sk, 0));
			return v;
		}else {
			double negR = -1 * r;
			double eRT = Math.pow(Math.E, negR*t);
			

			Vertex Fu = new Vertex();
			if (!up){
				Fu =  prev.getFu().getFd();
				v.setFu(Fu);
			} else{
				Fu.setTime(v.getTime()+1);
				v.setFu(Fu);
				Fu = calculatePrice(Fu, v, Sk, true);
			}

			
			Vertex Fd = new Vertex();
			Fd.setTime(v.getTime()+1);
			v.setFd(Fd);
			Fd = calculatePrice(Fd, v, Sk, false);

			double f = eRT* (p*v.getFu().getF() + (1-p)*v.getFd().getF());
			double earlyExercise = K - Sk;
			if (earlyExercise > f){
				v.setF(earlyExercise);
			}else{
				v.setF(f);
			}
			return v;
		}
	}
	


}
