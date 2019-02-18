
public class Vertex {
	private Vertex Fu;
	private Vertex Fd;
	private double Sk;
	private double f;
	private int time;
	private static int endTime;
	//private String path;
	private double runningAvg;
	
	public Vertex(){
		Fu = null;
		Fd = null;
		Sk = 0;
		f = 0;
		time = 0;
		runningAvg = 0;
	}
	
//	public String getPath() {
//		return path;
//	}
//
//	public void setPath(String path) {
//		this.path = path;
//	}
	public double getRunningAvg() {
		return runningAvg;
	}

	public void setRunningAvg(double runningAvg) {
		this.runningAvg = runningAvg;
	}
	public Vertex getFd() {
		return Fd;
	}

	public void setFd(Vertex fd) {
		Fd = fd;
	}

	public double getSk() {
		return Sk;
	}

	public void setSk(double sk) {
		Sk = sk;
	}

	public double getF() {
		return f;
	}

	public void setF(double f) {
		this.f = f;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public static int getEndTime() {
		return endTime;
	}

	public static void setEndTime(int endTime) {
		Vertex.endTime = endTime;
	}

	public void setFu(Vertex fu) {
		Fu = fu;
	}

	public Vertex getFu(){
		return Fu;
	}
}
