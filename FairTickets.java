import java.util.ListIterator;


public class FairTickets {

    int numberPeople; //number of people
    int totalTicketNumber; //number of total ticket
    MyLinkedList<String> names;
    MyLinkedList<MyLinkedList<Integer>> allTickets;

    public FairTickets(String[] args){

        if ( args.length < 2){
            System.out.println("Error : less arguments. Provide number of people and number of tickets");
            System.exit(0);
        }else if (args.length > 2){
            System.out.println("Error: Too many arguments.");
            System.exit(0);
        }

        this.numberPeople = Integer.parseInt(args[0]);

        this.totalTicketNumber = Integer.parseInt(args[1]);

        this.names = new MyLinkedList<>();
        this.allTickets = new MyLinkedList<>();


        if ( totalTicketNumber % ( 2 * numberPeople) != 0){
            System.out.println("NUmber of tickets should be multiple or 2 times number of people");
            System.exit(0);
        }
    }

    public void addNames() {
        for (int i = 1; i < this.numberPeople + 1; i++) {
            String name = "Person " + String.valueOf(i);
            this.names.add(name);
        }
        for (int i = 0; i < numberPeople; i++) {
            allTickets.add(new MyLinkedList<>());
        }
    }


    public static void main(String[] args) {

        FairTickets list = new FairTickets(args);  
        list.addNames();//call to add people on the list

        ListIterator<String> namesIterator;
        ListIterator<MyLinkedList<Integer>> ticketsIterator;
    
        int ticketNumber = 1; //set ticket number from 1
        
        // I have 20 tickets and 5 persons
        // each person gonna have same tickets
        //tickectNumber start at :: ticketNumber = 1;
        // CHECK :: is ticketNumber >= totalTicketNumber -> NO : Continue the process.
        //1. assign first 5 tickets in order : 1 2 3 4 5 
        //2. next 5 in reverse order : 10,9,8,7,6
        //3. next 5 as in order 11,12,13,14,15
        //4. next ones in reverse 16,17,18,19,20
        //5. is ticketNumber >= totalTicketNumber ? -> yes : Stop the process.

        while (ticketNumber <= list.totalTicketNumber) {
            //Define your iterators
            namesIterator = list.names.listIterator();
            ticketsIterator = list.allTickets.listIterator();

            //forward the process if the ticketNumber is <= total tickets
            while (namesIterator.hasNext()) {
                namesIterator.next();
                MyLinkedList<Integer> namesTickets = ticketsIterator.next();
                namesTickets.add(ticketNumber);
                ticketNumber++;

            }
            //backward the process if the ticketNumber is <= total tickets
            while (namesIterator.hasPrevious() && ticketsIterator.hasPrevious()){
                namesIterator.previous();
                ticketsIterator.previous().add(ticketNumber);
                ticketNumber++;
            }
        }
        //backback 


        
        //print results

        namesIterator = list.names.listIterator();
        ticketsIterator = list.allTickets.listIterator();
        
        while (namesIterator.hasNext() && ticketsIterator.hasNext()) {
            int sum = 0;
            String name = namesIterator.next();
            MyLinkedList<Integer> tickets = ticketsIterator.next();
            for (int ticket : tickets) {
                sum += ticket;
            }
            System.out.println(name + ":");
            
            for (int ticket : tickets) {
                System.out.println("Ticket " + "" + ticket);

            }
            System.out.println("Sum of tickets: " + sum);

            
        }
        
    }

}