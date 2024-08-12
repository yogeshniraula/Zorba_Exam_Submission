package xml_based.entity;

import java.util.Set;

public class Skill {
   
    
        private int skillId;
        private String skillName;
        private Set<Employee> employees;

        public int getSkillId() {
            return skillId;
        }

        public void setSkillId(int skillId) {
            this.skillId = skillId;
        }

        public String getSkillName() {
            return skillName;
        }

        public void setSkillName(String skillName) {
            this.skillName = skillName;
        }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    }


