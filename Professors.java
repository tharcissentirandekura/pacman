import java.util.Iterator;

public class Professors implements Iterable<String>{

    /*
     * inner class
     */

    private class ProfessorIterator implements Iterator<String> {

        private Professors profs;
        private int index;

        public ProfessorIterator(Professors profs){

            this.profs = profs;
            this.index = 0;

        }

        public boolean hasNext(){

            boolean valid = true;
            if (this.index < this.profs.names.length){
                valid = true;
            }
            else{
                valid = false;
            }
            return valid;
        }

        public String next(){
            String prof = "Professor " + this.profs.names[index];
            this.index += 1;
            return prof;
        }

    }


    /*
     * end of inner class
     */

     /*
      * class constructor 
      */




    private String[] names;

    Professors(String[] names){
        this.names = names.clone();
    }

    public Iterator<String> iterator(){ 
        return new ProfessorIterator(this);
    
    }

    public static void main(String[] args){

        String[] names = new String[] {
            "Eck", 
            "Feldman", 
            "Levinson", 
            "Taylor"
        };
        
        Professors profs = new Professors(names);

        // for ( String prof : profs){
        //     System.out.println(prof);
        // }

        ProfessorIterator iterator =  (Professors.ProfessorIterator) profs.iterator();

        while ( iterator.hasNext()){
            String prof = iterator.next();
            System.out.println(prof);

        }

        
        
    }


    
}


