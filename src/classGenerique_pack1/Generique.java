package classGenerique_pack1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;





class Normale{
	
	
	public static <T> void afficher(T t) {
		
		System.out.println(t);
		
	}
	
	public static  <T>void afficherTab(T[] tab){
		
		System.out.println(Arrays.toString(tab));
		
		
	}
	
	
	
	public static <T extends Comparable<T>> T renvoyerMax(T[] tab) {
		
		if(tab==null && tab.length==0)
			return null;
		T max= tab[0];
		for(T t : tab)
			if(t.compareTo(max)>0)
				max=t;
		return max;
		
	}
	
	public static <T extends Number> double calculerSomme(List<T> liste) {
		
		double somme=0;
		for(T t : liste)
			somme+=t.doubleValue();
		return somme;
		
	}
	
	
	public static <T> List<T> filterEtTrier(List<T> liste,
			Predicate<T> prd,Comparator<T> cmp)  {
		
		List<T>  nvListe  = liste.stream()
				.filter(prd)
				.sorted(cmp)
				.toList();
		return nvListe;
	}

	
}

class Triplet<A,B,C>{
	
	
	private A a;
	private B b;
	private C c;
	
	
	public Triplet(A a,B b, C c) {
		this.a=a;
		this.b=b;
		this.c=c;
	}
	
	
	public A getA() {
		return a;
	}
	
	
	public B getB() {
		return b;
	}
	
	
	public C getC() {
		return c;
	}
}

public class Generique<T> {
	

	private T t;
	
	public Generique(T t) {
		this.t=t;
	}
	
	public Generique() {
		
	}
	
	public T getPremier() {
		return t;
		
	}
	
	public void afficher() {
		System.out.println(t.toString());
	}
	
	
	public static void main(String [] args) {
		Generique<String> varString= new Generique<String>("Wxample");
		Generique<Integer> varInteger= new Generique<Integer>(3);
		varString.afficher();
		varInteger.afficher();
		
		
		Triplet<String, Boolean , Double> triplet = new Triplet<>("A",true,3.4);
		
		System.out.println(triplet.getA());
		System.out.println(triplet.getB());
		System.out.println(triplet.getC());
		
		Integer[] tabInt  = {1,2,9,5,6};
		
		
		Pomme[] pommes= {new  Pomme(134,"rouge"),
				new  Pomme(130,"verte"),
				new  Pomme(123,"blue")
				
				};
				
		
		int i = Normale.renvoyerMax(tabInt);
		Pomme p = Normale.renvoyerMax(pommes);
		
		System.out.println(p);
		
		Normale.afficher(new Date());
		
		Normale.afficherTab(tabInt);
		Double [] tabDouble = {12.0,34.0,4.5,6.0};
		
		List<Double> listeD = Arrays.asList(tabDouble);
		
		List<Integer> liste = Arrays.asList(tabInt);
		System.out.println(Normale.calculerSomme(liste));
		System.out.println(Normale.calculerSomme(listeD));
		
		
		List<Pomme> lPommes = Normale.filterEtTrier(Arrays.asList(pommes), 
				a->a.getColor()=="rouge", 
				Comparator.comparing(Pomme::getPoids));
		
		lPommes.forEach(System.out::println);
		
		List<Double> nvlisted = Normale.filterEtTrier(listeD, d->d%2==0, (d1,d2)->(int)(d1-d2));
		
		
		System.out.println("-----------------------------");
		
		
	
		nvlisted.forEach(System.out::println);

		
	}

}
