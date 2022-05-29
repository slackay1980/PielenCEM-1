package service;


import dao.FreightDAO;
import dao.RelationDAO;
import entyties.Freight;
import util.StateOfObjectRequest;
import util.TriState;

public class FreightService {

    public Boolean saveFreight(Freight freight)  {
        try {
            new FreightDAO().saveFreight(freight);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

    public TriState ifFreightExist(int relationId, int forwarderId) {

        try {
            if(new FreightDAO().getFreightIfExist(relationId,forwarderId))
                return TriState.triStateTrue;
            else
                return TriState.triStateFalse;
        }
        catch (Exception e) {
            return TriState.triStateError;
        }

    }

    public StateOfObjectRequest getFreight(int relationId, int forwarderId) {

        Freight freight = null;
        StateOfObjectRequest state = new StateOfObjectRequest();

        try {
            freight = new FreightDAO().getFreight(relationId,forwarderId);
            state.setError(false);
            state.setObject(freight);
                return state;
        }
        catch (Exception e) {
            state.setError(true);
            return state;
        }
    }


}
