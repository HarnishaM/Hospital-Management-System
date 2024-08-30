import java.time.LocalDate;
import java.util.HashMap;

import java.util.stream.Collectors;

public class HospitalManager {
    private HashMap<Integer, Patient> patients = new HashMap<>();
    private HashMap<Integer, Bed> beds = new HashMap<>();

    public HashMap<Integer, Patient> getPatients(){
        return patients;
    }
    public void setPatients(HashMap<Integer, Patient> patients){
        this.patients=patients;
    }
    public HashMap<Integer, Bed> getBeds(){
        return beds;
    }
    public void setBeds(HashMap<Integer, Bed> beds){
        this.beds=beds;
    }

    // Admit a Patient and Assign a Bed
    public void admitPatient(Patient patient, int bedNumber) {
        if (beds.containsKey(bedNumber) && !beds.get(bedNumber).isOccupied()) {
            patients.put(patient.getId(), patient);
            beds.get(bedNumber).setOccupied(true);
            System.out.println("Patient admitted successfully to bed number: " + bedNumber);
        } else {
            System.out.println("Bed number " + bedNumber + " is not available or doesn't exist.");
        }
    }

    // Discharge a Patient and Free the Bed
    public void dischargePatient(int patientId) {
        Patient patient = patients.get(patientId);
        if (patient != null) {
            patient.setDischargeDate(LocalDate.now());
            // Free the bed assigned to this patient
            beds.values().stream()
                    .filter(bed -> bed.isOccupied())
                    .findFirst()
                    .ifPresent(bed -> bed.setOccupied(false));

            System.out.println("Patient discharged successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Update Patient Details
    public void updatePatientDetails(int patientId, Patient updatedPatient) {
        if (patients.containsKey(patientId)) {
            patients.put(patientId, updatedPatient);
            System.out.println("Patient details updated successfully.");
        } else {
            System.out.println("Patient not found.");
        }
    }

    // Search for Patients
    public void searchPatient(String keyword) {
        var results = patients.values().stream()
                .filter(patient -> patient.getName().equalsIgnoreCase(keyword) ||
                        patient.getDiagnosis().equalsIgnoreCase(keyword) ||
                        String.valueOf(patient.getId()).equals(keyword))
                .collect(Collectors.toList());

        if (!results.isEmpty()) {
            results.forEach(System.out::println);
        } else {
            System.out.println("No patients found with the given keyword.");
        }
    }

    // Assign a Bed to a Patient
    public void assignBed(int patientId, int bedNumber) {
        if (patients.containsKey(patientId)) {
            if (beds.containsKey(bedNumber) && !beds.get(bedNumber).isOccupied()) {
                beds.get(bedNumber).setOccupied(true);
                System.out.println("Bed number " + bedNumber + " assigned to patient ID " + patientId);
            } else {
                System.out.println("Bed number " + bedNumber + " is not available or doesn't exist.");
            }
        } else {
            System.out.println("Patient not found.");
        }
    }

   
   
}
