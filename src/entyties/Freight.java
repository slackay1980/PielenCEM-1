package entyties;

import javax.persistence.*;
import java.util.Date;
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

    // 0 = per To ; 1 = pauschal
    @Column(name = "Typ")
    private int typ;

    @Column(name = "FREIGHT_PER_TO")
    private int freigtPerTo;

    @Column(name = "FREIGHT_PER_TO_SINCE")
    private Date freigtPerToSince;

    @Column(name = "FREIGHT_PER_TO_NOTE")
    private String freigtPerToNote;

    @Column(name = "FREIGHT_PER_ORDER")
    private int freigtPerOrder;

    @Column(name = "FREIGHT_PER_ORDER_SINCE")
    private Date freigtPerOrderSince;

    @Column(name = "FREIGHT_PER_ORDER_NOTE")
    private String freigtPerOrderNote;





    // @Column(name = "")


    public Freight() {

    }

    public Freight(List<TransportOrder> transportOrders, Relation relation, Forwarder forwarder,
                   int typ, int freigtPerTo, Date freigtPerToSince, String freigtPerToNote,
                   int freigtPerOrder, Date freigtPerOrderSince, String freigtPerOrderNote) {
        this.transportOrders = transportOrders;
        this.relation = relation;
        this.forwarder = forwarder;
        this.typ = typ;
        this.freigtPerTo = freigtPerTo;
        this.freigtPerToSince = freigtPerToSince;
        this.freigtPerToNote = freigtPerToNote;
        this.freigtPerOrder = freigtPerOrder;
        this.freigtPerOrderSince = freigtPerOrderSince;
        this.freigtPerOrderNote = freigtPerOrderNote;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<TransportOrder> getTransportOrders() {
        return transportOrders;
    }

    public void setTransportOrders(List<TransportOrder> transportOrders) {
        this.transportOrders = transportOrders;
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

    public Date getFreigtPerToSince() {
        return freigtPerToSince;
    }

    public void setFreigtPerToSince(Date freigtPerToSince) {
        this.freigtPerToSince = freigtPerToSince;
    }

    public String getFreigtPerToNote() {
        return freigtPerToNote;
    }

    public void setFreigtPerToNote(String freigtPerToNote) {
        this.freigtPerToNote = freigtPerToNote;
    }

    public int getFreigtPerOrder() {
        return freigtPerOrder;
    }

    public void setFreigtPerOrder(int freigtPerOrder) {
        this.freigtPerOrder = freigtPerOrder;
    }

    public Date getFreigtPerOrderSince() {
        return freigtPerOrderSince;
    }

    public void setFreigtPerOrderSince(Date freigtPerOrderSince) {
        this.freigtPerOrderSince = freigtPerOrderSince;
    }

    public String getFreigtPerOrderNote() {
        return freigtPerOrderNote;
    }

    public void setFreigtPerOrderNote(String freigtPerOrderNote) {
        this.freigtPerOrderNote = freigtPerOrderNote;
    }
}
