package entyties;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "FORWARDER")
public class Forwarder {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;


    @OneToMany(mappedBy = "forwarder")
    private List<Freight> freights;

    @Column(name ="FORWARDER_NAME")
    private String forwarderName;
    
    @Column(name ="FORWARDER_STREET")
    private String forwarderStreet;
    
    @Column(name ="FORWARDER_LAND")
    private String forwarderCountry;

    @Column(name ="FORWARDER_POSTCODE")
    private String forwarderPostCode;
    
    @Column(name ="FORWARDER_CITY")
    private String forwarderCity;
    
    @Column(name ="FORWARDER_EMPLOEE")
    private String forwarderEmploee;
 
    @Column(name ="FORWARDER_TELEFONE_1")
    private String forwarderTelefone1;
    
    @Column(name ="FORWARDER_TELEFONE_2")
    private String forwarderTelefone2;
    
    @Column(name ="FORWARDER_TELEFONE_3")
    private String forwarderTelefone3;
    
    @Column(name ="FORWARDER_EMAIL")
    private String forwarderEmail;
    
    @Column(name ="FORWARDER_LOGICID")
    private String forwarderLogicId;
    
    @Column(name ="FORWARDER_NOTE")
    private String forwarderNote;

    public Forwarder() {
    }

    public Forwarder(List<Freight> freights, String forwarderName, String forwarderStreet,
                     String forwarderCountry, String forwarderPostCode, String forwarderCity,
                     String forwarderEmploee, String forwarderTelefone1, String forwarderTelefone2,
                     String forwarderTelefone3, String forwarderEmail, String forwarderLogicId, String forwarderNote) {
        this.freights = freights;
        this.forwarderName = forwarderName;
        this.forwarderStreet = forwarderStreet;
        this.forwarderCountry = forwarderCountry;
        this.forwarderPostCode = forwarderPostCode;
        this.forwarderCity = forwarderCity;
        this.forwarderEmploee = forwarderEmploee;
        this.forwarderTelefone1 = forwarderTelefone1;
        this.forwarderTelefone2 = forwarderTelefone2;
        this.forwarderTelefone3 = forwarderTelefone3;
        this.forwarderEmail = forwarderEmail;
        this.forwarderLogicId = forwarderLogicId;
        this.forwarderNote = forwarderNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public List<Freight> getFreights() {
        return freights;
    }

    public void setFreights(List<Freight> freights) {
        this.freights = freights;
    }

    public String getForwarderName() {
        return forwarderName;
    }

    public void setForwarderName(String forwarderName) {
        this.forwarderName = forwarderName;
    }

    public String getForwarderStreet() {
        return forwarderStreet;
    }

    public void setForwarderStreet(String forwarderStreet) {
        this.forwarderStreet = forwarderStreet;
    }

    public String getForwarderCountry() {
        return forwarderCountry;
    }

    public void setForwarderCountry(String forwarderCountry) {
        this.forwarderCountry = forwarderCountry;
    }

    public String getForwarderPostCode() {
        return forwarderPostCode;
    }

    public void setForwarderPostCode(String forwarderPostCode) {
        this.forwarderPostCode = forwarderPostCode;
    }


    public String getForwarderCity() {
        return forwarderCity;
    }

    public void setForwarderCity(String forwarderCity) {
        this.forwarderCity = forwarderCity;
    }

    public String getForwarderEmploee() {
        return forwarderEmploee;
    }

    public void setForwarderEmploee(String forwarderEmploee) {
        this.forwarderEmploee = forwarderEmploee;
    }

    public String getForwarderTelefone1() {
        return forwarderTelefone1;
    }

    public void setForwarderTelefone1(String forwarderTelefone1) {
        this.forwarderTelefone1 = forwarderTelefone1;
    }

    public String getForwarderTelefone2() {
        return forwarderTelefone2;
    }

    public void setForwarderTelefone2(String forwarderTelefone2) {
        this.forwarderTelefone2 = forwarderTelefone2;
    }

    public String getForwarderTelefone3() {
        return forwarderTelefone3;
    }

    public void setForwarderTelefone3(String forwarderTelefone3) {
        this.forwarderTelefone3 = forwarderTelefone3;
    }

    public String getForwarderEmail() {
        return forwarderEmail;
    }

    public void setForwarderEmail(String forwarderEmail) {
        this.forwarderEmail = forwarderEmail;
    }

    public String getForwarderLogicId() {
        return forwarderLogicId;
    }

    public void setForwarderLogicId(String forwarderLogicId) {
        this.forwarderLogicId = forwarderLogicId;
    }

    public String getForwarderNote() {
        return forwarderNote;
    }

    public void setForwarderNote(String forwarderNote) {
        this.forwarderNote = forwarderNote;
    }
}
