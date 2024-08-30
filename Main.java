import java.time.LocalDate;
import java.util.Scanner;

public class Main {
     public static void main(String[] args) {
        HospitalManager manager = new HospitalManager();
        Scanner scanner = new Scanner(System.in);

        // Adding some beds for demonstration
        for (int i = 1; i <= 10; i++) {
            manager.getBeds().put(i, new Bed(i));
        }

        try {
            while (true) {
                System.out.println("\nHospital Management System Menu:");
                System.out.println("1. Admit Patient");
                System.out.println("2. Discharge Patient");
                System.out.println("3. Update Patient Details");
                System.out.println("4. Search for Patients");
                System.out.println("5. Assign Bed");
                System.out.println("6. Exit");
                System.out.print("Choose an option: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Patient ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Age: ");
                        int age = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter Gender: ");
                        String gender = scanner.nextLine();
                        System.out.print("Enter Diagnosis: ");
                        String diagnosis = scanner.nextLine();
                        System.out.print("Enter Treatment: ");
                        String treatment = scanner.nextLine();
                        System.out.print("Enter Bed Number: ");
                        int bedNumber = scanner.nextInt();

                        Patient patient = new Patient(id, name, age, gender, diagnosis, treatment, LocalDate.now());
                        manager.admitPatient(patient, bedNumber);
                        break;

                    case 2:
                        System.out.print("Enter Patient ID to discharge: ");
                        int dischargeId = scanner.nextInt();
                        manager.dischargePatient(dischargeId);
                        break;

                    case 3:
                        System.out.print("Enter Patient ID to update: ");
                        int updateId = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                        System.out.print("Enter updated Diagnosis: ");
                        String updatedDiagnosis = scanner.nextLine();
                        System.out.print("Enter updated Treatment: ");
                        String updatedTreatment = scanner.nextLine();

                        Patient updatedPatient = manager.getPatients().get(updateId);
                        if (updatedPatient != null) {
                            updatedPatient.setDiagnosis(updatedDiagnosis);
                            updatedPatient.setTreatment(updatedTreatment);
                            manager.updatePatientDetails(updateId, updatedPatient);
                        } else {
                            System.out.println("Patient not found.");
                        }
                        break;

                    case 4:
                        System.out.print("Enter search keyword (Name, ID, or Diagnosis): ");
                        scanner.nextLine(); // consume newline
                        String keyword = scanner.nextLine();
                        manager.searchPatient(keyword);
                        break;

                    case 5:
                        System.out.print("Enter Patient ID to assign bed: ");
                        int patientIdForBed = scanner.nextInt();
                        System.out.print("Enter Bed Number to assign: ");
                        int bedToAssign = scanner.nextInt();
                        manager.assignBed(patientIdForBed, bedToAssign);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
