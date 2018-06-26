import cxg.model.xmlmodel.jpa.Persistence;

public class Lanucher {

	public static void main(String[] args) {
		Persistence p = new Persistence();
		System.out.println(p.getVersion());
	}
	
}
