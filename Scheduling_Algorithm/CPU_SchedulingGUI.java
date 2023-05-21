import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
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

class CPU_SchedulingGUI extends JFrame implements ActionListener {
    private JLabel lblNumProcesses, lblAlgorithm;
    private JTextField txtNumProcesses, txtTimeQuantum;
    private JComboBox<String> cmbAlgorithm;
    private JButton btnSubmit;
    private JTextArea txtOutput;

    private Process[] processes;

    public CPU_SchedulingGUI() {
        setTitle("CPU Scheduling");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLayout(new FlowLayout());

        lblNumProcesses = new JLabel("Enter the number of processes:");
        txtNumProcesses = new JTextField(10);
        lblAlgorithm = new JLabel("Choose a scheduling algorithm:");
        cmbAlgorithm = new JComboBox<>(new String[]{"First-Come, First-Served (FCFS)", "Non-Preemptive Shortest Job First (NSJF)", "Shortest Remaining time first (Preemptive)", "Round Robin (RR)"});
        btnSubmit = new JButton("Submit");
        txtOutput = new JTextArea(30, 60);
        txtOutput.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        btnSubmit.addActionListener(this);

        add(lblNumProcesses);
        add(txtNumProcesses);
        add(lblAlgorithm);
        add(cmbAlgorithm);
        add(btnSubmit);
        add(scrollPane);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSubmit) {
            int n = Integer.parseInt(txtNumProcesses.getText());

            processes = new Process[n];

            for (int i = 0; i < n; i++) {
                int pid = i + 1;
                int at = Integer.parseInt(JOptionPane.showInputDialog("Enter the Arrival time of process " + pid + ":"));
                int bt = Integer.parseInt(JOptionPane.showInputDialog("Enter the Burst time of process " + pid + ":"));
                processes[i] = new Process(pid, bt, at, 0, 0, 0);
            }

            int choice = cmbAlgorithm.getSelectedIndex();

            switch (choice) {
                case 0:
                    fcfs(processes);
                    break;
                case 1:
                    n_sjf(processes);
                    break;
                case 2:
                     p_sjf(processes);
                     break;
                case 3:
                     int quantum = Integer.parseInt(JOptionPane.showInputDialog("Enter the time quantum:"));
                     roundRobin(processes, quantum);
                     break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid Option");
            }
        }
    }
        /* FROM HERE FCFS ALGORITHM STARTS */
    public void fcfs(Process[] processes) {
        Arrays.sort(processes, Comparator.comparingInt(p -> p.at));
    
        int totalCm = 0;
        for (int i = 0; i < processes.length; i++) {
            if (i == 0) {
                totalCm = processes[i].bt + processes[i].at;
                processes[i].ct = totalCm;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            } else {
                totalCm += processes[i].bt;
                processes[i].ct = totalCm;
                processes[i].wt = totalCm - processes[i].at - processes[i].bt;
                processes[i].tat = totalCm - processes[i].at;
            }
        }
        int wt = 0;
        int tat = 0;

        for(int i=0; i<processes.length; i++) {
            wt += processes[i].wt;
            tat += processes[i].tat;
        }

        float avg_wt = (float) wt / processes.length;
        float avg_tat = (float) tat / processes.length;

        displayOutput_FCFS(processes, avg_wt, avg_tat, wt,tat);

       
    }

    public void displayOutput_FCFS(Process[] processes, float avg_wt, float avg_tat, int wt, int tat) {
        StringBuilder output = new StringBuilder();
        output.append("Process\tBT\tAT\tCT\tWT\tTAT\n");
        for (Process process : processes) {
            output.append(process.pid).append("\t").append(process.bt).append("\t").append(process.at)
                    .append("\t").append(process.ct).append("\t").append(process.wt).append("\t").append(process.tat)
                    .append("\n");
        }
        output.append("\nTotal Waiting Time: ").append(wt);
        output.append("\nTotal turn Around Time: ").append(tat);
        output.append("\nAverage Waiting Time: ").append(avg_wt);
        output.append("\nAverage Turnaround Time: ").append(avg_tat);
        txtOutput.setText(output.toString());
    }

    /* THIS IS THE LINE WHERE FCFS ENDS */


    /*FROM HERE NON PREEMPTIVE SHORTEST JOBS FIRST STARTS */

    public void n_sjf(Process[] processes) {
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
        for(int i=0; i<processes.length; i++) {
            wt += processes[i].wt;
            tat += processes[i].tat;
        }

        float avg_wt = (float) wt / processes.length;
        float avg_tat = (float) tat / processes.length;

        displayOutput_NSJF(processes, avg_wt, avg_tat, wt,tat);

    }

    public void displayOutput_NSJF(Process[] processes, float avg_wt, float avg_tat, int wt, int tat) {
        StringBuilder output = new StringBuilder();
        output.append("Process\tBT\tAT\tCT\tWT\tTAT\n");
        for (Process process : processes) {
            output.append(process.pid).append("\t").append(process.bt).append("\t").append(process.at)
                    .append("\t").append(process.ct).append("\t").append(process.wt).append("\t").append(process.tat)
                    .append("\n");
        }
        output.append("\nTotal Waiting Time: ").append(wt);
        output.append("\nTotal turn Around Time: ").append(tat);
        output.append("\nAverage Waiting Time: ").append(avg_wt);
        output.append("\nAverage Turnaround Time: ").append(avg_tat);
        txtOutput.setText(output.toString());
    }

    /*THIS IS THE LINE WHERE NON PREEMPTIVE SHORTEST JOB FIRST ENDS */



    /* FROM HERE SHORTEST REMAINING TIME FIRST STARTS */

    public void p_sjf(Process[] processes) {
        int n = processes.length;
        int[] remainingTime = new int[n];
        int completed = 0;
        int currentTime = 0;
    
        for (int i = 0; i < n; i++) {
            remainingTime[i] = processes[i].bt;
        }
    
        while (completed < n) {
            int shortestJob = -1;
            int shortestTime = Integer.MAX_VALUE;
    
            for (int i = 0; i < n; i++) {
                if (processes[i].at <= currentTime && remainingTime[i] < shortestTime && remainingTime[i] > 0) {
                    shortestJob = i;
                    shortestTime = remainingTime[i];
                }
            }
    
            if (shortestJob == -1) {
                currentTime++;
                continue;
            }
    
            remainingTime[shortestJob]--;
    
            if (remainingTime[shortestJob] == 0) {
                completed++;
                processes[shortestJob].ct = currentTime + 1;
                processes[shortestJob].tat = processes[shortestJob].ct - processes[shortestJob].at;
                processes[shortestJob].wt = processes[shortestJob].tat - processes[shortestJob].bt;
            }
    
            currentTime++;
        }
    
        int wt = 0;
        int tat = 0;
        for (int i = 0; i < n; i++) {
            wt += processes[i].wt;
            tat += processes[i].tat;
        }
    
        float avg_wt = (float) wt / n;
        float avg_tat = (float) tat / n;
    
        displayOutput_PSJF(processes, avg_wt, avg_tat, wt, tat);
    }
    
    public void displayOutput_PSJF(Process[] processes, float avg_wt, float avg_tat, int wt, int tat) {
        StringBuilder output = new StringBuilder();
        output.append("Process\tBT\tAT\tCT\tWT\tTAT\n");
        for (Process process : processes) {
            output.append(process.pid).append("\t").append(process.bt).append("\t").append(process.at)
                    .append("\t").append(process.ct).append("\t").append(process.wt).append("\t").append(process.tat)
                    .append("\n");
        }
        output.append("\nTotal Waiting Time: ").append(wt);
        output.append("\nTotal Turnaround Time: ").append(tat);
        output.append("\nAverage Waiting Time: ").append(avg_wt);
        output.append("\nAverage Turnaround Time: ").append(avg_tat);
        txtOutput.setText(output.toString());
    }
    /* THIS IS THE LINE WHERE SHORTEST REMAINING TIME FIRST ENDS */



    /* FROM HERE ROUND ROBIN ALGORITHMS STARTS */
    public void roundRobin(Process[] processes, int quantum) {
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

        float avg_wt = (float) wt / processes.length;
        float avg_tat = (float) tat / processes.length;

        displayOutput_RR(processes, avg_wt, avg_tat, wt, tat);
    }
  
     
    public void displayOutput_RR(Process[] processes, float avg_wt, float avg_tat, int wt, int tat) {
        StringBuilder output = new StringBuilder();
        output.append("Process\tBT\tAT\tCT\tWT\tTAT\n");
        for (Process process : processes) {
            output.append(process.pid).append("\t").append(process.bt).append("\t").append(process.at)
                    .append("\t").append(process.ct).append("\t").append(process.wt).append("\t").append(process.tat)
                    .append("\n");
        }
        output.append("\nTotal Waiting Time: ").append(wt);
        output.append("\nTotal Turnaround Time: ").append(tat);
        output.append("\nAverage Waiting Time: ").append(avg_wt);
        output.append("\nAverage Turnaround Time: ").append(avg_tat);
        txtOutput.setText(output.toString());
    }
      /* THIS IS THE LINE WHERE ROUND ROBIN ALGORITHM ENDS */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CPU_SchedulingGUI gui = new CPU_SchedulingGUI();
            gui.setVisible(true);
        });
    }
}

