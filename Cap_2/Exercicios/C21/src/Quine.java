
public class Quine {

	public static void main(String[] args) {
		
		String p = "public class Quine{\n\tpublic static void main(String[] args){\n\t\tString p = System.out.println(p);\n\t}\n}";
		
		String t = "teste";
		System.out.printf(t, 34, t, 34);
	}

}
