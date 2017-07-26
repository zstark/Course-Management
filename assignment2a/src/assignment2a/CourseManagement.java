package assignment2a;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

 

class CourseList implements Serializable{
   
	private static final long serialVersionUID = 1L;
	Course[] list;
    int no_of_courses;
    int max_no_of_courses;
    public CourseList(){
        list = new Course [50];
        no_of_courses = 0;
        max_no_of_courses = 50;
    }
    
    public void AddCourse(Course A){
        list[no_of_courses] = A;
        no_of_courses++;
    }
    
    void SaveEverything(){
    	FileOutputStream fout = null;
        try {
                
            fout = new FileOutputStream("vishal.dat");
        } catch (FileNotFoundException ex) {
       
        }
                         try (ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                             oos.writeObject(this);
                             oos.flush();
                             oos.close();
                         } catch (IOException ex) {

        }
    	
    }
    
    public void DisplayDetails(){
    	
    	final JFrame frame = new JFrame("Display Details");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 155, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
        
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("Enter index of course :");
		lblEnterIndexOf.setBounds(10, 165, 152, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(153, 165, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		final JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 185, 56, 14);
		frame.getContentPane().add(lblName);
		lblName.setVisible(false);
		
		final JLabel lblName_1 = new JLabel("NAME");
		lblName_1.setBounds(76, 185, 46, 14);
		frame.getContentPane().add(lblName_1);
		lblName_1.setVisible(false);
		
		final JLabel lblFees1 = new JLabel("Fees :");
		lblFees1.setBounds(10, 200, 48, 14);
		frame.getContentPane().add(lblFees1);
		lblFees1.setVisible(false);
		
		final JLabel lblFees = new JLabel("FEES");
		lblFees.setBounds(76, 200, 46, 14);
		frame.getContentPane().add(lblFees);
		lblFees.setVisible(false);
		
		final JLabel lblDuration = new JLabel("Duration :");
		lblDuration.setBounds(10, 215, 66, 14);
		frame.getContentPane().add(lblDuration);
		lblDuration.setVisible(false);
		
		final JLabel lblDuration_1 = new JLabel("DURATION");
		lblDuration_1.setBounds(78, 215, 56, 14);
		frame.getContentPane().add(lblDuration_1);
		lblDuration_1.setVisible(false);
		
		final JLabel lblStartdate = new JLabel("StartDate :");
		lblStartdate.setBounds(10, 230, 66, 14);
		frame.getContentPane().add(lblStartdate);
		lblStartdate.setVisible(false);
		
		final JLabel lblStartdate_1 = new JLabel("STARTDATE");
		lblStartdate_1.setBounds(78, 230, 69, 14);
		frame.getContentPane().add(lblStartdate_1);
		lblStartdate_1.setVisible(false);
		
		final JLabel lblCoorddinator = new JLabel("Coordinator :");
		lblCoorddinator.setBounds(10, 245, 77, 14);
		frame.getContentPane().add(lblCoorddinator);
		lblCoorddinator.setVisible(false);
		
		final JLabel lblCoordinator = new JLabel("COORDINATOR");
		lblCoordinator.setBounds(88, 245, 77, 14);
		frame.getContentPane().add(lblCoordinator);
		lblCoordinator.setVisible(false);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText()) ;
				if(index >= no_of_courses || index < 0 ) {
			            System.out.println("Not possible! Enter again");
			            return;
			        }
			
				lblName.setVisible(true);
				lblName_1.setVisible(true);
				lblFees1.setVisible(true);
				lblFees.setVisible(true);
				lblDuration.setVisible(true);
				lblDuration_1.setVisible(true);
				lblStartdate.setVisible(true);
				lblStartdate_1.setVisible(true);
				lblCoorddinator.setVisible(true);
				if(list[index].GetCoordinator()!=null) lblCoordinator.setVisible(true);
				else lblCoordinator.setVisible(false);
				lblName_1.setText(list[index].GetName());
				lblFees.setText(list[index].GetFee());
				lblDuration_1.setText(list[index].GetDuration_in_days());
				lblStartdate_1.setText(list[index].GetStartDate());
			if(list[index].GetCoordinator()!=null)	lblCoordinator.setText(list[index].GetCoordinator().GetName());
				

			}
		});
		btnNewButton.setBounds(267, 165, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
			}
		});
		btnDone.setBounds(337, 236, 87, 23);
		frame.getContentPane().add(btnDone);
        
        
    }
    public void AlterFacultyDetails(){
    	final JFrame frame = new JFrame("Alter Faculty Details");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
		JLabel [] label = new JLabel[no_of_courses];
		for(int i = 0; i < no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 16*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		
		JLabel lblEnterIndexOf = new JLabel("Enter index of course :");
		lblEnterIndexOf.setBounds(10, 130, 132, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(153, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
    	
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText());
				AlterFacultyDetails(list[index]);
			}
		});
		btnSubmit.setBounds(260, 130, 100, 20);
		frame.getContentPane().add(btnSubmit);
    	
   
                }
    public void AlterFacultyDetails(final Course A){
    	final JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllFacultiesAre = new JLabel("All Faculties of this course are : ");
		lblAllFacultiesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllFacultiesAre);
		
		JLabel lblCoordinator = new JLabel("Coordinator : 0. " + A.GetCoordinator().GetName());
		lblCoordinator.setBounds(44, 30, 145, 14);
		frame.getContentPane().add(lblCoordinator);
		
		JLabel [] label = new JLabel[A.no_of_instructors];
		
		for(int i = 0; i < A.no_of_instructors ; i++){
			int j = i + 1;
			label[i] = new JLabel(j + " . " + A.GetInstructor(i).GetName());
			label[i].setBounds(44, 50 + 18*i, 100, 14);
			frame.getContentPane().add(label[i]);
			
		}
		
		JLabel lblEnterIndexOf = new JLabel("Enter index of Faculty :");
		lblEnterIndexOf.setBounds(10, 130, 132, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(153, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
    	
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 160, 46, 14);
		frame.getContentPane().add(lblName);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(80, 160, 104, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 180, 38, 14);
		frame.getContentPane().add(lblEmail);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 180, 104, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 200, 56, 14);
		frame.getContentPane().add(lblAddress);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setBounds(80, 200, 104, 23);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblMobNo = new JLabel("MobNo :");
		lblMobNo.setBounds(10, 220, 56, 14);
		frame.getContentPane().add(lblMobNo);
		
		final JTextField textField_4 = new JTextField();
		textField_4.setBounds(80, 220, 104, 23);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnDone = new JButton("Done");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText());
				
			if(index != 0){	
				textField_1.setText(A.GetInstructor(index).GetName());
				textField_2.setText(A.GetInstructor(index).GetEmail());
				textField_3.setText(A.GetInstructor(index).GetAddress());
				textField_4.setText(A.GetInstructor(index).GetMobNo());
			}
			else {
				textField_1.setText(A.GetCoordinator().GetName());
				textField_2.setText(A.GetCoordinator().GetEmail());
				textField_3.setText(A.GetCoordinator().GetAddress());
				textField_4.setText(A.GetCoordinator().GetMobNo());
			}
			}
		});
		btnDone.setBounds(253, 130, 100, 20);
		frame.getContentPane().add(btnDone);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText());
				if(index == 0){
					A.GetCoordinator().Setname(textField_1.getText());
					A.GetCoordinator().SetEmail(textField_2.getText());
					A.GetCoordinator().SetAddress(textField_3.getText());
					A.GetCoordinator().SetMobNo(textField_4.getText());
				}
				
				else{
					A.GetInstructor(index).Setname(textField_1.getText());
					A.GetInstructor(index).SetEmail(textField_2.getText());
					A.GetInstructor(index).SetAddress(textField_3.getText());
					A.GetInstructor(index).SetMobNo(textField_4.getText());
				}
				frame.setVisible(false);
			}
		});
		btnSubmit.setBounds(343, 230, 100, 20);
		frame.getContentPane().add(btnSubmit);
		
		
		
    	
    }

    public void AlterFacultyDetails(Faculty A){
        Scanner in = new Scanner(System.in);
      
        
        A.PrintFacultyDetails();
        
        System.out.println("press 1 for true and 0 for false..");
        int temp;
        System.out.print("Do you want to change Faculty's name?");
        temp = in.nextInt();
        in.nextLine();
        if(temp == 1){
            System.out.print("Enter name : ");
            A.Setname(in.nextLine());
        }
        System.out.print("Do you want to change Faculty's email?");
        temp = in.nextInt();
        in.nextLine();
        if(temp == 1){
            System.out.print("Enter email : ");
            A.SetEmail(in.nextLine());
            
        }
        System.out.print("Do you want to change Faculty's address?");
        temp = in.nextInt();
        in.nextLine();
        if(temp == 1){
            System.out.print("Enter address : ");
            A.SetAddress(in.nextLine());
            
        }
        System.out.print("Do you want to change Faculty's mobile number?");
        temp = in.nextInt();
        in.nextLine();
        if(temp == 1){
            System.out.print("Enter mobile number : ");
            A.SetMobNo(in.nextLine());
        }
        System.out.print("Do you want to change Faculty's department?");
        temp = in.nextInt();
        in.nextLine();
        if(temp == 1){
            System.out.print("Enter department : ");
        A.SetDepartment(in.nextLine());
        }
        System.out.println("Returning to main menu...");
    }
    
    public void AlterCourseDetails(){
      
    	
    	final JFrame frame = new JFrame("Alter Course's Details");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("Enter index of course :");
		lblEnterIndexOf.setBounds(10, 140, 142, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(143, 140, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setBounds(10, 170, 46, 14);
		frame.getContentPane().add(lblName);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setBounds(80, 170, 104, 23);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		JLabel lblDepartment = new JLabel("Fees :");
		lblDepartment.setBounds(10, 190, 38, 14);
		frame.getContentPane().add(lblDepartment);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setBounds(80, 190, 104, 23);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration :");
		lblDuration.setBounds(10, 210, 56, 14);
		frame.getContentPane().add(lblDuration);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setBounds(80, 210, 104, 23);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblStartdate = new JLabel("StartDate :");
		lblStartdate.setBounds(10, 230, 56, 14);
		frame.getContentPane().add(lblStartdate);
		
		final JTextField textField_4 = new JTextField();
		textField_4.setBounds(80, 230, 104, 23);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText());
				textField_1.setText(list[index].GetName());
				textField_2.setText(list[index].GetFee());
				textField_3.setText(list[index].GetDuration_in_days());
				textField_4.setText(list[index].GetStartDate());
			}
		});
		btnEnter.setBounds(253, 140, 100, 20);
		frame.getContentPane().add(btnEnter);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText());
				list[index].SetName(textField_1.getText());
				list[index].SetFee(textField_2.getText());
				list[index].SetDuration_in_days(textField_3.getText());
				list[index].SetStartDate(textField_4.getText());
				frame.setVisible(false);
			}
		});
		btnSubmit.setBounds(333, 230, 100, 20);
		frame.getContentPane().add(btnSubmit);
    	
        
    }
    
    
    
    
    public void CreateCourse(){
    	final JFrame frame = new JFrame("Create Course");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblDetails = new JLabel("Enter Details :");
		lblDetails.setBounds(174, 10, 100, 30);
		frame.getContentPane().add(lblDetails);
		
    	JLabel lblCourseName = new JLabel("Course Name :");
		lblCourseName.setBounds(24, 37, 94, 50);
		frame.getContentPane().add(lblCourseName);
		
		final JTextField textField = new JTextField();
		textField.setBounds(173, 49, 103, 38);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Course start date :");
		lblNewLabel.setBounds(24, 98, 108, 38);
		frame.getContentPane().add(lblNewLabel);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(173, 98, 103, 38);
		frame.getContentPane().add(textField_1);
		
		JLabel lblCourseFeeint = new JLabel("Course fee :");
		lblCourseFeeint.setBounds(24, 142, 108, 38);
		frame.getContentPane().add(lblCourseFeeint);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(173, 142, 103, 38);
		frame.getContentPane().add(textField_2);
		
		JLabel lblCourseDurationIn = new JLabel("Course duration in days  :");
		lblCourseDurationIn.setBounds(24, 186, 151, 38);
		frame.getContentPane().add(lblCourseDurationIn);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(173, 186, 103, 38);
		frame.getContentPane().add(textField_3);
		
		JButton btnSubmit = new JButton("SUBMIT");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Course A = new Course();
		        A.SetName(textField.getText());
		        A.SetStartDate(textField_1.getText());
		        A.SetFee(textField_2.getText());
		        A.SetDuration_in_days(textField_3.getText());
		        frame.setVisible(false);
		        AddCourse(A);
		        System.out.println(A.GetName()+" course added");

				
			}
		});
		btnSubmit.setBounds(183, 235, 89, 23);
		frame.getContentPane().add(btnSubmit);
    	
        

    }
    
    public void CreateParticipant(){
    	final JFrame frame = new JFrame("Create Participant");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
       
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("Enter index of course :");
		lblEnterIndexOf.setBounds(10, 130, 112, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(133, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name : ");
		lblName.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 186, 57, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 211, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		
		final JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 156, 100, 20);
		frame.getContentPane().add(textField_1);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 180, 100, 20);
		frame.getContentPane().add(textField_2);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 205, 100, 20);
		frame.getContentPane().add(textField_3);
		
		
		
		JLabel lblMobileno = new JLabel("MobileNo. :");
		lblMobileno.setBounds(255, 130, 57, 14);
		frame.getContentPane().add(lblMobileno);
		
		final JTextField textField_6 = new JTextField();
		textField_6.setBounds(324, 124, 100, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText()) ;
				if(index >= no_of_courses || index < 0 ) {
			            System.out.println("Not possible! Enter again");
			            return;
			        }
				Participant A = new Participant();
				A.Setname(textField_1.getText());
				A.SetAddress(textField_2.getText());
				A.SetEmail(textField_3.getText());
				A.SetMobNo(textField_6.getText());
				
				frame.setVisible(false);
				list[index].AddParticipant(A);
				System.out.println(A.GetName() + " added as participant of " + list[index].GetName());
			}
		});
		btnSubmit.setBounds(300, 227, 100, 23);
		frame.getContentPane().add(btnSubmit);
        
        

    }
    
    public void CreateCoordinator(){
        
        final JFrame frame = new JFrame("Create Coordinator");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 6, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 22 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("EnterCourse'sIndex :");
		lblEnterIndexOf.setBounds(10, 130, 122, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(139, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name : ");
		lblName.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 186, 57, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 211, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setBounds(10, 236, 77, 14);
		frame.getContentPane().add(lblDepartment);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(139, 156, 100, 20);
		frame.getContentPane().add(textField_1);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(139, 180, 100, 20);
		frame.getContentPane().add(textField_2);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(139, 205, 100, 20);
		frame.getContentPane().add(textField_3);
		
		final JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(139, 230, 100, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblMobileno = new JLabel("MobileNo. :");
		lblMobileno.setBounds(255, 130, 67, 14);
		frame.getContentPane().add(lblMobileno);
		
		final JTextField textField_6 = new JTextField();
		textField_6.setBounds(324, 124, 100, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText()) ;
				if(index >= no_of_courses || index < 0 ) {
			            System.out.println("Not possible! Enter again");
			            return;
			        }
				Faculty A = new Faculty();
				A.Setname(textField_1.getText());
				A.SetAddress(textField_2.getText());
				A.SetEmail(textField_3.getText());
				A.SetMobNo(textField_6.getText());
				A.SetDepartment(textField_4.getText());
				frame.setVisible(false);
				list[index].SetCoordinator(A);
			}
		});
		btnSubmit.setBounds(300, 227, 100, 23);
		frame.getContentPane().add(btnSubmit);
        

    }
    
    
    
    public void CreateInstructor(){
    	final JFrame frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("Enter index of course :");
		lblEnterIndexOf.setBounds(10, 130, 112, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(133, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblName = new JLabel("name : ");
		lblName.setBounds(10, 161, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setBounds(10, 186, 57, 14);
		frame.getContentPane().add(lblAddress);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setBounds(10, 211, 46, 14);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblDepartment = new JLabel("Department : ");
		lblDepartment.setBounds(10, 236, 77, 14);
		frame.getContentPane().add(lblDepartment);
		
		final JTextField textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 156, 100, 20);
		frame.getContentPane().add(textField_1);
		
		final JTextField textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 180, 100, 20);
		frame.getContentPane().add(textField_2);
		
		final JTextField textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 205, 100, 20);
		frame.getContentPane().add(textField_3);
		
		final JTextField textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(133, 230, 100, 20);
		frame.getContentPane().add(textField_4);
		
		JLabel lblMobileno = new JLabel("MobileNo. :");
		lblMobileno.setBounds(255, 130, 57, 14);
		frame.getContentPane().add(lblMobileno);
		
		final JTextField textField_6 = new JTextField();
		textField_6.setBounds(324, 124, 100, 20);
		frame.getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText()) ;
				if(index >= no_of_courses || index < 0 ) {
			            System.out.println("Not possible! Enter again");
			            return;
			        }
				Faculty A = new Faculty();
				A.Setname(textField_1.getText());
				A.SetAddress(textField_2.getText());
				A.SetEmail(textField_3.getText());
				A.SetMobNo(textField_6.getText());
				A.SetDepartment(textField_4.getText());
				frame.setVisible(false);
				list[index].AddInstructor(A);
				System.out.println(A.GetName() + " added as instructor of " + list[index].GetName());
			}
		});
		btnSubmit.setBounds(300, 227, 100, 23);
		frame.getContentPane().add(btnSubmit);
        

    }
    
    
    
    
    public void DeleteCourse(Course A){
        int i,j;
         for(i = 0; i < no_of_courses ; i++){
           
           if(list[i] == A){
               for(j = i+1;j < no_of_courses;j++) list[j-1] = list[j];
               list[no_of_courses-1] = null;
               no_of_courses--;
               break;
           }
       }
    }
    public void DeleteCourse(int index){
        int j;
        for(j = index+1;j < no_of_courses;j++) list[j-1] = list[j];
        list[no_of_courses-1] = null;
        no_of_courses--;
    }
    public void DeleteCourse(){
    	
    	final JFrame frame = new JFrame("Delete Course");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		JLabel lblAllCoursesAre = new JLabel("All courses are : ");
		lblAllCoursesAre.setBounds(44, 13, 115, 14);
		frame.getContentPane().add(lblAllCoursesAre);
        
		JLabel [] label = new JLabel[this.no_of_courses];
		for(int i = 0; i < this.no_of_courses ; i++){
			label[i] = new JLabel(i + " . " + list[i].GetName());
			label[i].setBounds(44, 32 + 15*i, 100, 14);
			frame.getContentPane().add(label[i]);
		}
		JLabel lblEnterIndexOf = new JLabel("Enter index of course to delete :");
		lblEnterIndexOf.setBounds(10, 130, 212, 14);
		frame.getContentPane().add(lblEnterIndexOf);
		
		final JTextField textField = new JTextField();
		textField.setBounds(233, 130, 100, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
    	
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int index = Integer.valueOf(textField.getText()) ;
				if(index >= no_of_courses || index < 0 ) {
			            System.out.println("Not possible! Enter again");
			            return;
			        }
				DeleteCourse(index);
				frame.setVisible(false);
				
			}
		});
		btnSubmit.setBounds(300, 227, 100, 23);
		frame.getContentPane().add(btnSubmit);
        
        
    }
    
    
    
    public void PrintCourseDetails(){
        int i,j;
        for(i = 0;i < no_of_courses; i++){
            j=i+1;
            System.out.println("Course no. " + j + " : ");
            list[i].PrintDetails();
        } 
    }
    public void PrintCourseNames(){
        int i,j;
        for(i = 0;i < no_of_courses; i++){
            j=i+1;
            System.out.println("Course no. " + j + " : " + list[i].GetName());
        } 
    }
    
}


 class Course implements Serializable{
   /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String name;
   private String fee;
   private String StartDate;
   private String duration_in_days;
   private Faculty coordinator;
   private Faculty [] instructors;
   private Participant [] participants; 
   private int no_of_participants;
   public int no_of_instructors;
   
   public Course(String name, String fee, String StartDate, String duration_in_days, Faculty coordinator){
       this.name = name;
       this.fee = fee;
       this.StartDate = StartDate;  //in dd/mm/yyyy format
       this.duration_in_days = duration_in_days;
       this.coordinator = coordinator;
       instructors = new Faculty[5]; // max 5 instructors allowed
       participants = new Participant[5]; // max 5 participants
   }
   
   public Course(){
       name = null;
       fee = null;
       StartDate = null;
       duration_in_days = null;
       coordinator = null;
       instructors = new Faculty[5]; // max 5 instructors allowed
       participants = new Participant[5]; // max 5 participants
   }
   
   public void SetName(String name){
       this.name = name;
   }
   public void SetFee(String fee){
       this.fee = fee;
   }
   public void SetStartDate(String StartDate){
       this.StartDate = StartDate;
   }
   public void SetDuration_in_days(String duration_in_days){
       this.duration_in_days = duration_in_days;
   }
   public void SetCoordinator(Faculty coordinator){
       this.coordinator = coordinator;
   }
   
  
   public String GetName(){
       return name;
   }
   public String GetFee(){
       return fee;
   }
   public String GetStartDate(){
       return StartDate;
   }
   public String GetDuration_in_days(){
       return duration_in_days;
   }
   public Faculty GetCoordinator(){
       return coordinator;
   }
   public Faculty GetInstructor(int index){
       return instructors[index];
   }
   public void AddParticipant(Participant A){
       participants[no_of_participants] = A;
       no_of_participants++;
   }
   public void DeleteParticipant(Participant A){
       int i,j;
       for(i = 0; i < no_of_participants ; i++){
           
           if(participants[i] == A){
               for(j = i+1;j < no_of_participants;j++) participants[j-1] = participants[j];
               participants[no_of_participants-1] = null;
               no_of_participants--;
               break;
           }
       }
   }
   
   public void AddInstructor(Faculty A){
       instructors[no_of_instructors] = A;
       no_of_instructors++;
   }
   
   
   public void DeleteInstructor(Faculty A){
       int i,j;
       for(i = 0; i < no_of_instructors ; i++){
           
           if(instructors[i] == A){
               for(j = i+1;j < no_of_instructors;j++) instructors[j-1] = instructors[j];
               instructors[no_of_instructors-1] = null;
               no_of_instructors--;
               break;
           }
       }
   }
   
   public void PrintDetails(){
       System.out.println("Name : " + name);
       System.out.println("Fee : " + fee);
       System.out.println("Start Date : " + StartDate);
       System.out.println("Duration : " + duration_in_days + " days.");
       System.out.println("Fee : " + fee);
       if(coordinator != null) System.out.println("coordinator is : " + coordinator.GetName());
       PrintParticipants();
       PrintInstructors();
       System.out.println();
    
   }
   public void PrintParticipants(){
       int i;
       System.out.println("Participants are : ");

       for(i = 0; i < no_of_participants; i++) System.out.println(participants[i].GetName());
   }
   public void PrintInstructors(){
       int i;
       System.out.println("Instructors are : ");
       for(i = 0; i < no_of_instructors; i++) System.out.println(instructors[i].GetName());
   }
}

class Faculty implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String Department;
    public String name;
    public String address;
    public String email;
    public String MobNo;
    
    public Faculty(String Department, String name, String address, String email, String MobNo){
        this.Department = Department;
        this.name = name;
        this.address = address;
        this.email = email;
        this.MobNo = MobNo;
    }
    public Faculty(){
        Department = null;
        name = null;
        address = null;
        email =  null;
        MobNo = null;
    }
    public void PrintFacultyDetails(){

        System.out.println("name : " + this.GetName());
        System.out.println("department : " + this.GetDepartment());
        System.out.println("address : " + this.GetAddress());
        System.out.println("email : " + this.GetMobNo());
        System.out.println("Mobile number : " + this.GetMobNo());

    }
    public void SetDepartment(String Department){
       this.Department = Department;
   }
   public void Setname(String name){
       this.name = name;
   }
   public void SetAddress(String address){
       this.address = address;
   }
   public void SetEmail(String email){
       this.email = email;
   }
   public void SetMobNo(String MobNo){
       this.MobNo = MobNo;
   }
   
   public String GetDepartment(){
       return Department;
   }
   public String GetName(){
       return name;
   }
   public String GetAddress(){
       return address;
   }
   public String GetEmail(){
       return email;
   }
   public String GetMobNo(){
       return MobNo;
   }
    
}

class Participant implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String name;
    public String address;
    public String MobNo;
    public String email;
    
    // no constructor
    public Participant( String name, String address, String email, String MobNo){
        this.name = name;
        this.address = address;
        this.email = email;
        this.MobNo = MobNo;
    }
    public Participant(){
        name = null;
        address = null;
        email =  null;
        MobNo = null;
    }
     public void Setname(String name){
       this.name = name;
   }
   public void SetAddress(String address){
       this.address = address;
   }
   public void SetEmail(String email){
       this.email = email;
   }
   public void SetMobNo(String MobNo){
       this.MobNo = MobNo;
   }
   public String GetName(){
       return name;
   }
   public String GetAddress(){
       return address;
   }
   public String GetEmail(){
       return email;
   }
   public String GetMobNo(){
       return MobNo;
   }
}



public class CourseManagement {

	private JFrame frame;
	CourseList myList;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManagement window = new CourseManagement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public CourseManagement() {
		myList = null;
        
        File file = new File("vishal.dat");
        if (file.exists()) {
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(
                        new FileInputStream("vishal.dat"));
            } catch (IOException ex) {
              //  Logger.getLogger(CourseManagement.class.getName()).log(Level.SEVERE, null, ex);
            }
                try {
                    myList = (CourseList) objectInputStream.readObject();
                    System.out.println("Reading from the file.. now myList : ");
                    myList.PrintCourseNames();
                } catch (IOException | ClassNotFoundException ex) {
                 
                }
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                   
                }

        }
        else{
                    myList = new CourseList();
                    System.out.println("File does not exist ..Creating new myList : ");
        }
        		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		MainMenu();
	}
	
	private void MainMenu(){
		frame = new JFrame("Main Menu");
		frame.setBounds(100, 100, 501, 302);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToCourse = new JLabel("Welcome to Course Software! ");
		lblWelcomeToCourse.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblWelcomeToCourse.setBounds(90, 29, 332, 14);
		frame.getContentPane().add(lblWelcomeToCourse);
		
		JLabel lblClickOnAny = new JLabel("Click on any one of these buttons : ");
		lblClickOnAny.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblClickOnAny.setBounds(90, 57, 313, 24);
		frame.getContentPane().add(lblClickOnAny);
		
		
		JButton btnCreatecourse = new JButton("CreateCourse");
		btnCreatecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.CreateCourse();
				myList.SaveEverything();
			}
		});
		btnCreatecourse.setBounds(41, 93, 136, 23);
		frame.getContentPane().add(btnCreatecourse);
		
		JButton btnCreatecoordinator = new JButton("CreateCoordinator");
		btnCreatecoordinator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.CreateCoordinator();
				myList.SaveEverything();
			}
		});
		btnCreatecoordinator.setBounds(41, 127, 136, 23);
		frame.getContentPane().add(btnCreatecoordinator);
		
		JButton btnCreateinstructor = new JButton("CreateInstructor");
		btnCreateinstructor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.CreateInstructor();
				myList.SaveEverything();
			}
		});
		btnCreateinstructor.setBounds(41, 161, 136, 23);
		frame.getContentPane().add(btnCreateinstructor);
		
		JButton btnCreateparticipant = new JButton("CreateParticipant");
		btnCreateparticipant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.CreateParticipant();
				myList.SaveEverything();
			}
		});
		btnCreateparticipant.setBounds(41, 194, 136, 23);
		frame.getContentPane().add(btnCreateparticipant);
		
		JButton btnDisplaydetails = new JButton("DisplayDetails");
		btnDisplaydetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.DisplayDetails();
				myList.SaveEverything();
			}
		});
		btnDisplaydetails.setBounds(228, 93, 136, 23);
		frame.getContentPane().add(btnDisplaydetails);
		
		JButton btnAltercoursedetails = new JButton("AlterCourseDetails");
		btnAltercoursedetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.AlterCourseDetails();
				myList.SaveEverything();
			}
		});
		btnAltercoursedetails.setBounds(228, 127, 136, 23);
		frame.getContentPane().add(btnAltercoursedetails);
		
		JButton btnDeletecourse = new JButton("DeleteCourse");
		btnDeletecourse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.DeleteCourse();
				myList.SaveEverything();
			}
		});
		btnDeletecourse.setBounds(228, 161, 136, 23);
		frame.getContentPane().add(btnDeletecourse);
		
		JButton btnAlterfacultydetails = new JButton("AlterFacultyDetails");
		btnAlterfacultydetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				myList.AlterFacultyDetails();
				myList.SaveEverything();
			}
		});
		btnAlterfacultydetails.setBounds(228, 194, 136, 23);
		frame.getContentPane().add(btnAlterfacultydetails);
		
	}

}
