import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Больница. Отделение: название, кол-во пациентов. Пациент: ФИО, возраст, пол.
//добавлять отделение/пациентов в него,
//удалять отделение/пациентов из него,
//редактирование отделения/пациентов. Добавление/удаление пациента в отделение
//увеличивает/уменьшает кол-во автоматически. Выводить информацию по отделениям (пациентов).
//Выводить информацию по пациентам (весь список с указанием отделения).

class Hospital {
    public List<Department> departments;

    public Hospital() {
        departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public void editDepartment(Department department, String newName) {
        department.setName(newName);
    }

    public void displayDepartmentsInfo() {
        for (Department department : departments) {
            System.out.println("Отделение: " + department.getName());
            System.out.println("Количество пациентов: " + department.getPatientsCount());
            System.out.println("|---------------------------|");
        }
    }

    public void displayPatientsInfo() {
        for (Department department : departments) {
            List<Patient> patients = department.getPatients();
            for (Patient patient : patients) {
                System.out.println("Отделение: " + department.getName());
                System.out.println("Пациент: " + patient.getName());
                System.out.println("Возраст: " + patient.getAge());
                System.out.println("Пол: " + patient.getGender());
                System.out.println("|---------------------------|");
            }
        }
    }
}

class Department {
    private String name;
    private List<Patient> patients;

    public Department(String name) {
        this.name = name;
        patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPatientsCount() {
        return patients.size();
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void removePatient(Patient patient) {
        patients.remove(patient);
    }

    public List<Patient> getPatients() {
        return patients;
    }
}

class Patient {
    private String name;
    private int age;
    private String gender;

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}

public class HospitalApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hospital hospital = new Hospital();


        Department defDepartment = new Department("Офтальмологическое");
        hospital.addDepartment(defDepartment);
        defDepartment = findDepartmentByName(hospital, "Офтальмологическое");
        Patient defPatient = new Patient("Кучеренко Н.А.", 21, "M");
        defDepartment.addPatient(defPatient);

        while (true) {
            System.out.println("1. Добавить отделение");
            System.out.println("2. Удалить отделение");
            System.out.println("3. Редактировать отделение");
            System.out.println("4. Добавить пациента");
            System.out.println("5. Удалить пациента");
            System.out.println("6. Вывести информацию по отделениям");
            System.out.println("7. Вывести информацию о пациентах");
            System.out.println("8. Выход из программы");
            System.out.print("Введите ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Введите название отделения: ");
                    String departmentName = scanner.nextLine();
                    Department newDepartment = new Department(departmentName);
                    hospital.addDepartment(newDepartment);
                    System.out.println("Отделение успешно добавлено!");
                    break;
                case 2:
                    System.out.print("Введите название отделения для удаления: ");
                    String departmentToRemove = scanner.nextLine();
                    Department department = findDepartmentByName(hospital, departmentToRemove);
                    if (department != null) {
                        hospital.removeDepartment(department);
                        System.out.println("Отделение успешно удалено!");
                    } else {
                        System.out.println("Отделение не найдено!");
                    }
                    break;
                case 3:
                    System.out.print("Введите название отделения для редактирования: ");
                    String departmentToEdit = scanner.nextLine();
                    department = findDepartmentByName(hospital, departmentToEdit);
                    if (department != null) {
                        System.out.print("Введите новое название отделения: ");
                        String newDepartmentName = scanner.nextLine();
                        hospital.editDepartment(department, newDepartmentName);
                        System.out.println("Отделение успешно изменено!");
                    } else {
                        System.out.println("Отделение не найдено!");
                    }
                    break;
                case 4:
                    System.out.print("Введите имя пациента: ");
                    String patientName = scanner.nextLine();
                    System.out.print("Введите возраст пациента: ");
                    int patientAge = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Введите пол пациента: ");
                    String patientGender = scanner.nextLine();
                    System.out.print("Введите отделение, в которое добавить пациента: ");
                    String departmentNameToAddPatient = scanner.nextLine();
                    department = findDepartmentByName(hospital, departmentNameToAddPatient);
                    if (department != null) {
                        Patient newPatient = new Patient(patientName, patientAge, patientGender);
                        department.addPatient(newPatient);
                        System.out.println("Пациент успешно добавлен!");
                    } else {
                        System.out.println("Отделение не найдено!");
                    }
                    break;
                case 5:
                    System.out.print("Введите имя пациента для удаления: ");
                    String patientToRemove = scanner.nextLine();
                    department = findDepartmentByPatientName(hospital, patientToRemove);
                    if (department != null) {
                        Patient patient = findPatientByName(department, patientToRemove);
                        if (patient != null) {
                            department.removePatient(patient);
                            System.out.println("Пациент успешно удалён!");
                        } else {
                            System.out.println("Пациент не найден!");
                        }
                    } else {
                        System.out.println("Пациент не найден!");
                    }
                    break;
                case 6:
                    hospital.displayDepartmentsInfo();
                    break;
                case 7:
                    hospital.displayPatientsInfo();
                    break;
                case 8:
                    System.out.println("Выход из программы...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неправильный ввод! Попробуйте ещё раз.");
                    break;
            }
        }
    }

    private static Department findDepartmentByName(Hospital hospital, String name) {
        for (Department department : hospital.departments) {
            if (department.getName().equals(name)) {
                return department;
            }
        }
        return null;
    }

    private static Department findDepartmentByPatientName(Hospital hospital, String patientName) {
        for (Department department : hospital.departments) {
            for (Patient patient : department.getPatients()) {
                if (patient.getName().equals(patientName)) {
                    return department;
                }
            }
        }
        return null;
    }

    private static Patient findPatientByName(Department department, String name) {
        for (Patient patient : department.getPatients()) {
            if (patient.getName().equals(name)) {
                return patient;
            }
        }
        return null;
    }
}