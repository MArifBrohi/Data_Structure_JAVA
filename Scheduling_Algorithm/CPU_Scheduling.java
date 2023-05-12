import java.util.*;

class Process {
    int bt;
    int wt;
    int at;
    int tat;
    int pid;
    int ct;

    Process(int pid, int bt, int at, int wt, int tat, int ct) {
        this.bt = bt;
        this.pid = pid;
        this.wt = wt;
        this.tat = tat;
        this.at = at;
        this.ct = ct;
        
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
            processes[i] = new Process(i+1, bt, at,0,0,0);
        }            
        

         // Choose a scheduling algorithm
         System.out.println("Choose a scheduling algorithm:");
         System.out.println("1. First-Come, First-Served (FCFS)");
         System.out.println("2. Non-Preemptive Shortest Job First (NSJF)");
         System.out.println("3. Preemptive Shortest Job First (PSJF)");
         System.out.println("4. Round Robin (RR)");
         int choice = sc.nextInt();
 
         switch (choice) {
            case 1:
                fcfs(processes);
                break;
            case 2:
                n_sjf(processes);
                break;
            case 3:
                p_sjf(processes);
            case 4:
                System.out.print("Enter the time quantum: ");
                int quantum = sc.nextInt();
                roundRobin(processes, quantum);
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
                processes[i].ct = totalCm;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            }
            else {
                totalCm += processes[i].bt;
                processes[i].ct = totalCm;
                processes[i].wt =  totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            }
         
        }

        /* Compute average waiting time and average turn around time */

        int wt = 0;
        int tat = 0;
        for(int j=0; j<processes.length; j++) {
            wt += processes[j].wt;
            tat += processes[j].tat;
        }


        System.out.println("Process\tBurst Time\tArrival Time\tCompletion Time\tWaiting Time\tTurn-Around Time");
        for (int i = 0; i < processes.length; i++) {
            System.out.println(processes[i].pid + "\t\t" + processes[i].bt + "\t\t" + processes[i].at + "\t\t" +
                    processes[i].ct + "\t\t" + (processes[i].wt) +
                    "\t\t" + (processes[i].tat));
        }
        System.out.println("Total Waiting time: "+wt);
        System.out.println("Total turn around time: "+tat);
        float avrg_wt = (float) wt / processes.length;
        float avrg_tat = (float) tat / processes.length;
        System.out.println("Average Waiting time: "+avrg_wt);
        System.out.println("Avergae Turn Around time: "+avrg_tat);
    }


    public static void n_sjf(Process[] processes) {
        Arrays.sort(processes, Comparator.comparingInt(p -> p.bt));
        int totalCm = 0;
        for(int i=0; i<processes.length; i++) {
            if(i==0) {
                totalCm = processes[i].at + processes[i].bt;
                processes[i].ct = totalCm;
                processes[i].tat = totalCm - processes[i].at;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
            }
            else {
                totalCm += processes[i].bt;
                processes[i].ct = totalCm;
                processes[i].tat = totalCm - processes[i].at;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
            }

            
        }
        int wt = 0;
        int tat = 0;
        for(int i=0;i<processes.length;i++){
            wt += processes[i].wt;
            tat += processes[i].tat;
        }

        System.out.println("Process\tBurst Time\tArrival Time\tCompletion Time\tWaiting Time\tTurn-Around Time");
        for (int i = 0; i < processes.length; i++) {
            System.out.println(processes[i].pid + "\t\t" + processes[i].bt + "\t\t" + processes[i].at + "\t\t" +
                    processes[i].ct + "\t\t" + (processes[i].wt) +
                    "\t\t" + (processes[i].tat));
        }
        System.out.println("Total Waiting time: "+wt);
        System.out.println("Total turn around time: "+tat);

        float avrg_wt = (float) wt / processes.length;
        float avrg_tat = (float) tat / processes.length;

        System.out.println("Average Waiting time: "+ avrg_wt);
        System.out.println("Average turn around time: "+avrg_tat);
      

    }
    public static void p_sjf(Process[] processes) {
        int n = processes.length;
        int[] remainingTime = new int[n];
        boolean[] completed = new boolean[n];
        int totalCompleted = 0;
        int currentTime = 0;
    
        while (totalCompleted < n) {
            int shortestJobIndex = -1;
            int shortestJobBurst = Integer.MAX_VALUE;
    
            for (int i = 0; i < n; i++) {
                if (!completed[i] && processes[i].at <= currentTime && processes[i].bt < shortestJobBurst) {
                    shortestJobBurst = processes[i].bt;
                    shortestJobIndex = i;
                }
            }
    
            if (shortestJobIndex == -1) {
                currentTime++;
                continue;
            }
    
            processes[shortestJobIndex].bt--;
            currentTime++;
    
            if (processes[shortestJobIndex].bt == 0) {
                processes[shortestJobIndex].ct = currentTime;
                processes[shortestJobIndex].tat = processes[shortestJobIndex].ct - processes[shortestJobIndex].at;
                processes[shortestJobIndex].wt = processes[shortestJobIndex].tat - processes[shortestJobIndex].bt;
                completed[shortestJobIndex] = true;
                totalCompleted++;
            }
        }
    
        int wt = 0;
        int tat = 0;
    
        for (int i = 0; i < n; i++) {
            wt += processes[i].wt;
            tat += processes[i].tat;
        }
    
        // Print the process details and statistics
        System.out.println("Process\tBurst Time\tArrival Time\tCompletion Time\tWaiting Time\tTurn-Around Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processes[i].pid + "\t\t" + processes[i].bt + "\t\t" + processes[i].at + "\t\t" +
                    processes[i].ct + "\t\t" + processes[i].wt + "\t\t" + processes[i].tat);
        }
    
        System.out.println("Total Waiting time: " + wt);
        System.out.println("Total turn around time: " + tat);
    
        float avg_wt = (float) wt / n;
        float avg_tat = (float) tat / n;
    
        System.out.println("Average Waiting time: " + avg_wt);
        System.out.println("Average turn around time: " + avg_tat);
    }
    
    

    public static void roundRobin(Process[] processes, int quantum) {
        int n = processes.length; // 3
        
        int[] remainingTime = new int[n];
    
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes[i].bt; //  0->6, 1->8, 2->10
            
        }
    
        int currentTime = 0;
        boolean[] completed = new boolean[n];
        int totalCompleted = 0;
    
        while (totalCompleted < n) {    // 0 < 3, 0 < 3 
            for (int i = 0; i < n; i++) {
                
                if (!completed[i]) {
                    int executionTime = Math.min(remainingTime[i], quantum);
                    // executionTime = 4, execution =2
                    currentTime += executionTime;
                    // 0+4 = 4, 4+4= 8, 8+4 = 12,  12+2 =14,
                   
                    remainingTime[i] -= executionTime;
                    // 6-4 = 2, 8-4 = 4, 10-4 = 6, 2-2=0
    
                    if (remainingTime[i] == 0) {
                        processes[i].ct = currentTime;
                        processes[i].tat = currentTime - processes[i].at;
                        processes[i].wt = processes[i].tat - processes[i].bt;
                        completed[i] = true;
                        totalCompleted++;
                    }
                }
            }
        }
    
        int wt = 0;
        int tat = 0;
        for (int i = 0; i < n; i++) {
            wt += processes[i].wt;
            tat += processes[i].tat;
        }
    
        // Print the process details and statistics
        System.out.println("Process\tBurst Time\tArrival Time\tCompletion Time\tWaiting Time\tTurn-Around Time");
        for (int i = 0; i < n; i++) {
            System.out.println(processes[i].pid + "\t\t" + processes[i].bt + "\t\t" + processes[i].at + "\t\t" +
                    processes[i].ct + "\t\t" + processes[i].wt + "\t\t" + processes[i].tat);
        }
    
        System.out.println("Total Waiting time: " + wt);
        System.out.println("Total turn around time: " + tat);
    
        float avg_wt = (float) wt / n;
        float avg_tat = (float) tat / n;
    
        System.out.println("Average Waiting time: " + avg_wt);
        System.out.println("Average turn around time: " + avg_tat);
    }
    


}