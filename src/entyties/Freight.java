package entyties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "FREIGHT")

public class Freight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;



    @OneToMany(fetch = FetchType.EAGER,mappedBy = "freight")
    private List<TransportOrder> transportOrders;



    @ManyToOne
    @JoinColumn(name="RELATION_ID")
    private Relation relation;


    @ManyToOne
    @JoinColumn(name="FORWARDER_ID")
    private Forwarder forwarder;

    // 1 = per To ; 2 = pauschal
    @Column(name = "Typ")
    private int typ;

    @Column(name = "FREIGHT_PER_TO")
    private int freigtPerTo;

    @Column(name = "FREIGHT_PER_TO_NOTE")
    private String noteFreigtPerTo;

    @Column(name = "FREIGHT_PER_ORDER")
    private int getFreigtPerOrder;

    @Column(name = "FREIGHT_PER_ORDER_NOTE")
    private String noteFreigtPerOrder;


    @Column(name = "FREIGHT_PER_TO1")
    private int freigtPerTo1;

    @Column(name = "FREIGHT_PER_TO_NOTE1")
    private String noteFreigtPerTo1;

    @Column(name = "FREIGHT_PER_ORDER1")
    private int getFreigtPerOrder1;

    @Column(name = "FREIGHT_PER_ORDER_NOTE1")
    private String noteFreigtPerOrder1;

    @Column(name = "FREIGHT_PER_TO2")
    private int freigtPerTo2;

    @Column(name = "FREIGHT_PER_TO_NOTE2")
    private String noteFreigtPerTo2;

    @Column(name = "FREIGHT_PER_ORDER2")
    private int getFreigtPerOrder2;

    @Column(name = "FREIGHT_PER_ORDER_NOTE2")
    private String noteFreigtPerOrder2;

    @Column(name = "FREIGHT_PER_TO3")
    private int freigtPerTo3;

    @Column(name = "FREIGHT_PER_TO_NOTE3")
    private String noteFreigtPerTo3;

    @Column(name = "FREIGHT_PER_ORDER3")
    private int getFreigtPerOrder3;

    @Column(name = "FREIGHT_PER_ORDER_NOTE3")
    private String noteFreigtPerOrder3;

    @Column(name = "FREIGHT_PER_TO4")
    private int freigtPerTo4;

    @Column(name = "FREIGHT_PER_TO_NOTE4")
    private String noteFreigtPerTo4;

    @Column(name = "FREIGHT_PER_ORDER4")
    private int getFreigtPerOrder4;

    @Column(name = "FREIGHT_PER_ORDER_NOTE4")
    private String noteFreigtPerOrder4;

    @Column(name = "FREIGHT_PER_TO5")
    private int freigtPerTo5;

    @Column(name = "FREIGHT_PER_TO_NOTE5")
    private String noteFreigtPerTo5;

    @Column(name = "FREIGHT_PER_ORDER5")
    private int getFreigtPerOrder5;

    @Column(name = "FREIGHT_PER_ORDER_NOTE5")
    private String noteFreigtPerOrder5;





    // @Column(name = "")


    public Freight() {

    }

    public Freight(Relation relation, Forwarder forwarder, int typ, int freigtPerTo, int getFreigtPerOrder) {
        this.relation = relation;
        this.forwarder = forwarder;
        this.typ = typ;
        this.freigtPerTo = freigtPerTo;
        this.getFreigtPerOrder = getFreigtPerOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Relation getRelation() {
        return relation;
    }

    public void setRelation(Relation relation) {
        this.relation = relation;
    }

    public Forwarder getForwarder() {
        return forwarder;
    }

    public void setForwarder(Forwarder forwarder) {
        this.forwarder = forwarder;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public int getFreigtPerTo() {
        return freigtPerTo;
    }

    public void setFreigtPerTo(int freigtPerTo) {
        this.freigtPerTo = freigtPerTo;
    }

    public int getGetFreigtPerOrder() {
        return getFreigtPerOrder;
    }

    public void setGetFreigtPerOrder(int getFreigtPerOrder) {
        this.getFreigtPerOrder = getFreigtPerOrder;
    }

    public String getNoteFreigtPerTo() {
        return noteFreigtPerTo;
    }

    public void setNoteFreigtPerTo(String noteFreigtPerTo) {
        this.noteFreigtPerTo = noteFreigtPerTo;
    }

    public String getNoteFreigtPerOrder() {
        return noteFreigtPerOrder;
    }

    public void setNoteFreigtPerOrder(String noteFreigtPerOrder) {
        this.noteFreigtPerOrder = noteFreigtPerOrder;
    }

    public int getFreigtPerTo1() {
        return freigtPerTo1;
    }

    public void setFreigtPerTo1(int freigtPerTo1) {
        this.freigtPerTo1 = freigtPerTo1;
    }

    public String getNoteFreigtPerTo1() {
        return noteFreigtPerTo1;
    }

    public void setNoteFreigtPerTo1(String noteFreigtPerTo1) {
        this.noteFreigtPerTo1 = noteFreigtPerTo1;
    }

    public int getGetFreigtPerOrder1() {
        return getFreigtPerOrder1;
    }

    public void setGetFreigtPerOrder1(int getFreigtPerOrder1) {
        this.getFreigtPerOrder1 = getFreigtPerOrder1;
    }

    public String getNoteFreigtPerOrder1() {
        return noteFreigtPerOrder1;
    }

    public void setNoteFreigtPerOrder1(String noteFreigtPerOrder1) {
        this.noteFreigtPerOrder1 = noteFreigtPerOrder1;
    }

    public int getFreigtPerTo2() {
        return freigtPerTo2;
    }

    public void setFreigtPerTo2(int freigtPerTo2) {
        this.freigtPerTo2 = freigtPerTo2;
    }

    public String getNoteFreigtPerTo2() {
        return noteFreigtPerTo2;
    }

    public void setNoteFreigtPerTo2(String noteFreigtPerTo2) {
        this.noteFreigtPerTo2 = noteFreigtPerTo2;
    }

    public int getGetFreigtPerOrder2() {
        return getFreigtPerOrder2;
    }

    public void setGetFreigtPerOrder2(int getFreigtPerOrder2) {
        this.getFreigtPerOrder2 = getFreigtPerOrder2;
    }

    public String getNoteFreigtPerOrder2() {
        return noteFreigtPerOrder2;
    }

    public void setNoteFreigtPerOrder2(String noteFreigtPerOrder2) {
        this.noteFreigtPerOrder2 = noteFreigtPerOrder2;
    }

    public int getFreigtPerTo3() {
        return freigtPerTo3;
    }

    public void setFreigtPerTo3(int freigtPerTo3) {
        this.freigtPerTo3 = freigtPerTo3;
    }

    public String getNoteFreigtPerTo3() {
        return noteFreigtPerTo3;
    }

    public void setNoteFreigtPerTo3(String noteFreigtPerTo3) {
        this.noteFreigtPerTo3 = noteFreigtPerTo3;
    }

    public int getGetFreigtPerOrder3() {
        return getFreigtPerOrder3;
    }

    public void setGetFreigtPerOrder3(int getFreigtPerOrder3) {
        this.getFreigtPerOrder3 = getFreigtPerOrder3;
    }

    public String getNoteFreigtPerOrder3() {
        return noteFreigtPerOrder3;
    }

    public void setNoteFreigtPerOrder3(String noteFreigtPerOrder3) {
        this.noteFreigtPerOrder3 = noteFreigtPerOrder3;
    }

    public int getFreigtPerTo4() {
        return freigtPerTo4;
    }

    public void setFreigtPerTo4(int freigtPerTo4) {
        this.freigtPerTo4 = freigtPerTo4;
    }

    public String getNoteFreigtPerTo4() {
        return noteFreigtPerTo4;
    }

    public void setNoteFreigtPerTo4(String noteFreigtPerTo4) {
        this.noteFreigtPerTo4 = noteFreigtPerTo4;
    }

    public int getGetFreigtPerOrder4() {
        return getFreigtPerOrder4;
    }

    public void setGetFreigtPerOrder4(int getFreigtPerOrder4) {
        this.getFreigtPerOrder4 = getFreigtPerOrder4;
    }

    public String getNoteFreigtPerOrder4() {
        return noteFreigtPerOrder4;
    }

    public void setNoteFreigtPerOrder4(String noteFreigtPerOrder4) {
        this.noteFreigtPerOrder4 = noteFreigtPerOrder4;
    }

    public int getFreigtPerTo5() {
        return freigtPerTo5;
    }

    public void setFreigtPerTo5(int freigtPerTo5) {
        this.freigtPerTo5 = freigtPerTo5;
    }

    public String getNoteFreigtPerTo5() {
        return noteFreigtPerTo5;
    }

    public void setNoteFreigtPerTo5(String noteFreigtPerTo5) {
        this.noteFreigtPerTo5 = noteFreigtPerTo5;
    }

    public int getGetFreigtPerOrder5() {
        return getFreigtPerOrder5;
    }

    public void setGetFreigtPerOrder5(int getFreigtPerOrder5) {
        this.getFreigtPerOrder5 = getFreigtPerOrder5;
    }

    public String getNoteFreigtPerOrder5() {
        return noteFreigtPerOrder5;
    }

    public void setNoteFreigtPerOrder5(String noteFreigtPerOrder5) {
        this.noteFreigtPerOrder5 = noteFreigtPerOrder5;
    }

    public List<TransportOrder> getTransportOrders() {
        return transportOrders;
    }

    public void setTransportOrders(List<TransportOrder> transportOrders) {
        this.transportOrders = transportOrders;
    }
}
