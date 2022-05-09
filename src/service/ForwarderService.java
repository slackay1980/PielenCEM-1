package service;

import dao.ForwarderDAO;
import entyties.Forwarder;

public class ForwarderService {

    public Boolean saveNewForwarder(Forwarder forwarder)  {
        try {
            new ForwarderDAO().saveNewForwarder(forwarder);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
