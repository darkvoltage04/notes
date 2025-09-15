package core.rective;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import reactor.core.publisher.Flux;
class Associates
{
	private long associateId;
	private String associateName;
	
	
	
	public Associates() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Associates(long associateId, String associateName) {
		super();
		this.associateId = associateId;
		this.associateName = associateName;
	}
	public long getAssociateId() {
		return associateId;
	}
	public void setAssociateId(long associateId) {
		this.associateId = associateId;
	}
	public String getAssociateName() {
		return associateName;
	}
	public void setAssociateName(String associateName) {
		this.associateName = associateName;
	}
	@Override
	public String toString() {
		return "Associates [associateId=" + associateId + ", associateName=" + associateName + "]";
	}

	
	
	
	
}



public class FluxWithUserdefined {
	
	static List<Associates> listOfAss=new ArrayList();
	static
	{
		listOfAss.add(new Associates(108, "Manoj"));
		listOfAss.add(new  Associates(109,"Sekhar"));
	listOfAss.add(null);
		listOfAss.add(new  Associates(111,"Gopal"));
		
	}
	
	public static Flux<Associates> associateFlux()
	{
		return Flux.fromIterable(listOfAss);
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		//Flux with Subcriber
		/*associateFlux().subscribe(
				
				assObj->System.out.println(assObj),
				error->System.out.println(error),
				()->System.out.println("Thank You")
				
				
				
				
				);*/
		
		
		
		//flux with Map trasformation
		
	/*	System.out.println("********Subcriber with Map trasformation***************");
		associateFlux().map(a->a.getAssociateName()).subscribe((name)->System.out.println(name));
		
		
		//flux with filter
		System.out.println("********Subcriber with Filter***************");
		associateFlux().filter(a-> a.getAssociateId()>100 && a.getAssociateId()<110).subscribe(System.out::println);
		*/
		
	//flux with error handling
		
		Flux<Associates> f = associateFlux()
			    .map(a -> {
			        if (a == null) {
			            throw new RuntimeException("Null values are not allowed");
			        }
			        return a;
			    })
			    
			    /*
			     * This is error recovery logic.

                  If any error occurs in the stream (like the RuntimeException from above), this block is executed.

                     Logs the error message.

                   Creates a fallback Associates object (here with associateName set to null).

                       Returns a new Flux containing just that fallback object.

                  So the stream recovers from the error by replacing the failed stream with a new Flux of default data.


			  
			     */
			    
			    .onErrorResume(error -> {
			        System.out.println("Caught error: " + error.getMessage());
			        Associates fallback = new Associates(); // create default/fallback Associates
			        fallback.setAssociateName(null) ;// set some default values if needed
			        return Flux.just(fallback);
			    });
	
		//Reactive stream are lazy tha's why For each item in the Flux, it prints the item using System.out.println.
	
	f.subscribe(System.out::println);
	
	System.out.println("buffuring....");
	//buffuring flux
	/*
	 * 
	 * .      take(2)	Limits the stream to 2 elements only
.           buffer()	Collects whatever elements come into a list (in this case, 2)
	 * 
	 * 
	 * 
	 */
	
	
	associateFlux().take(2).buffer().subscribe(chunk->System.out.println(chunk));
	
	//Combining two flux with ZIP
/*	System.out.println("***********combining two flux with Zip*************");
	Flux<String> names = Flux.just("Manoj", "Gopal", "Sekhar");
	Flux<Integer> scores = Flux.just(100, 101, 108);

	Flux.zip(names, scores, (name, score) -> name + " scored " + score)
	    .subscribe(System.out::println);*/
	
	
	}
}
