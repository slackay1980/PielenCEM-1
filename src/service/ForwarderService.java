package service;

import dao.ForwarderDAO;
import entyties.Forwarder;
import util.StateOfObjectRequest;

import java.util.List;

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

    public StateOfObjectRequest getForwarderLikeString(String forwarderString)  {

        StateOfObjectRequest state = new StateOfObjectRequest();

        try {
            state.setList(new ForwarderDAO().getForwarderLikeString(forwarderString));

        }
        catch (Exception e) {
            state.setError(true);
            state.setErrorString(e.getMessage());
        }

        return state;
    }

}
