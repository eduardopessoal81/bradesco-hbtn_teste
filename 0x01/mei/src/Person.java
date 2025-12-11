import java.util.Date;
import java.util.Calendar;

public class Person {

    private String name;
    private String surname;
    private Date birthDate;

    private boolean anotherCompanyOwner;
    private boolean pensioner;
    private boolean publicServer;

    private float salary;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public boolean isAnotherCompanyOwner() { return anotherCompanyOwner; }
    public void setAnotherCompanyOwner(boolean anotherCompanyOwner) { this.anotherCompanyOwner = anotherCompanyOwner; }

    public boolean isPensioner() { return pensioner; }
    public void setPensioner(boolean pensioner) { this.pensioner = pensioner; }

    public boolean isPublicServer() { return publicServer; }
    public void setPublicServer(boolean publicServer) { this.publicServer = publicServer; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    public String fullName() {
        return name + " " + surname;
    }

    public float calculateYearlySalary() {
        return salary * 12;
    }

    private int getAge() {
        Calendar today = Calendar.getInstance();
        Calendar birth = Calendar.getInstance();
        birth.setTime(birthDate);

        int age = today.get(Calendar.YEAR) - birth.get(Calendar.YEAR);

        if (today.get(Calendar.DAY_OF_YEAR) < birth.get(Calendar.DAY_OF_YEAR)) {
            age--;
        }
        return age;
    }

    public boolean isMEI() {
        boolean salaryOK = (calculateYearlySalary() < 130000);
        boolean ageOK = (getAge() > 18);
        boolean companyOK = !anotherCompanyOwner;
        boolean pensionOK = !pensioner;
        boolean publicServerOK = !publicServer;

        return salaryOK && ageOK && companyOK && pensionOK && publicServerOK;
    }
}