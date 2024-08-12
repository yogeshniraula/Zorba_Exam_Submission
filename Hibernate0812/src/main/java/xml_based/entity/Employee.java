package xml_based.entity;

import java.util.Set;

public class Employee {

        private int employeeId;
        private String employeeName;
        private Set<Skill> skills;
        private String employeeAddress;
        private String employeeEmail;
        private int employeeExperience;

    public int getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(int employeeId) {
            this.employeeId = employeeId;
        }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

        public String getEmployeeName() {
            return employeeName;
        }

        public void setEmployeeName(String employeeName) {
            this.employeeName = employeeName;
        }

    public String getEmployeeEmail() {
        return employeeEmail;
    }
    public int getEmployeeExperience() {
        return employeeExperience;
    }

    public void setEmployeeExperience(int employeeExperience) {
        this.employeeExperience = employeeExperience;
    }

    public void setEmployeeEmail(String employeeEmail) {

        this.employeeEmail = employeeEmail;
    }

        public Set<Skill> getSkills() {
            return skills;
        }

        public void setSkills(Set<Skill> skills) {
            this.skills = skills;
        }


    }




