import java.util.*;

class Process {
    int bt;
    int wt;
    int at;
    int tat;
    int pid;

    Process(int pid, int bt, int at, int wt, int tat) {
        this.bt = bt;
        this.pid = pid;
        this.wt = wt;
        this.tat = tat;
        this.at = at;
        
    }
}
class CPU_Scheduling {
    public static void main(String []args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of processes: ");
        
        int n = sc.nextInt();

        Process[] processes = new Process[n];

        for(int i=0; i<n; i++) {
            System.out.print("\nEnter the Arival time of process "+(i+1)+": ");
            int at = sc.nextInt();
            System.out.print("Enter the Burst time of process "+(i+1)+": ");
            int bt = sc.nextInt();
            processes[i] = new Process(i+1, bt, at,0,0);
        }            
        

         // Choose a scheduling algorithm
         System.out.println("Choose a scheduling algorithm:");
         System.out.println("1. First-Come, First-Served (FCFS)");
         System.out.println("2. Shortest Job First (SJF)");
         System.out.println("3. Round Robin (RR)");
         int choice = sc.nextInt();
 
         switch (choice) {
             case 1:
                 fcfs(processes);
                 break;

            default:
                System.out.println("Invalid Option...");
         }

    }

    public static void fcfs(Process[] processes) {
        Arrays.sort(processes, Comparator.comparingInt(p -> p.at));

        /* Compute completion time, waiting time and turn around time
            of each process */ 

         int totalCm = 0;
        for(int i=0; i<processes.length; i++) {

           
            if(i == 0) {
                totalCm = processes[i].bt+processes[i].at;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            }
            else {
                totalCm += processes[i].bt;
                processes[i].wt =  totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            }
            System.out.println("Completion time: "+(i+1)+" "+totalCm);
            System.out.println("Waiting time: "+(i+1)+" "+processes[i].wt);
            System.out.println("turn around time: "+(i+1)+" "+processes[i].tat);
        }

        /* Compute average waiting time and average turn around time */

        int wt = 0;
        int tat = 0;
        for(int j=0; j<processes.length; j++) {
            wt += processes[j].wt;
            tat += processes[j].tat;
        }
        System.out.println("Total Waiting time: "+wt);
        System.out.println("Total turn around time: "+tat);
        float avrg_wt = (float) wt / processes.length;
        float avrg_tat = (float) tat / processes.length;
        System.out.println("Average Waiting time: "+avrg_wt);
        System.out.println("Avergae Turn Around time: "+avrg_tat);
    }
}
