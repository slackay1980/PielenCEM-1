package entyties;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TRANSPORT_ORDER")
public class TransportOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @ManyToOne
    @JoinColumn(name="FREIGHT_ID")
    private Freight freight;

    @OneToMany(mappedBy = "transportOrder")
    private List<OrderCiment> orderCiments;

    /*
    @ManyToOne
    @JoinColumn(name="TRANSPORT_ORDER_ID")
    private OrderCiment orderCiment;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FORWARDER_ID", referencedColumnName = "id")
    private Forwarder forwarder;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUSTOMER_STATION_ID", referencedColumnName = "id")
    private CustomerStation customerStation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCENT_STATION_ID", referencedColumnName = "id")
    private ProducerStation producentStation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "RELATION_ID", referencedColumnName = "id")
    private Relation relation;




    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FREIGHT_ID", referencedColumnName = "id")
    private ProducerStation FREIGHT;

    */

    @Column(name = "DATE")
    private Date date;

    @Column(name = "TIME_FROM")
    private Time fromTime;

    @Column(name = "TIME_TILL")
    private Time tillTime;

    @Column(name = "BONUS")
    private boolean bonus;

    // 1 = per To , 2 = pauschal
    @Column(name = "BONUS_TYP")
    private int bonusTyp;

    @Column(name = "BONUS_PER_TO")
    private int bonusPerTo;

    @Column(name = "BONUS_PER_ORDER")
    private boolean bonusPerOrder;











}
